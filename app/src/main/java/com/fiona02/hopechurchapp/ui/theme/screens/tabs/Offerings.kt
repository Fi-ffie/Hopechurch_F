package com.fiona02.hopechurchapp.ui.theme.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Offerings(navController: NavHostController) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    )

    {
        Text(
            text = "OFFERINGS & TITHE",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontSize = 35.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Dear member, \n You can pay your tithes and donations efficiently here through mpesa. \n" +
                    "We appreciate and value your support.\n Be blessed.",
            color = Color.Black,
            modifier = Modifier.padding(10.dp),
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                val simToolKitLaunchIntent =
                    context.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { context.startActivity(it) }
            },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "STK",
                fontSize = 15.sp
            )
        }
    }
}
@Preview
@Composable
fun OfferingsPreview() {
    Offerings(rememberNavController())
}

