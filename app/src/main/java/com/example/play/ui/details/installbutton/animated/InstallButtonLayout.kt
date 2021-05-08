package com.example.play.ui.details.installbutton.animated

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.play.anim.AppIconState
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlaySurface

@Composable
fun InstallButtonLayout(
  updateProgress: (Boolean) -> Unit,
  updateAppIconSize: (AppIconState) -> Unit
) {
  PlaySurface(
      modifier = Modifier
          .padding(16.dp)
  ) {
    AnimatedInstallButton(updateProgress, updateAppIconSize)
  }
}

@Preview("Install Button Layout")
@Composable
private fun AboutPreview() {
  PlayTheme {
    PlaySurface {
      InstallButtonLayout(
          updateProgress = {},
          updateAppIconSize = {}
      )
    }
  }
}

@Preview("Install Button Layout Dark")
@Composable
private fun AboutDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      InstallButtonLayout(
          updateProgress = {},
          updateAppIconSize = {}
      )
    }
  }
}