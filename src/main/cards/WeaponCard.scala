package main.cards

trait WeaponCard extends Card

// classic cards
object Candlestick extends WeaponCard
object Dagger extends WeaponCard
object LeadPipe extends WeaponCard
object Revolver extends WeaponCard
object Rope extends WeaponCard
object Spanner extends WeaponCard

object WeaponCard {
  lazy val classic = List(Candlestick, Dagger, LeadPipe, Revolver, Rope, Spanner)
}