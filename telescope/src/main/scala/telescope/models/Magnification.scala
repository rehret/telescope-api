package telescope.models

import cats.Show

case class Magnification(value: Double)

object Magnification {
  implicit val showMagnification: Show[Magnification] = Show.show(magnification => s"${magnification.value}x")
}