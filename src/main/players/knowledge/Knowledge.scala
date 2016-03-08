package main.players.knowledge

import main.cards.Card
import main.players.Player

object Knowledge {
  lazy val Empty = new Knowledge(players = List(), envelope = SingleKnowledge.Empty)
}

class Knowledge(val players: List[SingleKnowledge], val envelope: SingleKnowledge) {
  override def toString = s"Knowledge[players=$players, envelope=$envelope]"
  
  def initialize(numPlayers: Int, possibleCards: List[Card]) =
    new Knowledge(players = List.fill(numPlayers)(SingleKnowledge.Empty.couldHave(possibleCards)), envelope = envelope)
  
  def playerHasCard(player: Player, card: Card) = {
    val updatedPlayersKnowledge = for {
      (singleKnowledge, index) <- players.zipWithIndex
    } yield {
      if(index == player.id) players(player.id).has(card)
      else players(player.id).doesntHave(card)
    }
    
    new Knowledge(updatedPlayersKnowledge, envelope.doesntHave(card))
  }
}