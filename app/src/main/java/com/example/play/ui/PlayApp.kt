package com.example.play.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlayScaffold
import com.example.play.ui.components.PlayToolBar
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PlayApp(finishActivity: () -> Unit) {

  /*
   * NavController is stateful and keeps track of the back stack of composables
   * that make up the screens in your app and the state of each screen.
   */
  val navController = rememberNavController()
  val (shouldShowAppBar, updateAppBarVisibility) = remember { mutableStateOf(true) }
  val navActions = remember(navController) { MainActions(navController, updateAppBarVisibility) }

  ProvideWindowInsets {
    PlayTheme {
      val tabItems = remember { BottomNavTabs.values() }
      PlayScaffold(
        topBar = { PlayToolBar(shouldShow = shouldShowAppBar) },
        bottomBar = {
          PlayBottomNav(
            navController = navController,
            tabs = tabItems,
            onTabSelected = navActions.switchAppCategory
          )
        }
      ) { innerPaddingModifier ->
        NavGraph(
          finishActivity = finishActivity,
          navController = navController,
          modifier = Modifier.padding(innerPaddingModifier),
          actions = navActions,
          shouldShowAppBar = updateAppBarVisibility
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