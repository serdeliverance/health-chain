package com.healthchain.domain

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

// TODO delete me
object DummyActor {

  sealed trait Command
  final case object Hello extends Command

  def apply(): Behavior[Command] = Behaviors.setup[Command] { ctx =>
    Behaviors.receiveMessage { message =>
      message match {
        case Hello => println(s"receiving $Hello")
      }
      Behaviors.same
    }
  }
}
