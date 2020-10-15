package com.example.play.ui.main

import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.example.play.R
import com.example.play.ui.components.PlayScaffold
import com.example.play.ui.apps.*
import com.example.play.theme.PlayTheme
import com.example.play.ui.books.Books
import com.example.play.ui.components.ToolBar
import com.example.play.ui.games.Games
import com.example.play.ui.movies.Movies

@Composable
fun Main(onAppSelected: (Long) -> Unit) {
  val (currentSection, setCurrentSection) = savedInstanceState { NavSections.Games }
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
  val icon: Int
) {
  Games(R.string.home_games, R.drawable.ic_games),
  Apps(R.string.home_apps, R.drawable.ic_apps),
  Movies(R.string.home_movies, R.drawable.ic_movies),
  Books(R.string.home_books, R.drawable.ic_books_otlined)
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