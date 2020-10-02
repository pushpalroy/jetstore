package com.example.play.ui.apps

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredSizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.play.R
import com.example.play.data.models.AppCollection
import com.example.play.data.models.AppRepo
import com.example.play.ui.main.AppsCategoryTabs
import com.example.play.ui.apps.applist.AppsCollection
import com.example.play.ui.components.CircularLocalImage
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.apps.AppsCategory.Categories
import com.example.play.ui.apps.AppsCategory.EarlyAccess
import com.example.play.ui.apps.AppsCategory.EditorsChoice
import com.example.play.ui.apps.AppsCategory.ForYou
import com.example.play.ui.apps.AppsCategory.TopCharts
import com.example.play.theme.AlphaNearOpaque
import com.example.play.theme.PlayTheme
import com.example.play.utils.navigationBarsPadding
import com.example.play.utils.statusBarsPadding

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
      ToolBar()
      AppsCategoryTabs(
          categories = appsCategories,
          selectedCategory = currentCategory,
          onCategorySelected = setCurrentCategory
      )
      Crossfade(currentCategory) { category ->
        when (category) {
          ForYou -> AppList(forYouData, onAppClick)
          TopCharts -> AppList(topChartsData, onAppClick)
          Categories -> AppList(categoriesData, onAppClick)
          else -> AppList(forYouData, onAppClick)
        }
      }
    }
  }
}

@Composable
fun AppList(
  data: List<AppCollection>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  ScrollableColumn(modifier = modifier) {
    Spacer(
        modifier = Modifier
            .preferredHeight(4.dp)
    )
    //FilterBar(filters)
    data.forEach { appCollection ->
      key(appCollection.id) {
        AppsCollection(
            appCollection = appCollection,
            onAppClick = onAppClick,
        )
      }
    }
    Spacer(
        modifier = Modifier
            .navigationBarsPadding(left = false, right = false)
            .preferredHeight(8.dp)
    )
  }
}

@Composable
private fun ToolBar(modifier: Modifier = Modifier) {
  Column(modifier = modifier.statusBarsPadding()) {
    Surface(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp,
        color = PlayTheme.colors.uiBackground
    ) {
      TopAppBar(
          backgroundColor = PlayTheme.colors.uiBackground.copy(alpha = AlphaNearOpaque),
          contentColor = PlayTheme.colors.textSecondary,
          elevation = 0.dp,
          modifier = Modifier.padding(end = 8.dp)
      ) {
        IconButton(
            onClick = { /* todo */ },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
          Icon(
              asset = Icons.Outlined.Menu,
              tint = PlayTheme.colors.iconTint
          )
        }
        Text(
            text = "Search for apps & games",
            style = MaterialTheme.typography.subtitle2,
            color = PlayTheme.colors.textSecondary,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        CircularLocalImage(
            resId = R.drawable.user_profile_pic,
            modifier = Modifier
                .preferredSizeIn(maxHeight = 35.dp, maxWidth = 35.dp)
                .align(Alignment.CenterVertically)
                .clickable(onClick = {})

        )
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