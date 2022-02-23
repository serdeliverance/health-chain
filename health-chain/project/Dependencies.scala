import sbt._

object Dependencies {

  object Versions {
    val akka           = "2.6.18"
    val akkaManagement = "1.1.3"
    val logback        = "1.2.9"
    val scalaTest      = "3.2.9"
  }

  val akkaCluster              = "com.typesafe.akka" %% "akka-cluster-typed"         % Versions.akka
  val akkaClusterSharding      = "com.typesafe.akka" %% "akka-cluster-sharding"      % Versions.akka
  val akkaDiscovery            = "com.typesafe.akka" %% "akka-discovery"             % Versions.akka
  val akkaPersistence          = "com.typesafe.akka" %% "akka-persistence"           % Versions.akka
  val akkaSerializationJackson = "com.typesafe.akka" %% "akka-serialization-jackson" % Versions.akka
  val akkaTyped                = "com.typesafe.akka" %% "akka-actor-typed"           % Versions.akka
  val akkaTypedTestkit         = "com.typesafe.akka" %% "akka-actor-testkit-typed"   % Versions.akka

  val akkaManagementClusterHttp            = "com.lightbend.akka.management" %% "akka-management-cluster-http"      % Versions.akkaManagement
  val akkaManagementClusterBootstrap       = "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % Versions.akkaManagement
  val akkaManagementDiscoveryKubernetesApi = "com.lightbend.akka.discovery"  %% "akka-discovery-kubernetes-api"     % Versions.akkaManagement

  val logback = "ch.qos.logback" % "logback-classic" % Versions.logback

  val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest
}
