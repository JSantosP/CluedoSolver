package test.game

import org.scalatest.BeforeAndAfter
import org.scalatest.FlatSpec

import main.game.Game

class GameSpec extends FlatSpec with BeforeAndAfter {
  behavior of "A just initialized Game"
  
  var game = Game.Empty
  
  before {
    game = Game.Empty
    game.initialize
  }
  
  it should "have as many players as defined when initialized" in {
    assert(game.players.size == game.numPlayers)
  }
  
  it should "have all players with no cards" in {
    assert(game.players.forall { player => player.cards.size == 0 })
  }
  
  it should "have cards" in {
    assert(game.cards.size > 0)
  }
  
  it should "have at least one card of each kind" in {
    assert(game.suspects.size > 0 && game.weapons.size > 0 && game.rooms.size > 0)
  }
  
  it should "have as many cards as they are when separate" in {
    assert(game.cards.size == (game.suspects.size + game.weapons.size + game.rooms.size))
  }
}
