
fun calculate(rolls: String): Int {
  return rolls.fold(0) { score, roll ->
    score + calculateScore(roll)
  }
}

fun calculateScore(roll: Char) =
    when (roll) {
      in '1'..'9' -> String(charArrayOf(roll)).toInt()
      else -> 0
    }
