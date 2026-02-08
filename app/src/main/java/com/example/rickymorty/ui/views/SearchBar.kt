package com.example.rickymorty.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.rickymorty.ui.ViewModel.CharacterVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBarView(vm: CharacterVM) {
    val searchedText by vm.searchedText.observeAsState("")

    SearchBar(
        query = searchedText,
        onQueryChange = { vm.onSearchTextChange(it) },
        onSearch = { },
        active = false,
        onActiveChange = { },
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
        placeholder = { Text("Search character...") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp))
    ) { }
}
