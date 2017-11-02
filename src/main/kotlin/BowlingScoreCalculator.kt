
fun calculate(rolls: String): Int {
  var score = 0
  for (roll in rolls) {
    score += calculateScore(roll)
  }
  return score
}

fun calculateScore(roll: Char) =
    when (roll) {
      in '1'..'9' -> String(charArrayOf(roll)).toInt()
      else -> 0
    }
