package com.jaures.smartmail.ui.screens.mail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jaures.smartmail.R
import com.jaures.smartmail.ui.components.BottomNavigationBar

@Composable
fun MailInterfaceScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "INBOX",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Permet d'avoir un scroll tout en gardant la BottomNavigationBar visible
            Box(
                modifier = Modifier
                    .weight(1f) // Utilisation du poids pour que la liste occupe l’espace restant
                    .fillMaxSize()
            ) {
                MessageListSection()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var searchQuery by remember { mutableStateOf("") }

    TextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = {
            Text(
                "Search in mail",
                fontSize = 16.sp
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.LightGray.copy(alpha = 0.2f)),
        leadingIcon = {
            IconButton(onClick = { /* Open drawer */ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_avatar_male),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun MessageListSection() {
    val messages = listOf(
        Message("Alice", "Project Update", "Meeting at 3PM", "Mar 1", true),
        Message("Bob", "Lunch", "Where do you want to eat?", "Mar 2", false),
        Message("Charlie", "Invoice", "Please check the attached invoice.", "Mar 3", true),
        Message("David", "Follow-up", "Any updates on the proposal?", "Mar 4", false),
        Message("Eve", "Event Reminder", "Don't forget the conference!", "Mar 5", true),
        Message("Frank", "Job Offer", "We'd like to extend an offer...", "Mar 6", false)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espacement amélioré
    ) {
        items(messages) { message ->
            MessageItem(message)
        }
    }
}

data class Message(
    val sender: String,
    val subject: String,
    val content: String,
    val date: String,
    val isFavorite: Boolean
)

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = message.sender.first().toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = message.sender,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = message.subject,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Text(
                    text = message.date,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = message.content,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    painter = painterResource(
                        id = if (message.isFavorite) R.drawable.icon_star_on else R.drawable.icon_star_off
                    ),
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { /* Handle favorite action */ },
                    tint = if (message.isFavorite) Color.Black else Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun PreviewMailInterfaceScreen() {
    val navController = rememberNavController()
    MailInterfaceScreen(navController)
}
