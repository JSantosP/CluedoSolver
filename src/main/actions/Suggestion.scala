package main.actions

import main.cards.WeaponCard
import main.cards.SuspectCard
import main.cards.RoomCard

case class Suggestion(suspect: SuspectCard, weapon: WeaponCard, room: RoomCard) extends Action {
  lazy val cards = List(suspect, weapon, room)
}