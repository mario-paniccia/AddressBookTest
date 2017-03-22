package addressbook.domain

class AddressBook(val entries: Seq[AddressBookEntry]) {

  def find(name: String):Option[AddressBookEntry] = entries.find(_.name == name)

}

object AddressBook {

  def apply(entries: AddressBookEntry*): AddressBook = new AddressBook(entries)
}
