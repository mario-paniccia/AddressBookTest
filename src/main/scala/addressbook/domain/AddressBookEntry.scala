package addressbook.domain

import org.joda.time.LocalDate

case class AddressBookEntry(name: String, sex: String, dob: LocalDate)
