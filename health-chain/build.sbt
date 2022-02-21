import Dependencies._

name := "health-chain"


ThisBuild / scalaVersion     := "2.13.7"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.healthchain"
ThisBuild / organizationName := "healthchain"

val akkaVersion = "2.6.18"
val logbackVersion = "1.2.9"

lazy val root = project in file(".")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed"           % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-typed"         % akkaVersion,
  "com.typesafe.akka" %% "akka-serialization-jackson" % akkaVersion,
  "ch.qos.logback"    %  "logback-classic"             % logbackVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed"   % akkaVersion % Test,
  scalaTest % Test
)