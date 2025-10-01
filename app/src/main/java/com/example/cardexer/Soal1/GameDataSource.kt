package com.example.cardexer.Soal1
data class modules(
    val name: String,
    val rating: Double,
    val isFree: Boolean,
    val imageId: String
)

class GameDataSource {
    fun loadRecommendedGames(): List<modules> {
        return listOf(
            modules("I Am Innocent", 4.4, true, "game_1"),
            modules("Blue Suit", 4.4, true, "game_2"),
            modules("Big Hunter", 4.3, true, "game_3"),
            modules("Real Duck", 4.5, true, "game_4"),
            modules("Cheating Tom 3", 10.0, true, "game_5"),
        )
    }

    fun loadNewGames(): List<modules> {
        return listOf(
            modules("C0_0K13S", 3.9, true, "game_6"),
            modules("BIG BACK", 9.9, false, "game_8"),
            modules("MEMEME", 10.0, false, "game_7"),
            modules("Pls Pay Attention", 4.5, true, "game_9"),
            modules("Cooking with Sofra", 4.6, false, "game_10"),
        )
    }

    fun loadPopularGames(): List<modules> {
        return listOf(
            modules("MooDeng", 5.0, true, "game_11"),
            modules("Supermarket Sim.", 3.2, false, "game_12"),
            modules("SARDINE pt.5", 4.9, true, "game_13"),
            modules("404 NOT FOUND", 4.7, false, "game_14"),
            modules("MiiTime", 5.0, true, "game_15"),
        )
    }
}