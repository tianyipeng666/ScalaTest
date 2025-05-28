package conf

object UdfUtils {

  private val time_map = Map(
    "d" -> 1000 * 60 * 60 * 24,
    "day" -> 1000 * 60 * 60 * 24,
    "h" -> 1000 * 60 * 60,
    "hour" -> 1000 * 60 * 60,
    "m" -> 1000 * 60,
    "minute" -> 1000 * 60,
    "s" -> 1000,
    "second" -> 1000)

  def parseTime(time: String): Long = {
    val (value, unit) = time.partition( c => c > '0' && c < '9')
    value.toLong * time_map(unit)
  }
}
