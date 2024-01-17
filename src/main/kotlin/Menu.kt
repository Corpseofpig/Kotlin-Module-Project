import java.util.Scanner

class Menu(private val items: List<Pair<String, () -> Unit>>) {

    fun show() {
        println("\n+++++++++++++++++++++++++++")
        items.forEachIndexed { index, item -> println("$index. ${item.first}")}

        execute()
    }

    fun getChoice(): Int {
        val scanner = Scanner(System.`in`)
        var choice: Int
        while (true) {
            try {
                print("Выберите опцию (0 - ${items.size-1}): \n> ")
                choice = scanner.nextInt()

                if (choice < 0 || choice >= items.size) {
                    println("Опция не найдена. Попробуйте еще раз")
                } else {
                    break
                }

            } catch (e: java.util.InputMismatchException) {
                println("Введено не число. Попробуйте еще раз")
                scanner.nextLine()
            }
        }
        return choice
    }

    fun execute() {
        val choice = getChoice()
        items[choice].second.invoke()
    }

}