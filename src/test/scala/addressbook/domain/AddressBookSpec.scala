package addressbook.domain

import org.joda.time.LocalDate
import org.scalatest.{FlatSpec, Matchers}

class AddressBookSpec extends FlatSpec with Matchers {

  val Dob = new LocalDate(1981, 5, 13)


  "AddressBook" should "find an entry by name" in {

    val ab = AddressBook(AddressBookEntry("p1", "Male", Dob),
      AddressBookEntry("p2", "Male", Dob),
      AddressBookEntry("p3", "Female", Dob))

    ab.find("p3") shouldBe Some(AddressBookEntry("p3", "Female", Dob))
  }

  "AddressBook" should "return None when no entry with requested name" in {

    val ab = AddressBook()

    ab.find("p3") shouldBe None
  }

}
