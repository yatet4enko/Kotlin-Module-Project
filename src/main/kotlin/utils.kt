import java.util.Scanner

fun scanNotEmptyText(title: String, emptyMessage: String): String {
    var text = ""

    while (text.isEmpty()) {
        println(title)

        text = Scanner(System.`in`).nextLine().trim()

        if (text.isEmpty()) {
            println(emptyMessage)
        }
    }

    return text
}
