package addressbook.domain

class AddressBook(var entries: Seq[AddressBookEntry])

object AddressBook {

  def apply(entries: AddressBookEntry*): AddressBook = new AddressBook(entries)
}
