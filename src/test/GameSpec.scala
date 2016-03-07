package test

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import main.game.Game

class GameSpec extends FlatSpec {
  behavior of "A new Game"
  
  it should "have as many players as defined" in {
    assert(Game.players.size == Game.numPlayers)
  }
  
  it should "have all players with no cards" in {
    assert(Game.players.forall { player => player.cards.size == 0 })
  }
}
