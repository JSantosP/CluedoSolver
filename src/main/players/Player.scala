package main.players

import main.cards.Card
import main.cards.SuspectCard
import main.cards.WeaponCard
import main.cards.RoomCard
import main.players.knowledge.Knowledge
import main.actions.Suggestion

object Player {
  val Empty = Player(id = -1, cards = List(), knowledge = Knowledge.Empty)
}

case class Player(id: Int, cards: List[Card], knowledge: Knowledge) {
  
  lazy val suspects = cards.filter { card => card.isInstanceOf[SuspectCard] }
  lazy val weapons  = cards.filter { card => card.isInstanceOf[WeaponCard] }
  lazy val rooms    = cards.filter { card => card.isInstanceOf[RoomCard] }
  
  def withID(id: Int): Player = this.copy(id = id)
  
  def playsAgainst(numPlayersWithoutSelf: Int, possibleCards: List[Card]): Player =
    this.copy(knowledge = knowledge.initialize(numPlayersWithoutSelf + 1, possibleCards))
  
  def dealCard(card: Card): Player =
    this.copy(cards = card +: cards, knowledge = knowledge.playerHasCard(this, card))
  
  def withAllCardsDealt: Player =
    this.copy(knowledge = knowledge.withAllCardsDealtForPlayer(this))
  
  def knowsItsCards: Boolean = {
    val ownKnowledge = knowledge.players(id)
    ownKnowledge.numCards == cards.size && ownKnowledge.possibleCards.isEmpty
  }
  
  def getOne(suggestion: Suggestion): Option[Card] = {
    val suggestedCards = cards.filter { card => suggestion.cards.contains(card) }
    
    suggestedCards.headOption // always gets first card!
  }
}
