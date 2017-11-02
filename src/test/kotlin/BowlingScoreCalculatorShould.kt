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

  @Test
  fun `calculate score for strikes`() {
    assertThat(calculate("X"), `is`(10))
    assertThat(calculate("X52"), `is`(24))
  }

  @Test
  fun `calculate score for spares and strikes`() {
    assertThat(calculate("1/X1/2"), `is`(54))
  }

  @Test
  fun `calculate score for last frame`() {
    assertThat(calculate("1/35XXX458/X3/XX6"), `is`(189))
  }
}