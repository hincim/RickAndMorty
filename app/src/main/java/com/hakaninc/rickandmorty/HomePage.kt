package com.hakaninc.rickandmorty

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.hakaninc.rickandmorty.repo.PersonDaoRetrofit
import com.hakaninc.rickandmorty.viewmodel.HomePageViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomePage(navController: NavController) {

    val viewModel : HomePageViewModel  = HomePageViewModel()
    val personList = viewModel.personList.observeAsState(listOf())
    val characterList = viewModel.characterList.observeAsState(listOf())

    val gender = remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = true){
        viewModel.getAllPersons()
        viewModel.getAllCharacter()
        for (c in characterList.value){
            if (c.gender!! == "Female"){
                gender.value = "https://media.istockphoto.com/id/1284444739/vector/female-symbol-on-transparent-background.jpg?s=612x612&w=0&k=20&c=EK8Uhpixm-Bo-Es4bVvaGWLlJQcFAf99lCOAR04qOTk="
            }
            if (c.gender!! == "Male"){
                gender.value = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Blue_male_symbol.svg/2048px-Blue_male_symbol.svg.png"
            }

        }
    }

   Column(verticalArrangement = Arrangement.Top,
   horizontalAlignment = Alignment.CenterHorizontally,
   modifier = Modifier.fillMaxSize()) {
       Image(painter = painterResource(id = R.drawable.rickandmorty,)
           , contentDescription = "Rick And Morty", alignment = Alignment.Center,
       modifier = Modifier.size(120.dp,120.dp))
       
       LazyRow{
           items(count = personList.value.count(),
           itemContent = {
                val person = personList.value[it]
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
                               Text(text = "${person.name}")
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
           items(count = characterList.value.count(),
               itemContent = {
                   val character = characterList.value[it]
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
                                   horizontalArrangement = Arrangement.SpaceAround,
                                   modifier = Modifier.fillMaxWidth()
                               ) {
                                   val activity = (LocalContext.current as Activity)
                                   GlideImage(imageModel = character.image, modifier =
                                   Modifier.size(100.dp,150.dp))
                                   if (character.gender.equals("Male")){
                                       Image(painter = painterResource(id = R.drawable.male),
                                           contentDescription = "Male", modifier = Modifier.size(50.dp,50.dp))
                                   }
                                   if (character.gender.equals("Female")){
                                       Image(painter = painterResource(id = R.drawable.female),
                                           contentDescription = "Male", modifier = Modifier.size(50.dp,50.dp))
                                   }
                                   if (character.gender.equals("unknown")){
                                       Image(painter = painterResource(id = R.drawable.genderless),
                                           contentDescription = "Male", modifier = Modifier.size(50.dp,50.dp))
                                   }
                                   if (character.gender.equals("genderless")){
                                       Image(painter = painterResource(id = R.drawable.genderless),
                                           contentDescription = "Male", modifier = Modifier.size(50.dp,50.dp))
                                   }
                                   Text(text = "${character.name}" +
                                           "\n ${character.gender}")

                               }
                           }
                       }
                   }
               })
       }
   }
}







