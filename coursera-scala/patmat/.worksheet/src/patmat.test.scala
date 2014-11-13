package patmat
import java.util.Random

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(130); val res$0 = 
  for {
    x <- 2 to 5
    y <- 2 to x
    if (x % y == 0)
  } yield (x, y);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(179); val res$1 = 

  //(2 to 5) map (x =>
  //  (2 to x) flatMap (y =>
  //    if (x % y == 0) (x, y)))

  (2 to 5) flatMap (x =>
    (2 to x) withFilter (y =>
      x % y == 0) map (y => (x, y)));System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(31); 
      
  val rand = new Random;System.out.println("""rand  : java.util.Random = """ + $show(rand ));$skip(17); val res$2 = 
  rand.nextInt();System.out.println("""res2: Int = """ + $show(res$2))}
}
