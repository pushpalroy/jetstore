package com.example.play.anim

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
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
        IDLE isTransitioningTo PRESSED ->
          tween(durationMillis = 1500)
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