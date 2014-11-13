package streams

object tttext {
  val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin
  val v = Vector(Vector("o", "o", "o"), Vector("o", "S", "o"), Vector("-", "o", "-"))
  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    Pos(1, 2)
  }
  findChar("S", v)
}