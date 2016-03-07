package test

import org.scalatest.FlatSpec
import main.game.Game

class EmptyGameSpec extends FlatSpec {
  behavior of "An empty Game"
  
  it should "have no players" in {
    assert(Game.players.size == 0)
  }
}