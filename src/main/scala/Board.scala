package cu.edu.cujae.inf



class Board (val numbOfRows: Int, val numberOfCol: Int, val goal: Tile, actPath: Array [ (Int, Int) ] ) {
  val board: Array [Array [Tile] ] = Array ofDim [Tile] (numbOfRows + 1, numberOfCol + 1)

  for (i <- board.indices; j <- board (i).indices) {
    if (actPath.contains ( (i, j) ) )
      board (i) (j) = new Tile (i, j, true)
    else
      board (i) (j) = new Tile (i, j, false)
  }
  calcTilesWeight ()

  //Listo Listoni
  def activatePath (): Boolean = {
    for (i <- actPath) {
      val t:Tile = board (i._1) (i._2)

      t.active = true
    }

    /* ToDo Validar que el camino conecte la salida con la meta */

    false
  }

  //Listo listoni
  def possibleTiles (aTile: (Int, Int) ): Array [Tile] = {
    val a = new Array [Tile] (4)

    a (0) = board (aTile._1 + 1) (aTile._2)
    a (1) = board (aTile._1 - 1) (aTile._2)
    a (2) = board (aTile._1) (aTile._2 + 1)
    a (3) = board (aTile._1) (aTile._2 - 1)

    a.filter (_.active)
  }

  //Listo Listoni
  def len (): Int = {
    numbOfRows * numberOfCol
  }


  //Listo Listoni
  private def calcTilesWeight (): Unit = {
    for (i <- actPath) {
      val t: Tile = board (i._1) (i._2)

      t.weight = distanceToGoal (i)
    }
  }

  //Listo Listoni
  private def distanceToGoal (aTile: (Int, Int) ): Int = {
    val xDist = Math.abs (goal.location._1 - aTile._1)
    val yDist = Math.abs (goal.location._2 - aTile._2)

    xDist + yDist
  }
}
