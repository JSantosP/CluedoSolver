package test.knowledge

import org.scalatest.FlatSpec

import main.cards.ReverendGreen
import main.game.Game
import main.players.Player
import main.players.knowledge.Knowledge

class KnowledgeSpec extends FlatSpec {
  behavior of "An initialized Knowledge"
  
  val numPlayers = Game.Empty.numPlayers
  val cards = Game.Empty.cards
  val knowledge = Knowledge.Empty.initialize(numPlayers, cards)
  
  it should "have as many SingleKnowledge pieces as players" in {
    assert(knowledge.players.size == numPlayers)
  }
  
  it should "have all players and envelope with all possible cards" in {
    val allPlayersWithAllPossibleCards = (for {
      (knowledge, index) <- knowledge.players.zipWithIndex
    } yield {
      knowledge.possibleCards.size == cards.size
    }).forall { playerHasAllPossibleCards => playerHasAllPossibleCards }
    
    val envelopeWithAllPossibleCards = knowledge.envelope.possibleCards.size == cards.size
    
    assert(allPlayersWithAllPossibleCards && envelopeWithAllPossibleCards)
  }
  
  it should "have updated SingleKnowledges when a card is dealt to a player" in {
    val playerToTest = Player.Empty.withID(0)
    val cardToTest = ReverendGreen
    
    val updatedKnowledge = knowledge.playerHasCard(playerToTest, cardToTest)
    
    val allPlayersCorrectlyUpdated = (for {
      (singleKnowledge, index) <- updatedKnowledge.players.zipWithIndex
    } yield {
      if(index == playerToTest.id) singleKnowledge.cards.contains(cardToTest) && !singleKnowledge.possibleCards.contains(cardToTest)
      else !singleKnowledge.possibleCards.contains(cardToTest)
    }).forall { isPlayerCorrect => isPlayerCorrect }
    
    val envelopeCorrectlyUpdated = !updatedKnowledge.envelope.possibleCards.contains(cardToTest)
    
    assert(allPlayersCorrectlyUpdated && envelopeCorrectlyUpdated)
  }
}
