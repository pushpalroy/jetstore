package com.example.play.ui.main

import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Games
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.play.R
import com.example.play.theme.PlayTheme
import com.example.play.ui.apps.Apps
import com.example.play.ui.books.Books
import com.example.play.ui.components.PlayScaffold
import com.example.play.ui.components.ToolBar
import com.example.play.ui.games.Games
import com.example.play.ui.movies.Movies

@Composable
fun Main(onAppSelected: (Long) -> Unit) {
  val (currentSection, setCurrentSection) = rememberSaveable {
    mutableStateOf(NavSections.Games)
  }
  val navItems = NavSections.values()
    .toList()
  PlayScaffold(
    bottomBar = {
      PlayBottomNav(
        currentSection = currentSection,
        onSectionSelected = setCurrentSection,
        items = navItems
      )
    }
  ) { innerPadding ->
    val modifier = Modifier.padding(innerPadding)
    Column {
      ToolBar()
      Crossfade(currentSection) { section ->
        when (section) {
          NavSections.Games -> Games(
            onAppClick = onAppSelected,
            modifier = modifier
          )
          NavSections.Apps -> Apps(
            onAppClick = onAppSelected,
            modifier = modifier
          )
          NavSections.Movies -> Movies(
            modifier = modifier
          )
          NavSections.Books -> Books()
        }
      }
    }
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

enum class NavSections(
  @StringRes val title: Int,
  val icon: ImageVector
) {
  Games(R.string.home_games, Icons.Outlined.Games),
  Apps(R.string.home_apps, Icons.Outlined.Apps),
  Movies(R.string.home_movies, Icons.Outlined.Movie),
  Books(R.string.home_books, Icons.Outlined.Book)
}

@Preview
@Composable
private fun PlayBottomNavPreview() {
  PlayTheme {
    Main(
      onAppSelected = {}
    )
  }
}