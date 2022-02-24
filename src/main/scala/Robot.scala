package cu.edu.cujae.inf

import java.io.PrintWriter
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Random



class Robot (val initialPosition: Tile, val board: Board) {
  private var maxMoves = board.len / 2
  val traveledPath = new ArrayBuffer [Array [ (Int, Int) ] ] (maxMoves)
  private var currentPosition = initialPosition


  def goToGoal (): Unit = {
    var reachedGoal = false
    val bifurc = new mutable.Stack [Tile] ()

    while (!reachedGoal) {
      val posMoves = possibleMoves ()

      if (posMoves.length > 1) {
        if (posMoves (0).weight > currentPosition.weight) {
          returnTo (bifurc.pop () )
        } else {
          bifurc.push (currentPosition)
          walk (posMoves (Random.nextInt (posMoves.length) ) )
        }
      } else {
          walk (posMoves (0) )
      }

      if (currentPosition.location == board.goal.location) {
        reachedGoal = true

        println ("Reached goal!!!")
      }
    }
  }

  def walk (aTile: Tile): Unit = {
    if (maxMoves < 0) {
      println ("Bot ran out of possible moves")
      System.exit (1)
    }

    val moves = Array( (currentPosition.location._1 - 1, currentPosition.location._2 - 1), (aTile.location._1 - 1, aTile.location._2 - 1) )

    currentPosition = aTile
    maxMoves -= 1

    println (moves.mkString ("Array (", ", ", ")") )
    registerMove (moves)
  }

  def returnTo (aTile: Tile): Unit = {
    val t = traveledPath.reverse

    for (i <- t.indices) {
      val j = t (i)(0)

      if (currentPosition.location != aTile.location) {
        walk (board.board (j._1 + 1) (j._2 + 1) )

        val lastPos = traveledPath.last (0)

        board.board (lastPos._1 + 1) (lastPos._2 + 1).weight += 1
      }
    }
  }

  def possibleMoves (): Array [Tile] = {
    val possM = board.possibleTiles (currentPosition.location)
    val weights = possM.map (_.weight)
    val minWeight = weights.min

    possM.filter (_.weight == minWeight)
  }

  def registerMove (move: Array [ (Int, Int) ] ): Unit = {
    traveledPath += move
  }

  def exportCSV (): Unit = {
    val out = new PrintWriter ("walks/path.csv")

    out.println("Posición actual, Posición siguiente")

    for (i <- traveledPath) {
      out.println (s"${i (0)._1};${i (0)._2}, ${i (1)._1};${i (1)._2}")
    }

    out.close ()
  }
}
