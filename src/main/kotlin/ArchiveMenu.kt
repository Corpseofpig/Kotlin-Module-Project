class ArchiveMenu(private val mainMenu: MainMenu) {

    private val menu = Menu(
        listOf(
            "Создание архива" to ::createArchive,
            "Просмотр архива" to ::viewArchives,
            "Назад в главное меню" to ::returnBack
        )
    )

    val archives = mutableListOf<Archive>()

    fun start() {
        while (true) {
            menu.show()
        }
    }

    private fun createArchive() {
        print("Введите имя архива (Оставьте пустым и нажмите Enter для выхода):\n>  ")
        val name = readLine() ?: ""

        if (name.isEmpty()) {
            return
        } else {
            archives.add(Archive(name))
            println("Архив успешно создан")
        }
    }

    private fun viewArchives() {
        if (archives.isEmpty()) {
            println("Список архивов пуст")
            return
        }

        archives.forEachIndexed { index, archive -> println("$index. ${archive.name}") }

        while (true){
            print("Выберите архив для просмотра: ")
            val index = readLine()?.toIntOrNull() ?: -1
            if(index == -1) return

            if(index < 0 || index > archives.size-1){
                println("Неверный номер архива. Попробуйте еще раз")
                continue
            }

            archives[index].showNotes()
            break
        }


    }

    private fun returnBack() {
        mainMenu.start()
    }

}