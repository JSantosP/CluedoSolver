package main.cards

trait SuspectCard extends Card

// classic cards
object MissScarlet extends SuspectCard
object ProfessorPlum extends SuspectCard
object MrsPeacock extends SuspectCard
object ReverendGreen extends SuspectCard
object ColonelMustard extends SuspectCard
object MrsWhite extends SuspectCard

object SuspectCard {
  lazy val classic = List(MissScarlet, ProfessorPlum, MrsPeacock, ReverendGreen, ColonelMustard, MrsWhite)
}
