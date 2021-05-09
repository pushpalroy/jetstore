package com.example.play.ui

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.SpringSpec
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.play.theme.PlayTheme
import com.example.play.ui.Destination.Home
import com.example.play.ui.details.AppDetails
import com.example.play.ui.main.Main
import com.example.play.utils.Navigator
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PlayApp(backDispatcher: OnBackPressedDispatcher) {
  val navigator: Navigator<Destination> =
    rememberSaveable(
        saver = Navigator.saver(backDispatcher)
    ) {
      Navigator(Home, backDispatcher)
    }
  val actions = remember(navigator) { Actions(navigator) }
  ProvideWindowInsets {
    PlayTheme {
      val springSpec = remember {
        SpringSpec<Float>(
            stiffness = 200f,
            dampingRatio = 0.4f
        )
      }
      Crossfade(navigator.current, animationSpec = springSpec) { destination ->
        when (destination) {
          Home -> Main(actions.selectApp)
          is Destination.AppDetail -> AppDetails(
              appId = destination.appId,
              backPress = actions.upPress
          )
        }
      }
    }
  }
}