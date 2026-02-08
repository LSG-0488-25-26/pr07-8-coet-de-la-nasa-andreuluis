package com.example.rickymorty.nav

sealed class Routes(val route: String) {
    object ListView : Routes("list")
    object FavoritesView : Routes("favorites")

    object DetailsView : Routes("details/{characterId}") {
        fun createRoute(characterId: Int) = "details/$characterId"
    }
}
