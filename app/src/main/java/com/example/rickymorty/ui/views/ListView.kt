package com.example.rickymorty.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickymorty.ui.ViewModel.CharacterVM
import com.example.rickymorty.ui.model.Character

@Composable
fun ListView(
    modifier: Modifier,
    navController: NavController,
    vm: CharacterVM
) {
    val characters by vm.characters.observeAsState(emptyList())
    val loading by vm.loading.observeAsState(false)
    val error by vm.error.observeAsState(null)
    val searchedText by vm.searchedText.observeAsState("")

    LaunchedEffect(Unit) {
        vm.loadCharacters(page = 1)
    }

    val filtered = if (searchedText.isBlank()) characters
    else characters.filter { it.name.contains(searchedText, ignoreCase = true) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MySearchBarView(vm)

        when {
            loading -> CircularProgressIndicator(modifier = Modifier.padding(24.dp))
            error != null -> Text(text = "Error: $error", modifier = Modifier.padding(24.dp))
            else -> ResponsiveCharactersList(filtered, navController)
        }
    }
}

@Composable
private fun ResponsiveCharactersList(list: List<Character>, navController: NavController) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val w = maxWidth
        when {
            w < 600.dp -> CharactersListCompact(list, navController)
            w < 840.dp -> CharactersListMedium(list, navController)
            else -> CharactersListExpanded(list, navController)
        }
    }
}

@Composable
private fun CharactersListCompact(list: List<Character>, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(list) { character ->
            CharacterItem(character, navController, imageHeight = 100, showExtra = false)
        }
    }
}

@Composable
private fun CharactersListMedium(list: List<Character>, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 10.dp)
    ) {
        items(list) { character ->
            CharacterItem(character, navController, imageHeight = 120, showExtra = false)
        }
    }
}

@Composable
private fun CharactersListExpanded(list: List<Character>, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 48.dp, vertical = 12.dp)
    ) {
        items(list) { character ->
            CharacterItem(character, navController, imageHeight = 140, showExtra = true)
        }
    }
}
