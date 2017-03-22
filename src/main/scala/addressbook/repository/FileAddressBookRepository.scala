package addressbook.repository

import Control._
import addressbook.domain.{AddressBook, AddressBookEntry}
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat

import scala.io.Source

class FileAddressBookRepository(resource: String) extends AddressBookRepository {

  //assuming file contains only valid lines
  override def getAddressBook(): AddressBook = {

    using(Source.fromResource(resource)) { source => {
      val entries = for {line <- source.getLines().toVector
                         cols = line.split(",").map(_.trim)
      } yield {
        AddressBookEntry(cols(0), cols(1), toDate(cols(2)))
      }
      new AddressBook(entries)
    }
    }
  }

  private def toDate(s: String) = LocalDate.parse(s, DateTimeFormat.forPattern("dd/MM/yy"));
}


object Control {
  def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      resource.close()
    }
}