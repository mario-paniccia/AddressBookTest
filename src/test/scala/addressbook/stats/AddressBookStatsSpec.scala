package addressbook.stats

import addressbook.domain.{AddressBook, AddressBookEntry, AddressBookSpec}
import org.joda.time.LocalDate
import org.scalatest.{FlatSpec, Matchers}

class AddressBookStatsSpec extends FlatSpec with Matchers {

  val Dob = new LocalDate(1981, 5, 13)
  val Dob2 = new LocalDate(2000, 5, 13)
  val Dob3 = new LocalDate(2010, 5, 13)

  val EmptyAddressBook = AddressBook()

  "AddressBookStats" should "return number of males" in {

    val ab = AddressBook(AddressBookEntry("p1", "Male", Dob),
      AddressBookEntry("p2", "Male", Dob2),
      AddressBookEntry("p3", "Female", Dob3))

    AddressBookStats.numberOfMales(ab) shouldBe 2
  }

  "AddressBookStats" should "return 0 number of males when empty" in {

    AddressBookStats.numberOfMales(EmptyAddressBook) shouldBe 0
  }

  "AddressBookStats" should "return the oldest person" in {

    val ab = AddressBook(AddressBookEntry("p1", "Male", Dob),
      AddressBookEntry("p2", "Male", Dob2),
      AddressBookEntry("p3", "Female", Dob3))

    AddressBookStats.oldestPerson(ab) shouldBe Some("p3")
  }

  "AddressBookStats" should "return None when address book is empty" in {

    AddressBookStats.oldestPerson(EmptyAddressBook) shouldBe None
  }

}
