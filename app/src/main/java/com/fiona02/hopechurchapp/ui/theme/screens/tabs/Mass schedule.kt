package com.fiona02.hopechurchapp.ui.theme.screens.tabs

import android.widget.ResourceCursorTreeAdapter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fiona02.hopechurchapp.R
import java.util.Formatter

data class ServiceSchedule(
    val day: String,
    val time: String,
    val serviceType: String,
    val location: String
)

data class GroupSchedule(
    val day: String,
    val time: String,
    val serviceType: String,
    val location: String
)

@Composable
fun ServiceSchedule(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current

        Text(
            text = "HOPE CHURCH",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(19.dp))
        Image(
            painter = painterResource(id = R.drawable.effiel),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(RectangleShape)
                .border(
                    width = 2.dp,
                    color = Color.White,
                    shape = RectangleShape
                )
        )
        Spacer(modifier = Modifier.height(19.dp))

        // Sample service schedule data
        val serviceSchedules = listOf(
            ServiceSchedule("Sunday", "7:00 AM", "First Service", "Main Sanctuary"),
            ServiceSchedule("Sunday", "9:15 AM", "Second Service", "Main Sanctuary"),
            ServiceSchedule("Sunday", "10:00 AM", "Kids Service", "Fellowship Hall"),
            ServiceSchedule("Sunday", "11:30 AM", "Praise & Worship", "Main Sanctuary"),
        )

        Spacer(modifier = Modifier.height(19.dp))

        // Sample mass schedule data
        val groupScheduleSchedules = listOf(
            GroupSchedule("Saturday", "4:30 PM", "Youth Service", "Fellowship Hall"),
            GroupSchedule("Tuesday", "4:00 PM", "Prayer Session", "Fellowship Hall"),
            GroupSchedule("Saturday", "2:00 PM", "Welfare Meeting", "Fellowship Hall"),
            GroupSchedule("Sunday", "2:00 PM", "Elders Meeting", "Fellowship Hall"),
        )

        // Display service schedule
        Text(
            text  = "Service Schedule",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontSize = 24.sp
        )

        displaySchedule(serviceSchedules)

        // Display mass schedule
        Text(
            text = "Group Schedule",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontSize = 24.sp
        )

        displaySchedule(groupScheduleSchedules)
    }
}

@Composable
fun displaySchedule(schedule: List<Any>) {
    // Define column headers
    val headers = listOf("Day", "Time", "Service Type", "Location")

    // Calculate column widths
    val columnWidths = headers.map { it.length }.toMutableList()
    schedule.forEach { item ->
        if (item is ServiceSchedule) {
            columnWidths[0] = maxOf(columnWidths[0], item.day.length)
            columnWidths[1] = maxOf(columnWidths[1], item.time.length)
            columnWidths[2] = maxOf(columnWidths[2], item.serviceType.length)
            columnWidths[3] = maxOf(columnWidths[3], item.location.length)
        } else if (item is GroupSchedule) {
            columnWidths[0] = maxOf(columnWidths[0], item.day.length)
            columnWidths[1] = maxOf(columnWidths[1], item.time.length)
            columnWidths[2] = maxOf(columnWidths[2], item.serviceType.length)
            columnWidths[3] = maxOf(columnWidths[3], item.location.length)
        }
    }

    // Print the table header
    val headerLine = buildString {
        val formatter = Formatter(this)
        formatter.format(
            "%-${columnWidths[0]}s | %-${columnWidths[1]}s | %-${columnWidths[2]}s | %-${columnWidths[3]}s",
            headers[0], headers[1], headers[2], headers[3]
        )
    }
    Text(text = headerLine,color=Color.White)

    // Print the schedule data
    schedule.forEach { item ->
        val itemLine = buildString {
            val formatter = Formatter(this)
            if (item is ServiceSchedule) {
                formatter.format(
                    "%-${columnWidths[0]}s | %-${columnWidths[1]}s | %-${columnWidths[2]}s | %-${columnWidths[3]}s",
                    item.day, item.time, item.serviceType, item.location
                )
            } else if (item is GroupSchedule) {
                formatter.format(
                    "%-${columnWidths[0]}s | %-${columnWidths[1]}s | %-${columnWidths[2]}s | %-${columnWidths[3]}s",
                    item.day, item.time, item.serviceType, item.location
                )
            }
        }
        Text(text = itemLine)
    }
}

@Preview
@Composable
fun ServiceSchedulePreview() {
    ServiceSchedule(rememberNavController())
}
