package com.example.play.ui.movies

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.main.MoviesCategory
import com.example.play.ui.main.MoviesCategory.ForYou
import com.example.play.ui.main.MoviesCategory.NewReleases
import com.example.play.ui.main.MoviesCategory.TopSelling
import com.example.play.ui.main.MoviesCategoryTabs
import com.example.play.ui.movies.movielist.MoviesForYouLayout
import com.example.play.ui.movies.movielist.TopSellingLayout
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun Movies(
  modifier: Modifier = Modifier,
  moviesCategories: List<MoviesCategory> = listOf(
      ForYou, TopSelling, NewReleases
  )
) {
  val forYouData = remember { AppRepo.getForYouMovies() }
  val topSellingData = remember { AppRepo.getTopSellingMovies() }
  val newReleasesData = remember { AppRepo.getNewReleasesMovies() }
  val (currentCategory, setCurrentCategory) = savedInstanceState { ForYou }

  PlaySurface(modifier = modifier.fillMaxSize()) {
    Column(modifier = Modifier.navigationBarsPadding(left = true, right = true)) {
      MoviesCategoryTabs(
          categories = moviesCategories,
          selectedCategory = currentCategory,
          onCategorySelected = setCurrentCategory
      )
      val tweenSpec = remember {
        TweenSpec<Float>(
            durationMillis = 600,
            easing = LinearOutSlowInEasing
        )
      }
      Crossfade(currentCategory, animationSpec = tweenSpec) { category ->
        when (category) {
          ForYou -> MoviesForYouLayout(forYouData)
          TopSelling -> TopSellingLayout(topSellingData)
          NewReleases -> TopSellingLayout(newReleasesData)
        }
      }
    }
  }
}

@Preview("Movies")
@Composable
fun MoviesPreview() {
  PlayTheme {
    Movies()
  }
}

@Preview("Movies • Dark Theme")
@Composable
fun MoviesDarkPreview() {
  PlayTheme(darkTheme = true) {
    Movies()
  }
}