package com.hakaninc.rickandmorty

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomePage(navController: NavController) {

    val personList = remember {
        mutableStateListOf<String>("Veli","Hakan","Rick")
    }
    
   Column(verticalArrangement = Arrangement.Top,
   horizontalAlignment = Alignment.CenterHorizontally,
   modifier = Modifier.fillMaxSize()) {
       Image(painter = painterResource(id = R.drawable.rickandmorty,)
           , contentDescription = "Rick And Morty", alignment = Alignment.Center,
       modifier = Modifier.size(120.dp,120.dp))
       
       LazyRow{
           items(count = personList.size,
           itemContent = {
                val person = personList[it]
               Card(modifier = Modifier
                   .fillMaxWidth()
                   .padding(5.dp)
               ) {
                   Row(modifier = Modifier.clickable {

                   }) {
                       Row(
                           verticalAlignment = Alignment.CenterVertically,
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(10.dp)
                       ) {
                           Row(
                               verticalAlignment = Alignment.CenterVertically,
                               horizontalArrangement = Arrangement.SpaceBetween,
                               modifier = Modifier.fillMaxWidth()
                           ) {
                               Text(text = "$person - $person")
                               IconButton(onClick = {

                               }) {

                               }
                           }
                       }
                   }
               }
           })
       }
       LazyColumn{
           items(count = personList.size,
               itemContent = {
                   val person = personList[it]
                   Card(modifier = Modifier
                       .fillMaxWidth()
                       .padding(5.dp)
                   ) {
                       Row(modifier = Modifier.clickable {
                            navController.navigate("character_detail_page")
                       }) {
                           Row(
                               verticalAlignment = Alignment.CenterVertically,
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .padding(10.dp)
                           ) {
                               Row(
                                   verticalAlignment = Alignment.CenterVertically,
                                   horizontalArrangement = Arrangement.SpaceBetween,
                                   modifier = Modifier.fillMaxWidth()
                               ) {
                                   Text(text = "$person - $person")
                                   IconButton(onClick = {

                                   }) {

                                   }
                               }
                           }
                       }
                   }
               })
       }
   }
}







