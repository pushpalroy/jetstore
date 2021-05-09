package com.example.play.ui.details.installbutton.animated

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.outlined.CloudDownload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.play.anim.getInstallButtonOpacityState

@Composable
fun ButtonContent(
  isPressed: Boolean
) {
  val buttonTextColorState = animateColorAsState(
      targetValue = if (isPressed) Color(0xff01875f) else Color.White,
      animationSpec = tween(
          durationMillis = 500
      )
  )

  val transition = rememberInfiniteTransition()
  val idleIconSizeState by transition.animateFloat(
      initialValue = 0f,
      targetValue = 24f,
      animationSpec = infiniteRepeatable(
          tween(500), RepeatMode.Reverse
      )
  )

  if (isPressed.not()) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Column(
          Modifier.width(24.dp),
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Icon(
            imageVector = Icons.Outlined.CloudDownload,
            tint = buttonTextColorState.value,
            modifier = Modifier.size(idleIconSizeState.dp),
            contentDescription = null
        )
      }
      Spacer(modifier = Modifier.width(16.dp))
      Text(
          "Install",
          softWrap = false,
          color = buttonTextColorState.value
      )
    }
  } else {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Column(
          Modifier.width(24.dp),
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Icon(
            imageVector = Icons.Default.CloudDownload,
            tint = buttonTextColorState.value,
            modifier = Modifier
                .size(idleIconSizeState.dp)
                .alpha(getInstallButtonOpacityState(isPressed).value),
            contentDescription = null
        )
      }
      Spacer(modifier = Modifier.width(16.dp))
      Text(
          "Cancel",
          softWrap = false,
          color = buttonTextColorState.value
      )
    }
  }
}