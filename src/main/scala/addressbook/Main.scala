package addressbook

import addressbook.domain.AddressBook

object Main extends App {

  val ab = new AddressBook(Seq.empty)


  println(AddressBookStats.numberOfMales(ab))
  println(AddressBookStats.oldestPerson(ab))
  println(AddressBookStats.numberOfDaysOlder(ab, "Bill McKnight", "Paul Robinson"))

}
