package com.jaures.smartmail.ui.screens.support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jaures.smartmail.ui.components.BottomNavigationBar

@Composable
fun SupportScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        // Column to hold the content and make sure the padding is taken into account
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Header
            Text(
                text = "Support",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )

            // LazyColumn for dynamic message list with scrolling
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(10) { index ->  // Simulate a series of 10 fake messages
                    val isUser = index % 2 == 0
                    MessageBubble(
                        avatar = if (isUser) com.jaures.smartmail.R.drawable.ic_avatar_female else com.jaures.smartmail.R.drawable.ic_avatar_male,
                        message = if (isUser) "How do I reset my password?" else "Please follow the steps on the settings page.",
                        timestamp = "08:2${index} AM",
                        isUser = isUser,
                        bubbleColor = if (isUser) Color(0xFFFFEDED) else Color(0xFFF5F5F5)
                    )
                }
            }

            // Send Button
            Button(
                onClick = { /* Handle Send */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Send",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun MessageBubble(
    avatar: Int? = null,
    message: String,
    timestamp: String,
    isUser: Boolean,
    bubbleColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        if (!isUser) {
            avatar?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
        }

        Column(
            modifier = Modifier
                .widthIn(max = 250.dp) // Limite de la largeur de la bulle
                .padding(horizontal = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = bubbleColor,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = message,
                    color = if (isUser) Color.White else Color.Black,
                    fontSize = 14.sp
                )
            }
            Text(
                text = timestamp,
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )
        }

        if (isUser) {
            Spacer(modifier = Modifier.width(8.dp))
            avatar?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSupportScreen() {
    val navController = rememberNavController()
    SupportScreen(navController = navController)
}