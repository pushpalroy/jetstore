package com.example.play.anim

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.TransitionDefinition
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import com.example.play.anim.AppRatingBarState.END
import com.example.play.anim.AppRatingBarState.START

enum class AppRatingBarState {
  START,
  END
}

@SuppressLint("Range")
fun getAppRatingBarTransitionDefinition(ratings: Float, durationMillis: Int): TransitionDefinition<AppRatingBarState> {
  return transitionDefinition {

    // State of app icon size when not pressed
    state(START) {
      this[appRatingBar] = 0f
    }

    // State of app icon size when pressed
    state(END) {
      this[appRatingBar] = ratings
    }

    // Transition from START to END
    transition(START to END) {
      appRatingBar using tween(durationMillis = durationMillis, easing = FastOutLinearInEasing)
    }
  }
}