package com.jaures.smartmail.ui.components

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DonutChartWithLegend() {
    val data = listOf(25f, 25f, 50f) // Pourcentages
    val customColors = listOf(
        Color(0xFF90BE6D), // #90BE6D
        Color(0xFFF9C74F), // #F9C74F
        Color(0xFFF94144)  // #F94144
    )
    val labels = listOf("Important", "Undecided", "Unimportant") // Légendes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Donut Chart
        Canvas(modifier = Modifier.size(200.dp)) {
            var startAngle = -90f
            data.forEachIndexed { index, value ->
                val sweepAngle = value * 360 / 100
                drawDonutSlice(customColors[index], startAngle, sweepAngle)
                drawPercentageText(value, startAngle, sweepAngle)
                startAngle += sweepAngle
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Légendes
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            data.forEachIndexed { index, value ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape) // Cercle
                            .background(customColors[index])
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${labels[index]}: ${value.toInt()}%",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

private fun DrawScope.drawDonutSlice(color: Color, startAngle: Float, sweepAngle: Float) {
    val strokeWidth = size.minDimension / 4 // Épaisseur de l'anneau
    val outerRadius = size.minDimension / 2 // Rayon extérieur
    val innerRadius = outerRadius - strokeWidth // Rayon intérieur

    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = false, //  anneau (donut)
        topLeft = Offset((size.width - outerRadius * 2) / 2, (size.height - outerRadius * 2) / 2),
        size = Size(outerRadius * 2, outerRadius * 2),
        style = Stroke(width = strokeWidth.toFloat()) // Stroke
    )
}

private fun DrawScope.drawPercentageText(value: Float, startAngle: Float, sweepAngle: Float) {
    val outerRadius = size.minDimension / 2 // Rayon extérieur
    val centerX = size.width / 2
    val centerY = size.height / 2

    // Calcul de la position du texte
    val middleAngle = startAngle + sweepAngle / 2 // Angle au milieu de la section
    val textRadius = outerRadius * 0.8f // Distance du centre pour placer le texte
    val x = centerX + textRadius * kotlin.math.cos(Math.toRadians(middleAngle.toDouble())).toFloat()
    val y = centerY + textRadius * kotlin.math.sin(Math.toRadians(middleAngle.toDouble())).toFloat()

    // Dessin le texte
    drawIntoCanvas { canvas ->
        val paint = Paint().asFrameworkPaint().apply {
            isAntiAlias = true
            textSize = 24f
            color = android.graphics.Color.BLACK
            textAlign = android.graphics.Paint.Align.CENTER
        }
        canvas.nativeCanvas.drawText(
            "${value.toInt()}%",
            x,
            y + paint.textSize / 3, // Ajustement vertical pour centrer le texte
            paint
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewDonutChartWithLegend() {
    DonutChartWithLegend()
}