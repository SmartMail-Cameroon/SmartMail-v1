import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jaures.smartmail.R
import com.jaures.smartmail.ui.theme.LightBlueColor

// Composable pour la TopBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit,
) {
    TopAppBar(
        title = title,
        navigationIcon = navigationIcon,
        actions = {},
        modifier = Modifier.fillMaxWidth()
    )
}

// Composable principal pour l'écran de login
@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Top bar avec le bouton de retour
        TopBar(
            title = { Text("Return") },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.popBackStack() }  // Retour à l'écran précédent
                )
            }
        )

        // Contenu central
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image et autres éléments
            Image(
                painter = painterResource(id = R.drawable.image5),
                contentDescription = "Login Image",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding()
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(25.dp))

            LoginOptionsWithTopBorder(navController = navController)  // Passer le navController ici
        }
    }
}
// Composable pour afficher les options de login avec une bordure en haut
@Composable
fun LoginOptionsWithTopBorder(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp, // Bordure en haut
                color = Color.LightGray, // Couleur de la bordure
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp) // Bordure en haut uniquement avec coins arrondis
            )
            .padding(16.dp) // Padding interne
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(160.dp))

            // Boutons de login
            ButtonWithIcon(
                text = "Continue with Google",
                iconRes = R.drawable.ic_google,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            ButtonWithIcon(
                text = "Continue with Ostfalia",
                iconRes = R.drawable.ic_google,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            ButtonWithIcon(
                text = "Continue with TU-Clausthal",
                iconRes = R.drawable.ic_google,
                modifier = Modifier.padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Séparateur horizontal
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Color.Gray.copy(alpha = 0.5f))
                )
                Text(
                    text = "OR",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Color.Gray.copy(alpha = 0.5f))
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    navController.navigate("signup") // Navigue vers l'écran de signup
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
                    text = "Continue with E-Mail",
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

// Composable pour afficher un bouton avec une icône
@Composable
fun ButtonWithIcon(text: String, iconRes: Int, modifier: Modifier = Modifier) {
    Button(
        onClick = { /* Handle button click */ },
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(50)), // Bordure grise avec coins arrondis
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White // Couleur de fond blanche
        )
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Unspecified // Conserve la couleur d'origine de l'icône
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
            color = Color.Black // Texte en noir pour contraster avec le fond blanc
        )
    }
}

// Preview composable
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    // Utilisez un NavController simulé pour la Preview
    val navController = rememberNavController()

    // Passez le navController à LoginScreen dans la Preview
    LoginScreen(navController = navController)
}
