package com.abaferastech.watermyplants.ui.screen.detailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Shower
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.abaferastech.watermyplants.data.local.Plant
import com.abaferastech.watermyplants.ui.screen.home.components.CustomButton

@Composable
fun DetailScreen(
    vm: DetailViewModel = hiltViewModel(),
    navController : NavController,
){
    val state by vm.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        state.plant?.let { Color(it.color) }?.let {
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.33f)
                .background(color = it)
        }?.let {
            Column(
                modifier = it
            ) {
                OutlinedIconButton(onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .size(34.dp)
                        .align(Alignment.End)
                        .padding(top = 14.dp, end = 15.dp)) {
                    Icon(imageVector = Icons.Outlined.Close, contentDescription = "close")
                }
            }
        }
        state.plant?.let { Color(it.color) }?.let {
            Modifier
                .fillMaxHeight()
                .background(color = it)
                .clip(shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
        }?.let {
            Surface(
                modifier = it
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = state.plant!!.name,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Surface(shape = RoundedCornerShape(20.dp),
                            color = Color(0xffFAFAFA),
                            modifier = Modifier
                                .height(90.dp)
                                .width(170.dp)
                                .padding(1.dp)) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Icon(imageVector = Icons.Outlined.CalendarToday,
                                    contentDescription = "Calender" ,
                                    tint = Color(0xff48545a) )

                                Column {
                                    Text(text = "FREQUENCY", color = Color(0xff48545a))
                                    Text(text = "1 / week", color = Color(0xff48545a))
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                            }
                        }

                        Surface(shape = RoundedCornerShape(20.dp),
                            color = Color(0xffFAFAFA),
                            modifier = Modifier
                                .height(90.dp)
                                .width(170.dp)
                                .padding(1.dp)) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Icon(imageVector = Icons.Outlined.Shower,
                                    contentDescription = "water" ,
                                    tint = Color(0xff48545a) )

                                Column {
                                    Text(text = "WATER", color = Color(0xff48545a))
                                    Text(text = "250 ml", color = Color(0xff48545a))
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Surface(shape = RoundedCornerShape(20.dp),
                            color = Color(0xffFAFAFA),
                            modifier = Modifier
                                .height(90.dp)
                                .width(170.dp)
                                .padding(1.dp)) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Icon(imageVector = Icons.Outlined.Thermostat,
                                    contentDescription = "Temperature" ,
                                    tint = Color(0xff48545a) )

                                Column {
                                    Text(text = "TEMP", color = Color(0xff48545a))
                                    Text(text = "15-24 \u2103", color = Color(0xff48545a))
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                            }
                        }

                        Surface(shape = RoundedCornerShape(20.dp),
                            color = Color(0xffFAFAFA),
                            modifier = Modifier
                                .height(90.dp)
                                .width(170.dp)
                                .padding(1.dp)) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Icon(imageVector = Icons.Outlined.WbSunny,
                                    contentDescription = "Sun" ,
                                    tint = Color(0xff48545a) )

                                Column {
                                    Text(text = "Light", color = Color(0xff48545a))
                                    Text(text = "Low", color = Color(0xff48545a))
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "The fuodfhk ksdhf jkvsdkhfk kshof " +
                            "jsdklghf fkgbdskfb ohbaeohf sdosdhgfpoah",
                        color = Color(0xff48545a),
                        modifier = Modifier.padding(horizontal = 24.dp),
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(60.dp))

                    CustomButton(isDone = false, color =  Color(0xFFA1E2EB), modifier = Modifier.size(60.dp), tintColor = Color.White)

                }
            }
        }
    }
}

//@Composable
//@Preview
//fun DetailPreview(){
//    DetailScreen()
//}