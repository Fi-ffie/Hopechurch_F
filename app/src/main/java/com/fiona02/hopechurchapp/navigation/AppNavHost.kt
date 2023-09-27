package com.fiona02.hopechurchapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fiona02.hopechurchapp.ui.theme.screens.home.Homescreen
import com.fiona02.hopechurchapp.ui.theme.screens.index.IndexScreen
import com.fiona02.hopechurchapp.ui.theme.screens.login.Loginscreen
import com.fiona02.hopechurchapp.ui.theme.screens.register.Registerscreen
import com.fiona02.hopechurchapp.ui.theme.screens.splash.SplashScreen
import com.fiona02.hopechurchapp.ui.theme.screens.tabs.ContactUs
import com.fiona02.hopechurchapp.ui.theme.screens.tabs.GroupLinks
import com.fiona02.hopechurchapp.ui.theme.screens.tabs.Offerings
import com.fiona02.hopechurchapp.ui.theme.screens.tabs.RequestService
import com.fiona02.hopechurchapp.ui.theme.screens.tabs.ServiceSchedule
import com.fiona02.hopechurchapp.ui.theme.screens.view_details.ViewDetails

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(),
               startDestination:String= ROUTE_SPLASH_SCREEN) {
    NavHost(navController = navController, modifier = modifier, startDestination = startDestination) {
        composable(ROUTE_LOGIN) {
            Loginscreen(navController)
        }
        composable(ROUTE_REGISTER) {
            Registerscreen(navController)
        }
        composable(ROUTE_HOME) {
            Homescreen(navController)
        }
        composable(ROUTE_INDEX) {
            IndexScreen(navController)
        }
        composable(ROUTE_MASS_SCHEDULE) {
            ServiceSchedule(navController)
        }
        composable(ROUTE_REQUEST_SERVICE) {
            RequestService(navController)
        }
        composable(ROUTE_SPLASH_SCREEN) {
            SplashScreen(navController)
        }
        composable(ROUTE_GROUP_LINKS) {
            GroupLinks(navController)
        }
        composable(ROUTE_CONTACT_US) {
            ContactUs(navController)
        }
        composable(ROUTE_OFFERINGS) {
            Offerings(navController)
        }
        composable(ROUTE_VIEW_DETAILS){
            ViewDetails(navController)
        }
    }

}