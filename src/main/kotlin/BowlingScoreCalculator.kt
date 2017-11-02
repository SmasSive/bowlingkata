
private const val SPARE = '/'
private const val MISS = '-'
private const val STRIKE = 'X'
private const val TOTAL_NUMBER_OF_FRAMES: Int = 18

fun calculate(rolls: String): Int {
  return rolls.foldIndexed(0) { index, score, roll ->
    score + calculateScore(roll) - spareDiff(rolls, roll, index) + bonus(rolls, roll, index)
  }
}
private fun bonus(rolls: String, roll: Char, index: Int): Int {
  if (isLastFrame(rolls, index)) return 0

  val nextScore = calculateScore(rolls.next(index))
  return when (roll) {
    SPARE -> nextScore
    STRIKE -> {
      val nextButOne = rolls.next(index + 1)
      nextScore + calculateScore(nextButOne) - spareDiff(rolls, nextButOne, index + 2)
    }
    else -> 0
  }
}

private fun isLastFrame(rolls: String, index: Int): Boolean {
  return TOTAL_NUMBER_OF_FRAMES <= rolls.substring(0, index)
      .map { roll -> if (roll == STRIKE) 2 else 1 }
      .fold(0) { acc, roll -> acc + roll }
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
      SPARE, STRIKE -> 10
      else -> 0
    }
