import dev.fritz2.binding.RootStore
import dev.fritz2.dom.html.render
import dev.fritz2.dom.mount

val books = listOf(
    Book("Le prince et le pauvre"),
    Book("Les quatre filles du docteur March")
)

fun main() {

    val booksStore = object : RootStore<List<Book>>(books) {

        var count = 0

        val addItem = handle { list ->
            count++
            list + Book("yet another book title no. $count")
        }

        val deleteItem = handle<Book> { list, current ->
            list.minus(current)
        }

    }

    render {
        div("books") {
            ul {
                booksStore.data.renderEach { s ->
                    li {
                        button("btn", id = "delete-btn") {
                            +s.title
                            clicks.map { console.log("deleting $s"); s } handledBy booksStore.deleteItem
                        }
                    }
                }
            }
            button("button") {
                +"add an item"
                clicks handledBy booksStore.addItem
            }
        }
    }.mount("target")

}
