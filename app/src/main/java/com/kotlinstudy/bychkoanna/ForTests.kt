package com.kotlinstudy.bychkoanna

import kotlin.math.*

class ForTests {
    object TimePassed {

        public fun timePassed(hours: Int, minutes: Int, seconds: Int): Int =
            hours * 3600 + minutes * 60 + seconds

        val passed = timePassed(10, 10, 10)

    }

    object Clean {
        public fun cleanWindow(window: Boolean) = true
    }
}
