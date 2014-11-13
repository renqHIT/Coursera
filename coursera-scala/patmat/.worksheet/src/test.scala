import java.util.Random
package patmat

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(130); val res$0 = 
  for {
    x <- 2 to 5
    y <- 2 to x
    if (x % y == 0)
  } yield (x, y);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(180); val res$1 = 

  //(2 to 5) map (x =>
  //  (2 to x) flatMap (y =>
  //    if (x % y == 0) (x, y)))

  (2 to 5) flatMap (x =>
    (2 to x) withFilter (y =>
      x % y == 0) map ( y => (x, y)));System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1))}
      
  //val rand = new Random
  //rand.nextInt()
}
