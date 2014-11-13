package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) {
        case (block, move) => move match {
          case Left => block.left
          case Right => block.right
          case Up => block.up
          case Down => block.down
        }
      }
  }

  trait Level1 extends SolutionChecker {
    /* terrain for level 1*/

    val level =
      """ooo-------
    	|oSoooo----
    	|ooooooooo-
    	|-ooooooooo
    	|-----ooToo
    	|------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  val v = Vector(Vector('a', 'b', 'c', 'd'), Vector('1', '2', '3', '4'), Vector('T', 'a', 'b', 'c'), Vector('q', 'w', 'r', 't'))

  test("Position of T") {
    new Level1 {
      assert(findChar('T', v) == Pos(2, 0))
    }
  }

  test("Position of 4") {
    new Level1 {
      assert(findChar('4', v) == Pos(1, 3))
    }
  }

  val level =
    """ST
          |oo
          |oo""".stripMargin

  test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0, 0)), "0,0")
      assert(!terrain(Pos(4, 11)), "4,11")
    }
  }

  test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1, 1))
    }
  }

  test("legal neighbors") {
    new Level1 {
      assert(startBlock.legalNeighbors == List((startBlock.down, Down), (startBlock.right, Right)))
    }
  }

  test("neighbors with history") {
    new Level1 {
      val s = Set((Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
        (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up)))
      assert(neighborsWithHistory(Block(Pos(1, 1), Pos(1, 1)), List(Left, Up)).toSet == s)
      //assert(neighborsWithHistory(Block(Pos(1, 1), Pos(1, 1)), List(Left, Up)) == s.toStream) !!! THIS WILL FAIL !!!
    }
  }

  test("new neighbors only") {
    new Level1 {
      val r = Set((Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream
      assert( newNeighborsOnly(Set((Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
        (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream,
        Set(Block(Pos(1, 2), Pos(1, 3)), Block(Pos(1, 1), Pos(1, 1)))) == r)
    }
  }

  test("Block(Pos(1,1), Pos(1,1)) is standing") {
    new Level1 {
      assert(Block(Pos(1, 1), Pos(1, 1)).isStanding == true)
    }
  }
  
  test("optimal solution for level 1") {
    new Level1 {
      assert(solve(solution) == Block(goal, goal))
    }
  }

  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }
}
