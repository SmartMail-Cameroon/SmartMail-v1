package com.jaures.smartmail.ui.screens.faq

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FAQScreen() {
    var searchQuery by remember { mutableStateOf("") } // Variable d'état pour le texte de recherche

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_media_previous), // Remplacez par votre icône "flèche retour"
                contentDescription = "Back",
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "FAQ",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // "How can we help you?" Section
        Text(
            text = "How can we help you?",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center, // Centre le texte horizontalement
            modifier = Modifier
                .fillMaxWidth() // S'assure que le texte occupe toute la largeur
                .padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(35.dp))


        // Barre de recherche
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_search), // Remplacez par votre icône "loupe"
                    contentDescription = "Search Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                BasicTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it }, // Mise à jour de l'état avec la valeur de recherche
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    decorationBox = { innerTextField ->
                        if (searchQuery.isEmpty()) {
                            Text(
                                text = "Enter your keyword",
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }
                        innerTextField() // Affichage du champ de texte réel
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // Centre les blocs horizontalement
            verticalAlignment = Alignment.CenterVertically // Aligne verticalement si nécessaire
        ) {
            // Premier bloc
            FAQCategoryBlock(
                backgroundColor = Color(0xFF2196F3),
                iconRes = android.R.drawable.ic_dialog_info, // Remplacez par une icône appropriée
                title = "Questions about",
                subtitle = "Getting Started"
            )

            Spacer(modifier = Modifier.width(16.dp)) // Espacement entre les blocs

            // Second bloc
            FAQCategoryBlock(
                backgroundColor = Color(0xFF4CAF50),
                iconRes = android.R.drawable.ic_dialog_info, // Remplacez par une icône appropriée
                title = "Questions about",
                subtitle = "How to use app"
            )
        }


        Spacer(modifier = Modifier.height(34.dp))

        // Section "Top Questions"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Top Questions",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "View All",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Red, // Changer la couleur en rouge
                modifier = Modifier.clickable { /* Gérer le clic */ }
            )

        }

        Spacer(modifier = Modifier.height(46.dp))

        // Questions verticales
        val questions = listOf(
            "How to recover deleted email?",
            "How to add new email?",
            "How to delete new email?"
        )
        questions.forEach { question ->
            FAQQuestionItem(question)
        }
    }
}

@Composable
fun FAQCategoryBlock(
    backgroundColor: Color,
    iconRes: Int,
    title: String,
    subtitle: String
) {
    Box(
        modifier = Modifier
            .size(144.dp, 116.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .padding(8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun FAQQuestionItem(question: String) {
    Row(
        modifier = Modifier
            .widthIn(min = 342.dp, max = 342.dp) // Largeur de 342 dp
            .heightIn(min = 87.dp, max = 87.dp) // Hauteur de 87 dp
            .padding(vertical = 8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = question,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = android.R.drawable.ic_input_add),
            contentDescription = "Add Icon",
            tint = Color.Red,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FAQScreenPreview() {
    FAQScreen()
}
