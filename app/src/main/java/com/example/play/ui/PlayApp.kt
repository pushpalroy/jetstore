package com.example.play.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlayScaffold
import com.example.play.ui.components.ToolBar
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PlayApp(finishActivity: () -> Unit) {

  /*
   * NavController is stateful and keeps track of the back stack of composables
   * that make up the screens in your app and the state of each screen.
   */
  val navController = rememberNavController()

  ProvideWindowInsets {
    PlayTheme {
      val tabItems = remember { BottomNavTabs.values() }
      PlayScaffold(
        topBar = { ToolBar() },
        bottomBar = { PlayBottomNav(navController = navController, tabs = tabItems) }
      ) { innerPaddingModifier ->
        NavGraph(
          finishActivity = finishActivity,
          navController = navController,
          modifier = Modifier.padding(innerPaddingModifier),
        )
      }
    }
  }
}

@Preview
@Composable
private fun PlayAppPreview() {
  PlayTheme {
    PlayApp {}
  }
}