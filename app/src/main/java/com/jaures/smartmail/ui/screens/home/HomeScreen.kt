package com.jaures.smartmail.ui.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jaures.smartmail.R
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.style.TextAlign
import com.jaures.smartmail.ui.components.BottomNavigationBar
import com.jaures.smartmail.ui.components.DonutChartWithLegend
import com.jaures.smartmail.ui.data.OverViewItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val items = listOf(
        OverViewItem(1, R.drawable.cleaner, "Smart Cleaner"),
        OverViewItem(2, R.drawable.email, "E-Mails"),
        OverViewItem(3, R.drawable.analyse, "Analysen"),
        OverViewItem(4, R.drawable.file, "Report")
    )

    Scaffold(
        topBar = {
            // TopBar pour le titre
            TopAppBar(
                title = {
                    Text(
                        text = "Smart Clean E-Mails",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { padding ->
        // LazyColumn
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Graphique
            item {
                Text(
                    text = "Overview",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                OverviewGraph()
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Grid element
            item {
                val onItemClick: (OverViewItem) -> Unit = { item ->
                    // Logique de navigation ou autre action
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items.take(2).forEach { item ->
                            OverViewCardItem(
                                imageResId = item.imageResId,
                                title = item.title,
                                onClick = { onItemClick(item) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items.drop(2).forEach { item ->
                            OverViewCardItem(
                                imageResId = item.imageResId,
                                title = item.title,
                                onClick = { onItemClick(item) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OverviewGraph() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.2f), RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DonutChartWithLegend()
            Text(
                text = "50% of E-mail are important",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
  }
}

@Composable
fun OverViewCardItem(
    imageResId: Int,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Titre
        Text(
            text = title,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}