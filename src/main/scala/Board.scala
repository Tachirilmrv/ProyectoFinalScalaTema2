package cu.edu.cujae.inf



class Board (val numbOfRows: Int, val numberOfCol: Int, val goal: (Int, Int), actPath: Array [ (Int, Int) ] ) {
  val board: Array [Array [Tile] ] = Array ofDim [Tile] (numbOfRows, numberOfCol)
  calcTilesWeight ()


  def activatePath (): Boolean = {
    for (i <- actPath) {
      val t:Tile = board apply i

      t.active = true
    }

    /* ToDo Validar que el camino conecte la salida con la meta */

    false
  }

  //Listo listoni
  def possibleTiles (aTile: (Int, Int) ): Array [Tile] = {
    val a = new Array [Tile] (4)

    a (0) = board apply (aTile._1 + 1, aTile._2)
    a (1) = board apply (aTile._1 - 1, aTile._2)
    a (2) = board apply (aTile._1, aTile._2 + 1)
    a (3) = board apply (aTile._1, aTile._2 - 1)

    a.filter (_.active)
  }


  //Listo Listoni
  private def calcTilesWeight (): Unit = {
    for (i <- actPath) {
      val t: Tile = board apply i

      t.weight = distanceToGoal (board apply i)
    }
  }

  //Listo Listoni
  private def distanceToGoal (aTile: (Int, Int) ): Int = {
    val xDist = Math.abs (goal._1 - aTile._1)
    val yDist = Math.abs (goal._2 - aTile._2)

    xDist + yDist
  }
}
