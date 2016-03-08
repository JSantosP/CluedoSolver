package test.knowledge

import org.scalatest.FlatSpec
import main.players.knowledge.Knowledge
import main.players.knowledge.SingleKnowledge

class EmptyKnowledge extends FlatSpec {
  behavior of "An empty Knowledge"
  
  val knowledge = Knowledge.Empty
  
  it should "have no knowledges for players" in {
    assert(knowledge.players.size == 0)
  }
  
  it should "have an empty SingleKnowledge for the envelope" in {
    assert(knowledge.envelope == SingleKnowledge.Empty)
  }
}
