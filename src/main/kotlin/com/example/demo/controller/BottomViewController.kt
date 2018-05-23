package com.example.demo.controller

import com.example.demo.model.CatSchedule
import com.example.demo.model.CatScheduleModel
import tornadofx.*
import java.text.DateFormat
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*

class BottomViewController: Controller() {

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

}