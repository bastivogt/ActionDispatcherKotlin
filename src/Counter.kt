import com.herr.vogt.actions.ActionDispatcher


open class Counter(start: Int = 0, end: Int = 10, step: Int = 1): ActionDispatcher() {
    var start: Int = start
        protected set
    var end: Int = end
        protected set
    var step: Int = step
        protected set
    var count: Int = 0
        protected set

    init {

    }


    companion object {
        const val COUNTER_START = "counterStart"
        const val COUNTER_CHANGE = "counterChange"
        const val COUNTER_FINISH = "counterFinish"
    }

    fun run() {
        dispatchAction(COUNTER_START, this)
        for(i: Int in start..end step this.step) {
            count = i
            dispatchAction(COUNTER_CHANGE, this)
        }
        dispatchAction(COUNTER_FINISH, this)
    }


    fun reset(start: Int, end: Int, step: Int) {
        this.start = start
        this.end = end
        this.step = step
        count = 0
    }
}