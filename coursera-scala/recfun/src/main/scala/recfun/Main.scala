package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
   def factB(c: Int, r: Int): Int =if (c==0) 1 else factB(c-1,r)*(r-c+1)/c  
    factB(c,r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanced(chars: List[Char], open: Int): Boolean = {
      chars match {
        case Nil => open == 0
        case '(' :: t => balanced(t, open + 1)
        case ')' :: t => open > 0 && balanced(t, open - 1)
        case _ :: t => balanced(t, open)
      }
    }
    balanced(chars, 0)
  }
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.isEmpty || money < 0) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
