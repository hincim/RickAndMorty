package com.hakaninc.rickandmorty.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hakaninc.rickandmorty.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(navController: NavController) {
    val animatedProgress = remember { Animatable(0f) }
    val image: Painter = painterResource(id = R.drawable.rickandmorty)

    LaunchedEffect(key1 = true){
        animatedProgress.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 750)
        )
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
        Image(painter = image, contentDescription = "Rick And Morty",
            Modifier
                .size(275.dp, 275.dp)
                .graphicsLayer(rotationY = animatedProgress.value))
        Text(text = "Welcome!", fontSize = 22.sp, fontWeight = FontWeight.Bold,)

        ChangeScreen{
            navController.navigate("home_page")
        }
    }
}
@Composable
fun ChangeScreen(navigateTo: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    val delayTime = 3000L

    LaunchedEffect(true) {
        coroutineScope.launch {
            delay(delayTime)
            navigateTo.invoke()
        }
    }
}
