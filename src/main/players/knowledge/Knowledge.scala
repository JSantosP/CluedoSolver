package main.players.knowledge

import main.cards.Card

object Knowledge {
  lazy val Empty = new Knowledge(players = List(), envelope = SingleKnowledge.Empty)
}

class Knowledge(val players: List[SingleKnowledge], val envelope: SingleKnowledge) {
  override def toString = s"Knowledge[players=$players, envelope=$envelope]"
  
  def initialize(numPlayers: Int, possibleCards: List[Card]) =
    new Knowledge(players = List.fill(numPlayers)(SingleKnowledge.Empty.couldHave(possibleCards)), envelope = envelope)
}
