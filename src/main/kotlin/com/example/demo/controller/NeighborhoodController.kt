package com.example.demo.controller

import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import tornadofx.*
import java.util.*

class NeighborhoodController: Controller() {

    fun housePane(position: Pos): StackPane {
        val houseNum = (1..6).random()

        return StackPane().apply {
            rectangle {
                fill = c("4E9830")
                width = 100.0
                height = 100.0
            }
            imageview("house$houseNum.png").apply {
                alignment = position
            }
        }
    }

    fun grassPane(): StackPane {
        return StackPane().apply {
            rectangle {
                fill = c("4E9830")
                width = 100.0
                height = 100.0
            }
        }
    }

    fun verticalStreetPane(): StackPane {
        return StackPane().apply {
            rectangle {
                fill = c("4E9830")
                width = 100.0
                height = 100.0
            }
            rectangle {
                fill = c("919191")
                width = 40.0
                height= 100.0
            }
        }
    }

    fun horizontalStreetPane(): StackPane {
        return StackPane().apply {
            rectangle {
                fill = c("4E9830")
                width = 100.0
                height = 100.0
            }
            rectangle {
                fill = c("919191")
                width = 100.0
                height= 40.0
            }
        }
    }

    fun crossStreetPane(): StackPane {
        return StackPane().apply {
            rectangle {
                fill = c("4E9830")
                width = 100.0
                height = 100.0
            }
            rectangle {
                fill = c("919191")
                width = 100.0
                height= 40.0
            }
            rectangle {
                fill = c("919191")
                width = 40.0
                height= 100.0
            }
        }
    }

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

}