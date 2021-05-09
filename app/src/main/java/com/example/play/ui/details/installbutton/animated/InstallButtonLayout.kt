package com.example.play.ui.details.installbutton.animated

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlaySurface

@Composable
fun InstallButtonLayout(
  isInstalling: MutableState<Boolean>
) {
  PlaySurface(modifier = Modifier.padding(16.dp)) {
    InstallButtonPanel(isPressed = isInstalling)
  }
}

@Preview("Install Button Layout")
@Composable
private fun AboutPreview() {
  PlayTheme {
    PlaySurface {
      InstallButtonLayout(isInstalling = remember {
        mutableStateOf(true)
      })
    }
  }
}

@Preview("Install Button Layout Dark")
@Composable
private fun AboutDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      InstallButtonLayout(isInstalling = remember {
        mutableStateOf(false)
      })
    }
  }
}