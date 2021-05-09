package com.example.play.anim

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode.Reverse
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.play.anim.ButtonState.IDLE
import com.example.play.anim.ButtonState.PRESSED

enum class ButtonState {
  IDLE,
  PRESSED
}

@Composable
fun getInstallButtonOpacityState(
  isPressed: Boolean
): State<Float> {
  val currentState = if (isPressed) PRESSED else IDLE
  val transition = updateTransition(targetState = currentState, label = "installButtonOpacityState")
  return transition.animateFloat(
    transitionSpec = {
      when {
        IDLE isTransitioningTo PRESSED -> tween(durationMillis = 1500)
        PRESSED isTransitioningTo IDLE -> {
          tween(durationMillis = 2000)
        }
        else -> snap()
      }
    }, label = "installButtonOpacityState"
  ) { installButtonOpacityState ->
    when (installButtonOpacityState) {
      IDLE -> 0f
      PRESSED -> 0.5f
    }
  }
}

@Composable
fun getButtonIconSizeState(): State<Float> {
  val transition = rememberInfiniteTransition()
  return transition.animateFloat(
    initialValue = 0f,
    targetValue = 24f,
    animationSpec = infiniteRepeatable(
      tween(500), Reverse
    )
  )
}

@Composable
fun getOpenButtonWidthState(isPressed: Boolean): State<Dp> {
  return animateDpAsState(
    targetValue = if (isPressed) 150.dp else 0.dp,
    animationSpec = tween(
      durationMillis = 800,
      delayMillis = if (isPressed) 0 else 1500
    )
  )
}

@Composable
fun getInstallButtonWidthState(isPressed: Boolean): State<Dp> {
  return animateDpAsState(
    targetValue = if (isPressed) 150.dp else 340.dp,
    animationSpec = tween(
      durationMillis = 1500,
      delayMillis = if (isPressed) 800 else 0
    )
  )
}

@Composable
fun getButtonColorState(isPressed: Boolean): State<Color> {
  return animateColorAsState(
    targetValue = if (isPressed) Color(0xff01875f) else Color.White,
    animationSpec = tween(
      durationMillis = 500
    )
  )
}

@Composable
fun getInstallBtnBorderColorState(isPressed: Boolean): State<Color> {
  return animateColorAsState(
    targetValue = if (isPressed) Color.White else Color(0xff01875f)
  )
}

@Composable
fun getInstallBtnBorderWidthState(isPressed: Boolean): State<Dp> {
  return animateDpAsState(
    targetValue = if (isPressed) 0.dp else 1.dp,
  )
}

@Composable
fun getInstallBtnBgColorState(isPressed: Boolean): State<Color> {
  return animateColorAsState(
    targetValue = if (isPressed) Color.White else Color(0xff01875f),
    animationSpec = tween(
      durationMillis = 3000
    )
  )
}

@Composable
fun getInstallBtnCornerState(isPressed: Boolean): State<Int> {
  return animateIntAsState(
    targetValue = if (isPressed) 50 else 10,
    animationSpec = tween(
      durationMillis = 3000,
      easing = FastOutLinearInEasing,
    )
  )
}

@Composable
fun getOpenButtonGapWidthState(isPressed: Boolean): State<Dp> {
  return animateDpAsState(
    targetValue = if (isPressed) 8.dp else 0.dp,
    animationSpec = tween(
      durationMillis = 800,
      delayMillis = if (isPressed) 800 else 1500,
      easing = LinearEasing
    )
  )
}