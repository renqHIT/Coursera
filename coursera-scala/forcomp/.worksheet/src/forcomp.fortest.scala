package forcomp

object fortest {
  type Word = String
  type Sentence = List[Word]
  type Occurrences = List[(Char, Int)];import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(149); 
  val w = "abcdefabBCccc";System.out.println("""w  : String = """ + $show(w ));$skip(44); 
  val s = List("aaaa", "bbbbbb", "c", "ED");System.out.println("""s  : List[String] = """ + $show(s ));$skip(17); val res$0 = 
  s.mkString("");System.out.println("""res0: String = """ + $show(res$0));$skip(153); 
  def wordOccurrences(w: Word): Occurrences = {
    w.toLowerCase().groupBy((elem: Char) => elem).map { case (x, y) => (x, y.length) }.toList.sorted
  };System.out.println("""wordOccurrences: (w: forcomp.fortest.Word)forcomp.fortest.Occurrences""");$skip(26); val res$1 = 
  wordOccurrences("abcd");System.out.println("""res1: forcomp.fortest.Occurrences = """ + $show(res$1));$skip(86); 
  def sentenceOccurrences(s: Sentence): Occurrences = wordOccurrences(s.mkString(""));System.out.println("""sentenceOccurrences: (s: forcomp.fortest.Sentence)forcomp.fortest.Occurrences""");$skip(27); val res$2 = 
 
  sentenceOccurrences(s);System.out.println("""res2: forcomp.fortest.Occurrences = """ + $show(res$2))}
}
