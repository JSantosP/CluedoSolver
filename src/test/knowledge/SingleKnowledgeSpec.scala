package test.knowledge

import org.scalatest.FlatSpec
import main.players.knowledge.SingleKnowledge
import main.cards.LeadPipe
import main.cards.ReverendGreen
import main.cards.BilliardRoom

class SingleKnowledgeSpec extends FlatSpec {
  behavior of "A SingleKnowledge with possible cards"
  
  val cardsToTest = List(ReverendGreen, LeadPipe, BilliardRoom)
  val singleKnowledge = SingleKnowledge.Empty
  val singleKnowledgeWithPossibleCards = singleKnowledge.couldHave(cardsToTest)
  
  it should "correctly update its list of possible cards" in {    
    assert(singleKnowledgeWithPossibleCards.possibleCards.size == singleKnowledge.possibleCards.size + cardsToTest.size)
  }
  
  it should "correctly remove a card that it can't have" in {
    val cardToTest = ReverendGreen
    val updatedKnowledge = singleKnowledgeWithPossibleCards.doesntHave(cardToTest)
    
    assert(updatedKnowledge.possibleCards.filter { card => card == cardToTest }.size == 0)
  }
  
  it should "correctly update when a card is known" in {
    val cardToTest = ReverendGreen
    val updatedKnowledge = singleKnowledgeWithPossibleCards.has(cardToTest)
    
    assert(updatedKnowledge.numCards == singleKnowledgeWithPossibleCards.numCards + 1 &&
           updatedKnowledge.cards.size == singleKnowledgeWithPossibleCards.cards.size + 1 &&
           updatedKnowledge.possibleCards.size == singleKnowledgeWithPossibleCards.possibleCards.size - 1)
  }
}
