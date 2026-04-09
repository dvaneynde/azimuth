ThisBuild / scalaVersion := "2.12.7"

ThisBuild / organization := "eu.dlvm"

lazy val azimuth = (project in file("."))
  .settings(
    name := "azimuth",
    // first version; change to higher version with snapshot for iterative development; or just ask Claude
    version := "0.1.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )
