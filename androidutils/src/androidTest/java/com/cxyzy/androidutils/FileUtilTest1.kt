package com.cxyzy.androidutils

import android.content.Context
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FileUtilTest1 {
    lateinit var appContext: Context
    @Before
    fun setUp() {
        appContext = InstrumentationRegistry.getTargetContext()
    }

    @Test
    fun deleteFile() {

    }
}
