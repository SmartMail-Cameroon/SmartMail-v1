import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jaures.smartmail.R
import com.jaures.smartmail.ui.theme.LightBlueColor

// Composable pour la TopBar dans le SignUpScreen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit,
) {
    // Crée une barre d'application avec un titre et un bouton de navigation
    TopAppBar(
        title = title, // Titre de la TopBar
        navigationIcon = navigationIcon, // Icône de navigation (par exemple, bouton retour)
        actions = {}, // Actions supplémentaires (aucune dans ce cas)
        modifier = Modifier.fillMaxWidth() // Remplir toute la largeur disponible
    )
}

// Composable principal pour l'écran d'inscription
@Composable
fun SignUpScreen(navController: NavHostController) {
    // Variables d'état pour les champs du formulaire
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }

    // Column principale pour structurer l'écran d'inscription
    Column(modifier = Modifier.fillMaxSize()) {

        // Top bar avec le bouton de retour
        SignUpTopBar(
            title = { Text("Sign Up") },
            navigationIcon = {
                // Icône de retour pour revenir à l'écran précédent
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.popBackStack() }  // Action de retour
                )
            }
        )

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image d'illustration (peut être remplacée par une autre image)
            Image(
                painter = painterResource(id = R.drawable.image5), // Remplacez par votre image
                contentDescription = "Sign Up Image",
                modifier = Modifier
                    .height(180.dp) // Hauteur de l'image
                    .fillMaxWidth() // Remplir toute la largeur
                    .padding() // Espacement autour de l'image
                    .clip(RoundedCornerShape(16.dp)) // Bord arrondi
                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp)) // Bordure de l'image
            )
            Spacer(modifier = Modifier.height(25.dp))

            // Titre du formulaire "Create Your Account"
            Text(
                text = "Create Your Account",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 24.dp) // Espacement autour du titre
                    .fillMaxWidth(), // Prend toute la largeur
                textAlign = TextAlign.Center // Centrer le texte
            )

            // Formulaire d'inscription avec les champs et bouton
            TextFieldWithLabel(
                label = "First Name", // Nom
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            TextFieldWithLabel(
                label = "Last Name", // Prénom
                value = surname,
                onValueChange = { surname = it },
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            TextFieldWithLabel(
                label = "Email Address", // Email
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            PasswordTextField(
                label = "Password", // Mot de passe
                password = password,
                onValueChange = { password = it },
                isPasswordVisible = isPasswordVisible,
                onPasswordVisibilityChanged = { isPasswordVisible = it },
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            PasswordTextField(
                label = "Repeat Password", // Répéter le mot de passe
                password = confirmPassword,
                onValueChange = { confirmPassword = it },
                isPasswordVisible = isPasswordVisible,
                onPasswordVisibilityChanged = { isPasswordVisible = it },
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Case à cocher pour accepter les termes
            Row(
                modifier = Modifier.padding(start = 24.dp),
                verticalAlignment = Alignment.CenterVertically, // Centrer verticalement la case à cocher et le texte
                horizontalArrangement = Arrangement.Start // Alignement à gauche
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
                Text(
                    text = "I agree with the terms and conditions by creating an account",
                    style = TextStyle(fontSize = 12.sp),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Bouton d'inscription
            Button(
                onClick = {
                    navController.navigate("home") // Navigue vers l'écran de signup
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .border(2.dp, LightBlueColor, RoundedCornerShape(50)),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = LightBlueColor
                )
            ) {
                Text(
                    text = "Sign Up",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBlueColor
                    )
                )
            }
        }
    }
}

// Composable pour les TextField avec une étiquette
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithLabel(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // TextField avec une étiquette, une bordure arrondie et une couleur spécifique
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier,
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = LightBlueColor,
            unfocusedBorderColor = Color.Gray
        )
    )
}

// Composable pour les champs de mot de passe avec visibilité
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    label: String,
    password: String,
    onValueChange: (String) -> Unit,
    isPasswordVisible: Boolean,
    onPasswordVisibilityChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // TextField pour les mots de passe avec option de visibilité
    OutlinedTextField(
        value = password,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier,
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { onPasswordVisibilityChanged(!isPasswordVisible) }) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = null
                )
            }
        },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            focusedBorderColor = LightBlueColor,
            unfocusedBorderColor = Color.Gray
        )
    )
}

// Preview composable
@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    // Utilisez un NavController simulé pour la Preview
    val navController = rememberNavController()

    // Passez le navController à SignUpScreen dans la Preview
    SignUpScreen(navController = navController)
}
