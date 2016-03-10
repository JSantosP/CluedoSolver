package main.actions

import main.cards.WeaponCard
import main.cards.SuspectCard
import main.cards.RoomCard

class Suggestion(val suspect: SuspectCard, val weapon: WeaponCard, val room: RoomCard) extends Action {
  lazy val cards = List(suspect, weapon, room)
}