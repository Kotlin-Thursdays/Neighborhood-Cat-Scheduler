package com.example.demo.app

import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val neighborhood by cssclass()
        val street by cssclass()
    }

    init {
        neighborhood {
            backgroundColor += c("4E9830")
            prefWidth = 470.px
            prefHeight = 590.px
        }

        street {
            backgroundColor += c("919191")
        }

        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}