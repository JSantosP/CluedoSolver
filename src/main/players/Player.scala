package main.players

import main.cards.Card
import main.cards.SuspectCard
import main.cards.WeaponCard
import main.cards.RoomCard
import main.players.knowledge.Knowledge
import main.actions.Suggestion

object Player {
  val Empty = new Player(id = -1, cards = List(), knowledge = Knowledge.Empty)
}

class Player(val id: Int, val cards: List[Card], val knowledge: Knowledge) {  
  override def toString = s"Player[id=$id, cards=$cards, knowledge=$knowledge]"
  
  lazy val suspects = cards.filter { card => card.isInstanceOf[SuspectCard] }
  lazy val weapons  = cards.filter { card => card.isInstanceOf[WeaponCard] }
  lazy val rooms    = cards.filter { card => card.isInstanceOf[RoomCard] }
  
  def withID(id: Int) = new Player(id = id, cards = cards, knowledge = knowledge)
  
  def playsAgainst(numPlayersWithoutSelf: Int, possibleCards: List[Card]) =
    new Player(id = id, cards = cards, knowledge = knowledge.initialize(numPlayersWithoutSelf + 1, possibleCards))
  
  def dealCard(card: Card) =
    new Player(id = id, cards = card :: cards, knowledge.playerHasCard(this, card))
  
  def withAllCardsDealt =
    new Player(id = id, cards = cards, knowledge.withAllCardsDealtForPlayer(this))
  
  def knowsItsCards = {
    val ownKnowledge = knowledge.players(id)
    ownKnowledge.numCards == cards.size && ownKnowledge.possibleCards.size == 0
  }
  
  def getOne(suggestion: Suggestion): Option[Card] = {
    val suggestedCards = cards.filter { card => suggestion.cards.contains(card) }
    
    if(suggestedCards.size == 0) None
    else Some(suggestedCards.head)  // always gets first card!
  }
}
