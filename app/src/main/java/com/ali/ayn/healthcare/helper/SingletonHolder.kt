package com.ali.ayn.healthcare.helper

open class SingletonHolder<in A, out T : Any>(private val creator: (A) -> T) {

    //for singleton instantiation
    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator(arg)
                instance = created
                created
            }
        }
    }

    fun destroyInstance() {
        instance = null
    }
}
