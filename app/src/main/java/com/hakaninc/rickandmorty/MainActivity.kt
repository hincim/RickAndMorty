package com.hakaninc.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hakaninc.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "splash_screen"){

                    composable("splash_screen"){

                        SplashScreen(navController = navController)
                    }

                    composable("home_page"){

                        HomePage(navController = navController)
                    }

                    composable("character_detail_page"){

                        CharacterDetailPage(navController = navController)
                    }
                }
            }
        }
    }
}

















