package com.example.play.ui.details.installbutton.animated

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.play.anim.*
import com.example.play.anim.ButtonState.IDLE
import com.example.play.anim.ButtonState.PRESSED
import com.example.play.theme.PlayTheme

@SuppressLint("Range")
@Composable
fun AnimatedInstallButton(
  updateProgress: (Boolean) -> Unit,
  updateAppIconSize: (AppIconState) -> Unit
) {
  val installButtonState = remember { mutableStateOf(PRESSED) }
  val transitionDefinition = getInstallButtonTransitions()

  val toState = if (installButtonState.value == IDLE) {
    PRESSED
  } else {
    IDLE
  }

  val transitionState = transition(
      definition = transitionDefinition,
      initState = installButtonState.value,
      toState = toState
  )

  InstallButtonPanel(
      installButtonState,
      transitionState = transitionState,
      updateProgress,
      updateAppIconSize
  )
}

@Composable
fun InstallButtonPanel(
  installButtonState: MutableState<ButtonState>,
  transitionState: TransitionState,
  updateProgress: (Boolean) -> Unit,
  updateAppIconSize: (AppIconState) -> Unit
) {
  Row(
      modifier = Modifier.padding(8.dp)
  ) {
    OpenButton(
        transitionState = transitionState,
        modifier = Modifier.size(transitionState[openButtonWidth], 38.dp)
    )
    InstallButton(
        installButtonState = installButtonState,
        transitionState = transitionState,
        updateProgress = updateProgress,
        updateAppIconSize = updateAppIconSize,
        modifier = Modifier
            .size(transitionState[installButtonWidth], 38.dp)
            .weight(1f, true)
    )
  }
}

@Composable
fun InstallButton(
  installButtonState: MutableState<ButtonState>,
  transitionState: TransitionState,
  updateProgress: (Boolean) -> Unit,
  updateAppIconSize: (AppIconState) -> Unit,
  modifier: Modifier
) {
  Button(
      border = BorderStroke(
          transitionState[installButtonBorderWidth],
          transitionState[installButtonBorderColor]
      ),
      backgroundColor = transitionState[installButtonBgColor],
      shape = RoundedCornerShape(transitionState[installButtonCorners]),
      modifier = modifier,
      onClick = {
        if (installButtonState.value == IDLE) {
          installButtonState.value = PRESSED
          updateAppIconSize(AppIconState.INSTALLING)
          updateProgress(false)
        } else {
          installButtonState.value = IDLE
          updateAppIconSize(AppIconState.IDLE)
          updateProgress(true)
        }
      }
  ) {
    ButtonContent(installButtonState, transitionState)
  }
}

@Composable
fun OpenButton(
  transitionState: TransitionState,
  modifier: Modifier
) {
  Button(
      border = BorderStroke(1.dp, PlayTheme.colors.accent),
      backgroundColor = PlayTheme.colors.uiBackground,
      shape = RoundedCornerShape(50),
      modifier = modifier,
      onClick = {}
  ) {
    Text(
        "Open",
        softWrap = false,
        color = PlayTheme.colors.accent
    )
  }
  Spacer(modifier = Modifier.width(transitionState[buttonsGapWidth]))
}

