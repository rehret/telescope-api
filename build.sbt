ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.13.3"

lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(
    Dependencies.External.catsCore,

    // Test Dependencies
    Dependencies.External.Test.scalaTest
  )
)

lazy val root = (project in file("."))
  .aggregate(telescope)
  .dependsOn(telescope)
  .settings(
    commonSettings,
    name := "telescope-api",
  )

lazy val telescope = (project in file("telescope"))
  .settings(
    commonSettings,
    name := "telescope",
  )

Test / logBuffered := false
Test / parallelExecution := false
Test / testOptions += Tests.Argument("-oF")
