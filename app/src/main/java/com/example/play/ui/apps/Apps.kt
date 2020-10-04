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
import com.example.play.ui.apps.AppsCategory.Categories
import com.example.play.ui.apps.AppsCategory.EarlyAccess
import com.example.play.ui.apps.AppsCategory.EditorsChoice
import com.example.play.ui.apps.AppsCategory.ForYou
import com.example.play.ui.apps.AppsCategory.TopCharts
import com.example.play.ui.apps.applist.ForYouList
import com.example.play.ui.components.PlaySurface
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
  val categoriesData = remember { AppRepo.getCategoriesApps() }
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
          ForYou -> ForYouList(forYouData, onAppClick)
          TopCharts -> ForYouList(topChartsData, onAppClick)
          Categories -> ForYouList(categoriesData, onAppClick)
          else -> ForYouList(forYouData, onAppClick)
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

@Preview("Home")
@Composable
fun HomePreview() {
  PlayTheme {
    Apps(onAppClick = {})
  }
}

@Preview("Home • Dark Theme")
@Composable
fun HomeDarkPreview() {
  PlayTheme(darkTheme = true) {
    Apps(onAppClick = {})
  }
}