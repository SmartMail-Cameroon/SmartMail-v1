package com.jaures.smartmail.ui.screens.report

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyReportScreen(navController: NavController) {
    Log.d("NavControllerCheck", "NavController hash: ${navController.hashCode()}")
    val items = listOf(
        Triple("Important", Color(0xFF4CAF50), "😊"), // Texte, couleur, emoji
        Triple("Undecided", Color(0xFFFFC107), "😐"),
        Triple("Unimportant", Color(0xFFF44336), "☹️")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Daily report",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        items.forEach { item ->
            DailyReportCard(
                text = item.first,
                color = item.second,
                emoji = item.third,
                onClick = {
                    val encodedItemId = item.first?.let { Uri.encode(it) } ?: ""
                    if (encodedItemId.isNotBlank()) {
                        Log.d("Navigationuoo", "Navigating to detail/$encodedItemId")
                        try {
                            navController.navigate("detail/$encodedItemId")
                        } catch (e: Exception) {
                            Log.e("NavigationError", "Error navigating to detail: ${e.message}")
                        }
                    } else {
                        Log.e("NavigationError", "item.first is null or blank")
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyReportCard(
    text: String,
    color: Color,
    emoji: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = color), // Couleur de fond
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Élévation
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = emoji,
                fontSize = 48.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun DailyReportScreenPreview() {
    val navController = rememberNavController()
    DailyReportScreen(navController = navController)
}
