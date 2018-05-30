package com.example.demo.model

import javafx.beans.property.SimpleStringProperty
import sun.java2d.pipe.SpanShapeRenderer
import tornadofx.*

data class CatSchedule(val ownerName: String, val catName: String, val address: String,
                       val time: String, val catImage: String)

class CatScheduleModel: ItemViewModel<CatSchedule>() {
    val ownerName = bind { SimpleStringProperty(item?.ownerName ?: "") }
    val catName = bind { SimpleStringProperty(item?.catImage ?: "") }
    val address = bind { SimpleStringProperty(item?.address ?: "" ) }
    val time = bind { SimpleStringProperty(item?.time ?: "00:00AM") }
    val catImage = bind { SimpleStringProperty(item?.catImage ?: "") }
}

class CatScheduleScope:  Scope() {
    val model = CatScheduleModel()
}