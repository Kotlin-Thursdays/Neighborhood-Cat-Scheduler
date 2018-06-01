package com.example.demo.controller

import com.example.demo.model.CatSchedule
import com.example.demo.model.CatScheduleModel
import com.example.demo.model.CatScheduleScope
import com.example.demo.view.BottomView
import com.example.demo.view.Editor
import javafx.scene.image.ImageView
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import tornadofx.*
import java.text.DateFormat
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*

class BottomViewController: Controller() {

    private val view: BottomView by inject()

    val mondays = listOf(
            CatSchedule("Tom Mariano", "Meowsers", "1110 6th Street", "3:00PM", "/kitty/kitty1.png"),
            CatSchedule("John Hill", "Tom", "1115 6th Street", "4:00PM", "/kitty/kitty2.png"),
            CatSchedule("Louise Vargas", "Mr. Whiskers", "1120 6th Street", "4:30PM", "/kitty/kitty3.png"),
            CatSchedule("Dale Benton", "Pepper", "2111 8th Street", "7:00PM", "/kitty/kitty4.png"),
            CatSchedule("Tucker Harrison", "Princess", "2267 8th Street", "8:00PM", "/kitty/kitty5.png")
    ).observable()

    val tuesdays = listOf(
            CatSchedule("Tom Mariano", "Meowsers", "1110 6th Street", "3:00PM", "/kitty/kitty1.png"),
            CatSchedule("John Hill", "Tom", "1115 6th Street", "4:00PM", "/kitty/kitty2.png"),
            CatSchedule("Louise Vargas", "Mr. Whiskers", "1120 6th Street", "4:30PM", "/kitty/kitty3.png"),
            CatSchedule("Dale Benton", "Pepper", "2111 8th Street", "7:00PM", "/kitty/kitty4.png"),
            CatSchedule("Tucker Harrison", "Princess", "2267 8th Street", "8:00PM", "/kitty/kitty5.png")
    ).observable()

    val wednesdays = listOf(
            CatSchedule("Tom Mariano", "Meowsers", "1110 6th Street", "3:00PM", "/kitty/kitty1.png"),
            CatSchedule("John Hill", "Tom", "1115 6th Street", "4:00PM", "/kitty/kitty2.png"),
            CatSchedule("Louise Vargas", "Mr. Whiskers", "1120 6th Street", "4:30PM", "/kitty/kitty3.png"),
            CatSchedule("Dale Benton", "Pepper", "2111 8th Street", "7:00PM", "/kitty/kitty4.png"),
            CatSchedule("Tucker Harrison", "Princess", "2267 8th Street", "8:00PM", "/kitty/kitty5.png")
    ).observable()

    val thursdays = listOf(
            CatSchedule("Tom Mariano", "Meowsers", "1110 6th Street", "3:00PM", "/kitty/kitty1.png"),
            CatSchedule("John Hill", "Tom", "1115 6th Street", "4:00PM", "/kitty/kitty2.png"),
            CatSchedule("Louise Vargas", "Mr. Whiskers", "1120 6th Street", "4:30PM", "/kitty/kitty3.png"),
            CatSchedule("Dale Benton", "Pepper", "2111 8th Street", "7:00PM", "/kitty/kitty4.png"),
            CatSchedule("Tucker Harrison", "Princess", "2267 8th Street", "8:00PM", "/kitty/kitty5.png")
    ).observable()

    val fridays = listOf(
            CatSchedule("Tom Mariano", "Meowsers", "1110 6th Street", "3:00PM", "/kitty/kitty1.png"),
            CatSchedule("John Hill", "Tom", "1115 6th Street", "4:00PM", "/kitty/kitty2.png"),
            CatSchedule("Louise Vargas", "Mr. Whiskers", "1120 6th Street", "4:30PM", "/kitty/kitty3.png"),
            CatSchedule("Dale Benton", "Pepper", "2111 8th Street", "7:00PM", "/kitty/kitty4.png"),
            CatSchedule("Tucker Harrison", "Princess", "2267 8th Street", "8:00PM", "/kitty/kitty5.png")
    ).observable()

    fun changeCatAvi(catSchedule: CatSchedule) {
        view.avi.children.clear()
        val rectangle = Rectangle(200.0, 200.0 , Color.TRANSPARENT)
        val image = ImageView(catSchedule.catImage)
        view.avi.children.addAll(rectangle, image)
    }

    fun editCatSchedule(catSchedule: CatSchedule) {
        val catScheduleScope = CatScheduleScope()
        catScheduleScope.model.item = catSchedule
        find(Editor::class, scope = catScheduleScope).openModal()
    }

    init {
        subscribe<BottomView.CatScheduleRequest> {

        }
    }
}

class CatScheduleEvent(val catSchedules: List<CatSchedule>): FXEvent()