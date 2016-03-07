package main.game

import main.players.Player

object Game {
  val NUM_PLAYERS = 4
  
  private lazy val emptyPlayers = List.tabulate(NUM_PLAYERS)(id => new Player(id = id, cards = List()))
  
  var players: List[Player] = emptyPlayers
  
  override def toString = s"Game[players=$players]"
}