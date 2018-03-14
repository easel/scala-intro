organization := "org.github.easel"
name := "scala-intro"
version := "0.1"

val scalaV = "2.11.8"

tutSettings

tutTargetDirectory := baseDirectory.value / "slides"

lazy val scalaIntro = project.in(file("."))
  .settings(scalaVersion := scalaV)
  .settings(addCompilerPlugin("org.spire-math" % "kind-projector"   % "0.7.1" cross CrossVersion.binary))
  .settings(addCompilerPlugin("com.milessabin" % "si2712fix-plugin" % "1.2.0" cross CrossVersion.full))
  .settings(libraryDependencies ++= Dependencies.Cats)
  .settings(libraryDependencies ++= Dependencies.Circe)
  .settings(libraryDependencies ++= Dependencies.ScalaTest)
