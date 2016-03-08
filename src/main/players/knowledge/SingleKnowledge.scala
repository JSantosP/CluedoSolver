package main.players.knowledge

import main.cards.Card

object SingleKnowledge {
  lazy val Empty = new SingleKnowledge(numCards = 0, cards = List(), possibleCards = List())
}

class SingleKnowledge(val numCards: Int, val cards: List[Card], val possibleCards: List[Card]) {
  override def toString = s"SinglePlayerKnowledge=[numCards=$numCards, cards=$cards, possibleCards=$possibleCards]"
  
  def couldHave(p: List[Card]) = {
    require(p.forall { card => !cards.contains(card) }, "A possible card is already a known card!")
    
    new SingleKnowledge(numCards = numCards, cards = cards, possibleCards = p)
  }
}
