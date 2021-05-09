package com.example.play.ui.details.installbutton.animated

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.play.anim.getInstallBtnBgColorState
import com.example.play.anim.getInstallBtnBorderColorState
import com.example.play.anim.getInstallBtnBorderWidthState
import com.example.play.anim.getInstallBtnCornerState
import com.example.play.anim.getInstallButtonWidthState
import com.example.play.anim.getOpenButtonGapWidthState
import com.example.play.anim.getOpenButtonWidthState
import com.example.play.theme.PlayTheme

@Composable
fun InstallButtonPanel(
  isPressed: MutableState<Boolean>
) {
  Row(
    modifier = Modifier.padding(8.dp)
  ) {
    val openButtonWidthState = getOpenButtonWidthState(isPressed = isPressed.value)
    val installButtonWidthState = getInstallButtonWidthState(isPressed = isPressed.value)

    OpenButton(
      isPressed = isPressed,
      modifier = Modifier.size(openButtonWidthState.value, 38.dp)
    )

    InstallButton(
      isPressed = isPressed,
      modifier = Modifier
        .size(installButtonWidthState.value, 38.dp)
        .weight(1f, true)
    )
  }
}

@Composable
fun InstallButton(
  isPressed: MutableState<Boolean>,
  modifier: Modifier
) {
  val buttonBorderColorState = getInstallBtnBorderColorState(isPressed = isPressed.value)
  val buttonBorderWidthState = getInstallBtnBorderWidthState(isPressed = isPressed.value)
  val buttonBgColorState = getInstallBtnBgColorState(isPressed = isPressed.value)
  val buttonCornersState = getInstallBtnCornerState(isPressed = isPressed.value)

  Button(
    border = BorderStroke(
      buttonBorderWidthState.value,
      buttonBorderColorState.value
    ),
    colors = ButtonDefaults.buttonColors(
      backgroundColor = buttonBgColorState.value
    ),
    shape = RoundedCornerShape(buttonCornersState.value),
    modifier = modifier,
    onClick = {
      isPressed.value = isPressed.value.not()
    }
  ) {
    ButtonContent(isPressed = isPressed.value)
  }
}

@Composable
fun OpenButton(
  isPressed: MutableState<Boolean>,
  modifier: Modifier
) {
  val buttonGapWidthState = getOpenButtonGapWidthState(isPressed = isPressed.value)

  Button(
    border = BorderStroke(1.dp, PlayTheme.colors.accent),
    colors = ButtonDefaults.buttonColors(
      backgroundColor = PlayTheme.colors.uiBackground
    ),
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
  Spacer(modifier = Modifier.width(buttonGapWidthState.value))
}

