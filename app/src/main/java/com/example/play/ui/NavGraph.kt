/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.play.ui

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.play.R
import com.example.play.ui.apps.Apps
import com.example.play.ui.books.Books
import com.example.play.ui.details.AppDetails
import com.example.play.ui.games.Games
import com.example.play.ui.movies.Movies

/**
 * Main destinations used in the ([PlayApp]).
 */
object MainDestinations {
  const val MAIN_ROUTE = "main"
  const val APP_DETAILS_ROUTE = "details"
  const val APP_ID_KEY = "appId"
}

/**
 * Bottom nav destinations used in the ([PlayApp]).
 */
object BottomNavDestinations {
  const val GAMES_ROUTE = "bottom/nav/games"
  const val APPS_ROUTE = "bottom/nav/apps"
  const val MOVIES_ROUTE = "bottom/nav/movies"
  const val BOOKS_ROUTE = "bottom/nav/books"
}

@Composable
fun NavGraph(
  modifier: Modifier = Modifier,
  finishActivity: () -> Unit = {},
  navController: NavHostController = rememberNavController(),
  startDestination: String = MainDestinations.MAIN_ROUTE
) {

  val actions = remember(navController) { MainActions(navController) }

  NavHost(
    navController = navController,
    startDestination = startDestination
  ) {

    /*
     * Add the PlayApp composable to the NavGraphBuilder
     */
    composable(MainDestinations.MAIN_ROUTE) {
      // Intercept back in Main: make it finish the activity
      BackHandler {
        finishActivity()
      }
      PlayApp { finishActivity() }
    }

    /*
     * Add the AppDetails composable to the NavGraphBuilder
     */
    composable(
      route = "${MainDestinations.APP_DETAILS_ROUTE}/{${MainDestinations.APP_ID_KEY}}",
      arguments = listOf(navArgument(MainDestinations.APP_ID_KEY) { type = NavType.LongType })
    ) { backStackEntry: NavBackStackEntry ->
      AppDetails(
        backStackEntry.arguments?.getLong(MainDestinations.APP_ID_KEY),
        upPress = { actions.upPress(backStackEntry) }
      )
    }

    /*
     * Construct a nested NavGraph with app categories
     */
    navigation(
      route = MainDestinations.MAIN_ROUTE,
      startDestination = BottomNavTabs.Games.route
    ) {
      categories(
        onAppSelected = actions.openAppDetails,
        modifier = modifier
      )
    }
  }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
  val openAppDetails = { appId: Long, from: NavBackStackEntry ->
    // In order to discard duplicated navigation events, we check the Lifecycle
    if (from.lifecycleIsResumed()) {
      navController.navigate(route = "${MainDestinations.APP_DETAILS_ROUTE}/$appId")
    }
  }
  val upPress: (rom: NavBackStackEntry) -> Unit = { from ->
    // In order to discard duplicated navigation events, we check the Lifecycle
    if (from.lifecycleIsResumed()) {
      navController.navigateUp()
    }
  }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
  this.lifecycle.currentState == Lifecycle.State.RESUMED

fun NavGraphBuilder.categories(
  onAppSelected: (Long, NavBackStackEntry) -> Unit,
  modifier: Modifier = Modifier
) {
  composable(BottomNavTabs.Games.route) { from ->
    Games(
      onAppSelected = { id -> onAppSelected(id, from) },
      modifier = modifier
    )
  }
  composable(BottomNavTabs.Apps.route) { from ->
    Apps(
      onAppSelected = { id -> onAppSelected(id, from) },
      modifier = modifier
    )
  }
  composable(BottomNavTabs.Movies.route) {
    Movies(modifier = modifier)
  }
  composable(BottomNavTabs.Books.route) {
    Books()
  }
}

enum class AppsCategory {
  ForYou,
  TopCharts,
  Categories,
  EditorsChoice,
  EarlyAccess
}

enum class MoviesCategory {
  ForYou,
  TopSelling,
  NewReleases
}

enum class BottomNavTabs(
  @StringRes val title: Int,
  val icon: ImageVector,
  val route: String
) {
  Games(R.string.home_games, Icons.Outlined.Games, BottomNavDestinations.GAMES_ROUTE),
  Apps(R.string.home_apps, Icons.Outlined.Apps, BottomNavDestinations.APPS_ROUTE),
  Movies(R.string.home_movies, Icons.Outlined.Movie, BottomNavDestinations.MOVIES_ROUTE),
  Books(R.string.home_books, Icons.Outlined.Book, BottomNavDestinations.BOOKS_ROUTE)
}