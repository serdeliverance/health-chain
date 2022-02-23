import Dependencies._

name := "health-chain"

ThisBuild / scalaVersion     := "2.13.7"
ThisBuild / organization     := "com.healthchain"
ThisBuild / organizationName := "healthchain"

ThisBuild / dynverSeparator := "-"

lazy val root = project
  .in(file("."))
  .enablePlugins(JavaAppPackaging, DockerPlugin, AshScriptPlugin)
  .settings(dockerSettings)
  .settings(
    Compile / mainClass := Some("com.healthchain.HealthChain"),
    libraryDependencies ++= Seq(
      akkaCluster,
      akkaClusterSharding,
      akkaDiscovery,
      akkaManagementClusterHttp,
      akkaManagementClusterBootstrap,
      akkaManagementDiscoveryKubernetesApi,
      akkaPersistence,
      akkaSerializationJackson,
      akkaTyped,
      logback,
      akkaTypedTestkit % Test,
      scalaTest % Test
    ),
    Test / parallelExecution := false
  )

val dockerSettings = List(
  maintainer := "Sergio Cano <canosergio90@gmail.com>",
  dockerBaseImage := "openjdk:8-jre-alpine",
  dockerUpdateLatest := true,
  dockerExposedPorts ++= Seq(8080)
)
