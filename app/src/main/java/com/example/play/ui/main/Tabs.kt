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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.play.R
import com.example.play.ui.apps.AppsCategory
import com.example.play.ui.apps.AppsCategory.Categories
import com.example.play.ui.apps.AppsCategory.EarlyAccess
import com.example.play.ui.apps.AppsCategory.EditorsChoice
import com.example.play.ui.apps.AppsCategory.ForYou
import com.example.play.ui.apps.AppsCategory.TopCharts
import com.example.play.theme.PlayTheme
import com.example.play.theme.Typography

@Composable
fun AppsCategoryTabs(
  categories: List<AppsCategory>,
  selectedCategory: AppsCategory,
  onCategorySelected: (AppsCategory) -> Unit,
  modifier: Modifier = Modifier
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
      modifier = modifier,
      backgroundColor = PlayTheme.colors.uiBackground
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
                style = Typography.body2
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
      modifier.preferredWidth(112.dp)
          .preferredHeight(4.dp)
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