package com.hakaninc.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hakaninc.rickandmorty.screen.CharacterDetailPage
import com.hakaninc.rickandmorty.screen.HomePage
import com.hakaninc.rickandmorty.screen.SplashScreen
import com.hakaninc.rickandmorty.ui.theme.RickAndMortyTheme
import com.hakaninc.rickandmorty.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RickAndMortyTheme {


                val navController = rememberNavController()
                val userViewModel = UserViewModel()

                NavHost(navController = navController, startDestination = "home_page"){

                    composable("splash_screen"){

                        SplashScreen(navController = navController)
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

















