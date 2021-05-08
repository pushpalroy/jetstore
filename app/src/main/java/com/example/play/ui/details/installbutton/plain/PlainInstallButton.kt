package com.example.play.ui.details.installbutton.plain

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PlainInstallButton() {
  Button(
      onClick = {},
      shape = RoundedCornerShape(10),
      modifier = Modifier
          .fillMaxWidth()
          .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 16.dp)
  ) {
    Text("Install")
  }
}