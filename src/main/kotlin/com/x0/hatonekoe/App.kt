package com.x0.hatonekoe

import com.x0.hatonekoe.view.MainView
import javafx.application.Application
import tornadofx.App

fun main(args: Array<String>) {
    Application.launch(TornadoMemoApp::class.java, *args)
}

class TornadoMemoApp : App() {
    override val primaryView = MainView::class
}
