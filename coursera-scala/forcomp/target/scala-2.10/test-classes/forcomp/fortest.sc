package forcomp

object fortest {
  type Word = String
  type Sentence = List[Word]
  type Occurrences = List[(Char, Int)]
  val w = "abcdefabBCccc"                         //> w  : String = abcdefabBCccc
  val s = List("aaaa", "bbbbbb", "c", "ED")       //> s  : List[String] = List(aaaa, bbbbbb, c, ED)
  s.mkString("")                                  //> res0: String = aaaabbbbbbcED
  def wordOccurrences(w: Word): Occurrences = {
    w.toLowerCase().groupBy((elem: Char) => elem).map { case (x, y) => (x, y.length) }.toList.sorted
  }                                               //> wordOccurrences: (w: forcomp.fortest.Word)forcomp.fortest.Occurrences
  wordOccurrences("abcd")                         //> res1: forcomp.fortest.Occurrences = List((a,1), (b,1), (c,1), (d,1))
  def sentenceOccurrences(s: Sentence): Occurrences = wordOccurrences(s.mkString(""))
                                                  //> sentenceOccurrences: (s: forcomp.fortest.Sentence)forcomp.fortest.Occurrence
                                                  //| s
 
  sentenceOccurrences(s)                          //> res2: forcomp.fortest.Occurrences = List((a,4), (b,6), (c,1), (d,1), (e,1))
                                                  //| 
}