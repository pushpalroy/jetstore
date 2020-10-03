package com.example.play.anim

import android.annotation.SuppressLint
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.TransitionDefinition
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.play.anim.ButtonState.IDLE
import com.example.play.anim.ButtonState.PRESSED

enum class ButtonState {
  IDLE,
  PRESSED
}

@SuppressLint("Range")
fun getInstallButtonTransitions(): TransitionDefinition<ButtonState> {
  return transitionDefinition {

    // State of button when not pressed
    state(IDLE) {
      this[installButtonWidth] = 340.dp
      this[installButtonCorners] = 10
      this[installButtonTextColor] = Color.White
      this[installButtonBgColor] = Color(0xff01875f)
      this[installButtonBorderColor] = Color(0xff01875f)
      this[installButtonBorderWidth] = 2.dp
      this[iconOpacity] = 0f
      this[pressedIconSize] = 48.dp
      this[idleIconSize] = 24.dp
      this[openButtonWidth] = 0.dp
      this[buttonsGapWidth] = 0.dp
    }

    // State of button when pressed
    state(PRESSED) {
      this[installButtonWidth] = 150.dp
      this[installButtonCorners] = 50
      this[installButtonTextColor] = Color(0xff01875f)
      this[installButtonBorderColor] = Color(0xa3a3a3)
      this[installButtonBorderWidth] = 1.dp
      this[installButtonBgColor] = Color.White
      this[iconOpacity] = 0.5f
      this[pressedIconSize] = 48.dp
      this[idleIconSize] = 24.dp
      this[openButtonWidth] = 150.dp
      this[buttonsGapWidth] = 8.dp
    }

    // Transition from Idle to Pressed
    transition(IDLE to PRESSED) {
      installButtonWidth using tween(durationMillis = 1500)
      buttonsGapWidth using tween(durationMillis = 800, delayMillis = 1500)
      openButtonWidth using tween(durationMillis = 800, delayMillis = 1500)
      installButtonCorners using tween(durationMillis = 3000, easing = FastOutLinearInEasing)
      installButtonBgColor using tween(durationMillis = 3000)
      installButtonTextColor using tween(durationMillis = 500)
      iconOpacity using tween(durationMillis = 1500)
      idleIconSize using repeatable(
          animation = keyframes {
            durationMillis = 1500
            12.dp at 100
            16.dp at 300
            24.dp at 600
            32.dp at 900
            48.dp at 1500
          },
          iterations = AnimationConstants.Infinite
      )
    }

    // Transition from Pressed to Idle
    transition(PRESSED to IDLE) {
      installButtonWidth using tween(durationMillis = 1500, delayMillis = 800)
      buttonsGapWidth using tween(durationMillis = 800, delayMillis = 800)
      openButtonWidth using tween(durationMillis = 800)
      installButtonCorners using tween(
          durationMillis = 3000,
          easing = FastOutLinearInEasing
      )
      installButtonBgColor using tween(durationMillis = 3000)
      installButtonTextColor using tween(durationMillis = 500)
      iconOpacity using tween(durationMillis = 3000)
      idleIconSize using repeatable(
          animation = keyframes {
            durationMillis = 1700
            24.dp at 1400
            12.dp at 1500
            24.dp at 1600
            12.dp at 1700
          },
          iterations = AnimationConstants.Infinite
      )
    }
  }
}