import dev.fritz2.binding.RootStore
import dev.fritz2.dom.html.render
import dev.fritz2.dom.mount

val book1 = Book("Le prince et le pauvre", "Mark Twain", "978-3-16-148410-0")
val book2 = Book("Les quatre filles du docteur March", "Louisa May Alcott", "978-3-16-148411-0")
val book3 = Book("Les trois mousquetaires", "Alexandre Dumas", "978-3-16-148412-0")

val books = listOf(book1, book2, book3)

val bookLists = listOf(
    BookList("Stanislas CE1", listOf(book1)),
    BookList("Stanislas CM2", listOf(book2, book3))
)

val reader1 = Reader("Delphine")
val reader2 = Reader("Sacha")
val reader3 = Reader("Florian")

val readers = listOf(reader1, reader2, reader3)

val readings = listOf(
    Reading(reader1, book2, ReadingStatus.READING),
    Reading(reader1, book3, ReadingStatus.READ),
    Reading(reader2, book1, ReadingStatus.READ),
    Reading(reader3, book1, ReadingStatus.WANTED)
)


fun main() {

    render {
        books(books)
    }.mount("target")

}
