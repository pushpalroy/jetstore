package com.example.play.ui.components

import androidx.compose.animation.animate
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredHeightIn
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.data.AppRepo
import com.example.play.data.Filter
import com.example.play.theme.PlayTheme

@Composable
fun FilterBar(
  filters: List<Filter>,
  filterSelected: Int = AppRepo.getFilters().first().id.value,
  setFilterSelected: (Int) -> Unit = {}) {
  ScrollableRow(modifier = Modifier.preferredHeightIn(min = 56.dp)) {
    Spacer(Modifier.preferredWidth(24.dp))
    filters.forEach { filter ->
      filter.enabled.value = filterSelected == filter.id.value
      val (selected, setSelected) = remember { filter.enabled }
      FilterChip(
          filter = filter,
          modifier = Modifier.align(Alignment.CenterVertically),
          selected = selected,
          setSelected = setSelected,
          setFilterSelected = setFilterSelected
      )
      Spacer(Modifier.preferredWidth(8.dp))
    }
  }
}

@Composable
fun FilterChip(
  filter: Filter,
  modifier: Modifier = Modifier,
  shape: Shape = RoundedCornerShape(50),
  selected: Boolean = false,
  setSelected: (Boolean) -> Unit,
  setFilterSelected: (Int) -> Unit
) {

  val backgroundColor = animate(
      if (selected) PlayTheme.colors.accent.copy(alpha = 0.1f) else PlayTheme.colors.uiBackground
  )
  val textColor = animate(
      if (selected) PlayTheme.colors.accentDark else PlayTheme.colors.textSecondary
  )

  PlaySurface(
      modifier = modifier.preferredHeight(30.dp)
          .border(
              1.dp, if (selected) PlayTheme.colors.accent.copy(
              alpha = 0.1f
          ) else PlayTheme.colors.uiBorder, shape
          ),
      color = backgroundColor,
      contentColor = textColor,
      shape = shape
  ) {
    Box(
        modifier = Modifier.toggleable(
            value = selected,
            onValueChange = {
              setSelected(true)
              setFilterSelected(filter.id.value)
            }
        )
    ) {
      Text(
          text = filter.name,
          style = TextStyle(
              fontWeight = FontWeight.Normal,
              fontSize = 13.sp,
              letterSpacing = 0.15.sp
          ),
          maxLines = 1,
          modifier = Modifier.padding(
              horizontal = 20.dp,
              vertical = 6.dp
          )
      )
    }
  }
}

@Preview
@Composable
fun FilterBarPreview() {
  PlayTheme {
    FilterBar(filters = AppRepo.getFilters())
  }
}

@Preview
@Composable
fun FilterBarDarkPreview() {
  PlayTheme(darkTheme = true) {
    FilterBar(filters = AppRepo.getFilters())
  }
}