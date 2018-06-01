package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.BottomViewController
import com.example.demo.model.CatSchedule
import com.example.demo.model.CatScheduleModel
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import tornadofx.*

class BottomView: View() {

    private val controller: BottomViewController by inject()
    private val model: CatScheduleModel by inject()
    object CatScheduleRequest : FXEvent(EventBus.RunOn.BackgroundThread)

    lateinit var avi: StackPane
    private var weekdays = listOf(
            Pair("Monday", controller.mondays),
            Pair("Tuesday", controller.tuesdays),
            Pair("Wednesday", controller.wednesdays),
            Pair("Thursday", controller.thursdays),
            Pair("Fridays", controller.fridays)
    )

    override val root = hbox {
        tabpane {
            weekdays.forEach {
                tab(it.first) {
                    tableview(it.second) {
                        column("Owner", CatSchedule::ownerNameProperty)
                        column("Cat", CatSchedule::catNameProperty)
                        column("Address", CatSchedule::addressProperty).remainingWidth()
                        column("Time", CatSchedule::timeProperty)
                        bindSelected(model)
                        smartResize()

                        onUserSelect(1) { controller.changeCatAvi(it) }
                        onUserSelect(2) { controller.editCatSchedule(it) }
                    }
                }
            }

            addClass(Styles.schedule)
        }

        avi = stackpane {
            rectangle {
                width = 200.0
                height = 200.0
                fill = Color.TRANSPARENT
            }
            imageview("/kitty/kitty1.png", true)
        }
    }
}