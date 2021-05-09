package com.example.play.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.data.AppRepo
import com.example.play.data.Filter
import com.example.play.theme.PlayTheme

@Composable
fun FilterBar(
  filters: List<Filter>,
  filterSelected: Int = AppRepo.getFilters().first().id.value,
  setFilterSelected: (Int) -> Unit = {}) {
  LazyRow(modifier = Modifier.heightIn(min = 56.dp)) {
    item {
      Spacer(modifier = Modifier.width(24.dp))
      filters.forEach { filter ->
        filter.enabled.value = filterSelected == filter.id.value
        val (selected, setSelected) = remember { filter.enabled }
        FilterChip(
          filter = filter,
          selected = selected,
          setSelected = setSelected,
          setFilterSelected = setFilterSelected
        )
        Spacer(modifier = Modifier.width(8.dp))
      }
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

  val backgroundColor by animateColorAsState(
      if (selected) PlayTheme.colors.accent.copy(alpha = 0.1f) else PlayTheme.colors.uiBackground
  )
  val textColor by  animateColorAsState(
      if (selected) PlayTheme.colors.accentDark else PlayTheme.colors.textSecondary
  )

  PlaySurface(
      modifier = modifier.height(30.dp)
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