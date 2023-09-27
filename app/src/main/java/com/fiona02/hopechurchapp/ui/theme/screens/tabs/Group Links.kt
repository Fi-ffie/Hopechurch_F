package com.fiona02.hopechurchapp.ui.theme.screens.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fiona02.hopechurchapp.R
import com.fiona02.hopechurchapp.navigation.ROUTE_REGISTER

@Composable
fun GroupLinks(controller: NavHostController) {
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
            text = "Hope Church Group Links.",
            color = Color.White,
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Hello members.\n The following are the Whatsapp links to the various groups in our church.\n Please feel " +
                    "to join,interact,share and support your fellow friends in Christ.\n Welcome.",

            color = Color.Black,
            modifier=Modifier.padding(10.dp),
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Welfare group \n https://chat.whatsapp.com/G4jpEQt15aX1cXXCPDEvnA",
            color = Color.White,
            modifier=Modifier
                .padding(10.dp)
                .clickable { },
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Youth group \n https://chat.whatsapp.com/G4jpEQt15aX1cXXCPDEvnA",
            color = Color.White,
            modifier=Modifier.padding(10.dp),
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Men's association \n https://chat.whatsapp.com/G4jpEQt15aX1cXXCPDEvnA",
            color = Color.White,
            modifier=Modifier.padding(10.dp),
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Women's group \n https://chat.whatsapp.com/G4jpEQt15aX1cXXCPDEvnA",
            color = Color.White,
            modifier=Modifier.padding(10.dp),
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
            fontSize = 20.sp,
        )


    }
}
@Preview
@Composable
fun GroupLinksPreview() {
    GroupLinks(rememberNavController())

}

