package main.players.knowledge

import main.cards.Card
import main.players.Player

object Knowledge {
  lazy val Empty = Knowledge(players = List(), envelope = SingleKnowledge.Empty)
}

case class Knowledge(players: List[SingleKnowledge], envelope: SingleKnowledge) {
  
  def initialize(numPlayers: Int, possibleCards: List[Card]) =
    Knowledge(
      players = List.fill(numPlayers)(SingleKnowledge.Empty.couldHave(possibleCards)),
      envelope = envelope.couldHave(possibleCards))
  
  def playerHasCard(player: Player, card: Card) = {
    val updatedPlayersKnowledge = for {
      (singleKnowledge, index) <- players.zipWithIndex
    } yield {
      if(index == player.id) players(player.id).has(card)
      else players(player.id).doesntHave(card)
    }
    
    Knowledge(players = updatedPlayersKnowledge, envelope = envelope.doesntHave(card))
  }
  
  def withAllCardsDealtForPlayer(player: Player) =
    this.copy(players = players.updated(player.id, players(player.id).withAllCardsKnown))
}
