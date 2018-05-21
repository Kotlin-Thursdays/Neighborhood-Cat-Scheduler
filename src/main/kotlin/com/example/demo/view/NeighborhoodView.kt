package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import tornadofx.*
import java.util.*

class NeighborhoodView: View() {

    // set up neighborhood
    override val root = gridpane {
        row {
            add(grassPane())
            add(grassPane())
            add(housePane(Pos.BASELINE_LEFT))
            add(verticalStreetPane())
            add(housePane(Pos.BASELINE_CENTER))
            add(verticalStreetPane())
            add(housePane(Pos.BASELINE_RIGHT))
            add(grassPane())
        }
        row {
            add(horizontalStreetPane())
            add(horizontalStreetPane())
            add(horizontalStreetPane())
            add(crossStreetPane())
            add(horizontalStreetPane())
            add(crossStreetPane())
            add(horizontalStreetPane())
            add(horizontalStreetPane())
        }
        row {
            add(housePane(Pos.TOP_RIGHT))
            add(grassPane())
            add(housePane(Pos.TOP_RIGHT))
            add(verticalStreetPane())
            add(grassPane())
            add(verticalStreetPane())
            add(housePane(Pos.TOP_LEFT))
            add(grassPane())
        }
        row {
            add(grassPane())
            add(housePane(Pos.BASELINE_CENTER))
            add(grassPane())
            add(verticalStreetPane())
            add(housePane(Pos.BASELINE_CENTER))
            add(verticalStreetPane())
            add(housePane(Pos.BASELINE_LEFT))
            add(grassPane())
        }
        row {
            add(horizontalStreetPane())
            add(horizontalStreetPane())
            add(horizontalStreetPane())
            add(crossStreetPane())
            add(horizontalStreetPane())
            add(crossStreetPane())
            add(horizontalStreetPane())
            add(horizontalStreetPane())
        }
        // use this to check placement
        // isGridLinesVisible = true
    }

    private fun housePane(position: Pos): StackPane {
        val houseNum = (1..6).random()

        return stackpane {
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

    private fun grassPane(): StackPane {
        return stackpane {
            rectangle {
                fill = c("4E9830")
                width = 100.0
                height = 100.0
            }
        }
    }

    private fun verticalStreetPane(): StackPane {
        return stackpane {
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

    private fun horizontalStreetPane(): StackPane {
        return stackpane {
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

    private fun crossStreetPane(): StackPane {
        return stackpane {
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

    fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

}