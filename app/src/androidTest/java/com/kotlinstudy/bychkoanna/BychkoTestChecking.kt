package com.kotlinstudy.bychkoanna
import android.view.Window
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import com.kotlinstudy.bychkoanna.ForTests

@RunWith(AndroidJUnit4::class)

class BychkoTestChecking {
    @Test

    fun checking() {
 assertEquals(true, ForTests.Clean.cleanWindow(true))
    }
}