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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hakaninc.rickandmorty.R
import com.hakaninc.rickandmorty.viewmodel.UserViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterDetailPage(navController: NavController,userViewModel: UserViewModel) {

    val character = userViewModel.user.value

    val str = character.episode.toString()
    val pattern = "\\d+".toRegex()
    val matches = pattern.findAll(str)
    val list = ArrayList<String>()
    for (match in matches){
        list.add(match.value)
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .verticalScroll(rememberScrollState())
        ,contentAlignment = Alignment.TopStart
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
                fontSize = 22.sp
            )
        }
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(70.dp)
        ) {
            GlideImage(
                imageModel = character.image, modifier =
                Modifier.size(275.dp, 275.dp)
            )

        }
        Row(modifier = Modifier
            .padding(top = 350.dp)
            .fillMaxWidth()) {

            Column() {
                Text(
                    text = "Status: ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.h6.copy(
                        shadow = Shadow(
                            color = Color(0x4c000000),
                            offset = Offset(2f, 2f),
                            blurRadius = 7f
                        )
                    ),
                    fontSize = 22.sp
                )
                Text(
                    text = "Specy: ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Text(
                    text = "Gender: ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Text(
                    text = "Origin: ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.h6.copy(
                        shadow = Shadow(
                            color = Color(0x4c000000),
                            offset = Offset(2f, 2f),
                            blurRadius = 7f
                        )
                    ),
                    fontSize = 22.sp
                )
                Text(
                    text = "Location: ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.h6.copy(
                        shadow = Shadow(
                            color = Color(0x4c000000),
                            offset = Offset(2f, 2f),
                            blurRadius = 7f
                        )
                    ),
                    fontSize = 22.sp
                )
                Text(
                    text = "Episodes: ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.h6.copy(
                        shadow = Shadow(
                            color = Color(0x4c000000),
                            offset = Offset(2f, 2f),
                            blurRadius = 7f
                        )
                    ),
                    fontSize = 22.sp
                )
                Text(
                    text = "Created at\n(in API): ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, start = 20.dp, end = 20.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.h6.copy(
                        shadow = Shadow(
                            color = Color(0x4c000000),
                            offset = Offset(2f, 2f),
                            blurRadius = 7f
                        )
                    ),
                    fontSize = 22.sp
                )
            }

            Column() {
                Text(
                    text = character.status!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, end = 20.dp),
                    color = Color.Black,
                    fontSize = 22.sp
                )
                Text(
                    text = character.species!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp,end = 20.dp),
                    color = Color.Black,
                    fontSize = 22.sp
                )
                Text(
                    text = character.gender!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, end = 20.dp),
                    color = Color.Black,
                    fontSize = 22.sp
                )
                Text(
                    text = character.origin?.name!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, end = 20.dp),
                    color = Color.Black,
                    fontSize = 22.sp
                )
                Text(
                    text = character.location?.name!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp,end = 20.dp),
                    color = Color.Black,
                    fontSize = 22.sp
                )
                Text(
                    text = list.toString().removeSurrounding("[","]"),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp,end = 20.dp),
                    color = Color.Black,
                    fontSize = 22.sp
                )
                Text(
                    text = character.created!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 5.dp, end = 20.dp),
                    color = Color.Black,
                    fontSize = 22.sp
                )
            }

        }
    }

               /* Text(text = "Status: ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.h6.copy(
                        shadow =  Shadow(
                            color = Color(0x4c000000),
                            offset = Offset(2f, 2f),
                            blurRadius = 7f
                        )
                    ),
                    fontSize = 22.sp
                )
                Text(text = character.status.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.h6.copy(
                        shadow =  Shadow(
                            color = Color(0x4c000000),
                            offset = Offset(2f, 2f),
                            blurRadius = 7f
                        )
                    ),
                    fontSize = 10.sp
                )
            }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp)) {
            Text(text = "Status: ${character.status}",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                color = Color.Black,
                style = MaterialTheme.typography.h6.copy(
                    shadow =  Shadow(
                        color = Color(0x4c000000),
                        offset = Offset(2f, 2f),
                        blurRadius = 7f
                    )
                ),
                fontSize = 22.sp
            )
            Text(text = character.status.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                color = Color.Black,
                style = MaterialTheme.typography.h6.copy(
                    shadow =  Shadow(
                        color = Color(0x4c000000),
                        offset = Offset(2f, 2f),
                        blurRadius = 7f
                    )
                ),
                fontSize = 22.sp
            )


            Text(text = "Gender: ${character.gender}",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 5.dp, start = 20.dp),
                color = Color.White,
                style = MaterialTheme.typography.h6.copy(
                    shadow =  Shadow(
                        color = Color(0x4c000000),
                        offset = Offset(2f, 2f),
                        blurRadius = 7f
                    )
                )
            )

            Text(text = "Origin: ${character.origin?.name}",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 5.dp, start = 20.dp),
                color = Color.White,
                style = MaterialTheme.typography.body2.copy(
                    shadow =  Shadow(
                        color = Color(0x4c000000),
                        offset = Offset(2f, 2f),
                        blurRadius = 7f
                    )
                )
            )

            Text(text = "Location: ${character.location?.name}",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 5.dp, start = 20.dp),
                color = Color.White,

            )

            Text(text = "Episodes: ${list.toString().removeSurrounding("[","]")}",
                modifier = Modifier.padding(top = 5.dp, start = 20.dp),
                color = Color.White,
                style = MaterialTheme.typography.body2.copy(
                    shadow =  Shadow(
                        color = Color(0x4c000000),
                        offset = Offset(2f, 2f),
                        blurRadius = 7f
                    )
                )
            )

            Text(text = "Created at \n" +
                    "(in API): ${character.created}",
                modifier = Modifier.padding(top = 5.dp, start = 20.dp),
                color = Color.White,
                style = MaterialTheme.typography.h6.copy(
                    shadow =  Shadow(
                        color = Color(0x4c000000),
                        offset = Offset(2f, 2f),
                        blurRadius = 7f
                    )
                )
            )
        }
    }*/
/*
    Surface(modifier = Modifier.verticalScroll(rememberScrollState()).fillMaxSize(),
    color = Color.Red) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24)
                    , contentDescription = "Back")
            }
            Spacer(modifier = Modifier.padding(32.dp))
            Text(text = "${character.name}", textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 15.dp), fontSize = 22.sp)
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(100.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            GlideImage(imageModel = character.image, modifier =
            Modifier.size(100.dp,150.dp))


        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 250.dp, start = 10.dp),
            horizontalAlignment = Alignment.Start) {

            Text(text = "Status:         ${character.status}", fontSize = 22.sp)
            Text(text = "Specy:          ${character.species}", fontSize = 22.sp)
            Text(text = "Gender:        ${character.gender}", fontSize = 22.sp)
            Text(text = "Origin:          ${character.origin?.name}", fontSize = 22.sp)
            Text(text = "Location:     ${character.location?.name}", fontSize = 22.sp)
            Text(text = "Episodes:     ${list.toString().removeSurrounding("[","]")}", fontSize = 22.sp)
            Text(text = "Created at \n(in API):    ${character.created}", fontSize = 22.sp)


        }
    }
*/
    /*Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.White, contentColor = Color.Black
        , title = {

            })
    }, content = {

    })*/

}