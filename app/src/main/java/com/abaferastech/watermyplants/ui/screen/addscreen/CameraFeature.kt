package com.abaferastech.watermyplants.ui.screen.addscreen

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun CameraT(){
    val context = LocalContext.current
    val img: Bitmap = BitmapFactory.decodeResource(Resources.getSystem(),
        android.R.drawable.ic_menu_report_image)
    val bitmap = remember {
        mutableStateOf(img)
    }
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

}