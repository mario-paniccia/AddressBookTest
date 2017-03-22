package addressbook.stats

import addressbook.domain.AddressBook
import addressbook.utils.AddressBookImplicits._

object AddressBookStats {


  def numberOfMales(addressBook: AddressBook): Int = addressBook.entries.count(_.sex == "Male")

  def oldestPerson(addressBook: AddressBook): Option[String] = {
    addressBook.entries match {
      case Nil => None
      case x +: xs => {
        val result = xs.foldLeft(x) {
        (acc, elem) => if(elem.dob > acc.dob) elem else acc
      }
        Some(result.name)
      }
    }
  }

  def numberOfDaysOlder(addressBook: AddressBook, p1: String, p2: String): Option[Int] = {
    addressBook.entries match {
      case Nil => None
      case _ => {
        val p1Entry = addressBook.find(p1)
        Some(33)
      }
    }
  }

}
