package com.example.demo.view

import com.example.demo.model.CatScheduleScope
import javafx.scene.control.TextField
import tornadofx.*

class Editor: View() {

    // cast scope
    override val scope = super.scope as CatScheduleScope

    // extract our view model from the scope
    private val model = scope.model
    var ownerNameField : TextField by singleAssign()
    var catNameField : TextField by singleAssign()
    var timeField: TextField by singleAssign()

    override val root = hbox {
        form {
            fieldset("Edit person") {
                field("Owner") {
                    textfield(model.ownerName) {
                        ownerNameField = this
                    }
                }
                field("Cat") {
                    textfield(model.catName) {
                        catNameField = this
                    }
                }
                field("Time") {
                    textfield(model.time) {
                        timeField = this
                    }
                }
                button("Save").action {
                    enableWhen(model.dirty)
                    save()
                }
            }
        }
    }

    private fun save() {
        // flush changes from the text field into the model
        model.commit()

        // edited cat schedule is contained in the model
        val catSchedule = model.item
        println("Saving Changes: ${catSchedule.ownerName} / ${catSchedule.catName} / ${catSchedule.time}")
    }

}