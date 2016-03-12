package main.players.knowledge

import main.cards.Card

object SingleKnowledge {
  lazy val Empty = SingleKnowledge(numCards = 0, cards = List(), possibleCards = List())
}

case class SingleKnowledge(numCards: Int, cards: List[Card], possibleCards: List[Card]) {
  
  def couldHave(p: List[Card]): SingleKnowledge = {
    require(p.forall { card => !cards.contains(card) }, "A possible card is already a known card!")
    
    this.copy(possibleCards = p)
  }
  
  def has(card: Card): SingleKnowledge =
    SingleKnowledge(
      numCards = numCards + 1,
      cards = card +: cards,
      possibleCards.filterNot(_ == card))
  
  def doesntHave(card: Card): SingleKnowledge =
    this.copy(possibleCards = possibleCards.filterNot { c => c == card })
  
  def withAllCardsKnown: SingleKnowledge =
    this.copy(possibleCards = Nil)
}
