package main.players

import main.cards.Card

class Player(val id: Int, val cards: List[Card]) {
  override def toString = s"Player[id=$id, cards=$cards]"
}