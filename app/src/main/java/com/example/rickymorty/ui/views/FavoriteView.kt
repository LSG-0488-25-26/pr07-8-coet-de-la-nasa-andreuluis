package com.example.rickymorty.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickymorty.data.local.FavoriteCharacterEntity
import com.example.rickymorty.ui.ViewModel.CharacterVM
import com.example.rickymorty.ui.model.Character

@Composable
fun FavoritesView(
    modifier: Modifier,
    navController: NavController,
    vm: CharacterVM
) {
    val favorites by vm.favorites.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        vm.loadFavorites()
    }

    if (favorites.isEmpty()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("No favorites yet")
        }
        return
    }

    val list = favorites.map { it.toCharacter() }

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val w = maxWidth
        when {
            w < 600.dp -> FavList(list, navController, 16.dp, 100, false)
            w < 840.dp -> FavList(list, navController, 24.dp, 120, false)
            else -> FavList(list, navController, 48.dp, 140, true)
        }
    }
}

@Composable
private fun FavList(
    list: List<Character>,
    navController: NavController,
    horizontalPadding: Dp,
    imageHeight: Int,
    showExtra: Boolean
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = horizontalPadding, vertical = 8.dp)
    ) {
        items(list) { character ->
            CharacterItem(character, navController, imageHeight = imageHeight, showExtra = showExtra)
        }
    }
}

private fun FavoriteCharacterEntity.toCharacter(): Character =
    Character(id, name, status, species, gender, origin, imageUrl)
