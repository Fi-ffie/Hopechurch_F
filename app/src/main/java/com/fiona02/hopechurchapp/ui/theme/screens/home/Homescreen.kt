package com.fiona02.hopechurchapp.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.fiona02.hopechurchapp.navigation.ROUTE_CONTACT_US
import com.fiona02.hopechurchapp.navigation.ROUTE_GROUP_LINKS
import com.fiona02.hopechurchapp.navigation.ROUTE_MASS_SCHEDULE
import com.fiona02.hopechurchapp.navigation.ROUTE_OFFERINGS
import com.fiona02.hopechurchapp.navigation.ROUTE_REQUEST_SERVICE

@Composable
fun Homescreen(navController: NavHostController){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally){

        var context= LocalContext.current
//        var productdata= productviewmodel(navController, context)

        Text(text = "Welcome to Hope Church.",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_MASS_SCHEDULE)
        }, colors = ButtonDefaults.buttonColors()
            ,modifier = Modifier.fillMaxWidth()) {
            Text(text = "Mass Schedule.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(onClick = {
            navController.navigate(ROUTE_REQUEST_SERVICE)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Request Service.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(onClick = {
            navController.navigate(ROUTE_OFFERINGS)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Offerings.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(onClick = {
            navController.navigate(ROUTE_GROUP_LINKS)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Group Links.")
        }
        Spacer(modifier = Modifier.height(5.dp))

        Button(onClick = {
            navController.navigate(ROUTE_CONTACT_US)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Contact Us.")
        }
        Spacer(modifier = Modifier.height(5.dp))
    }
}
@Preview
@Composable
fun Homepage(){
    Homescreen(rememberNavController())
}
