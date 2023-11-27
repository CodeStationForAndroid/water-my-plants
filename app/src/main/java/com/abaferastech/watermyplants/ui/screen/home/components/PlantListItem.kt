package com.abaferastech.watermyplants.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abaferastech.watermyplants.data.local.Plant


@Composable
fun PlantListItem(
    plant: Plant,
    //navController : NavController,
    modifier: Modifier = Modifier,
    image: Int? = null
){

    Card(

        colors = CardDefaults.cardColors(
            containerColor = Color(plant.color),
        )
    ) {
        Row(modifier = Modifier
            .height(93.dp)
            .fillMaxWidth()
            .padding(top = 13.dp, bottom = 13.dp, end = 10.dp, start = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically)
        {

            Box(contentAlignment = Alignment.Center) {
                image?.let { painterResource(id = it) }?.let {
                    Image(
                        painter = it,
                        contentDescription = "image",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(3.dp),
                modifier = Modifier
                    .padding(end = 30.dp))
            {
                Text(text = plant.name, fontWeight = FontWeight.Bold, fontSize = 24.sp, maxLines = 2 )
                Text(text = "250 ml")

            }

            CustomButton(isDone = true)
        }

    }

}

