package com.example.rickymorty.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rickymorty.nav.Routes
import com.example.rickymorty.ui.views.DetailScreen
import com.example.rickymorty.ui.views.ListView

@Composable
fun RickAndMortyNavHost(modifier: Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.ListView.route
    ) {
        composable(Routes.ListView.route) {
            ListView(modifier, navController)
        }

        composable(
            Routes.DetailsView.route,
            arguments = listOf(
                navArgument("characterId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            DetailScreen(
                navController = navController,
                characterId = backStackEntry.arguments?.getInt("characterId") ?: -1,
                modifier = modifier
            )
        }
    }
}
