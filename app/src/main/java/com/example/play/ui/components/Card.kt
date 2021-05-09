package com.example.play.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.play.theme.PlayTheme

@Composable
fun PlayCard(
  modifier: Modifier = Modifier,
  shape: Shape = MaterialTheme.shapes.medium,
  color: Color = PlayTheme.colors.uiBackground,
  contentColor: Color = PlayTheme.colors.textPrimary,
  border: BorderStroke? = null,
  elevation: Dp = 1.dp,
  content: @Composable () -> Unit
) {
  PlaySurface(
    modifier = modifier,
    shape = shape,
    color = color,
    contentColor = contentColor,
    elevation = elevation,
    border = border,
    content = content
  )
}
