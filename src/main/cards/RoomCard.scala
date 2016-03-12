package main.cards

sealed trait RoomCard extends Card

// classic cards
case object Kitchen extends RoomCard
case object Ballroom extends RoomCard
case object Conservatory extends RoomCard
case object DiningRoom extends RoomCard
case object BilliardRoom extends RoomCard
case object Library extends RoomCard
case object Lounge extends RoomCard
case object Hall extends RoomCard
case object Study extends RoomCard

object RoomCard {
  lazy val classic = List(
    Kitchen,
    Ballroom,
    Conservatory,
    DiningRoom,
    BilliardRoom,
    Library,
    Lounge,
    Hall,
    Study)
}
