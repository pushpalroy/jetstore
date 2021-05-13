package com.example.play.ui

import androidx.annotation.FloatRange
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.play.anim.getBottomNavTintState
import com.example.play.anim.getProgressState
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlaySurface
import com.google.accompanist.insets.navigationBarsPadding
import java.util.Locale

private val TextIconSpacing = 5.dp
private val BottomNavHeight = 56.dp
private val BottomNavLabelTransformOrigin = TransformOrigin(0f, 0.5f)
private val BottomNavIndicatorShape = RoundedCornerShape(percent = 50)
private val BottomNavigationItemPadding = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)

// Bottom Navigation
@Composable
fun PlayBottomNav(
  navController: NavHostController,
  tabs: Array<BottomNavTabs>,
  onTabSelected: (String, String) -> Unit,
  color: Color = PlayTheme.colors.iconPrimary,
  contentColor: Color = PlayTheme.colors.iconInteractive
) {
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE) ?: BottomNavTabs.Games.route
  val routes = remember { BottomNavTabs.values().map { it.route } }

  PlaySurface(
    color = color,
    contentColor = contentColor
  ) {
    val springSpec = remember { getAnimSpec() }
    if (currentRoute in routes) {
      Column {
        PlayBottomNavLayout(
          selectedIndex = routes.indexOf(currentRoute),
          itemCount = tabs.size,
          indicator = { PLayBottomNavIndicator() },
          animSpec = springSpec,
          modifier = Modifier.navigationBarsPadding(left = false, right = false)
        ) {
          tabs.forEach { tab ->
            val selected = currentRoute == tab.route
            val tint by getBottomNavTintState(selected = selected)

            PlayBottomNavigationItem(
              icon = {
                Icon(
                  imageVector = tab.icon,
                  tint = tint,
                  contentDescription = null
                )
              },
              text = {
                Text(
                  text = stringResource(tab.title).toUpperCase(Locale.ROOT),
                  color = tint,
                  style = MaterialTheme.typography.button,
                  maxLines = 1
                )
              },
              selected = selected,
              onSelected = { onTabSelected(tab.route, currentRoute) },
              animSpec = springSpec,
              modifier = BottomNavigationItemPadding
                .clip(BottomNavIndicatorShape)
            )
          }
        }
      }
    }
  }
}

// Bottom Navigation Item
@Composable
fun PlayBottomNavigationItem(
  icon: @Composable BoxScope.() -> Unit,
  text: @Composable BoxScope.() -> Unit,
  selected: Boolean,
  onSelected: () -> Unit,
  animSpec: AnimationSpec<Float>,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier.selectable(selected = selected, onClick = onSelected),
    contentAlignment = Alignment.Center
  ) {
    // Animate the icon/text positions within the item based on selection
    val animationProgress by getProgressState(selected = selected, animSpec = animSpec)
    PlayBottomNavItemLayout(
      icon = icon,
      text = text,
      animationProgress = animationProgress
    )
  }
}

// Bottom Navigation Item Layout
@Composable
private fun PlayBottomNavItemLayout(
  icon: @Composable BoxScope.() -> Unit,
  text: @Composable BoxScope.() -> Unit,
  @FloatRange(from = 0.0, to = 1.0) animationProgress: Float
) {
  Layout(
    content = {
      Box(Modifier.layoutId("icon"), content = icon)
      val scale = lerp(start = 0.2f, stop = 1f, fraction = animationProgress)
      Box(
        modifier = Modifier
          .padding(start = TextIconSpacing)
          .layoutId("text")
          .graphicsLayer {
            alpha = animationProgress
            scaleX = scale
            scaleY = scale
            transformOrigin = BottomNavLabelTransformOrigin
          },
        content = text
      )
    }
  ) { measurable, constraints ->
    val iconPlaceable = measurable.first { it.layoutId == "icon" }
      .measure(constraints)
    val textPlaceable = measurable.first { it.layoutId == "text" }
      .measure(constraints)

    placeTextAndIcon(
      textPlaceable,
      iconPlaceable,
      constraints.maxWidth,
      constraints.maxHeight,
      animationProgress
    )
  }
}

// Place text and icon using Placeable
private fun MeasureScope.placeTextAndIcon(
  textPlaceable: Placeable,
  iconPlaceable: Placeable,
  width: Int,
  height: Int,
  @FloatRange(from = 0.0, to = 1.0) animationProgress: Float
): MeasureResult {
  val iconY = (height - iconPlaceable.height) / 2
  val textY = (height - textPlaceable.height) / 2

  val textWidth = textPlaceable.width * animationProgress
  val iconX = (width - textWidth - iconPlaceable.width) / 2
  val textX = iconX + iconPlaceable.width

  return layout(width, height) {
    iconPlaceable.place(iconX.toInt(), iconY)
    if (animationProgress != 0f) {
      textPlaceable.place(textX.toInt(), textY)
    }
  }
}

// Bottom Navigation Layout
@Composable
private fun PlayBottomNavLayout(
  selectedIndex: Int,
  itemCount: Int,
  animSpec: AnimationSpec<Float>,
  indicator: @Composable BoxScope.() -> Unit,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  // Track how "selected" each item is [0, 1]
  val selectionFractions = remember(itemCount) {
    List(itemCount) { i ->
      Animatable(if (i == selectedIndex) 1f else 0f)
    }
  }

  selectionFractions.forEachIndexed { index, selectionFraction ->
    val target = if (index == selectedIndex) 1f else 0f
    LaunchedEffect(target, animSpec) {
      selectionFraction.animateTo(target, animSpec)
    }
  }

  // Animate the position of the indicator
  val indicatorIndex = remember { Animatable(0f) }
  val targetIndicatorIndex = selectedIndex.toFloat()
  LaunchedEffect(targetIndicatorIndex) {
    indicatorIndex.animateTo(targetIndicatorIndex, animSpec)
  }

  Layout(
    modifier = modifier.height(BottomNavHeight),
    content = {
      content()
      Box(Modifier.layoutId("indicator"), content = indicator)
    }
  ) { measurable, constraints ->
    check(itemCount == (measurable.size - 1)) // account for indicator

    // Divide the width into n + 1 slots and give the selected item 2 slots
    val unselectedWidth = constraints.maxWidth / (itemCount + 1)
    val selectedWidth = constraints.maxWidth - (itemCount - 1) * unselectedWidth
    val indicatorMeasurable = measurable.first { it.layoutId == "indicator" }

    val itemPlaceable = measurable
      .filterNot { it == indicatorMeasurable }
      .mapIndexed { index, measurables ->
        // Animate item's width based upon the selection amount
        val width = lerp(unselectedWidth, selectedWidth, selectionFractions[index].value)
        measurables.measure(
          constraints.copy(
            minWidth = width,
            maxWidth = width
          )
        )
      }

    val indicatorPlaceable = indicatorMeasurable.measure(
      constraints.copy(
        minWidth = selectedWidth,
        maxWidth = selectedWidth
      )
    )

    layout(
      width = constraints.maxWidth,
      height = itemPlaceable.maxByOrNull { it.height }?.height ?: 0
    ) {
      val indicatorLeft = indicatorIndex.value * unselectedWidth
      indicatorPlaceable.place(x = indicatorLeft.toInt(), y = 0)
      var x = 0
      itemPlaceable.forEach { placeable ->
        placeable.place(x = x, y = 0)
        x += placeable.width
      }
    }
  }
}

// Bottom Navigation Indicator
@Composable
private fun PLayBottomNavIndicator(
  strokeWidth: Dp = 1.dp,
  color: Color = PlayTheme.colors.iconInteractive,
  shape: Shape = BottomNavIndicatorShape
) {
  Spacer(
    modifier = Modifier
      .fillMaxSize()
      .then(BottomNavigationItemPadding)
      .border(strokeWidth, color, shape)
  )
}

private fun getAnimSpec(): SpringSpec<Float> {
  return SpringSpec(
    // Determined experimentally
    stiffness = 200f,
    dampingRatio = 0.9f
  )
}