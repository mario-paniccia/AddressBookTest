package addressbook.repository

import addressbook.domain.AddressBookEntry
import org.joda.time.LocalDate
import org.scalatest.{FlatSpec, Matchers}

class FileAddressBookRepositorySpec extends FlatSpec with Matchers {

  "a FileAddressBookRepository" should "be able to read a valid address book from file" in {

    val repo = new FileAddressBookRepository("inputs_sample.txt")

    val ab = repo.getAddressBook()

    ab.entries should have size 2
    ab.entries should contain allOf (AddressBookEntry("Bill McKnight", "Male", new LocalDate(1977, 3, 16)),
                                AddressBookEntry("Sarah Stone", "Female", new LocalDate(1980, 9, 20)))
  }

}
