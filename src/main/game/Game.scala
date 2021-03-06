package main.game

import main.cards.Card
import main.cards.RoomCard
import main.cards.SuspectCard
import main.cards.WeaponCard
import main.envelope.Envelope
import main.players.Player
import main.actions.Suggestion
import main.actions.Action
import main.actions.NoCardShown

object Game {
  def Empty = new Game(players = List(), envelope = Envelope.Empty)
}

class Game(var players: List[Player], var envelope: Envelope) {
  override def toString = s"Game[players=$players, envelope=$envelope]"
  
  val numPlayers = 4
  
  lazy val cards = Card.classic
  lazy val suspects = cards.filter { card => card.isInstanceOf[SuspectCard] }
  lazy val weapons  = cards.filter { card => card.isInstanceOf[WeaponCard] }
  lazy val rooms    = cards.filter { card => card.isInstanceOf[RoomCard] }
  
  def initialize = {
    players = List.tabulate(numPlayers)(id => Player.Empty.withID(id).playsAgainst(numPlayers - 1, cards))
    envelope = Envelope.Empty
  }
  
  private def dealSolution(envelope: Envelope, suspect: SuspectCard, weapon: WeaponCard, room: RoomCard) = {
    envelope.dealSolution(suspect, weapon, room)
  }
  
  private def dealCardsToPlayers(players: List[Player], cards: List[Card], index: Int = 0): List[Player] = cards match {
    case Nil => players
    case card :: remainingCards => {
      val updatedPlayers = players.updated(index, players(index).dealCard(card))
      dealCardsToPlayers(updatedPlayers, remainingCards, (index + 1) % players.size)
    }
  }
  
  def dealCards = {
    val suspectSolution :: remainingSuspects = util.Random.shuffle(suspects)
    val weaponSolution  :: remainingWeapons  = util.Random.shuffle(weapons)
    val roomSolution    :: remainingRooms    = util.Random.shuffle(rooms)
    val remainingCards = util.Random.shuffle(remainingSuspects ++ remainingWeapons ++ remainingRooms)
    
    envelope = dealSolution(envelope,
                            suspectSolution.asInstanceOf[SuspectCard],
                            weaponSolution.asInstanceOf[WeaponCard],
                            roomSolution.asInstanceOf[RoomCard])
                 
    players = dealCardsToPlayers(players, remainingCards)
    players = players.map { player => player.withAllCardsDealt }
  }
  
  def performAction(player: Player, action: Action) = {
    ???
  }
}
