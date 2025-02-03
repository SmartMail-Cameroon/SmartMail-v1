package com.jaures.smartmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jaures.smartmail.navigation.AppNavGraph
import com.jaures.smartmail.ui.theme.SmartMailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Activer le mode plein écran
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()

        setContent {
            SmartMailTheme {
                // Contrôleur de navigation
                val navController = rememberNavController()
                // AppNavGraph pour la navigation
                AppNavGraph(navController = navController)
                // Gestion du System UI pour masquer la barre de navigation
                SetSystemUiVisibility()
            }
        }
    }
}

@Composable
fun SetSystemUiVisibility() {
    val systemUiController = rememberSystemUiController()
    systemUiController.isNavigationBarVisible = false
}
