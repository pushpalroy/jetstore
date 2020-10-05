package com.example.play.ui.main

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.material.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.R
import com.example.play.theme.PlayTheme
import com.example.play.ui.main.AppsCategory.Categories
import com.example.play.ui.main.AppsCategory.EarlyAccess
import com.example.play.ui.main.AppsCategory.EditorsChoice
import com.example.play.ui.main.AppsCategory.ForYou
import com.example.play.ui.main.AppsCategory.TopCharts

@Composable
fun AppsCategoryTabs(
  categories: List<AppsCategory>,
  selectedCategory: AppsCategory,
  onCategorySelected: (AppsCategory) -> Unit
) {
  val selectedIndex = categories.indexOfFirst { it == selectedCategory }
  val indicator = @Composable { tabPositions: List<TabPosition> ->
    HomeCategoryTabIndicator(
        Modifier.defaultTabIndicatorOffset(tabPositions[selectedIndex])
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
fun HomeCategoryTabIndicator(
  modifier: Modifier = Modifier,
  color: Color = PlayTheme.colors.accent
) {
  Spacer(
      modifier.preferredWidth(5.dp)
          .preferredHeight(3.dp)
          .background(color, RoundedCornerShape(topLeftPercent = 100, topRightPercent = 100))
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