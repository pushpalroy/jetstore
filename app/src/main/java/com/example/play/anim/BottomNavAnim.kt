package com.example.play.anim

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import com.example.play.theme.PlayTheme

@Composable
fun getBottomNavTintState(selected: Boolean): State<Color> {
  return animateColorAsState(
    if (selected) {
      PlayTheme.colors.iconInteractive
    } else {
      PlayTheme.colors.iconInteractiveInactive
    }
  )
}

@Composable
fun getProgressState(
  selected: Boolean,
  animSpec: AnimationSpec<Float>
): State<Float> {
  return animateFloatAsState(if (selected) 1f else 0f, animSpec)
}