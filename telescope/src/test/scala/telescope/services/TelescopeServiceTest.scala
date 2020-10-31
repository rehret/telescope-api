package telescope.services

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import telescope.models._

class TelescopeServiceTest extends AnyFunSpec with Matchers {
  describe("TelescopeService") {
    val telescopeService = new TelescopeService()

    describe("magnification") {
      it("should calculate magnification as ratio of telescope focal length to eyepiece focal length") {
        // Arrange
        val telescope = Telescope(100.0, FocalRatio(10))
        val eyepiece = Eyepiece(10.0, FieldOfView(0))

        // Act
        val result = telescopeService.magnification(telescope, eyepiece)

        // Assert
        result shouldEqual Magnification(10.0)
      }
    }

    describe("maximumUsefulMagnification") {
      it("should calculate maximum useful magnification using the f-ratio as the eyepiece focal length") {
        // Arrange
        val telescope = Telescope(100.0, FocalRatio(10))

        // Act
        val result = telescopeService.maximumUsefulMagnification(telescope)

        // Assert
        result shouldEqual Magnification(10.0)
      }
    }

    describe("maximumAvailableMagnification") {
      it("should calculate the maximum magnification of all provided eyepieces with a magnification less than or equal to the maximum useful magnification") {
        // Arrange
        val telescope = Telescope(100.0, FocalRatio(10))
        val eyepieces = List(
          Eyepiece(5.0, FieldOfView(0)),
          Eyepiece(20.0, FieldOfView(0))
        )

        // Act
        val result =
          telescopeService.maximumAvailableMagnification(telescope, eyepieces)

        // Assert
        result shouldEqual Some(
          (Eyepiece(20.0, FieldOfView(0)), Magnification(5.0)))
      }

      it("should return None if no provided eyepieces are within the maximum useful magnification") {
        // Arrange
        val telescope = Telescope(100.0, FocalRatio(10))
        val eyepieces = List(
          Eyepiece(5.0, FieldOfView(0))
        )

        // Act
        val result =
          telescopeService.maximumAvailableMagnification(telescope, eyepieces)

        // Assert
        result shouldEqual None
      }
    }

    describe("fieldOfView") {
      it("should calculate the field of view of the given telescope and eyepiece as the ratio of the eyepiece's field of view to the combined magnification") {
        // Arrange
        val telescope = Telescope(100.00, FocalRatio(10))
        val eyepiece = Eyepiece(10.00, FieldOfView(80))

        // Act
        val result = telescopeService.fieldOfView(telescope, eyepiece)

        // Assert
        result shouldEqual FieldOfView(8)
      }
    }
  }
}
