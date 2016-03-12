package main.cards

sealed trait SuspectCard extends Card

// classic cards
case object MissScarlet extends SuspectCard
case object ProfessorPlum extends SuspectCard
case object MrsPeacock extends SuspectCard
case object ReverendGreen extends SuspectCard
case object ColonelMustard extends SuspectCard
case object MrsWhite extends SuspectCard

object SuspectCard {
  lazy val classic = List(
    MissScarlet,
    ProfessorPlum,
    MrsPeacock,
    ReverendGreen,
    ColonelMustard,
    MrsWhite)
}
