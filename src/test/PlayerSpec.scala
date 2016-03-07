package test

import org.scalatest.FlatSpec
import main.cards.ReverendGreen
import main.players.Player

class PlayerSpec extends FlatSpec {
  behavior of "A Player"
  
  it should "have an extra card when dealing a card" in {
    val card = ReverendGreen
    val basePlayer = Player.Empty
    val player = basePlayer.dealCard(card)
    
    assert(player.cards.size == basePlayer.cards.size + 1)
  }
  
  it should "have dealt card in its hand" in {
    val card = ReverendGreen
    val player = Player.Empty.dealCard(card)
    
    assert(player.cards.contains(card))
  }
}