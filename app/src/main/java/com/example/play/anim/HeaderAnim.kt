package com.example.play.anim

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getAppIconSizeAnimState(showProgress: Boolean): State<Dp> {
  return animateDpAsState(
    targetValue = if (showProgress) 80.dp else 100.dp,
    animationSpec = tween(
      durationMillis = 500,
      delayMillis = 500
    )
  )
}