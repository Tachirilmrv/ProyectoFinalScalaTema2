package cu.edu.cujae.inf



object Controller extends App {
  val xPath = Array (1, 3, 1, 2, 3, 5, 6, 1, 5, 1, 2, 3, 4, 5, 6, 1, 6, 1, 2, 3, 4, 6, 4, 6, 4, 5, 6)
  val yPath = Array (0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 7, 7, 7)
  val path = xPath.zip (yPath)
  val b = new Board (8, 8, new Tile (6, 1, true), path)
  val bot = new Robot (new Tile (1, 6, false), b)

  bot.goToGoal ()
  bot.exportCSV ()
}
