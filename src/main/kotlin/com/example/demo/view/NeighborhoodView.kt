package com.example.demo.view

import com.example.demo.controller.NeighborhoodController
import javafx.geometry.Pos
import tornadofx.*

class NeighborhoodView: View() {

    private val controller: NeighborhoodController by inject()

    // set up neighborhood
    override val root = gridpane {
        row {
            add(controller.grassPane())
            add(controller.grassPane())
            add(controller.housePane(Pos.BASELINE_LEFT))
            add(controller.verticalStreetPane())
            add(controller.housePane(Pos.BASELINE_CENTER))
            add(controller.verticalStreetPane())
            add(controller.housePane(Pos.BASELINE_RIGHT))
            add(controller.grassPane())
        }
        row {
            add(controller.horizontalStreetPane())
            add(controller.horizontalStreetPane())
            add(controller.horizontalStreetPane())
            add(controller.crossStreetPane())
            add(controller.horizontalStreetPane())
            add(controller.crossStreetPane())
            add(controller.horizontalStreetPane())
            add(controller.horizontalStreetPane())
        }
        row {
            add(controller.housePane(Pos.TOP_RIGHT))
            add(controller.grassPane())
            add(controller.housePane(Pos.TOP_RIGHT))
            add(controller.verticalStreetPane())
            add(controller.grassPane())
            add(controller.verticalStreetPane())
            add(controller.housePane(Pos.TOP_LEFT))
            add(controller.grassPane())
        }
        row {
            add(controller.grassPane())
            add(controller.housePane(Pos.BASELINE_CENTER))
            add(controller.grassPane())
            add(controller.verticalStreetPane())
            add(controller.housePane(Pos.BASELINE_CENTER))
            add(controller.verticalStreetPane())
            add(controller.housePane(Pos.BASELINE_LEFT))
            add(controller.grassPane())
        }
        row {
            add(controller.horizontalStreetPane())
            add(controller.horizontalStreetPane())
            add(controller.horizontalStreetPane())
            add(controller.crossStreetPane())
            add(controller.horizontalStreetPane())
            add(controller.crossStreetPane())
            add(controller.horizontalStreetPane())
            add(controller.horizontalStreetPane())
        }
        // use this to check placement
        // isGridLinesVisible = true
    }

}