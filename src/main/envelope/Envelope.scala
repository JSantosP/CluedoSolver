package main.envelope

import main.cards.Card

object Envelope {
  lazy val Empty = new Envelope(cards = List()) 
}

class Envelope(val cards: List[Card]) {
  override def toString = "Envelope[cards=$cards]"
}
