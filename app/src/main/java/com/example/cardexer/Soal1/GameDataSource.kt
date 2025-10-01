
data class GameModel(
    val name: String,
    val rating: Double,
    val isRecommended: Boolean,
    val imageId: String
)

class GameDataSource {
    fun loadRecommendedGames(): List<GameModel> {
        return listOf(
            GameModel("I Am Innocent", 4.4, true, "game_1"),
            GameModel("Blue Suit", 4.4, true, "game_2"),
            GameModel("Big Hunter", 4.3, true, "game_3"),
            GameModel("Real Duck", 4.5, true, "game_4"),
            GameModel("Cheating Tom 3", 10.0, true, "game_5"),
        )
    }

    fun loadNewGames(): List<GameModel> {
        return listOf(
            GameModel("C0_0K13S", 3.9, true, "game_6"),
            GameModel("BIG BACK", 9.9, false, "game_8"),
            GameModel("MEMEME", 10.0, false, "game_7"),
            GameModel("Pls Pay Attention", 4.5, true, "game_9"),
            GameModel("Cooking with Sofra", 4.6, false, "game_10"),
        )
    }

    fun loadPopularGames(): List<GameModel> {
        return listOf(
            GameModel("MooDeng", 5.0, true, "game_11"),
            GameModel("Supermarket Sim.", 3.2, false, "game_12"),
            GameModel("SARDINE pt.5", 4.9, true, "game_13"),
            GameModel("404 NOT FOUND", 4.7, false, "game_14"),
            GameModel("MiiTime", 5.0, true, "game_15"),
        )
    }
}