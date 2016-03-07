package test.game

import org.scalatest.BeforeAndAfter
import org.scalatest.FlatSpec

import main.cards.RoomCard
import main.cards.SuspectCard
import main.cards.WeaponCard
import main.game.Game

class GameWithCards extends FlatSpec with BeforeAndAfter {
  behavior of "A Game with cards dealt"
  
  var game = Game.Empty
  
  before {
    game = Game.Empty
    game.initialize
    game.dealCards
  }
  
  it should "have an envelope with three cards" in {
    assert(game.envelope.cards.size == 3)
  }
  
  it should "have a solution where each card is from a type" in {
    assert(game.envelope.cards.filter { card => card.isInstanceOf[SuspectCard] }.size == 1)
    assert(game.envelope.cards.filter { card => card.isInstanceOf[WeaponCard]  }.size == 1)
    assert(game.envelope.cards.filter { card => card.isInstanceOf[RoomCard]    }.size == 1)
  }
}
