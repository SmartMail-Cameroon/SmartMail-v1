package com.jaures.smartmail.ui.screens.level

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun LevelScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header with image before "Level" title and "Back" button
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

            // Add Image before Level text
            Image(
                painter = painterResource(id = com.jaures.smartmail.R.drawable.levelicon), // Replace with actual resource
                contentDescription = "Level Icon",
                modifier = Modifier
                    .size(53.dp, 54.dp) // Set size to 53x54
                    .padding(end = 8.dp) // Space between the image and the text
            )

            Text(
                text = "Level",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // Column for the three vertical images at the bottom
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // First Image
            Image(
                painter = painterResource(id = com.jaures.smartmail.R.drawable.level), // Replace with actual resource
                contentDescription = "Image 1",
                modifier = Modifier
                    .size(355.dp, 229.dp) // Set size to 355x229
                    .clickable { /* Action on image click */ }
            )

            // Second Image
            Image(
                painter = painterResource(id = com.jaures.smartmail.R.drawable.level2), // Replace with actual resource
                contentDescription = "Image 2",
                modifier = Modifier
                    .size(355.dp, 229.dp) // Set size to 355x229
                    .clickable { /* Action on image click */ }
            )

            // Third Image
            Image(
                painter = painterResource(id = com.jaures.smartmail.R.drawable.level3), // Replace with actual resource
                contentDescription = "Image 3",
                modifier = Modifier
                    .size(355.dp, 229.dp) // Set size to 355x229
                    .clickable { /* Action on image click */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLevelScreen() {
    val navController = rememberNavController() // Replace with your NavController
    LevelScreen(navController = navController)
}