package main.envelope

import main.cards.Card
import main.cards.SuspectCard
import main.cards.WeaponCard
import main.cards.RoomCard

object Envelope {
  lazy val Empty = new Envelope(cards = List()) 
}

class Envelope(val cards: List[Card]) {
  override def toString = "Envelope[cards=$cards]"
  
  def dealSolution(suspect: SuspectCard, weapon: WeaponCard, room: RoomCard) =
    new Envelope(List(suspect, weapon, room))
}
