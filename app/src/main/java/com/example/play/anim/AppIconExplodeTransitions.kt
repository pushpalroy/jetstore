package com.example.play.anim

import android.annotation.SuppressLint
import androidx.compose.animation.core.TransitionDefinition
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.transitionDefinition
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
      this[appIconExplodeSize] = 120f
    }

    // State of app icon size when pressed
    state(EXPLODED) {
      this[appIconExplodeSize] = 400f
    }

    // Transition from Idle to Installing
    transition(IDLE to EXPLODED) {
      appIconExplodeSize using keyframes {
        durationMillis = 800
        120f at 0
        80f at 120
        400f at 800
      }
    }
  }
}