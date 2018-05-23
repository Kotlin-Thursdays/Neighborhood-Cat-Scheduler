package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.BottomViewController
import com.example.demo.model.CatSchedule
import com.example.demo.model.CatScheduleModel
import javafx.scene.paint.Color
import tornadofx.*

class BottomView: View() {

    private val controller: BottomViewController by inject()
    private val model: CatScheduleModel by inject()
    private var cat: String = "/kitty/kitty1.png"

    override val root = hbox {
        tabpane {
            tab("Monday") {
                tableview(controller.mondays) {
                    column("Owner", CatSchedule::ownerName)
                    column("Cat", CatSchedule::catName)
                    column("Address", CatSchedule::address).remainingWidth()
                    column("Time", CatSchedule::time)

                    bindSelected(model)
                    smartResize()
                }
            }
            tab("Tuesday") {
                tableview(controller.tuesdays) {
                    column("Owner", CatSchedule::ownerName)
                    column("Cat", CatSchedule::catName)
                    column("Address", CatSchedule::address).remainingWidth()
                    column("Time", CatSchedule::time)
                    bindSelected(model)
                    smartResize()
                }
            }
            tab("Wednesday") {
                tableview(controller.wednesdays) {
                    column("Owner", CatSchedule::ownerName)
                    column("Cat", CatSchedule::catName)
                    column("Address", CatSchedule::address).remainingWidth()
                    column("Time", CatSchedule::time)
                    bindSelected(model)
                    smartResize()
                }
            }
            tab("Thursday") {
                tableview(controller.thursdays) {
                    column("Owner", CatSchedule::ownerName)
                    column("Cat", CatSchedule::catName)
                    column("Address", CatSchedule::address).remainingWidth()
                    column("Time", CatSchedule::time)
                    bindSelected(model)
                    smartResize()
                }
            }
            tab("Friday") {
                tableview(controller.fridays) {
                    column("Owner", CatSchedule::ownerName)
                    column("Cat", CatSchedule::catName)
                    column("Address", CatSchedule::address).remainingWidth()
                    column("Time", CatSchedule::time)
                    bindSelected(model)
                    smartResize()
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
}