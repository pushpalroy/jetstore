package com.example.play.ui

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.play.theme.PlayTheme
import com.example.play.ui.details.AppDetails
import com.example.play.ui.main.Main
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PlayApp() {

  /*
   * NavController is stateful and keeps track of the back stack of composables
   * that make up the screens in your app and the state of each screen.
   */
  val navController = rememberNavController()

  ProvideWindowInsets {
    PlayTheme {
      /*
       * The NavHost links the NavController with a navigation graph that specifies the composable destinations
       * that you should be able to navigate between. As you navigate between composables, the content of the NavHost
       * is automatically recomposed. Each composable destination in your navigation graph is associated with a route.
       */
      NavHost(
        navController = navController,
        startDestination = "main"
      ) {
        composable("main") {
          Main(navController = navController)
        }
        composable(
          "details/{appId}",
          arguments = listOf(navArgument("appId") { type = NavType.LongType })
        ) { backStackEntry ->
          AppDetails(
            backStackEntry.arguments?.getLong("appId"),
            navController = navController
          )
        }
      }
    }
  }
}