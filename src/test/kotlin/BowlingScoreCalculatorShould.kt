import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class BowlingScoreCalculatorShould {

  @Test
  fun calculate_score_for_simple_roll() {
    assertThat(calculate("0"), `is`(0))
    assertThat(calculate("1"), `is`(1))
    assertThat(calculate("2"), `is`(2))
    assertThat(calculate("23"), `is`(5))
  }

  @Test
  fun `calculate score for a miss`() {
    assertThat(calculate("-"), `is`(0))
    assertThat(calculate("1-"), `is`(1))
  }

  @Test
  fun `calculate score for spares`() {
    assertThat(calculate("3/-"), `is`(10))
    assertThat(calculate("7/7/7/7/7/7/7/7/7/-"), `is`(146))
  }
}