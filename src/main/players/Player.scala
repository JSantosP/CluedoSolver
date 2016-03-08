package main.players

import main.cards.Card
import main.cards.SuspectCard
import main.cards.WeaponCard
import main.cards.RoomCard
import main.players.knowledge.Knowledge

object Player {
  val Empty = new Player(id = -1, cards = List(), knowledge = Knowledge.Empty)
}

class Player(val id: Int, val cards: List[Card], val knowledge: Knowledge) {  
  override def toString = s"Player[id=$id, cards=$cards]"
  
  lazy val suspects = cards.filter { card => card.isInstanceOf[SuspectCard] }
  lazy val weapons  = cards.filter { card => card.isInstanceOf[WeaponCard] }
  lazy val rooms    = cards.filter { card => card.isInstanceOf[RoomCard] }
  
  def withID(id: Int) = new Player(id = id, cards = cards, knowledge = knowledge)
  
  def dealCard(card: Card) =
    new Player(id = id, cards = card :: cards, knowledge)
}
