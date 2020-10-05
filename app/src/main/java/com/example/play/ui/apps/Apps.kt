package com.example.play.ui.apps

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.example.play.data.AppRepo
import com.example.play.theme.PlayTheme
import com.example.play.ui.applist.ForYouLayout
import com.example.play.ui.applist.TopChartsLayout
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.main.AppsCategory
import com.example.play.ui.main.AppsCategory.Categories
import com.example.play.ui.main.AppsCategory.EarlyAccess
import com.example.play.ui.main.AppsCategory.EditorsChoice
import com.example.play.ui.main.AppsCategory.ForYou
import com.example.play.ui.main.AppsCategory.TopCharts
import com.example.play.ui.main.AppsCategoryTabs
import com.example.play.utils.navigationBarsPadding

@Composable
fun Apps(
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier,
  appsCategories: List<AppsCategory> = listOf(
      ForYou, TopCharts, Categories, EditorsChoice, EarlyAccess
  )
) {
  val forYouData = remember { AppRepo.getForYouApps() }
  val topChartsData = remember { AppRepo.getTopChartsApps() }
  val (currentCategory, setCurrentCategory) = savedInstanceState { ForYou }

  PlaySurface(modifier = modifier.fillMaxSize()) {
    Column(modifier = Modifier.navigationBarsPadding(left = true, right = true)) {
      AppsCategoryTabs(
          categories = appsCategories,
          selectedCategory = currentCategory,
          onCategorySelected = setCurrentCategory
      )
      val tweenSpec = remember {
        TweenSpec<Float>(
            durationMillis = 600,
            easing = LinearOutSlowInEasing
        )
      }
      Crossfade(currentCategory, animation = tweenSpec) { category ->
        when (category) {
          ForYou -> ForYouLayout(forYouData, onAppClick)
          TopCharts -> TopChartsLayout(topChartsData, onAppClick)
          else -> ForYouLayout(forYouData, onAppClick)
        }
      }
    }
  }
}

@Preview("Apps")
@Composable
fun AppsPreview() {
  PlayTheme {
    Apps(onAppClick = {})
  }
}

@Preview("Apps • Dark Theme")
@Composable
fun AppsDarkPreview() {
  PlayTheme(darkTheme = true) {
    Apps(onAppClick = {})
  }
}