package com.fiona02.hopechurchapp.ui.theme.screens.view_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fiona02.hopechurchapp.data.detailsviewmodel
import com.fiona02.hopechurchapp.models.Details
import com.fiona02.hopechurchapp.navigation.ROUTE_VIEW_DETAILS

@Composable
fun ViewDetails(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top)

    {
        val context = LocalContext.current
        val detailsRepository = detailsviewmodel(navController, context)
        val emptyDetailState = remember { mutableStateOf(Details("","","","","","")) }
        var emptyDetailsListState = remember { mutableStateListOf<Details>() }

        var details = detailsRepository.viewDetails(emptyDetailState, emptyDetailsListState)


            Text(text = "Request Details",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(details){
                    ItemDetails(
                        name = it.name,
                        phonenumber = it.phonenumber,
                        type = it.type,
                        date = it.date,
                        time = it.time,
                        id=it.id,
                        navController = navController,
                        detailsRepository = detailsRepository,

                    )
                }
            }
        }
    }
@Composable
fun ItemDetails(name:String, phonenumber:String, type:String, date:String, time:String,
                navController:NavHostController, detailsRepository:detailsviewmodel,id:String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = phonenumber)
        Text(text = type)
        Text(text = date)
        Text(text = time)
        Button(onClick = {
            detailsRepository.deleteDetails(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_VIEW_DETAILS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}
//@Preview
//@Composable
//fun ViewDetailsPreview() {
//    ViewDetails(rememberNavController())
//
//}