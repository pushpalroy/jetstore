package com.example.play.ui.apps.applist

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.data.App
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.Switch

@Composable
fun TopChartsLayout(
  appCollection: List<App>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    TopChartsHeader()
    TopChartAppsList(appCollection, onAppClick)
  }
}

@Composable
private fun TopChartsHeader() {
  val (switchState, updateSwitchState) = remember { mutableStateOf(false) }
  Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
          .padding(24.dp)
  ) {
    Text(
        text = "Show installed apps",
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        color = PlayTheme.colors.textSecondary,
        modifier = Modifier.weight(1f)
    )
    Switch(
        switchState = switchState,
        updateSwitchState = updateSwitchState,
        modifier = Modifier.align(Alignment.CenterVertically)
    )
  }
}

@Composable
private fun TopChartAppsList(
  apps: List<App>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumnFor(items = apps, modifier = modifier) { app ->
    TopChartAppItem(app, onAppClick)
  }
}

@Preview("Top Charts preview")
@Composable
fun TopChartsPreview() {
  PlayTheme {
    TopChartsLayout(appCollection = AppRepo.getTopChartsApps(),
        onAppClick = {})
  }
}

@Preview("Top Charts dark preview")
@Composable
fun TopChartsDarkPreview() {
  PlayTheme(darkTheme = true) {
    TopChartsLayout(appCollection = AppRepo.getTopChartsApps(),
        onAppClick = {})
  }
}