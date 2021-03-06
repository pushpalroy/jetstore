package com.example.play.ui.apps

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
import com.example.play.ui.AppsCategory
import com.example.play.ui.AppsCategory.Categories
import com.example.play.ui.AppsCategory.EarlyAccess
import com.example.play.ui.AppsCategory.EditorsChoice
import com.example.play.ui.AppsCategory.ForYou
import com.example.play.ui.AppsCategory.TopCharts
import com.example.play.ui.apps.applist.ForYouLayout
import com.example.play.ui.apps.applist.TopChartsLayout
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.AppsCategoryTabs
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun Apps(
  onAppSelected: (Long) -> Unit,
  modifier: Modifier = Modifier,
  appsCategories: List<AppsCategory> = getAppCategoriesList()
) {
  val forYouData = remember { AppRepo.getForYouApps() }
  val topChartsData = remember { AppRepo.getTopChartsApps() }
  val (currentCategory, setCurrentCategory) = rememberSaveable { mutableStateOf(ForYou) }

  PlaySurface(modifier = modifier.fillMaxSize()) {
    Column(modifier = Modifier.navigationBarsPadding(left = true, right = true)) {
      AppsCategoryTabs(
        categories = appsCategories,
        selectedCategory = currentCategory,
        onCategorySelected = setCurrentCategory
      )
      val tweenSpec = remember { getAnimSpec() }
      Crossfade(currentCategory, animationSpec = tweenSpec) { category ->
        when (category) {
          ForYou -> ForYouLayout(forYouData, onAppSelected = onAppSelected)
          TopCharts -> TopChartsLayout(topChartsData, onAppSelected = onAppSelected)
          else -> ForYouLayout(forYouData, onAppSelected = onAppSelected)
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

private fun getAppCategoriesList() = listOf(
  ForYou, TopCharts, Categories, EditorsChoice, EarlyAccess
)

@Preview("Apps")
@Composable
fun AppsPreview() {
  PlayTheme {
    Apps(
      onAppSelected = {}
    )
  }
}

@Preview("Apps • Dark Theme")
@Composable
fun AppsDarkPreview() {
  PlayTheme(darkTheme = true) {
    Apps(
      onAppSelected = {}
    )
  }
}