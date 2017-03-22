package addressbook.stats

import addressbook.domain.AddressBook
import addressbook.utils.AddressBookImplicits._
import org.joda.time.{Days, LocalDate}

object AddressBookStats {


  def numberOfMales(addressBook: AddressBook): Int = addressBook.entries.count(_.sex == "Male")

  def oldestPerson(addressBook: AddressBook): Option[String] = {
    addressBook.entries match {
      case Nil => None
      case x +: xs => {
        val result = xs.foldLeft(x) {
        (acc, elem) => if(elem.dob < acc.dob) elem else acc
      }
        Some(result.name)
      }
    }
  }


  def numberOfDaysOlder(addressBook: AddressBook, p1: String, p2: String): Option[Int] = {

    def calculateDaysOlder(p1Dob: LocalDate, p2Dob: LocalDate): Int = Days.daysBetween(p1Dob, p2Dob).getDays

    addressBook.entries match {
      case Nil => None
      case _ => {
        val p1EntryOpt = addressBook.find(p1)
        val p2EntryOpt = addressBook.find(p2)
        for {
          p1 <- p1EntryOpt
          p2 <- p2EntryOpt
          p1Dob = p1.dob
          p2Dob = p2.dob
        } yield calculateDaysOlder(p1Dob, p2Dob)
      }
    }
  }

}
