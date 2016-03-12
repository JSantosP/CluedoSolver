package main.envelope

import main.cards.Card
import main.cards.SuspectCard
import main.cards.WeaponCard
import main.cards.RoomCard

object Envelope {
  lazy val Empty = Envelope(cards = List())
}

case class Envelope(cards: List[Card]) {
  
  def dealSolution(suspect: SuspectCard, weapon: WeaponCard, room: RoomCard) =
    Envelope(List(suspect, weapon, room))
}
