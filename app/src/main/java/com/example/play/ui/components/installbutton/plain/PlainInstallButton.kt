package com.example.play.ui.components.installbutton.plain

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.play.ui.theme.PlayTheme

@Composable
fun PlainInstallButton() {
  Button(
      onClick = {},
      backgroundColor = PlayTheme.colors.accent,
      shape = RoundedCornerShape(10),
      contentColor = PlayTheme.colors.uiBackground,
      modifier = Modifier
          .fillMaxWidth()
          .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 16.dp)
  ) {
    Text("Install")
  }
}