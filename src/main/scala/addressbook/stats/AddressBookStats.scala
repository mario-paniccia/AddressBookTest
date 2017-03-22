package addressbook.stats

import addressbook.domain.AddressBook

object AddressBookStats {


  def numberOfMales(addressBook: AddressBook): Int = addressBook.entries.count(_.sex == "Male")

  def oldestPerson(addressBook: AddressBook): String = ???

  def numberOfDaysOlder(addressBook: AddressBook, p1: String, p2: String): Int = ???

}
