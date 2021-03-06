package com.x0.hatonekoe.model

import com.x0.hatonekoe.TornadoMemoApp
import javafx.application.Application
import org.junit.BeforeClass
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class FileModelTest {
    val fileModel = ModelManager.fileModel
    val testFile: File = File(javaClass.classLoader.getResource("test01.txt").file)

    companion object {
        @BeforeClass @JvmStatic
        fun settings() {
            Thread {
                Application.launch(TornadoMemoApp::class.java, "")
            }.start()
        }
    }

    @Test
    fun mainWindowTitleTest() {
        fileModel.fileProperty.set(testFile)
        assertEquals("test01.txt", fileModel.file.value?.name)
        assertEquals(" [test01.txt]", fileModel.mainWindowTitleProperty.value)
    }

    @Test
    fun resetTest() {
        fileModel.fileProperty.set(testFile)
        assertNotNull(fileModel.file.value)

        fileModel.reset()
        assertNull(fileModel.file.value)
        assertEquals("", fileModel.mainWindowTitleProperty.value)
    }
}
