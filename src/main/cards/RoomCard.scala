package main.cards

trait RoomCard extends Card

// classic cards
object Kitchen extends RoomCard
object Ballroom extends RoomCard
object Conservatory extends RoomCard
object DiningRoom extends RoomCard
object BilliardRoom extends RoomCard
object Library extends RoomCard
object Lounge extends RoomCard
object Hall extends RoomCard
object Study extends RoomCard

object RoomCard {
  lazy val classic = List(Kitchen, Ballroom, Conservatory, DiningRoom, BilliardRoom, Library, Lounge, Hall, Study)
}
