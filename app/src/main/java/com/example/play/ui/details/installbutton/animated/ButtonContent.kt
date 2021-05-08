package com.example.play.ui.details.installbutton.animated

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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.play.anim.ButtonState
import com.example.play.anim.ButtonState.PRESSED
import com.example.play.anim.iconOpacity
import com.example.play.anim.idleIconSize
import com.example.play.anim.installButtonTextColor

@Composable
fun ButtonContent(
  buttonState: MutableState<ButtonState>,
  state: TransitionState
) {
  if (buttonState.value == PRESSED) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Column(
          Modifier.width(24.dp),
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Icon(
            imageVector = Icons.Outlined.CloudDownload,
            tint = state[installButtonTextColor],
            modifier = Modifier.size(state[idleIconSize]),
            contentDescription = null
        )
      }
      Spacer(modifier = Modifier.width(16.dp))
      Text(
          "Install",
          softWrap = false,
          color = state[installButtonTextColor]
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
            tint = state[installButtonTextColor],
            modifier = Modifier.size(state[idleIconSize])
                .drawOpacity(state[iconOpacity]),
            contentDescription = null
        )
      }
      Spacer(modifier = Modifier.width(16.dp))
      Text(
          "Cancel",
          softWrap = false,
          color = state[installButtonTextColor]
      )
    }
  }
}