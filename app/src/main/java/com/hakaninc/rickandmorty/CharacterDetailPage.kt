package com.hakaninc.rickandmorty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hakaninc.rickandmorty.repo.PersonDaoRetrofit
import com.hakaninc.rickandmorty.retrofit.PersonsDaoRetrofit

@Composable
fun CharacterDetailPage(navController: NavController) {

    LaunchedEffect(key1 = true){
        PersonDaoRetrofit().getAllPersonsRepo()

    }

    Row(modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Start) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24)
                , contentDescription = "Back")
        }
        Spacer(modifier = Modifier.padding(32.dp))
            Text(text = "Character Name", textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 15.dp), fontSize = 22.sp)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(100.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Character",)

        
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 250.dp, start = 10.dp),
        horizontalAlignment = Alignment.Start) {
        
        Text(text = "Status:         Alive", fontSize = 22.sp)
        Text(text = "Specy:          Human", fontSize = 22.sp)
        Text(text = "Gender:        Female", fontSize = 22.sp)
        Text(text = "Origin:          Earth(C-137)", fontSize = 22.sp)
        Text(text = "Location:     Earth(C-137)", fontSize = 22.sp)
        Text(text = "Episodes:     1, 2, 3, 4, 5, 6, 22, 51", fontSize = 22.sp)
        Text(text = "Created at \n(in API):    5 May 2017, 09:48:44", fontSize = 22.sp)


    }
    /*Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.White, contentColor = Color.Black
        , title = {

            })
    }, content = {

    })*/

}