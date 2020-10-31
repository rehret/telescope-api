package telescope.models

import cats.Show

case class FieldOfView(value: Double)

object FieldOfView {
  implicit val fieldOfViewShow: Show[FieldOfView] =
    Show.show(fieldOfView => s"${fieldOfView.value}°")
}
