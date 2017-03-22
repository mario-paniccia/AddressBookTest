package addressbook.repository

import addressbook.domain.AddressBook

abstract class AddressBookRepository {

  def getAddressBook():AddressBook
}
