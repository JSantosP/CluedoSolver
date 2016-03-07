package test

import org.scalatest.FlatSpec
import main.cards.ReverendGreen
import main.players.Player
import main.cards.BilliardRoom
import main.cards.LeadPipe

class PlayerSpec extends FlatSpec {
  behavior of "A Player"
  
  val player = Player.Empty
  
  it should "have an extra card when dealing a card" in {
    val card = ReverendGreen
    val playerWithCard = player.dealCard(card)
    
    assert(playerWithCard.cards.size == player.cards.size + 1)
  }
  
  it should "have dealt card in its hand" in {
    val card = ReverendGreen
    val playerWithCard = player.dealCard(card)
    
    assert(playerWithCard.cards.contains(card))
  }
  
  it should "have correctly separated cards by type" in {
    val suspect = ReverendGreen
    val weapon = LeadPipe
    val room = BilliardRoom
    val playerWithCards = player.dealCard(suspect).dealCard(weapon).dealCard(room)
    
    assert(playerWithCards.cards.size == playerWithCards.suspects.size + playerWithCards.weapons.size + playerWithCards.rooms.size)
    assert(playerWithCards.suspects.size == 1 && playerWithCards.suspects.contains(suspect))
    assert(playerWithCards.weapons.size == 1 && playerWithCards.weapons.contains(weapon))
    assert(playerWithCards.rooms.size == 1 && playerWithCards.rooms.contains(room))
  }
}
