package com.example.demo.view

import com.example.demo.app.Styles
import javafx.scene.effect.ImageInput
import javafx.scene.image.ImageView
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints
import javafx.scene.shape.Rectangle
import tornadofx.*

class MainView : View() {
    // global variables
    private var tileWidth: Double = 0.0
    private var tileHeight: Double = 0.0
    private lateinit var grid: GridPane

    override val root = borderpane {
        prefHeight = 700.0
        prefWidth = 800.0
        top(NeighborhoodView::class)
        bottom(BottomView::class)
    }
}