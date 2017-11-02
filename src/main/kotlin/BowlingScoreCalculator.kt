
fun calculate(rolls: String): Int {
  var score = 0
  for (roll in rolls) {
    score += calculateScore(roll)
  }
  return score
}

fun calculateScore(roll: Char) = String(charArrayOf(roll)).toInt()
