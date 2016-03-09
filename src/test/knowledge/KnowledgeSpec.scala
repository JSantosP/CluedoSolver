package test.knowledge

import org.scalatest.FlatSpec
import main.players.knowledge.Knowledge
import org.scalatest.BeforeAndAfter
import main.game.Game

class KnowledgeSpec extends FlatSpec with BeforeAndAfter {
  behavior of "An initialized Knowledge"
  
  var knowledge = Knowledge.Empty
  val numPlayers = Game.Empty.numPlayers
  val cards = Game.Empty.cards
  
  before {
    knowledge = knowledge.initialize(numPlayers, cards)
  }
  
  it should "have as many SingleKnowledge pieces as players" in {
    assert(knowledge.players.size == numPlayers)
  }
  
  it should "have all players and envelope with all possible cards" in {
    val allPlayersWithAllPossibleCards = (for {
      (knowledge, index) <- knowledge.players.zipWithIndex
    } yield {
      knowledge.possibleCards.size == cards.size
    }).forall { playerHasAllPossibleCards => playerHasAllPossibleCards == true }
    
    val envelopeWithAllPossibleCards = knowledge.envelope.possibleCards.size == cards.size
    
    assert(allPlayersWithAllPossibleCards && envelopeWithAllPossibleCards)
  }
}
