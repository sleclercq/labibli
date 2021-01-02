import dev.fritz2.binding.RootStore
import dev.fritz2.binding.SimpleHandler
import dev.fritz2.dom.html.Div
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.dom.html.Tr

fun RenderContext.book(book: Book, bookDeleteFunction: SimpleHandler<Book>): Tr {

    return tr {
        td { +book.title }
        td { +book.author }
        td {
            button("btn", id = "delete-btn") {
                +"Delete"
                clicks.map { console.log("deleting $book"); book } handledBy bookDeleteFunction
            }
        }
    }

}
