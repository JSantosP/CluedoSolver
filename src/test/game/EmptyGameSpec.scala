package test.game

import org.scalatest.FlatSpec
import org.scalatest.BeforeAndAfter
import main.game.Game

class EmptyGameSpec extends FlatSpec with BeforeAndAfter {
  behavior of "An empty Game"
  
  var game = Game.Empty
  
  before {
    game = Game.Empty
  }
  
  it should "have no players" in {
    assert(game.players.size == 0)
  }
  
  it should "have no cards in the envelope" in {
    assert(game.envelope.cards.size == 0)
  }
}
