package com.fiona02.hopechurchapp.ui.theme.screens.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.fiona02.hopechurchapp.data.detailsviewmodel
import com.fiona02.hopechurchapp.navigation.ROUTE_VIEW_DETAILS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequestService(navController: NavHostController) {
    var context = LocalContext.current
    Column ( modifier= Modifier
        .background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            text = "REQUEST SERVICE",
            color = Color.White,
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Hello, \n If you wish to request for a special service from the church clergy" +
                    " please feel free to fill the form below.\n Be Blessed.",
            color = Color.Black,
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Form
        var name by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var type by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var time by remember { mutableStateOf("") }

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = type,
            onValueChange = { type = it },
            label = { Text("Type") },
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date (Dd/Mm/YYYY)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Time") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
//            -----------WRITE THE SAVE LOGIC HERE---------------//
                var detailsRepository = detailsviewmodel(navController,context)
                detailsRepository.saveDetails(name.trim(), phoneNumber.trim(),
                    type.trim(), date.trim(), time.trim()
                )
                navController.navigate(ROUTE_VIEW_DETAILS)},
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
        )
        {
            Text(
                text = "Make Request",
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun RequestServicePreview() {
    RequestService(rememberNavController())

}