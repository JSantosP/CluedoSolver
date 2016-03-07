package main.players

import main.cards.Card

object Player {
  val Empty = new Player(id = -1, cards = List())
}

class Player(val id: Int, val cards: List[Card]) {  
  override def toString = s"Player[id=$id, cards=$cards]"
  
  def dealCard(card: Card) =
    new Player(id = id, cards = card :: cards)
}