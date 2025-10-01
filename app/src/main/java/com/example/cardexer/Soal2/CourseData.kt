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
            Module("Focus","Meditation","","3-5 min"),
            Module("Happiness","Meditation","","7-10 min"),
            Module("Relationships","Meditation","","3-15 min"),
            Module("Focus","Meditation","","8-12 min"),
            Module("Happiness","Meditation","","15-20 min"),
        )
    }
}