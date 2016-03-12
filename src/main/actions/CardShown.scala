package main.actions

import main.players.Player

case class CardShown(asker: Player, answerer: Player) extends Action
