package part1.simtrafficbase.messages;

import akka.actor.typed.ActorRef;

public record Step(ActorRef<SimulationMessage> sender) implements SimulationMessage {}
