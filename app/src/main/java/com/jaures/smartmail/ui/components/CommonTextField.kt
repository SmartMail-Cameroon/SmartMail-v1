package com.jaures.smartmail.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
/**
 * Un champ de texte réutilisable et personnalisable pour la saisie utilisateur.
 *
 * @param value La valeur actuelle du champ de texte.
 * @param onValueChange Lambda appelée pour gérer les changements de texte dans le champ.
 * @param placeholder Le texte indicatif affiché lorsque le champ est vide (par défaut : chaîne vide).
 * @param modifier Le modificateur pour personnaliser la mise en page et l'apparence (par défaut : Modifier).
 * @param keyboardType Le type de clavier à afficher (par défaut : KeyboardType.Text).
 * @param isPassword Indique si le champ de texte est destiné à une saisie de mot de passe (par défaut : false).
 */
@Composable
fun CommonTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false
) {
    // État pour gérer la visibilité du mot de passe
    var isPasswordVisible by remember { mutableStateOf(false) }

    // Mise en œuvre du champ de texte avec des propriétés personnalisables
    TextField(
        value = value,
        onValueChange = onValueChange, // Gestion des changements dans le champ de texte
        placeholder = {
            Text(
                text = placeholder, // Texte indicatif affiché lorsque le champ est vide
                fontSize = 14.sp, // Taille de la police pour le placeholder
                color = Color.Gray // Couleur du placeholder
            )
        },
        modifier = modifier
            .fillMaxWidth() // Le champ occupe toute la largeur disponible
            .padding(vertical = 8.dp), // Ajout de marges verticales
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType // Configure le type de clavier à afficher
        ),
        visualTransformation = if (isPassword && !isPasswordVisible)
            PasswordVisualTransformation() // Masque le texte si c'est un mot de passe
        else
            VisualTransformation.None, // Affiche le texte tel quel
        trailingIcon = {
            // Ajoute une icône à droite pour afficher ou masquer le mot de passe
            if (isPassword) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.Visibility
                    else Icons.Default.VisibilityOff, // Icône selon l'état de visibilité
                    contentDescription = if (isPasswordVisible)
                        "Masquer le mot de passe"
                    else
                        "Afficher le mot de passe", // Description pour l'accessibilité
                    modifier = Modifier.clickable {
                        isPasswordVisible = !isPasswordVisible // Change l'état de visibilité
                    }
                )
            }
        },
        colors = TextFieldDefaults.colors(
            // Personnalisation des couleurs du champ de texte
            unfocusedContainerColor = Color.Transparent, // Couleur de fond lorsque le champ n'est pas actif
            focusedContainerColor = Color.Transparent, // Couleur de fond lorsque le champ est actif
            focusedIndicatorColor = Color.Blue, // Couleur de la ligne sous le champ lorsqu'il est actif
            unfocusedIndicatorColor = Color.Gray // Couleur de la ligne sous le champ lorsqu'il est inactif
        )
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewCommonTextField() {
    CommonTextField(
        value = "",
        onValueChange = {},
        placeholder = "Enter your email"
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPasswordTextField() {
    CommonTextField(
        value = "",
        onValueChange = {},
        placeholder = "Enter your password",
        isPassword = true
    )
}
