package com.fiona02.hopechurchapp.ui.theme.screens.tabs

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ContactUs(navController: NavHostController) {
    val context = LocalContext.current
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    )

    {
        Text(
            text = "CONTACT US",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "We value your inquiries and feedback.\n" +
                    "Please feel free to reach out to us using any of the following methods:",
            color = Color.Black,
            modifier = Modifier.padding(10.dp),
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))


        OutlinedButton(
            onClick = {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254719713965"))

                if (ContextCompat.checkSelfPermission(
                        context,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        1
                    )
                } else {
                    context.startActivity(intent)
                }

            },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(text = "Call",
                fontSize = 15.sp)
        }
        OutlinedButton(onClick = {
            val uri = Uri.parse("smsto:0710423445")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "Welcome to Hope Church.")

            context.startActivity(intent)
        },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(text = "SMS",
                fontSize = 15.sp)
        }
        OutlinedButton(
            onClick = {
                val emailIntent =
                    Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "info@hopechurchgmail.com", null))

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

                context.startActivity(Intent.createChooser(emailIntent, "Send email..."))
            },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(text = "Email",
                fontSize = 15.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "You can also share this app to family and friends below." +
                    " \n Welcome to Hope Church.",
            color = Color.Black,
            modifier = Modifier.padding(10.dp),
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        )

        OutlinedButton(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                context.startActivity(shareIntent)
            },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(text = "Share",
                fontSize = 15.sp)
        }

    }
}
@Preview
@Composable
fun ContactUsPreview() {
    ContactUs(rememberNavController())
}