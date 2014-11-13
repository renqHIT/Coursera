package streams

object tttext {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(169); 
  val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin;System.out.println("""level  : String = """ + $show(level ));$skip(86); 
  val v = Vector(Vector("o", "o", "o"), Vector("o", "S", "o"), Vector("-", "o", "-"));System.out.println("""v  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[String]] = """ + $show(v ));$skip(86); 
  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    Pos(1, 2)
  };System.out.println("""findChar: (c: Char, levelVector: Vector[Vector[Char]])<error>""");$skip(19); val res$0 = 
  findChar("S", v);System.out.println("""res0: <error> = """ + $show(res$0))}
}
