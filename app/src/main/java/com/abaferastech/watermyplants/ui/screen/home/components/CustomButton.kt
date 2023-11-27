package com.abaferastech.watermyplants.ui.screen.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    isDone: Boolean = false
){

    val icon = if (isDone) Icons.Outlined.Check else Icons.Outlined.FavoriteBorder

    Surface(
        shape = CircleShape,
        color = Color.White,
        shadowElevation = 6.dp
    ) {
        Box(
            modifier = modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            Icon(imageVector = icon, contentDescription = "isDone")
        }
    }
}

@Preview
@Composable
fun Preview(){
    CustomButton(isDone = false)
}