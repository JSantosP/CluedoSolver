package main.cards

trait Card {
  override def toString = this.getClass.getName.split("\\$").last.split("\\.").last
}

object Card {
  lazy val classic = SuspectCard.classic ++ WeaponCard.classic ++ RoomCard.classic
}