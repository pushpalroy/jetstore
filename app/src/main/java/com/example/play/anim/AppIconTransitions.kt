package com.example.play.anim

import android.annotation.SuppressLint
import androidx.compose.animation.core.TransitionDefinition
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.ui.unit.dp
import com.example.play.anim.AppIconState.IDLE
import com.example.play.anim.AppIconState.INSTALLING
import com.example.play.ui.components.installbutton.animated.appIconSize

enum class AppIconState {
  IDLE,
  INSTALLING
}

@SuppressLint("Range")
fun getAppIconTransitionDefinition(): TransitionDefinition<AppIconState> {
  return transitionDefinition {

    // State of app icon size when not pressed
    state(IDLE) {
      this[appIconSize] = 100.dp
    }

    // State of app icon size when pressed
    state(INSTALLING) {
      this[appIconSize] = 80.dp
    }

    // Transition from Idle to Installing
    transition(IDLE to INSTALLING) {
      appIconSize using keyframes {
        durationMillis = 1000
        100.dp at 200
        95.dp at 400
        90.dp at 600
        85.dp at 800
        80.dp at 1000
      }
    }

    // Transition from Installing to Idle
    transition(INSTALLING to IDLE) {
      appIconSize using keyframes {
        durationMillis = 1000
        80.dp at 200
        85.dp at 400
        90.dp at 600
        95.dp at 800
        100.dp at 1000
      }
    }
  }
}