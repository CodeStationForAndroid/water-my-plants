package com.abaferastech.watermyplants.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.abaferastech.watermyplants.ui.navigation.Screens
import com.abaferastech.watermyplants.ui.screen.home.components.PlantListItem

@Composable
fun HomeScreen(
    navController: NavController,
    vm: HomeViewModel = hiltViewModel()
){
    val state by vm.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screens.AddScreen.route)
            }) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Add Plant" )
            }

        },
    ) { innerPadding ->

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.plants){ plant ->
                PlantListItem(
                    plant = plant,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}