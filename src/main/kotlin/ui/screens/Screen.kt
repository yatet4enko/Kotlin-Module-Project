package ui.screens

import ui.MenuItem
import java.lang.Exception
import java.util.Scanner

abstract class Screen() {

    protected open lateinit var menuItems: List<MenuItem>
    fun run(): Screen? {
        printContent()
        printMenu()

        return processSelectedMenuItem(scanMenuSelect())
    }

    abstract fun printContent()

    abstract fun processSelectedMenuItem(menuItem: MenuItem): Screen?
    private fun printMenu() {
        menuItems.forEachIndexed { index, menuItem ->
            println("${index}. ${menuItem.title}")
        }
    }

    private fun scanMenuSelect(): MenuItem {
        var menuItem: MenuItem? = null

        while (menuItem == null) {
            var inputInt: Int? = null

            try {
                inputInt = Scanner(System.`in`).nextInt()

                if (inputInt < 0 || inputInt > menuItems.size - 1) {
                    println("Такого числа нет, введите корректное значение:")
                    printMenu()

                    continue
                }

                menuItem = menuItems[inputInt]
            } catch (e: Exception) {

                println("Введите, пожалуйста, число:")
                printMenu()
            }
        }

        return menuItem
    }
}
