package com.example.rickymorty.ui.views

import androidx.compose.foundation.layout.Arrangement
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

@Composable
fun ListView(
    modifier: Modifier,
    navController: NavController,
    vm: CharacterVM
) {
    val characters by vm.characters.observeAsState(emptyList())
    val loading by vm.loading.observeAsState(false)
    val error by vm.error.observeAsState(null)

    LaunchedEffect(Unit) {
        vm.loadCharacters(page = 1)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            loading -> {
                CircularProgressIndicator(modifier = Modifier.padding(24.dp))
            }

            error != null -> {
                Text(
                    text = "Error: $error",
                    modifier = Modifier.padding(24.dp)
                )
            }

            else -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(characters) { character ->
                        CharacterItem(character = character, navController = navController)
                    }
                }
            }
        }
    }
}
