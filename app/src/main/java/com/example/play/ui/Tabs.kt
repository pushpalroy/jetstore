package com.example.play.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.R
import com.example.play.theme.PlayTheme
import com.example.play.ui.AppsCategory.Categories
import com.example.play.ui.AppsCategory.EarlyAccess
import com.example.play.ui.AppsCategory.EditorsChoice
import com.example.play.ui.AppsCategory.ForYou
import com.example.play.ui.AppsCategory.TopCharts
import com.example.play.ui.MoviesCategory.NewReleases
import com.example.play.ui.MoviesCategory.TopSelling

@Composable
fun AppsCategoryTabs(
  categories: List<AppsCategory>,
  selectedCategory: AppsCategory,
  onCategorySelected: (AppsCategory) -> Unit
) {
  val selectedIndex = categories.indexOfFirst { it == selectedCategory }
  val indicator = @Composable { tabPositions: List<TabPosition> ->
    HomeCategoryTabIndicator(
      Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
    )
  }

  ScrollableTabRow(
    selectedTabIndex = selectedIndex,
    indicator = indicator,
    backgroundColor = PlayTheme.colors.uiBackground,
    edgePadding = 32.dp
  ) {
    categories.forEachIndexed { index, category ->
      Tab(
        selected = index == selectedIndex,
        onClick = { onCategorySelected(category) },
        modifier = Modifier.background(color = PlayTheme.colors.uiBackground),
        text = {
          Text(
            text = when (category) {
              ForYou -> stringResource(R.string.for_you)
              TopCharts -> stringResource(R.string.top_charts)
              Categories -> stringResource(R.string.categories)
              EditorsChoice -> stringResource(R.string.editors_choice)
              EarlyAccess -> stringResource(R.string.early_access)
            },
            color = if (index == selectedIndex) {
              PlayTheme.colors.accent
            } else {
              PlayTheme.colors.textPrimary
            },
            style = TextStyle(
              fontWeight = FontWeight.Normal,
              fontSize = 12.sp
            )
          )
        }
      )
    }
  }
}

@Composable
fun MoviesCategoryTabs(
  categories: List<MoviesCategory>,
  selectedCategory: MoviesCategory,
  onCategorySelected: (MoviesCategory) -> Unit
) {
  val selectedIndex = categories.indexOfFirst { it == selectedCategory }
  val indicator = @Composable { tabPositions: List<TabPosition> ->
    HomeCategoryTabIndicator(
      Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
    )
  }

  ScrollableTabRow(
    selectedTabIndex = selectedIndex,
    indicator = indicator,
    backgroundColor = PlayTheme.colors.uiBackground,
    edgePadding = 32.dp
  ) {
    categories.forEachIndexed { index, category ->
      Tab(
        selected = index == selectedIndex,
        onClick = { onCategorySelected(category) },
        modifier = Modifier.background(color = PlayTheme.colors.uiBackground),
        text = {
          Text(
            text = when (category) {
              MoviesCategory.ForYou -> stringResource(R.string.for_you)
              TopSelling -> stringResource(R.string.top_selling)
              NewReleases -> stringResource(R.string.new_releases)
            },
            color = if (index == selectedIndex) {
              PlayTheme.colors.accent
            } else {
              PlayTheme.colors.textPrimary
            },
            style = TextStyle(
              fontWeight = FontWeight.Normal,
              fontSize = 12.sp
            )
          )
        }
      )
    }
  }
}

@Composable
fun HomeCategoryTabIndicator(
  modifier: Modifier = Modifier,
  color: Color = PlayTheme.colors.accent
) {
  Spacer(
    modifier
      .width(5.dp)
      .height(3.dp)
      .background(color, RoundedCornerShape(percent = 50))
  )
}

@Preview
@Composable
fun AppCategoryTabsPreview() {
  PlayTheme {
    AppsCategoryTabs(
      categories = listOf(
        ForYou, TopCharts, Categories, EditorsChoice, EarlyAccess
      ),
      selectedCategory = ForYou,
      onCategorySelected = {}
    )
  }
}

@Preview
@Composable
fun AppCategoryTabsDarkPreview() {
  PlayTheme(darkTheme = true) {
    AppsCategoryTabs(
      categories = listOf(
        ForYou, TopCharts, Categories, EditorsChoice, EarlyAccess
      ),
      selectedCategory = ForYou,
      onCategorySelected = {}
    )
  }
}

@Preview
@Composable
fun MovieCategoryTabsPreview() {
  PlayTheme {
    MoviesCategoryTabs(
      categories = listOf(
        MoviesCategory.ForYou, TopSelling, NewReleases
      ),
      selectedCategory = MoviesCategory.ForYou,
      onCategorySelected = {}
    )
  }
}

@Preview
@Composable
fun MovieCategoryTabsDarkPreview() {
  PlayTheme(darkTheme = true) {
    MoviesCategoryTabs(
      categories = listOf(
        MoviesCategory.ForYou, TopSelling, NewReleases
      ),
      selectedCategory = MoviesCategory.ForYou,
      onCategorySelected = {}
    )
  }
}