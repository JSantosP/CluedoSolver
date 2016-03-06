package main.cards

trait Card {
  override def toString = this.getClass.getName.split("\\$").last.split("\\.").last
}