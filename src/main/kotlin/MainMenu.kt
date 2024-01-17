class MainMenu {
    val archiveMenu = ArchiveMenu(this)
    val noteMenu = NoteMenu(this, archiveMenu.archives)

    val menu = Menu(
        listOf(
            "Архивы" to { archiveMenu.start() },
            "Заметки" to { noteMenu.start() },
            "Выйти" to { exit() }
        )
    )

    fun start() {
        while (true) {
            menu.show()
        }
    }

    fun exit() {
        println("Завершение работы")
        System.exit(0)
    }
}