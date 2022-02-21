package com.healthchain

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import com.healthchain.domain.DummyActor

object HealthChain {

  object RootBehavior {
    def apply(): Behavior[Nothing] = Behaviors.setup[Nothing] { context =>
      context.spawn(DummyActor(), "DummyActor")

      Behaviors.empty
    }
  }
}
