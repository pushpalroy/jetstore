package com.example.play.ui

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import com.example.play.ui.Destination.Home
import com.example.play.ui.details.AppDetails
import com.example.play.ui.main.Home
import com.example.play.theme.PlayTheme
import com.example.play.utils.Navigator
import com.example.play.utils.ProvideDisplayInsets


@Composable
fun PlayApp(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSavedInstanceState(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Home, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }
    ProvideDisplayInsets {
        PlayTheme {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    Home -> Home(actions.selectApp)
          is Destination.AppDetail -> AppDetails(
              appId = destination.appId,
              backPress = actions.upPress
          )
                }
            }
        }
    }
}