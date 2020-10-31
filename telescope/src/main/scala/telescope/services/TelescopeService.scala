package telescope.services

import telescope.models.{Eyepiece, FieldOfView, Magnification, Telescope}

class TelescopeService {
  def maximumAvailableMagnification(
      telescope: Telescope,
      eyepieces: List[Eyepiece]): Option[(Eyepiece, Magnification)] = {
    val maxMagnification = maximumUsefulMagnification(telescope)
    eyepieces
      .map(e => (e, magnification(telescope, e)))
      .filter(tuple => tuple._2.value <= maxMagnification.value)
      .maxByOption(tuple => tuple._2.value)
  }

  def maximumUsefulMagnification(telescope: Telescope): Magnification =
    magnification(telescope, Eyepiece(telescope.fRatio.value, FieldOfView(0)))

  def magnification(telescope: Telescope, eyepiece: Eyepiece): Magnification =
    Magnification(telescope.focalLength / eyepiece.focalLength)

  def fieldOfView(telescope: Telescope, eyepiece: Eyepiece): FieldOfView =
    FieldOfView(
      eyepiece.fieldOfView.value / magnification(telescope, eyepiece).value
    )
}
