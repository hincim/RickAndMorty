package com.hakaninc.rickandmorty.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hakaninc.rickandmorty.R
import com.hakaninc.rickandmorty.viewmodel.UserViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterDetailPage(navController: NavController, userViewModel: UserViewModel) {

    val character = userViewModel.user.value

    val str = character.episode.toString()
    val pattern = "\\d+".toRegex()
    val matches = pattern.findAll(str)
    val list = ArrayList<String>()
    for (match in matches) {
        list.add(match.value)
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()), contentAlignment = Alignment.TopStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                    contentDescription = "Back"
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${character.name}", textAlign = TextAlign.Center,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.avenir_black))
            )
        }
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(70.dp)
        ) {
            GlideImage(
                imageModel = character.image, modifier =
                Modifier.size(275.dp, 275.dp).padding(start = 50.dp, end = 50.dp, top = 20.dp,
                bottom = 20.dp)
            )

        }
        Column(
            modifier = Modifier
                .padding(top = 350.dp)
                .fillMaxWidth()
        ) {

            Row(modifier =Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Status: ",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp, fontFamily = FontFamily(Font(R.font.avenir_black))
                )
                Text(
                    text =character.status!!,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_regular))
                )
            }
            Row (modifier =Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Start){
                Text(
                    text = "Specy: ",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_black))
                )
                Text(
                    text =character.species!!,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_regular))
                )
            }
            Row (modifier =Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Start){
                Text(
                    text = "Gender: ",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_black))
                )
                Text(
                    text =character.gender!!,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_regular))
                )
            }
            Row(modifier =Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Origin: ",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_black))
                )
                Text(
                    text =character.origin?.name!!,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_regular))
                )
            }
            Row(modifier =Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Location: ",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_black))
                )
                Text(
                    text =character.location?.name!!,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_regular))
                )
            }
            Row(modifier =Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Episodes: ",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_black))
                )
                Text(
                    text =list.toString().removeSurrounding("[", "]"),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_regular))
                )
            }
            Row(modifier =Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Created at \n(in API): ",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 22.sp,fontFamily = FontFamily(Font(R.font.avenir_black))
                )
                Text(
                    text =character.created!!,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 22.sp,style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.avenir_regular)
                        ), fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }
}