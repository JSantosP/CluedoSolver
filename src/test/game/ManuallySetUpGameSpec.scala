package test.game

import org.scalatest.BeforeAndAfter
import org.scalatest.FlatSpec
import main.cards.BilliardRoom
import main.cards.LeadPipe
import main.cards.ReverendGreen
import main.envelope.Envelope
import main.game.Game
import main.cards.Kitchen
import main.cards.MissScarlet
import main.cards.Candlestick
import main.players.Player
import main.cards.Card
import main.cards.SuspectCard
import main.cards.RoomCard
import main.cards.WeaponCard

class ManuallySetUpGameSpec extends FlatSpec with BeforeAndAfter {
  behavior of "A manually setup Game"
  
  var game = Game.Empty
  def dealCardsToPlayer(player: Player, cards: List[Card]) = {
    // TODO: deal cards to player and tell it all cards are dealt
    player
  }
  
  val solutionSuspect = MissScarlet
  val solutionWeapon = Candlestick
  val solutionRoom = Kitchen
  
  val player0Cards = List()
  val player1Cards = List()
  val player2Cards = List()
  val player3Cards = List()
  
  before {
    game = Game.Empty
    game.initialize
    
    // envelope's cards
    game.envelope = Envelope.Empty.dealSolution(solutionSuspect, solutionWeapon, solutionRoom)
    
    // player's cards
    game.players = game.players.updated(0, dealCardsToPlayer(game.players(0), player0Cards))
    game.players = game.players.updated(1, dealCardsToPlayer(game.players(1), player1Cards))
    game.players = game.players.updated(2, dealCardsToPlayer(game.players(2), player2Cards))
    game.players = game.players.updated(3, dealCardsToPlayer(game.players(3), player3Cards))
  }
  
  
}
