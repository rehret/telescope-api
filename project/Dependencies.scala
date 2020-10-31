import sbt._

object Dependencies {
  object External {
    val catsCore = "org.typelevel" %% "cats-core" % "2.1.1"

    object Test {
      val scalaTest = "org.scalatest" %% "scalatest" % "3.2.2" % "test"
    }
  }
}
