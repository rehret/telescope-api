package telescope.models

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MagnificationTest extends AnyFunSpec with Matchers {
  describe("Magnification") {
    describe("Show") {
      import cats.implicits._

      it("should return the magnification followed by 'x'") {
        // Arrange
        val magnification = Magnification(123.45)

        // Act
        val result = magnification.show

        // Assert
        result shouldEqual "123.45x"
      }
    }
  }
}
