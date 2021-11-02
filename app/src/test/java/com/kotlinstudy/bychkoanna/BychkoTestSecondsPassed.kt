package com.kotlinstudy.bychkoanna

import org.junit.Test
import org.junit.Assert.*
import com.kotlinstudy.bychkoanna.ForTests

class BychkoTestSecondsPassed {
    @Test
    fun secondsPassed() {
        assertEquals(62, ForTests.TimePassed.timePassed(0, 1, 2))
        assertEquals(37230, ForTests.TimePassed.timePassed(10, 20, 30))
    }

}
