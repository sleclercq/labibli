import dev.fritz2.binding.RootStore
import dev.fritz2.dom.html.render
import dev.fritz2.dom.mount

val books = listOf(
    Book("Le prince et le pauvre", "Mark Twain"),
    Book("Les quatre filles du docteur March", "Louisa May Alcott"),
    Book("Les trois mousquetaires", "Alexandre Dumas")
)

fun main() {

    render {
        books(books)
    }.mount("target")

}
