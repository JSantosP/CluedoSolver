package test.envelope

import org.scalatest.{Matchers, FlatSpec}
import main.envelope.Envelope

class EnvelopeSpec extends FlatSpec with Matchers{
  behavior of "An Envelope"
  
  it should "have no cards when empty" in {
    Envelope.Empty.cards.isEmpty shouldEqual true
  }
}
