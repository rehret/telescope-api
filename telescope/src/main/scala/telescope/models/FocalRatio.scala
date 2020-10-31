package telescope.models

import cats.Show

case class FocalRatio(value: Int)

object FocalRatio {
  implicit val focalRatioShow: Show[FocalRatio] = Show.show(focalRatio => s"f/${focalRatio.value}")
}
