package cu.edu.cujae.inf

import java.io.{BufferedWriter, FileWriter}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}



class Robot (val maxMoves: Int, val initialPosition: (Int, Int), val board: Board) {
  val traveledPath = new ArrayBuffer [Array [ (Int, Int) ] ] (maxMoves)
  private var currentPosition = initialPosition


  def walk (aTile: (Int, Int) ): Unit = {
    val moves = Array (currentPosition, aTile)

    currentPosition = aTile

    registerMove (moves)
  }

  //Listo listoni
  def possibleMoves (): Array [Tile] = {
    val possM = board.possibleTiles (currentPosition)
    val weights = possM.map (_.weight)
    val minWeight = weights.min

    possM.filter (_.weight == minWeight)
  }

  //Listo listoni
  def registerMove (move: Array [ (Int, Int) ] ): Unit = {
    traveledPath += move
  }

  def exportCSV (): Unit = {
    val outputFile = new BufferedWriter (new FileWriter ("/blablabla.csv") )
    val csvSchema = Array ("From", "To")

   /* var listOfRecords = new ListBuffer [Array [] ]
    listOfRecords += csvFields

    for (i listOfRecords += Array () ) {
      outputFile

      outputFile.close ()
    }*/
  }
}
