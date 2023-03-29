package com.hakaninc.rickandmorty.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hakaninc.rickandmorty.R
import com.hakaninc.rickandmorty.viewmodel.HomePageViewModel
import com.hakaninc.rickandmorty.viewmodel.UserViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomePage(navController: NavController, userViewModel: UserViewModel) {

    val viewModel: HomePageViewModel = HomePageViewModel()
    val personList = viewModel.personList.observeAsState(listOf())
    val characterList = viewModel.characterList.observeAsState(listOf())
    val personState= viewModel.personState.observeAsState()
    val characterState = viewModel.characterState.observeAsState()

    val lazyColumnLoading = remember {
        mutableStateOf(false)
    }
    val lazyRowLoading = remember {
        mutableStateOf(false)
    }

    if (characterList.value.isNotEmpty()){
        lazyColumnLoading.value = true
    }
    if (personList.value.isNotEmpty()){
        lazyRowLoading.value = true
    }

    LaunchedEffect(key1 = true) {

        viewModel.getAllPersons()
        viewModel.getAllCharacter()

    }
    when {
        characterState.value != null || personState.value != null -> {
            Toast.makeText(navController.context,personState.value,Toast.LENGTH_SHORT).show()
            Toast.makeText(navController.context,characterState.value,Toast.LENGTH_SHORT).show()
        }
    }


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.rickandmorty),
            contentDescription = "Rick And Morty",
            alignment = Alignment.Center,
            modifier = Modifier.size(120.dp, 120.dp)
        )

        LazyRow {
            items(count = personList.value.count(),
                itemContent = {
                    val person = personList.value[it]

                    when {
                        lazyRowLoading.value -> {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .shadow(10.dp),
                                backgroundColor = Color.White,

                                ) {
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
                                    }
                                }
                            }

                        }else ->{
                        CircularProgressIndicator(
                            color = colorResource(id = R.color.statusBarColor),
                            modifier = Modifier
                                .size(45.dp)
                                .padding(5.dp)
                        )
                    }
                    }
                })
        }
        LazyColumn {
            items(count = characterList.value.count(),
                itemContent = {
                    val character = characterList.value[it]
                    when {
                        lazyColumnLoading.value ->{
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .shadow(10.dp),
                                backgroundColor = Color.White,

                                ) {

                                Row(modifier = Modifier.clickable {
                                    navController.navigate("character_detail_page")
                                    userViewModel.setUser(character)
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

                                            GlideImage(
                                                imageModel = character.image, modifier =
                                                Modifier.size(100.dp, 150.dp)
                                            )
                                            when {

                                                character.gender.equals("Male") -> {
                                                    ImageGender(R.drawable.male,"Male",
                                                        Modifier.size(50.dp, 50.dp))
                                                }
                                                character.gender.equals("Female") -> {
                                                    ImageGender(R.drawable.female,"Male",
                                                        Modifier.size(50.dp, 50.dp))
                                                }
                                                character.gender.equals("unknown") -> {
                                                    ImageGender(R.drawable.genderless,"unknown",
                                                        Modifier.size(50.dp, 50.dp))
                                                }
                                                character.gender.equals("genderless") -> {
                                                    ImageGender(R.drawable.genderless,"genderless",
                                                        Modifier.size(50.dp, 50.dp))
                                                }

                                            }
                                            Text(
                                                text = "${character.name}" +
                                                        "\n${character.gender}"
                                            )

                                        }
                                    }
                                }
                            }

                        }else ->{
                        CircularProgressIndicator(
                            color = colorResource(id = R.color.statusBarColor),
                            modifier = Modifier
                                .size(45.dp)
                                .padding(5.dp)
                        )
                    }
                    }
                })
        }
    }
}

@Composable
private fun ImageGender(painter : Int, contentDescription: String, modifier: Modifier) {
    Image(painter = painterResource(id = painter), contentDescription = contentDescription,
        modifier = modifier)
}








