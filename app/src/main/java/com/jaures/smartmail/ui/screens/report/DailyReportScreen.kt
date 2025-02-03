import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun DailyReportUI(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Ajout du défilement vertical
    ) {
        // DailyReportOpBar
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
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "Daily report",
                fontSize = 28.sp, // Large title size
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(2f)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // Vertical Column containing 3 blocks
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(38.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // First Block
            BlockWithEmoji(
                backgroundColor = Color(0xFF4CAF50), // Green color
                emojiResource = com.jaures.smartmail.R.drawable.important, // Replace with your actual emoji resource
                label = "Important",
                onClick = { navController.navigate("important") }
            )

            // Second Block
            BlockWithEmoji(
                backgroundColor = Color(0xFFFFEB3B), // Yellow color
                emojiResource = com.jaures.smartmail.R.drawable.undecided, // Replace with your actual emoji resource
                label = "Undecided",
                onClick = { navController.navigate("undecided") }
            )

            // Third Block
            BlockWithEmoji(
                backgroundColor = Color(0xFFF44336), // Red color
                emojiResource = com.jaures.smartmail.R.drawable.unimportant, // Replace with your actual emoji resource
                label = "Unimportant",
                onClick = { navController.navigate("unimportant") }
            )
        }
    }
}

@Composable
fun BlockWithEmoji(
    backgroundColor: Color,
    emojiResource: Int,
    label: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Hauteur relative
            .background(color = backgroundColor, shape = RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = emojiResource),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDailyReportUI() {
    val navController = rememberNavController() // Replace with your NavController
    DailyReportUI(navController = navController)
}