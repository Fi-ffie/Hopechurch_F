package com.fiona02.hopechurchapp.ui.theme.screens.splash

import android.media.Image
import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fiona02.hopechurchapp.R
import com.fiona02.hopechurchapp.navigation.ROUTE_INDEX
import com.fiona02.hopechurchapp.ui.theme.screens.login.Loginscreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale= remember{
        Animatable(0f)

    }
    LaunchedEffect( key1 =true ){
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 3000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(2000L)
        navController.navigate(ROUTE_INDEX)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        // You can use an Image or any other Composable to display your splash screen UI
        Image(
            painter = painterResource(id = R.drawable.hope),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primary)
                .clip(shape = RoundedCornerShape(50.dp))
                .scale(scale.value)
        )
    }
}
@Preview
@Composable
fun SplashScreen() {
    SplashScreen(rememberNavController())
}