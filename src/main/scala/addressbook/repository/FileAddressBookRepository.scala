package addressbook.repository
import java.io.File
import java.text.DateFormat

import addressbook.domain.{AddressBook, AddressBookEntry}
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat

import scala.io.Source

class FileAddressBookRepository(path: String) extends AddressBookRepository {

  override def getAddressBook(): AddressBook = {
    val source = Source.fromFile(new File(path))

    val entries = for {line <- source.getLines().toSeq
                       cols = line.split(",").map(_.trim)
                  } yield {
                        AddressBookEntry(cols(0), cols(1), toDate(cols(2)))
                  }

    new AddressBook(entries)
  }

  private def toDate(s: String) = LocalDate.parse(s, DateTimeFormat.forPattern("dd/MM/yy"));
}
