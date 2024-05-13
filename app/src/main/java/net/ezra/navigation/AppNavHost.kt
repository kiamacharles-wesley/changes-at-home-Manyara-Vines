package net.ezra.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.CartPage
import net.ezra.HistoryScreen
import net.ezra.ui.auth.PhoneLoginScreen
import net.ezra.ui.auth.PhoneSignupScreen
import net.ezra.SettingsScreen
import net.ezra.ui.SplashScreen
import net.ezra.ui.auth.LoginScreen


import net.ezra.ui.destinations.BeachesScreen

import net.ezra.ui.destinations.DesertsScreen
import net.ezra.ui.destinations.LakesScreen
import net.ezra.ui.destinations.MountainsScreen
import net.ezra.ui.destinations.WildlifeScreen

import net.ezra.ui.Hotels.PopularHotels
import net.ezra.ui.Hotels.RaddisonBlu

import net.ezra.ui.Mountains.MountkenyaScreen

import net.ezra.ui.Packages.AlongRiftVAlley
import net.ezra.ui.Popular.RecommendedPackages
import net.ezra.ui.Popular.RecommendedPlaces
import net.ezra.ui.search.SearchScreen
import net.ezra.ui.auth.SignUpScreen
import net.ezra.ui.destinations.NotificationScreen
import net.ezra.ui.home.HomePage
import net.ezra.ui.parksBeaches.Diani
import net.ezra.ui.popular.VascodaGama
import net.ezra.ui.tsavo.Tsavo

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_LOGIN) {
            LoginScreen(navController = navController)
        }


        composable(ROUTE_SIGNUP) {
            SignUpScreen(navController=navController){}
        }



        composable(ROUTE_HOME) {
          HomePage(navController)
        }


        composable(ROUTE_SEARCH) {
            SearchScreen(navController)
        }

        composable(ROUTE_ALONG_RIFT_VALLEY) {
            AlongRiftVAlley(navController)
        }

        composable(ROUTE_VASCODAGAMA) {
           VascodaGama(navController)
        }

        composable(ROUTE_MT_KENYA) {
            MountkenyaScreen(navController)
        }



        composable(ROUTE_DIANI) {
           Diani(navController)
        }

        composable(ROUTE_RADDISONBLU) {
            RaddisonBlu(navController)
        }
        composable(ROUTE_TSAVO) {
           Tsavo(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_BEACHES) {
            BeachesScreen(navController)
        }

        composable(ROUTE_NOTIFICATIONS) {
           NotificationScreen(navController )
        }

        composable(ROUTE_PROFILE) {
            DesertsScreen(navController)
        }

        composable(ROUTE_LAKES) {
            LakesScreen(navController)
        }

        composable(ROUTE_MOUNTAINS) {
            MountainsScreen(navController)
        }

        composable(ROUTE_WILDLIFE) {
            WildlifeScreen(navController)
        }

        composable(ROUTE_CART) {
            CartPage(navController)
        }

        composable(ROUTE_RECOMMENDED_PACKAGES) {
            RecommendedPackages(navController)
        }

        composable(ROUTE_RECOMMENDED_PLACES) {
            RecommendedPlaces(navController)
        }

        composable(ROUTE_POPULAR_HOTELS) {
           PopularHotels(navController)
        }

        composable(ROUTE_HISTORY) {
            HistoryScreen(navController)
        }

        composable(ROUTE_PHONE_LOGIN) {
            PhoneLoginScreen(navController)
        }
        composable(ROUTE_PHONE_SIGNUP) {
            PhoneSignupScreen(navController=navController){}
        }
        composable(ROUTE_SETTINGS) {
            SettingsScreen(navController)
        }
        composable(ROUTE_HISTORY) {
            HistoryScreen(navController)
        }























    }
}