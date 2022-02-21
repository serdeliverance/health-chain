import Dependencies._

name := "health-chain"

ThisBuild / scalaVersion     := "2.13.7"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.healthchain"
ThisBuild / organizationName := "healthchain"

lazy val root = project
  .in(file("."))
  .enablePlugins(JavaAppPackaging, DockerPlugin, AshScriptPlugin)
  .settings(dockerSettings)
  .settings(
    Compile / mainClass := Some("com.healthchain.HealthChain"),
    libraryDependencies ++= Seq(
      Akka.actor,
      Akka.cluster,
      Akka.serializationJackson,
      logback,
      Akka.actorTestkit % Test,
      scalaTest % Test
    ),
    Test / parallelExecution := false
  )

val dockerSettings = List(
  maintainer := "Sergio Cano <canosergio90@gmail.com>",
  dockerBaseImage := "openjdk:8-jre-alpine",
  dockerExposedPorts ++= Seq(8080)
)
