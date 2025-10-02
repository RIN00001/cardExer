package com.example.cardexer.Soal2

data class Module(
    val title: String,
    val genre: String,
    val imageUrl: String,
    val duration: String
)

class ModuleDataSource{

    fun loadCourses(): List<Module>{
        return listOf(
            Module("Focus","Meditation","meditation_1","3-5 min"),
            Module("Happiness","Meditation","being_happy_1","7-10 min"),
            Module("Relationships","Meditation","meditation_1","3-15 min"),
            Module("Focus","Meditation","reading_a_book","8-12 min"),
            Module("Happiness","Meditation","meditation_1","15-20 min"),
        )
    }
}