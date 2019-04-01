package com.herr.vogt.actions

open class ActionDispatcher() {
    var actions: HashMap<String, (type: String, source: Any) -> Unit> = hashMapOf()
        protected set


    fun hasAction(type: String): Boolean {
        return actions.containsKey(type)
    }

    fun addAction(type: String, listener: (type: String, source: Any) -> Unit): Boolean {
        if(!hasAction(type)) {
            actions.put(type, listener)
            return true
        }
        return false
    }

    fun removeAction(type: String): Boolean {
        if(hasAction(type)) {
            actions.remove(type)
            return true
        }
        return false
    }

    fun dispatchAction(type: String, source: Any) {
        if(hasAction(type)) {
            actions.get(type)?.invoke(type, source)
        }
    }
}