package main.game

import main.players.Player
import main.cards.Card
import main.cards.SuspectCard
import main.cards.WeaponCard
import main.cards.RoomCard

object Game {
  override def toString = s"Game[players=$players]"
  
  val numPlayers = 4
  
  private lazy val emptyPlayers = List.tabulate(numPlayers)(id => new Player(id = id, cards = List()))
  
  lazy val cards = Card.classic
  lazy val suspects = cards.filter { card => card.isInstanceOf[SuspectCard] }
  lazy val weapons  = cards.filter { card => card.isInstanceOf[WeaponCard] }
  lazy val rooms    = cards.filter { card => card.isInstanceOf[RoomCard] }
  
  var players: List[Player] = List()
  
  def initialize = {
    players = emptyPlayers
  }
}
