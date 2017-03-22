package addressbook

import addressbook.repository.FileAddressBookRepository
import addressbook.stats.AddressBookStats

object Main extends App {

  val addressBookRepository = new FileAddressBookRepository("inputs.txt")
  val ab = addressBookRepository.getAddressBook()

  println(AddressBookStats.numberOfMales(ab))
  println(AddressBookStats.oldestPerson(ab))
  println(AddressBookStats.numberOfDaysOlder(ab, "Bill McKnight", "Paul Robinson"))

}
