package patmat
import java.util.Random

object test {
  for {
    x <- 2 to 5
    y <- 2 to x
    if (x % y == 0)
  } yield (x, y)                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,2), (3,3
                                                  //| ), (4,2), (4,4), (5,5))

  //(2 to 5) map (x =>
  //  (2 to x) flatMap (y =>
  //    if (x % y == 0) (x, y)))

  (2 to 5) flatMap (x =>
    (2 to x) withFilter (y =>
      x % y == 0) map (y => (x, y)))              //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,2), (3,3
                                                  //| ), (4,2), (4,4), (5,5))
      
  val rand = new Random                           //> rand  : java.util.Random = java.util.Random@76ae34
  rand.nextInt()                                  //> res2: Int = -1568748918
}