package com.fiona02.hopechurchapp.ui.theme.screens.index

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fiona02.hopechurchapp.R
import com.fiona02.hopechurchapp.navigation.ROUTE_REGISTER

@Composable
fun IndexScreen(controller: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Spacer(modifier = Modifier.height(19.dp))

        Text(
            text = "HOPE CHURCH",
            color = Color.White,
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.effiel),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.White,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Greetings.\n Welcome to Hope Church ministry.We are excited to walk with you in you spiritual journey with" +
                    " Christ.\n This application will serve to implement our various church functions via mobile means that are more efficient.",
            color = Color.Black,
            modifier=Modifier.padding(10.dp),
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 15.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                controller.navigate(ROUTE_REGISTER)

            },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
        )
        {
            Text(
                text = " WELCOME :)",
                color = Color.White,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Serif
            )


        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Praise & Worship with us at Hope Church",
            color = Color(0xFF000000),
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 15.sp
        )


    }

}
@Preview
@Composable
fun IndexPreview() {
    IndexScreen(rememberNavController())

}