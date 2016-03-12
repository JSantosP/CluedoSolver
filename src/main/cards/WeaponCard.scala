package main.cards

sealed trait WeaponCard extends Card

// classic cards
case object Candlestick extends WeaponCard
case object Dagger extends WeaponCard
case object LeadPipe extends WeaponCard
case object Revolver extends WeaponCard
case object Rope extends WeaponCard
case object Spanner extends WeaponCard

object WeaponCard {
  lazy val classic = List(Candlestick, Dagger, LeadPipe, Revolver, Rope, Spanner)
}
