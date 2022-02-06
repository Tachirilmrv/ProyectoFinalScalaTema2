package cu.edu.cujae.inf



class Tile (xLoc: Int, yLoc: Int, act: Boolean) {
  val location: (Int, Int) = (xLoc, yLoc)
  var active: Boolean = act
  var weight: Int = 0
}
