package test

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import main.game.Game

class GameSpec extends FlatSpec {
  behavior of "A Game"
  
  it should "have as many players as defined" in {
    assert(Game.players.size == Game.numPlayers)
  }
  
  it should "have all players with no cards" in {
    assert(Game.players.forall { player => player.cards.size == 0 })
  }
  
  it should "have cards" in {
    assert(Game.cards.size > 0)
  }
  
  it should "have at least one card of each kind" in {
    assert(Game.suspects.size > 0 && Game.weapons.size > 0 && Game.rooms.size > 0)
  }
  
  it should "have as many cards as they are when separate" in {
    assert(Game.cards.size == (Game.suspects.size + Game.weapons.size + Game.rooms.size))
  }
}
