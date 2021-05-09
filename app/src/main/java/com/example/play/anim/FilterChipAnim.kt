package com.example.play.anim

import androidx.compose.animation.animateColorAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import com.example.play.theme.PlayTheme

@Composable
fun getFilterBgColorState(isSelected: Boolean): State<Color> {
  return animateColorAsState(
    if (isSelected) PlayTheme.colors.accent.copy(alpha = 0.1f)
    else PlayTheme.colors.uiBackground
  )
}

@Composable
fun getFilterTextColorState(isSelected: Boolean): State<Color> {
  return animateColorAsState(
    if (isSelected) PlayTheme.colors.accentDark
    else PlayTheme.colors.textSecondary
  )
}