name := "flow-parser-macros-test"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

val scalaTestVersion = "3.0.1"

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "fastparse" % "0.4.2",
  "flow-parser-macros" %% "flow-parser-macros" % "0.0.1-SNAPSHOT",
  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)
