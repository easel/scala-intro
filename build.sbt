organization := "org.github.easel"
name := "scala-intro"
version := "0.1"

val scalaV = "2.11.8"

tutSettings

tutTargetDirectory := baseDirectory.value / "slides"

lazy val scalaIntro = project.in(file("."))
  .settings(scalaVersion := scalaV)
  .settings(libraryDependencies ++= Dependencies.Cats)
  .settings(libraryDependencies ++= Dependencies.ScalaTest)
