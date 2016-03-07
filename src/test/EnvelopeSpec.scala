package test

import org.scalatest.FlatSpec
import main.envelope.Envelope

class EnvelopeSpec extends FlatSpec {
  behavior of "An Envelope"
  
  it should "have no cards when empty" in {
    assert(Envelope.Empty.cards.size == 0)
  }
}
