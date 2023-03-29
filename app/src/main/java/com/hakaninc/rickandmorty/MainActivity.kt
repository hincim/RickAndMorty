package com.hakaninc.rickandmorty

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hakaninc.rickandmorty.screen.CharacterDetailPage
import com.hakaninc.rickandmorty.screen.HelloScreen
import com.hakaninc.rickandmorty.screen.HomePage
import com.hakaninc.rickandmorty.screen.SplashScreen
import com.hakaninc.rickandmorty.ui.theme.RickAndMortyTheme
import com.hakaninc.rickandmorty.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

    private val isFirstOpen = "isFirstOpen"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE)
        val isFirstTime = sharedPreferences.getBoolean(isFirstOpen, true)

        setContent {
            RickAndMortyTheme {


                val navController = rememberNavController()
                val userViewModel = UserViewModel()
                val stateScreen = remember {
                    mutableStateOf("")
                }

                if (isFirstTime){
                    stateScreen.value = "splash_screen"
                    with(sharedPreferences.edit()){
                        putBoolean(isFirstOpen,false)
                        apply()
                    }
                }else{
                    stateScreen.value = "hello_screen"
                }

                NavHost(navController = navController, startDestination = stateScreen.value){

                    composable("splash_screen"){

                        SplashScreen(navController = navController)
                    }
                    
                    composable("hello_screen"){
                        HelloScreen(navController = navController)
                    }

                    composable("home_page"){

                        HomePage(navController = navController, userViewModel = userViewModel)
                    }

                    composable("character_detail_page"){

                        CharacterDetailPage(navController = navController,userViewModel)
                    }
                }
            }
        }
    }
}

















