

fun main() {
    val c: Counter = Counter()

/*    val counterFinsih: (String, Any) -> Unit = fun(type: String, source: Any) {
        val c = source as Counter
        println("$type : ${c.count}")
    }

    val counterFinsih = fun(type: String, source: Any) {
        val c = source as Counter
        println("$type : ${c.count}")
    }*/

/*    val counterFinish = {type: String, source: Any ->
        val c = source as Counter
        println("$type : ${c.count}")
    }

    c.addAction(Counter.COUNTER_FINISH, counterFinish)*/




    c.addAction(Counter.COUNTER_START) {type: String, source: Any ->
        val c = source as Counter
        println("$type : ${c.count}")
        //c.removeAction(Counter.COUNTER_FINISH)
    }

    c.addAction(Counter.COUNTER_CHANGE, ::counterChange)

    c.addAction(Counter.COUNTER_FINISH, fun(type: String, source: Any) {
        val c = source as Counter
        println("$type : ${c.count}")
    })

    c.run()
}

fun counterChange(type: String, source: Any) {
    val c = source as Counter
    println("$type : ${c.count}")
}