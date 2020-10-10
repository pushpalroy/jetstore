package com.example.play.anim

import android.annotation.SuppressLint
import androidx.compose.animation.core.TransitionDefinition
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.ui.unit.dp
import com.example.play.anim.AppIconExplodeState.EXPLODED
import com.example.play.anim.AppIconExplodeState.IDLE

enum class AppIconExplodeState {
  IDLE,
  EXPLODED
}

@SuppressLint("Range")
fun getAppIconExplodeTransitionDefinition(): TransitionDefinition<AppIconExplodeState> {
  return transitionDefinition {

    // State of app icon size when not pressed
    state(IDLE) {
      this[appIconExplodePadding] = 8.dp
    }

    // State of app icon size when pressed
    state(EXPLODED) {
      this[appIconExplodePadding] = 0.dp
    }

    // Transition from Idle to Installing
    transition(IDLE to EXPLODED) {
      appIconExplodePadding using keyframes {
        durationMillis = 1000
        8.dp at 0
        7.dp at 100
        6.dp at 200
        5.dp at 300
        4.dp at 400
        3.dp at 500
        2.dp at 600
        1.dp at 700
        0.dp at 1000
      }
    }
  }
}