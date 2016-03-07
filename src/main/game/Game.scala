package main.game

import main.players.Player
import main.cards.Card

object Game {
  val numPlayers = 4
  
  private lazy val emptyPlayers = List.tabulate(numPlayers)(id => new Player(id = id, cards = List()))
  
  private lazy val cards = Card.classic
  
  var players: List[Player] = emptyPlayers
  
  override def toString = s"Game[players=$players]"
}
