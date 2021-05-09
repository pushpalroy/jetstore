package com.example.play.ui.details.installbutton.animated

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.play.theme.PlayTheme

@Composable
fun InstallButtonPanel(
  isPressed: MutableState<Boolean>
) {
  Row(
      modifier = Modifier.padding(8.dp)
  ) {
    val openButtonWidthState = animateDpAsState(
        targetValue = if (isPressed.value) 150.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 800,
            delayMillis = if (isPressed.value) 0 else 1500
        )
    )
    OpenButton(
        isPressed = isPressed,
        modifier = Modifier.size(openButtonWidthState.value, 38.dp)
    )

    val installButtonWidthState = animateDpAsState(
        targetValue = if (isPressed.value) 150.dp else 340.dp,
        animationSpec = tween(
            durationMillis = 1500,
            delayMillis = if (isPressed.value) 800 else 0
        )
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
  val buttonBorderColorState = animateColorAsState(
      targetValue = if (isPressed.value) Color.White else Color(0xff01875f)
  )
  val buttonBorderWidthState = animateDpAsState(
      targetValue = if (isPressed.value) 0.dp else 1.dp,
  )
  val buttonBgColorState = animateColorAsState(
      targetValue = if (isPressed.value) Color.White else Color(0xff01875f),
      animationSpec = tween(
          durationMillis = 3000
      )
  )
  val buttonCornersState = animateIntAsState(
      targetValue = if (isPressed.value) 50 else 10,
      animationSpec = tween(
          durationMillis = 3000,
          easing = FastOutLinearInEasing,
      )
  )
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
  val buttonGapWidthState = animateDpAsState(
      targetValue = if (isPressed.value) 8.dp else 0.dp,
      animationSpec = tween(
          durationMillis = 800,
          delayMillis = if (isPressed.value) 800 else 1500,
          easing = LinearEasing
      )
  )
  Spacer(modifier = Modifier.width(buttonGapWidthState.value))
}

