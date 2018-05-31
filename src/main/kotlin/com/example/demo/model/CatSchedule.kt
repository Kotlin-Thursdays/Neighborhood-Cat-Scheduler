package com.example.demo.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class CatSchedule(ownerName: String, catName: String, address: String,
                  time: String, catImage: String) {
    val ownerNameProperty = SimpleStringProperty(this, "", ownerName)
    var ownerName by ownerNameProperty

    val catNameProperty = SimpleStringProperty(this, "", catName)
    var catName by catNameProperty

    val addressProperty = SimpleStringProperty(this, "", address)
    var address by addressProperty

    val timeProperty = SimpleStringProperty(this, "", time)
    var time by timeProperty

    val catImageProperty = SimpleStringProperty(this, "", catImage)
    var catImage by catImageProperty
}

class CatScheduleModel: ItemViewModel<CatSchedule>() {
    val ownerName = bind(CatSchedule::ownerNameProperty)
    val catName = bind(CatSchedule::catNameProperty)
    val address = bind(CatSchedule::addressProperty)
    val time = bind(CatSchedule::timeProperty)
    val catImage = bind(CatSchedule::catImageProperty)
}

class CatScheduleScope:  Scope() {
    val model = CatScheduleModel()
}