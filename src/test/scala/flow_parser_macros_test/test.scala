package flow_parser_macros_test

import flow_parser_macros.D188
import org.scalatest._
import Util.doNothing
import fastparse.core.Parsed
import flow_parser_macros_impl.Parsing
import flow_parser_macros_impl.Parsing.lineParser

class D188Spec extends FunSpec with Matchers {
  
  describe("A D188") {

    val g387a = D188.Group387("f1a", "f2a", "f3a")
    val g387b = D188.Group387("f1b", "f2b", "f3b")

    it("should have 15 columns and a sequence of g387s") {
      D188.flowType should equal("D188")
      D188.Group386("f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10", "f11", "f12", "f13", "f14", "f15", Seq(g387a, g387b))
      //just making sure this compiles
    }

  }
  
  describe("a group387 parser") {
    it("should parse a group 387 line into a case class") {
      val testData = "387|123|abc|123|"
      val Parsed.Success(value, index) = D188.Group387.parser.parse(testData)
      value should equal(D188.Group387("123", "abc", "123"))
      value.meterRegisterId should equal("123")
      value.registerReading should equal("abc")
      value.prepaymentUnitRate should equal("123")

      index should equal(testData.size)
    }
  }
  
  describe("a group386 parser") {
    it("should parse a group386 line and its subgroups") (pending)
    
  }
  
}

object Util {
  def doNothing(a:Any*): Unit = ()
}

