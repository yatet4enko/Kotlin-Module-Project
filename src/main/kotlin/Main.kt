import ui.screens.ArchivesScreen
import ui.screens.Screen

fun main(args: Array<String>) {
    var currentScreen: Screen? = ArchivesScreen()

    while (currentScreen != null) {
        currentScreen = currentScreen.run()
    }
}