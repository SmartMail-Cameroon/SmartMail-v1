package com.jaures.smartmail.navigation

import LoginScreen
import SignUpScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jaures.smartmail.ui.screens.report.DailyReportScreen
import com.jaures.smartmail.ui.screens.report.DetailDailyReportScreen
import com.jaures.smartmail.ui.screens.home.HomeScreen
import com.jaures.smartmail.ui.screens.intro.IntroScreen


@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "intro" // Votre écran de démarrage
    ) {
        // Route vers IntroScreen
        composable(route = "intro") {
            IntroScreen(navController = navController)
        }

        // Route vers LoginScreen
        composable(route = "login") {
            LoginScreen(navController = navController)
        }

        // Route vers SignUpScreen
        composable(route = "signup") {
            SignUpScreen(navController = navController)
        }

        composable(route = "home") {
            HomeScreen(navController = navController)
        }

        composable(route = "daily_report") {
            DailyReportScreen(navController = navController)
        }

        composable("detail/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            Log.d("NavGraph", "Navigating to detail screen with itemId: ${itemId}")
            DetailDailyReportScreen(navController = navController, itemId = itemId)
        }
    }
}
