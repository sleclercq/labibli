import dev.fritz2.binding.RootStore
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.dom.html.Table



fun RenderContext.books(books: List<Book>): Table {

    val booksStore = object : RootStore<List<Book>>(books) {

        var count = 0

        val addItem = handle { list ->
            count++
            list + Book("yet another book title no. $count", "Some Author")
        }

        val deleteItem = handle<Book> { list, current ->
            list.minus(current)
        }
    }

    return table("books") {
        thead {
            tr {
                th { +"Title" }
                th { +"Author" }
                th { +"Actions" }
            }
        }
        booksStore.data.renderEach { b -> book(b, booksStore.deleteItem) }
        button("button") {
            +"add an item"
            clicks handledBy booksStore.addItem
        }
    }

}
