package com.jaures.smartmail.ui.screens.level

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LevelScreen(navController: NavHostController) {
    val systemUiController = rememberSystemUiController()

    // Masquer la barre de navigation
    SideEffect {
        systemUiController.isNavigationBarVisible = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Rendre l'écran scrollable
    ) {
        // Header avec bouton "Back" et icône
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Back",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5DB075),
                modifier = Modifier
                    .weight(1f)
                    .clickable { navController.popBackStack() }
                    .align(Alignment.CenterVertically)
            )

            Image(
                painter = painterResource(id = com.jaures.smartmail.R.drawable.levelicon),
                contentDescription = "Level Icon",
                modifier = Modifier
                    .size(50.dp) // Ajusté pour s'adapter aux petits écrans
                    .padding(end = 8.dp)
            )

            Text(
                text = "Level",
                fontSize = 24.sp, // Réduit pour s'adapter aux écrans 5"
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // Images scrollables
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val imageModifier = Modifier
                .fillMaxWidth()
                .height(180.dp) // Ajusté pour écrans plus petits
                .clickable { /* Action on click */ }

            Image(
                painter = painterResource(id = com.jaures.smartmail.R.drawable.level),
                contentDescription = "Image 1",
                modifier = imageModifier
            )

            Image(
                painter = painterResource(id = com.jaures.smartmail.R.drawable.level2),
                contentDescription = "Image 2",
                modifier = imageModifier
            )

            Image(
                painter = painterResource(id = com.jaures.smartmail.R.drawable.level3),
                contentDescription = "Image 3",
                modifier = imageModifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLevelScreen() {
    val navController = rememberNavController()
    LevelScreen(navController = navController)
}
