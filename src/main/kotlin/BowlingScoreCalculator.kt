
private const val SPARE = '/'
private const val MISS = '-'

fun calculate(rolls: String): Int {
  return rolls.foldIndexed(0) { index, score, roll ->
    score + calculateScore(roll) - spareDiff(rolls, roll, index) + bonus(rolls, roll, index)
  }
}

private fun bonus(rolls: String, roll: Char, index: Int): Int {
  return if (roll == SPARE) calculateScore(rolls.next(index)) else 0
}

private fun String.next(index: Int): Char {
  return if (index < length - 1) this[index + 1] else MISS
}

private fun spareDiff(rolls: String, roll: Char, index: Int): Int {
  return if (roll == SPARE) calculateScore(rolls.previous(index)) else 0
}

private fun String.previous(index: Int): Char {
  return if (index > 0) this[index - 1] else MISS
}

private fun calculateScore(roll: Char) =
    when (roll) {
      in '1'..'9' -> String(charArrayOf(roll)).toInt()
      SPARE -> 10
      else -> 0
    }
