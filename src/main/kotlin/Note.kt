class Note (val name: String, val text: String) {
    fun show(){
        printLine()
        println("| $name |")
        printLine()
        println("| $text |")
        printLine()
    }

    fun printLine(){
        print("+")
        repeat((maxOf(name.length, text.length)+2)){
            print("-")
        }
        print("+\n")
    }
}