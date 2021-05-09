package com.example.play.anim

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

enum class AppRatingBarState {
  START,
  END
}

@Composable
fun getAppRatingBarState(
  progress: Float,
  durationMillis: Int = 3000,
  showProgress: Boolean
): State<Float> {
  val currentState = if (showProgress) AppRatingBarState.END else AppRatingBarState.START
  val transition = updateTransition(targetState = currentState, label = "appRatingBarState")
  return transition.animateFloat(
    transitionSpec = {
      when {
        AppRatingBarState.START isTransitioningTo AppRatingBarState.END ->
          tween(
            easing = FastOutSlowInEasing,
            durationMillis = durationMillis
          )
        AppRatingBarState.END isTransitioningTo AppRatingBarState.START -> {
          tween(
            easing = FastOutSlowInEasing,
            durationMillis = durationMillis
          )
        }
        else -> snap()
      }
    }, label = "appRatingBarState"
  ) { appRatingBarState ->
    when (appRatingBarState) {
      AppRatingBarState.START -> 0f
      AppRatingBarState.END -> progress
    }
  }
}