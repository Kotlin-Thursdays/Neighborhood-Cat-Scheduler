package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.BottomViewController
import com.example.demo.model.CatSchedule
import com.example.demo.model.CatScheduleModel
import com.example.demo.model.CatScheduleScope
import javafx.scene.paint.Color
import tornadofx.*

class BottomView: View() {

    private val controller: BottomViewController by inject()
    private val model: CatScheduleModel by inject()
    private var cat: String = "/kitty/kitty1.png"
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
                        column("Owner", CatSchedule::ownerName)
                        column("Cat", CatSchedule::catName)
                        column("Address", CatSchedule::address).remainingWidth()
                        column("Time", CatSchedule::time)
                        bindSelected(model)
                        smartResize()

                        onUserSelect { editCatSchedule(it) }
                    }
                }
            }

            addClass(Styles.schedule)
        }

        stackpane {
            rectangle {
                width = 200.0
                height = 200.0
                fill = Color.TRANSPARENT
            }
            imageview(cat, true)
        }
    }

    private fun editCatSchedule(catSchedule: CatSchedule) {
        val catScheduleScope = CatScheduleScope()
        catScheduleScope.model.item = catSchedule
        openInternalWindow(Editor::class, scope = catScheduleScope)
    }

}