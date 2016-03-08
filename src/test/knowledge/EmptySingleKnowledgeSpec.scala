package test.knowledge

import org.scalatest.FlatSpec
import main.players.knowledge.SingleKnowledge

class EmptySingleKnowledgeSpec extends FlatSpec {
  behavior of "An empty SingleKnowledge"
  
  val singleKnowledge = SingleKnowledge.Empty
  
  it should "have no cards and no possible cards" in {
    assert(singleKnowledge.numCards == 0 && singleKnowledge.cards.size == 0)
  }
  
  it should "have no possible cards" in {
    assert(singleKnowledge.possibleCards.size == 0)
  }
}
