package com.example.play.ui.movies

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.MoviesCategory
import com.example.play.ui.MoviesCategory.ForYou
import com.example.play.ui.MoviesCategory.NewReleases
import com.example.play.ui.MoviesCategory.TopSelling
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.MoviesCategoryTabs
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

  val (currentCategory, setCurrentCategory) = rememberSaveable {
    mutableStateOf(ForYou)
  }

  PlaySurface(modifier = modifier.fillMaxSize()) {
    Column(modifier = Modifier.navigationBarsPadding(left = true, right = true)) {
      MoviesCategoryTabs(
        categories = moviesCategories,
        selectedCategory = currentCategory,
        onCategorySelected = setCurrentCategory
      )
      val tweenSpec = remember { getAnimSpec() }
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

private fun getAnimSpec(): TweenSpec<Float> {
  return TweenSpec(
    durationMillis = 600,
    easing = LinearOutSlowInEasing
  )
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