package com.example.play.ui.components

import androidx.compose.foundation.Icon
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.play.theme.PlayTheme
import com.example.play.utils.statusBarsPadding

@Composable
fun BackButton(upPress: () -> Unit) {
  IconButton(
      onClick = upPress,
      modifier = Modifier
          .statusBarsPadding()
          .padding(horizontal = 16.dp, vertical = 16.dp)
          .preferredSize(24.dp)
  ) {
    Icon(
        asset = Outlined.ArrowBack,
        tint = PlayTheme.colors.iconTint
    )
  }
}

@Preview("Back Button")
@Composable
private fun BackButtonPreview() {
  PlayTheme {
    PlaySurface {
      BackButton(
          upPress = {}
      )
    }
  }
}

@Preview("Back Button Dark")
@Composable
private fun BackButtonDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      BackButton(
          upPress = {}
      )
    }
  }
}