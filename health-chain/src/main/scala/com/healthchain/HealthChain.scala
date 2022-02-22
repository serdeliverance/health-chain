package com.healthchain

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}
import akka.cluster.ClusterEvent
import akka.cluster.typed.{Cluster, Subscribe}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.management.cluster.bootstrap.ClusterBootstrap
import akka.management.javadsl.AkkaManagement
import com.healthchain.domain.DummyActor

object HealthChain {

  object RootBehavior {
    def apply(): Behavior[Nothing] = Behaviors.setup[Nothing] { context =>
      context.spawn(DummyActor(), "DummyActor")

      Behaviors.empty
    }
  }

  def main(args: Array[String]): Unit =
    ActorSystem[Nothing](
      Behaviors.setup[Nothing] { context =>
        import akka.actor.typed.scaladsl.adapter._
        implicit val classicSystem = context.system.toClassic
        implicit val ec            = context.system.executionContext

        val cluster = Cluster(context.system)
        context.log.info("Started [" + context.system + "], cluster.selfAddress = " + cluster.selfMember.address + ")")

        Http().newServerAt("0.0.0.0", 8080).bind(complete("Hello world"))

        // TODO delete it later
        // Create an actor that handles cluster domain events
        val listener = context.spawn(Behaviors.receive[ClusterEvent.MemberEvent]((ctx, event) => {
          ctx.log.info("MemberEvent: {}", event)
          Behaviors.same
        }), "listener")

        // TODO delete it later
        Cluster(context.system).subscriptions ! Subscribe(listener, classOf[ClusterEvent.MemberEvent])

        AkkaManagement.get(classicSystem).start()
        ClusterBootstrap.get(classicSystem).start()
        Behaviors.empty
      },
      "HealthChain"
    )

}
