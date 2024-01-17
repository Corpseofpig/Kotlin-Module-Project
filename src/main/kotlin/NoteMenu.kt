class NoteMenu(
    private val mainMenu: MainMenu,
    private val archives: List<Archive>
){

    private val menu = Menu(
        listOf(
            "Создание заметки" to ::createNote,
            "Просмотр заметок" to ::viewNotes,
            "Сохранение заметки в архив" to ::saveNoteToArchive,
            "Назад в главное меню" to ::returnBack
        )
    )

    private val notes = mutableListOf<Note>()

    fun start() {
        while (true) {
            menu.show()
        }
    }

    private fun createNote() {

        print("Введите название заметки (Оставьте пустым и нажмите Enter для выхода):\n>  ")
        val name = readLine() ?: ""

        if (name.isBlank()) {
            return
        }

        print("Введите текст заметки: (Оставьте пустым и нажмите Enter для выхода):\n> ")
        val text = readLine() ?: ""

        if (text.isBlank()) {
            return
        }

        val newNote = Note(name, text)
        notes.add(newNote)
        println("Заметка успешно создана")
    }

    private fun viewNotes() {
        if (notes.isEmpty()) {
            println("Список заметок пуст.")
            return
        }

        while (true){
            showNotes()

            print("Введите номер заметки (Нажмите Enter для выхода):\n>  ")
            val choice = readLine()?.toIntOrNull()

            if(choice == null) return

            if(choice < 0 || choice > notes.size){
                println("Неверный номер заметки. Попробуйте еще раз")
                continue
            }

            println("Просмотр заметки:")
            notes[choice].show()
            break
        }
    }

    private fun saveNoteToArchive() {
        if(notes.isEmpty()){
            println("Список заметок пуст.")
            return
        }
        if(archives.isEmpty()){
            println("Список архивов пуст")
            return
        }

        while (true){
            showNotes()
            print("Введите номер заметки (Нажмите Enter для выхода):\n>  ")
            val noteIndex = readLine()?.toIntOrNull() ?: -1

            if(noteIndex == -1) return

            if(noteIndex < 0 || noteIndex > notes.size-1){
                println("Неверный номер заметки. Попробуйте еще раз")
                continue
            }

            showArchives()
            print("Введите номер архива (Нажмите Enter для выхода):\n> ")
            val archiveIndex = readLine()?.toIntOrNull() ?: -1

            if(archiveIndex == -1) return

            if(archiveIndex < 0 || archiveIndex > archives.size-1){
                println("Неверный номер архива. Попробуйте еще раз")
                continue
            }

            val note = notes[noteIndex]
            val archive = archives[archiveIndex]

            archive.addNote(note)

            println("Заметка успешно сохранена")
            return
        }
    }

    private fun showNotes(){
        notes.forEachIndexed { index, note -> println("$index. ${note.name}")}
    }

    private fun showArchives(){
        archives.forEachIndexed { index, note -> println("$index. ${note.name}")}
    }

    private fun returnBack() {
        mainMenu.start()
    }
}