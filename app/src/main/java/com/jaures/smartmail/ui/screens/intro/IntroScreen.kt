package com.jaures.smartmail.ui.screens.intro

// Importation des librairies nécessaires pour le développement de l'interface utilisateur avec Jetpack Compose
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jaures.smartmail.R
import com.jaures.smartmail.ui.components.CommonButton

@Composable
fun IntroScreen(navController: NavController) {
    val contentList = listOf(
        ContentItem(
            image = R.drawable.image1,
            title = "Clean up your inbox",
            description = "Keep your inbox tidy and organized by automatically removing unnecessary emails."
        ),
        ContentItem(
            image = R.drawable.image2,
            title = "Reduce CO2 together",
            description = "Contribute to a greener future by saving energy and reducing your email storage."
        ),
        ContentItem(
            image = R.drawable.image3,
            title = "Sort your emails",
            description = "Create, assign, and track tasks efficiently to stay on top of your goals."
        ),
        ContentItem(
            image = R.drawable.image4,
            title = "Automatic deletion",
            description = "Unnecessary emails are automatically detected and removed to save you time."
        )
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Ajout du défilement
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(
            currentIndex = currentIndex,
            onSkipClick = { navController.navigate("login") },
            onBackClick = { if (currentIndex > 0) currentIndex-- }
        )

        AnimatedContentSection(contentList, currentIndex)

        BottomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            onNextClick = {
                if (currentIndex < contentList.size - 1) {
                    currentIndex++
                } else {
                    navController.navigate("login")
                }
            }
        )
    }
}
// Fonction qui gère l'animation du contenu lors de la transition entre les éléments
@Composable
fun AnimatedContentSection(contentList: List<ContentItem>, currentIndex: Int) {
    // Animation de la visibilité de l'élément courant avec effet de fondu
    AnimatedVisibility(
        visible = currentIndex >= 0,
        enter = fadeIn(animationSpec = tween(durationMillis = 300)),
        exit = fadeOut(animationSpec = tween(durationMillis = 300))
    ) {
        ContentSection(contentList, currentIndex)
    }
}

// Fonction qui affiche l'élément courant du carrousel (image, titre et description)
@Composable
fun ContentSection(contentList: List<ContentItem>, currentIndex: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Affichage de l'élément sélectionné
        ContentItemView(contentList[currentIndex])

        // Espacement entre les éléments
        Spacer(modifier = Modifier.height(16.dp))

        // Indicateur de pagination sous forme de points
        DotsIndicator(currentIndex, contentList.size)
    }
}

// Fonction d'affichage d'un élément du contenu avec son image, titre et description
@Composable
fun ContentItemView(item: ContentItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Affichage de l'image de l'élément
        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding()
                .background(Color.LightGray, RoundedCornerShape(16.dp))
        )

        // Espacement entre les éléments
        Spacer(modifier = Modifier.height(16.dp))

        // Titre de l'élément
        Text(
            text = item.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )

        // Espacement entre le titre et la description
        Spacer(modifier = Modifier.height(8.dp))

        // Description de l'élément
        Text(
            text = item.description,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

// Fonction qui affiche des points pour indiquer la pagination
@Composable
fun DotsIndicator(currentIndex: Int, totalItems: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        // Création des points pour chaque élément du carrousel
        for (index in 0 until totalItems) {
            Box(
                modifier = Modifier
                    .size(if (index == currentIndex) 12.dp else 8.dp)
                    .padding(4.dp)
                    .background(
                        color = if (index == currentIndex) Color.Blue else Color.Gray,
                        shape = CircleShape
                    )
            )
        }
    }
}

// Bouton "Next" qui permet de passer à l'élément suivant ou d'achever l'introduction
@Composable
fun BottomButton(modifier: Modifier = Modifier, onNextClick: () -> Unit) {
    CommonButton(
        text = "Next",
        onClick = { onNextClick() },
        modifier = modifier
            .height(56.dp)
            .background(
                color = Color(0xFF007AFF),
                shape = RoundedCornerShape(16.dp)
            )
    )
}

// Barre supérieure de l'écran d'introduction avec des boutons de navigation
@Composable
fun TopBar(currentIndex: Int, onSkipClick: () -> Unit, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Affichage du bouton de retour si l'index est supérieur à zéro
        if (currentIndex > 0) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Gray
                )
            }
        }

        // Bouton "Skip" pour sauter l'introduction
        ClickableText(
            text = AnnotatedString("Skip"),
            style = TextStyle(
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            onClick = { onSkipClick() },
            modifier = Modifier
                .padding(end = 16.dp)
        )
    }
}

// Fonction de prévisualisation de l'écran d'introduction pour les tests visuels
@Preview(showBackground = true)
@Composable
fun PreviewIntroScreen() {
    val navController = rememberNavController()
    IntroScreen(navController = navController)
}
