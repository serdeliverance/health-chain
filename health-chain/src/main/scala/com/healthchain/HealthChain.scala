package com.healthchain

import akka.actor.typed.{ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import com.healthchain.domain.DummyActor
import com.typesafe.config.ConfigFactory

object HealthChain {

  object RootBehavior {
    def apply(): Behavior[Nothing] = Behaviors.setup[Nothing] { context =>
      context.spawn(DummyActor(), "DummyActor")

      Behaviors.empty
    }
  }

  def main(args: Array[String]): Unit = {
    val ports =
      if (args.isEmpty) Seq(25251, 25252, 0)
      else args.toSeq.map(_.toInt)
    ports.foreach(startup)
  }

  def startup(port: Int): Unit = {
    val config =
      ConfigFactory
        .parseString(s"""akka.remote.artery.canonical.port=$port""")
        .withFallback(ConfigFactory.load())

    ActorSystem[Nothing](RootBehavior(), "HealthChain", config)
  }
}
