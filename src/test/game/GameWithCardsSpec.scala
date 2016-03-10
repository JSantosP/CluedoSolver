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
  
  it should "have an envelope with cards that players don't have" in {
    assert(game.envelope.cards.forall { card =>
      game.players.forall { player =>
        !player.cards.contains(card)
      }
    })
  }
  
  it should "have all players with different cards" in {
    assert(game.players.forall { player =>
      val otherPlayers = game.players.filterNot { p => p == player }
      otherPlayers.forall { otherPlayer =>
        player.cards.forall { card => !otherPlayer.cards.contains(card) }
      }
    })
  }
  
  it should "have dealt all cards between envelope and players" in {
    val cardsInPlayers: Int = game.players.flatMap { player => Some(player.cards.size) }.sum
    assert(game.cards.size == cardsInPlayers + game.envelope.cards.size)
  }
  
  it should "have all players that know their own cards" in {
    assert(game.players.forall { player => player.knowsItsCards })
  }
}
