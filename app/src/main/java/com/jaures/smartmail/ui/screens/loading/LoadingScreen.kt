package com.jaures.smartmail.ui.screens.loading

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jaures.smartmail.R
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavHostController) {
    var rotation by remember { mutableStateOf(0f) }
    val animatedRotation by animateFloatAsState(
        targetValue = rotation,
        animationSpec = tween(durationMillis = 2000, easing = { it })
    )

    // Attendre 2 secondes avant de naviguer vers Home
    LaunchedEffect(Unit) {
        rotation += 360f // Déclenche l'animation une seule fois
        delay(5000) // Attente de 2 secondes
        navController.navigate("home") { // Remplace "home" par ta route réelle
            popUpTo("loading") { inclusive = true } // Évite de revenir en arrière sur l'écran de chargement
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Dégradé en haut
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.TopCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF2575FC), Color.Transparent)
                    ),
                    shape = RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 200.dp)
                )
        )

        // Dégradé en bas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(0xFF2575FC))
                    ),
                    shape = RoundedCornerShape(topStart = 200.dp, topEnd = 200.dp)
                )
        )

        // Contenu centré
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Image qui tourne
            Image(
                painter = painterResource(id = R.drawable.circles),
                contentDescription = "Loading",
                modifier = Modifier
                    .size(200.dp)
                    .rotate(animatedRotation)
                    .background(Color.Transparent, CircleShape)
            )

            Text(
                text = "Loading...",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 50.dp)
            )
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    val navController = rememberNavController()
    LoadingScreen(navController = navController)
}
