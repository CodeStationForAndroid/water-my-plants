package com.abaferastech.watermyplants.ui.screen.addscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.abaferastech.watermyplants.ui.navigation.Screens
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddScreen(navController: NavController, vm: AddViewModel = viewModel()){
    val state by vm.uiState.collectAsState()
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Add a new plant") },

        )
    }, content = { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
            ) {
                TableRow(label = "Plant name", detailContent = {
                    UnStyledTextField(
                        value = state.plantName,
                        onValueChange = vm::setPlantName,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("e.g Spider Lily") },
                        arrangement = Arrangement.End,
                        maxLines = 1,
                        textStyle = TextStyle(
                            textAlign = TextAlign.Right,
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                        )
                    )
                })
                Divider(
                    modifier = Modifier.padding(start = 16.dp),
                    thickness = 1.dp,
                )
                var datePickerShowing by remember {
                    mutableStateOf(false)
                }
                TableRow(label = "Date", detailContent = {
                    TextButton(onClick = { datePickerShowing = true }) {
                        Text(state.dateToWater.toString())
                    }
                    if (datePickerShowing) {
                        DatePickerDialog(onDismissRequest = { datePickerShowing = false },
                          onDateChange = { it ->
                                vm.setDate(it)
                                datePickerShowing = false
                            },
                            initialDate = state.dateToWater,
                            title = { Text("Select date") })
                    }
                })
                Divider(
                    modifier = Modifier.padding(start = 16.dp),
                    thickness = 1.dp,
                )
                TableRow(label = "Take photo of plant", detailContent = {
                    IconButton(onClick = { navController.navigate(Screens.CameraScreen.route) }) {
                        Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = "take photo")
                    }
                }
                )
            }
        }
    }
    )

}