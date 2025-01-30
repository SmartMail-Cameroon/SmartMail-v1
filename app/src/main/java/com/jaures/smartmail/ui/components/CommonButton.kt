package com.jaures.smartmail.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jaures.smartmail.ui.theme.BlueColor
import com.jaures.smartmail.ui.theme.WhiteColor

/**
 * Un bouton réutilisable et personnalisable pour les actions utilisateur.
 *
 * @param text Le texte affiché sur le bouton.
 * @param modifier Le modificateur pour personnaliser la mise en page et l'apparence (par défaut : Modifier).
 * @param backgroundColor La couleur de fond du bouton (par défaut : `BlueColor`).
 * @param contentColor La couleur du texte sur le bouton (par défaut : `WhiteColor`).
 * @param onClick Lambda appelée lors du clic sur le bouton.
 */
@Composable
fun CommonButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = BlueColor, // Couleur par défaut du fond (bleu)
    contentColor: Color = WhiteColor, // Couleur par défaut du texte (blanc)
    onClick: () -> Unit
) {
    // Conteneur principal du bouton
    Box(
        modifier = modifier
            .fillMaxWidth() // Le bouton occupe toute la largeur disponible
            .height(56.dp) // Hauteur fixe du bouton
            .background(
                color = backgroundColor, // Applique la couleur de fond
                shape = RoundedCornerShape(28.dp) // Coins arrondis avec un rayon de 28.dp
            )
            .clickable { onClick() }, // Gère l'action à effectuer lorsqu'on clique sur le bouton
        contentAlignment = Alignment.Center // Centre le texte à l'intérieur du bouton
    ) {
        // Texte affiché sur le bouton
        Text(
            text = text, // Texte personnalisé fourni en paramètre
            color = contentColor, // Couleur du texte (blanc par défaut)
            fontSize = 16.sp, // Taille de la police
            fontWeight = FontWeight.Bold, // Applique un style gras au texte
            textAlign = TextAlign.Center // Aligne le texte au centre
        )
    }
}

@Preview
@Composable
fun PreviewCommonButton() {
    CommonButton(text = "Click Me", onClick = {})
}
