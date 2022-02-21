import sbt._

object Dependencies {

  object Versions {
    val akka      = "2.6.18"
    val scalaTest = "3.2.9"
    val logback   = "1.2.9"
  }

  val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest

  val logback = "ch.qos.logback" % "logback-classic" % Versions.logback

  object Akka {
    val actor                = "com.typesafe.akka" %% "akka-actor-typed"           % Versions.akka
    val cluster              = "com.typesafe.akka" %% "akka-cluster-typed"         % Versions.akka
    val serializationJackson = "com.typesafe.akka" %% "akka-serialization-jackson" % Versions.akka
    val actorTestkit         = "com.typesafe.akka" %% "akka-actor-testkit-typed"   % Versions.akka
  }
}
