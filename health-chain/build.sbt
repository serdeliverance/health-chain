import Dependencies._

name := "health-chain"

ThisBuild / scalaVersion     := "2.13.7"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.healthchain"
ThisBuild / organizationName := "healthchain"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(AshScriptPlugin)

lazy val root = project in file(".")

libraryDependencies ++= Seq(
  Akka.actor,
  Akka.cluster,
  Akka.serializationJackson,
  logback,
  Akka.actorTestkit % Test,
  scalaTest % Test
)

Compile / mainClass := Some("com.healthchain.HealthChain")

maintainer := "Sergio Cano <canosergio90@gmail.com>"
dockerBaseImage := "openjdk:8-jre-alpine"
dockerExposedPorts ++= Seq(8080)