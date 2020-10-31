package telescope.models

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class FocalRatioTest extends AnyFunSpec with Matchers {
  describe("FocalRatio") {
    describe("Show") {
      import cats.implicits._

      it("should return the focal ratio in the format 'f/XXX'") {
        // Arrange
        val focalRatio = FocalRatio(25)

        // Act
        val result = focalRatio.show

        // Assert
        result shouldEqual "f/25"
      }
    }
  }
}
