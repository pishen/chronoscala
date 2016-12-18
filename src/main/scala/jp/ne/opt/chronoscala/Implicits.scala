package jp.ne.opt.chronoscala

import java.time._

import jp.ne.opt.chronoscala.Tag.CS

import scala.language.implicitConversions

trait Implicits
  extends IntImplicits
  with DurationImplicits
  with TimeImplicits
  with ZoneImplicits
  with OrderingImplicits

trait NamespacedImplicits
  extends NamespacedIntImplicits
  with DurationImplicits
  with TimeImplicits
  with ZoneImplicits
  with OrderingImplicits

trait IntImplicits {
  implicit def richInt(n: Int): RichInt = new RichInt(n)
}

trait NamespacedIntImplicits {
  implicit def richIntCs(n: Int): RichAny[Int] = new RichAny(n)
  implicit def richCsInt(n: CS[Int]): RichInt = new RichInt(n)
}

trait DurationImplicits {
  implicit def richDuration(d: Duration): RichDuration = new RichDuration(d)
  implicit def richPeriod(p: Period): RichPeriod = new RichPeriod(p)
}

trait TimeImplicits {
  implicit def richZonedDateTime(t: ZonedDateTime): RichZonedDateTime = new RichZonedDateTime(t)
  implicit def richLocalDateTime(t: LocalDateTime): RichLocalDateTime = new RichLocalDateTime(t)
  implicit def richLocalTime(t: LocalTime): RichLocalTime = new RichLocalTime(t)
  implicit def richLocalDate(t: LocalDate): RichLocalDate = new RichLocalDate(t)
  implicit def richInstant(i: Instant): RichInstant = new RichInstant(i)
}

trait ZoneImplicits {
  implicit def stringToZoneId(s: String): ZoneId = ZoneId.of(s)
}

trait OrderingImplicits {
  implicit val zonedDateTimeOrdering: Ordering[ZonedDateTime] = Ordering.fromLessThan(_ isBefore _)
  implicit val localDateTimeOrdering: Ordering[LocalDateTime] = Ordering.fromLessThan(_ isBefore _)
  implicit val localDateOrdering: Ordering[LocalDate] = Ordering.fromLessThan(_ isBefore _)
  implicit val localTimeOrdering: Ordering[LocalTime] = Ordering.fromLessThan(_ isBefore _)
  implicit val instantOrdering: Ordering[Instant] = Ordering.fromLessThan(_ isBefore _)
}
