
class Archive(val name: String) {
    val notes = mutableListOf<Note>()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun showNotes() {
        if (notes.isEmpty()) {
            println("Архив $name пуст.")
        } else {
            while(true){
                println()
                notes.forEachIndexed { index, note ->
                    println("$index. ${note.name}")
                }

                print("Введите номер заметки (Нажмите Enter для выхода)\n>  ")
                val choice = readLine()?.toIntOrNull()

                if(choice == null) return

                if (choice >= 0 && choice < notes.size) {
                    println("Содержимое заметки:")
                    notes[choice].show()
                } else {
                    println("Неверный номер заметки. Попробуйте еще раз")
                }
            }


        }
    }
}