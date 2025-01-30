package com.jaures.smartmail.ui.components

import androidx.compose.foundation.layout.height
import com.jaures.smartmail.R
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    BottomAppBar(
        modifier = Modifier.height(60.dp), // Hauteur de la barre de navigation
        containerColor = MaterialTheme.colorScheme.surface, // Couleur de fond
        contentColor = MaterialTheme.colorScheme.onSurface, // Couleur du contenu
    ) {
        NavigationBar {
            // Élément Home
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_home), // Remplacez par votre icône Home
                        contentDescription = "Home"
                    )
                },
                label = { Text("Home") },
                selected = currentRoute == "home", // Vérifie si l'écran actuel est Home
                onClick = {
                    navController.navigate("home") {
                        popUpTo(navController.graph.startDestinationId) // Évite les duplications dans la pile de navigation
                        launchSingleTop = true
                    }
                }
            )

            // Élément Support
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_support), // Remplacez par votre icône Support
                        contentDescription = "Support"
                    )
                },
                label = { Text("Support") },
                selected = currentRoute == "support", // Vérifie si l'écran actuel est Support
                onClick = {
                    navController.navigate("support") {
                        popUpTo(navController.graph.startDestinationId) // Évite les duplications dans la pile de navigation
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}