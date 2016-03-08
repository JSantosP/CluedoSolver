package main.players.knowledge

object Knowledge {
  lazy val Empty = new Knowledge(players = List(), envelope = SingleKnowledge.Empty)
}

class Knowledge(val players: List[SingleKnowledge], val envelope: SingleKnowledge) {
  override def toString = s"Knowledge[players=$players, envelope=$envelope]"
}