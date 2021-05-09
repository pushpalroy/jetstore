package com.example.play.ui.apps.applist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.data.App
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.FilterBar
import com.example.play.ui.components.Switch

@Composable
fun TopChartsLayout(
  appCollection: List<App>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  val (filterSelected, setFilterSelected: (Int) -> Unit) = remember { mutableStateOf(1) }
  Column(modifier = modifier) {
    TopChartsHeader(filterSelected, setFilterSelected)
    TopChartAppsList(
        appCollection.filter { app ->
          app.filterCategory == AppRepo.getFilter(filterSelected)?.name
        },
        onAppClick
    )
  }
}

@Composable
private fun TopChartsHeader(
  filterSelected: Int,
  setFilterSelected: (Int) -> Unit
) {
  val (switchState, updateSwitchState) = remember { mutableStateOf(true) }
  Column {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 8.dp)
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
    FilterBar(filters = AppRepo.getFilters(), filterSelected, setFilterSelected)
  }
}

@Composable
private fun TopChartAppsList(
  apps: List<App>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumn(modifier = modifier) {
    items(apps) { app->
      TopChartAppItem(app, onAppClick)
    }
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