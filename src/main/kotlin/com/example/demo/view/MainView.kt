package com.example.demo.view

import com.example.demo.app.Styles
import tornadofx.*

class MainView : View("Neighborhood Cat Scheduler") {

    override val root = borderpane {
            prefHeight = 700.0
            prefWidth = 800.0
            top(NeighborhoodView::class)
            left(BottomView::class)
            addClass(Styles.main)
    }

}