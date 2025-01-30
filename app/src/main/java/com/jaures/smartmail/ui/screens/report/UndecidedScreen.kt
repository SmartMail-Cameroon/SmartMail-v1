package com.jaures.smartmail.ui.screens.dailyreport

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun UndecidedScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Section d'entête (non défilable)
        HeaderUndecidedSection()
        // Section des messages (défilable)
        MessageListUndecidedSection()

        // Section de la barre de navigation
        BottomNavigationBarUndecided()
    }
}

@Composable
fun HeaderUndecidedSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .background(Color(0xFFF9C74F)) // Fond vert
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            // Bouton retour
            Text(
                text = "Back",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                modifier = Modifier
                    .size(38.dp, 19.dp)
                    .weight(1f),
                fontSize = 16.sp
            )

            // Texte "Important"
            Text(
                text = "Important",
                style = MaterialTheme.typography.titleLarge.copy(color = Color.White),
                modifier = Modifier
                    .size(144.dp, 36.dp)
                    .weight(2f),
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )

            // Section "Not accurate?"
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .size(72.dp, 54.dp)
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(com.jaures.smartmail.R.drawable.alert),
                    contentDescription = null,
                    modifier = Modifier.size(19.64.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Not accurate?",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        // Image centrée
        Image(
            painter = painterResource(com.jaures.smartmail.R.drawable.undecided),
            contentDescription = null,
            modifier = Modifier
                .size(86.dp, 88.17.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun MessageListUndecidedSection() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)  // Padding pour la section des messages
    ) {
        items(6) { index ->
            MessageItemUndecided(
                name = "Name Surname",
                subject = "Subject goes here",
                message = "This is the message content for this item.",
                date = "Mar 1",
                isFavorite = index % 2 == 0
            )
        }
    }
}

@Composable
fun BottomNavigationBarUndecided() {
    Spacer(modifier = Modifier.height(8.dp))

    // Barre de navigation en bas
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth() // Barre de navigation prend toute la largeur
    ) {
        // Item "Home"
        NavigationBarItem(
            icon = {
                Column(
                    modifier = Modifier
                        .size(width = 179.5.dp, height = 46.dp), // Taille de la section "Home"
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = com.jaures.smartmail.R.drawable.ic_home),
                        contentDescription = "Home",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Home",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            },
            label = null,
            selected = false,
            onClick = { /* Handle Home Navigation */ }
        )

        // Item "Support"
        NavigationBarItem(
            icon = {
                Column(
                    modifier = Modifier
                        .size(width = 179.5.dp, height = 46.dp), // Taille de la section "Support"
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = com.jaures.smartmail.R.drawable.ic_support),
                        contentDescription = "Support",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Support",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            },
            label = null,
            selected = true,
            onClick = { /* Handle Support Navigation */ }
        )
    }
}

@Composable
fun MessageItemUndecided(name: String, subject: String, message: String, date: String, isFavorite: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar Icon
        Box(
            modifier = Modifier
                .size(42.dp)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name.first().toString(),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Message Info (Name, Subject, Message, Date, Favorite)
        Column(modifier = Modifier.weight(1f)) {
            // Row for Name, Subject, and Date
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp), // Adjusted height for the block
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left part - Name and Subject
                Column(modifier = Modifier.weight(1f)) {
                    // Name in bold
                    Text(
                        text = name,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    // Subject (message header)
                    Text(
                        text = subject,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                // Right part - Date
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            // Message Content and Favorite Icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Message Content
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )

                // Favorite Icon
                Icon(
                    painter = painterResource(
                        id = if (isFavorite) com.jaures.smartmail.R.drawable.icon_star_on else com.jaures.smartmail.R.drawable.icon_star_off
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { /* Handle favorite action */ },
                    tint = if (isFavorite) Color.Black else Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun PreviewUndecidedScreen() {
    UndecidedScreen()
}
