package test

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import main.game.Game

class GameSpec extends FlatSpec with Matchers {
  "A Game" should "have as many players as defined" in {
    assert(Game.players.size == Game.NUM_PLAYERS)
  }
}