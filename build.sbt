val scala210 = "2.10.6"

lazy val chronoscala = (project in file("."))
  .settings(
    name := "chronoscala",

    organization := "jp.ne.opt",

    licenses += "MIT" -> url("https://raw.githubusercontent.com/opt-tech/chronoscala/master/LICENSE"),

    version := "0.0.2-SNAPSHOT",

    publishMavenStyle := true,

    scalaVersion := scala210,

    crossScalaVersions := Seq(scala210, "2.11.8"),

    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
  )