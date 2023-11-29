package com.abaferastech.watermyplants.ui.screen.addscreen

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddScreen(navController: NavController, vm: AddViewModel = hiltViewModel()){
    val context = LocalContext.current
    val img: Bitmap = BitmapFactory.decodeResource(
        Resources.getSystem(),
        android.R.drawable.ic_menu_report_image)
    val bitmap = remember {
        mutableStateOf(img)
    }

    vm.setImage(bitmap.value)
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ){
        if (it != null) {
            bitmap.value = it
        }
    }

    val launchImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
        if (Build.VERSION.SDK_INT < 28){
            bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
        }
        else{
            val source = it?.let { it1 ->
                ImageDecoder.createSource(context.contentResolver, it1)
            }
            bitmap.value = source?.let { it1 ->
                ImageDecoder.decodeBitmap(it1)
            }!!
        }
    }
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
            Image(
                bitmap = bitmap.value.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(200.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    )
                    .clickable(enabled = true, onClick = {launcher.launch()})
            )
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
                TableRow(label = "Select or Take photo of plant", detailContent = {
                    IconButton(onClick = { launcher.launch() }) {
                        Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = "take photo")
                    }
                    IconButton(onClick = { launchImage.launch("image/*") }) {
                        Icon(imageVector = Icons.Default.Image, contentDescription = "select photo")
                    }
                }
                )
            }
            Button(
                onClick = {
                    vm.savePlant()
                    navController.popBackStack()
                },
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(12.dp),

            ) {
                Text("Save Plant")
            }
        }
    }
    )

}