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
fun Home(onAppSelected: (Long) -> Unit) {
  val (currentSection, setCurrentSection) = savedInstanceState { NavSections.Apps }
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
          NavSections.Apps -> Apps(
              onAppClick = onAppSelected,
              modifier = modifier
          )
          NavSections.Games -> Games()
          NavSections.Movies -> Movies()
          NavSections.Books -> Books()
        }
      }
    }
  }
}

enum class NavSections(
  @StringRes val title: Int,
  val icon: Int
) {
  Apps(R.string.home_apps, R.drawable.ic_apps),
  Games(R.string.home_games, R.drawable.ic_games),
  Movies(R.string.home_movies, R.drawable.ic_movies),
  Books(R.string.home_books, R.drawable.ic_books_otlined)
}

@Preview
@Composable
private fun PlayBottomNavPreview() {
  PlayTheme {
    Home(
        onAppSelected = {}
    )
  }
}