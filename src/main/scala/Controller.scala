package cu.edu.cujae.inf



object Controller extends App {
  /* Caso de prueba pequeño 6x6 */
  val goal = (2, 0)
  val start = (0, 0)

  var xPath = Array (2, 3, 4, 5, 0, 2, 3, 5, 0, 4, 5, 0, 1, 2, 3, 4, 1, 4, 1, 2, 4)
  var yPath = Array (0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5)

  xPath = xPath.map(_ + 1)
  yPath = yPath.map(_ + 1)

  val path = xPath.zip (yPath)
  val b = new Board (6, 6, new Tile (goal._1 + 1, goal._2 + 1, true), path)
  val bot = new Robot (new Tile (start._1 + 1, start._2 + 1, false), b)


  /* Caso de prueba mediano 8x8 */
/*  val goal = (6, 1)
  val start = (1, 6)

  var xPath = Array (1, 3, 1, 2, 3, 5, 6, 1, 5, 1, 2, 3, 4, 5, 6, 1, 6, 1, 2, 3, 4, 6, 4, 6, 4, 5, 6)
  var yPath = Array (0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 7, 7, 7)

  xPath = xPath.map(_ + 1)
  yPath = yPath.map(_ + 1)

  val path = xPath.zip (yPath)
  val b = new Board (8, 8, new Tile (goal._1 + 1, goal._2 + 1, true), path)
  val bot = new Robot (new Tile (start._1 + 1, start._2 + 1, false), b)*/


  /* Caso de prueba grande 10x10 */
/*  val goal = (0, 0)
  val start = (9, 9)

  var xPath = Array (0, 8, 0, 1, 5, 6, 7, 8, 1, 2, 5, 7, 2, 4, 5, 7, 8, 2, 4, 8, 2, 4, 8, 0, 1, 2, 3, 4, 5, 6, 8, 0, 4, 6, 7, 8, 0, 1, 2, 3, 4, 8, 4, 8)
  var yPath = Array (0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9)

  xPath = xPath.map(_ + 1)
  yPath = yPath.map(_ + 1)

  val path = xPath.zip (yPath)
  val b = new Board (10, 10, new Tile (goal._1 + 1, goal._2 + 1, true), path)
  val bot = new Robot (new Tile (start._1 + 1, start._2 + 1, false), b)*/


  bot.goToGoal ()
  bot.exportCSV ()
}
