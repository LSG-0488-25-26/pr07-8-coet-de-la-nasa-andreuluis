package com.example.rickymorty.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rickymorty.ui.ViewModel.CharacterVM

@Composable
fun DetailScreen(
    navController: NavController,
    characterId: Int,
    vm: CharacterVM,
    modifier: Modifier = Modifier
) {
    val character by vm.selected.observeAsState(null)
    val loading by vm.loading.observeAsState(false)
    val error by vm.error.observeAsState(null)

    LaunchedEffect(characterId) {
        if (characterId != -1) vm.loadCharacterById(characterId)
    }

    Box(modifier = modifier.fillMaxSize()) {

        when {
            loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            error != null -> {
                Text(
                    text = "Error: $error",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            character == null -> {
                Text(
                    text = "Not found",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            else -> {
                val c = character!!

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = c.imageUrl,
                        contentDescription = c.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(300.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = c.name,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            DetailRow("Status", c.status)
                            DetailRow("Species", c.species)
                            DetailRow("Gender", c.gender)
                            DetailRow("Origin", c.origin)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "go back",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
