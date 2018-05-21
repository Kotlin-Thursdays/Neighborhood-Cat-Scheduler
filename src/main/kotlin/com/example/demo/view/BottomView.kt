package com.example.demo.view

import com.example.demo.app.Styles
import tornadofx.*

class BottomView: View("Neighborhood Cat Scheduler") {
    override val root = label(title) {
        addClass(Styles.heading)
    }
}