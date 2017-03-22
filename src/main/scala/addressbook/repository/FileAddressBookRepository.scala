package addressbook.repository
import addressbook.domain.AddressBook

class FileAddressBookRepository(path: String) extends AddressBookRepository {

  override def getAddressBook(): AddressBook = ???
}
