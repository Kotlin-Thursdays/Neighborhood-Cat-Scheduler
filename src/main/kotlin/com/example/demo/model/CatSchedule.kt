package com.example.demo.model

import tornadofx.*

data class CatSchedule(val ownerName: String? = null, val catName: String? = null,
                       val address: String? = null, val time: String? = null, val catImage: String? = null)

class CatScheduleModel: ItemViewModel<CatSchedule>() {
    val ownerName = bind { item?.ownerName?.toProperty() }
    val catName = bind { item?.catName?.toProperty() }
    val address = bind { item?.address?.toProperty() }
    val time = bind { item?.time?.toProperty() }
    val catImage = bind { item?.catImage?.toProperty() }
}