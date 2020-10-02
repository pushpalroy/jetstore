package com.example.play.ui.components.installbutton.animated

import android.annotation.SuppressLint
import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.play.anim.AppIconState
import com.example.play.anim.ButtonState
import com.example.play.anim.ButtonState.IDLE
import com.example.play.anim.ButtonState.PRESSED
import com.example.play.anim.getInstallButtonTransitions
import com.example.play.ui.theme.PlayTheme

@SuppressLint("Range")
@Composable
fun AnimatedInstallButton(
  updateProgress: (Boolean) -> Unit,
  updateAppIconSize: (AppIconState) -> Unit
) {
  val buttonState = remember { mutableStateOf(PRESSED) }
  val transitionDefinition = getInstallButtonTransitions()

  val toState = if (buttonState.value == IDLE) {
    PRESSED
  } else {
    IDLE
  }

  val state = transition(
      definition = transitionDefinition,
      initState = buttonState.value,
      toState = toState
  )

  InstallButtonPanel(buttonState, state = state, updateProgress, updateAppIconSize)
}

@Composable
fun InstallButtonPanel(
  buttonState: MutableState<ButtonState>,
  state: TransitionState,
  updateProgress: (Boolean) -> Unit,
  updateAppIconSize: (AppIconState) -> Unit
) {
  Row(
      modifier = Modifier.padding(8.dp)
  ) {
    if (buttonState.value == IDLE) {
      OpenButton(state = state)
    }
    InstallButton(buttonState, state = state, updateProgress, updateAppIconSize)
  }
}

@Composable
fun InstallButton(
  buttonState: MutableState<ButtonState>,
  state: TransitionState,
  updateProgress: (Boolean) -> Unit,
  updateAppIconSize: (AppIconState) -> Unit
) {
  Button(
      border = BorderStroke(state[installButtonBorderWidth], state[installButtonBorderColor]),
      backgroundColor = state[installButtonBgColor],
      shape = RoundedCornerShape(state[installButtonCorners]),
      modifier = Modifier.size(state[installButtonWidth], 38.dp),
      onClick = {
        if (buttonState.value == IDLE) {
          buttonState.value = PRESSED
          updateAppIconSize(AppIconState.INSTALLING)
          updateProgress(false)
        } else {
          buttonState.value = IDLE
          updateAppIconSize(AppIconState.IDLE)
          updateProgress(true)
        }
      }
  ) {
    ButtonContent(buttonState, state)
  }
}

@Composable
fun OpenButton(state: TransitionState) {
  Button(
      border = BorderStroke(1.dp, PlayTheme.colors.accent),
      backgroundColor = PlayTheme.colors.uiBackground,
      shape = RoundedCornerShape(50),
      modifier = Modifier.size(state[openButtonWidth], 38.dp),
      onClick = {}
  ) {
    Text(
        "Open",
        softWrap = false,
        color = PlayTheme.colors.accent
    )
  }
  Spacer(modifier = Modifier.width(state[buttonsGapWidth]))
}

