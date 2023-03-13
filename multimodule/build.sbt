ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "1.0"
ThisBuild / name := "multi-module"
ThisBuild / organization := "com.knoldus"


val core = (project in file("core")).settings(
	assembly / mainClass := Some("com.knoldus.MainScalaApp"),
	libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
)
val utils =(project in file("utils")).settings(
    name := "utils",
    version := "1.0.0",
    scalaVersion := "2.13.8"
  )
   .dependsOn(core)
val root = (project in file(".")).aggregate(core,utils)


libraryDependencies += "joda-time" % "joda-time" % "2.12.2"
libraryDependencies += "org.joda" % "joda-convert" % "2.2.2"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.32" //JDBC
updateOptions := updateOptions.value.withCachedResolution(true) //cached resolution
