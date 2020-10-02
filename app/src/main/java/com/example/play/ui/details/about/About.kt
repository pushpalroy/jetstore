package com.example.play.ui.details.about

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlaySurface

@Composable
fun About() {
  Column(
      modifier = Modifier.padding(top = 8.dp, start = 24.dp, end = 16.dp)
  ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(
          text = "About this app",
          style = TextStyle(
              fontWeight = FontWeight.Medium,
              fontSize = 16.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier.weight(1f)
      )
      IconButton(
          onClick = {},
          modifier = Modifier.align(Alignment.CenterVertically)
      ) {
        Icon(
            asset = Outlined.ArrowForward,
            tint = PlayTheme.colors.iconTint
        )
      }
    }
    Text(
        text = "Fun and addictive game. Start downloading and explore the new world!",
        style = MaterialTheme.typography.subtitle2,
        color = PlayTheme.colors.textSecondary
    )
  }
}

@Preview("About")
@Composable
private fun AboutPreview() {
  PlayTheme {
    PlaySurface {
      About()
    }
  }
}

@Preview("About Dark")
@Composable
private fun AboutDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      About()
    }
  }
}