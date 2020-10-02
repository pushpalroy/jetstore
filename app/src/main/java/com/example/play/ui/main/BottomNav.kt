package com.example.play.ui.main

import androidx.annotation.FloatRange
import androidx.compose.animation.AnimatedFloatModel
import androidx.compose.animation.animate
import androidx.compose.animation.animatedFloat
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onCommit
import androidx.compose.runtime.remember
import androidx.compose.ui.Layout
import androidx.compose.ui.MeasureScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.Placeable
import androidx.compose.ui.TransformOrigin
import androidx.compose.ui.draw.clip
import androidx.compose.ui.drawLayer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.id
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.AnimationClockAmbient
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.play.ui.components.PlaySurface
import com.example.play.theme.PlayTheme
import com.example.play.utils.navigationBarsPadding
import java.util.Locale

private val TextIconSpacing = 5.dp
private val BottomNavHeight = 56.dp
private val BottomNavLabelTransformOrigin = TransformOrigin(0f, 0.5f)
private val BottomNavIndicatorShape = RoundedCornerShape(percent = 50)
private val BottomNavigationItemPadding = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)

// Bottom Navigation
@Composable
fun PlayBottomNav(
  currentSection: NavSections,
  onSectionSelected: (NavSections) -> Unit,
  items: List<NavSections>,
  color: Color = PlayTheme.colors.iconPrimary,
  contentColor: Color = PlayTheme.colors.iconInteractive
) {
  PlaySurface(
      color = color,
      contentColor = contentColor
  ) {
    val springSpec = remember {
      SpringSpec<Float>(
          // Determined experimentally
          stiffness = 800f,
          dampingRatio = 0.8f
      )
    }
    Column {
      PlayBottomNavLayout(
          selectedIndex = currentSection.ordinal,
          itemCount = items.size,
          indicator = { PLayBottomNavIndicator() },
          animSpec = springSpec,
          modifier = Modifier.navigationBarsPadding(left = false, right = false)
      ) {
        items.forEach { section ->
          val selected = section == currentSection
          val tint = animate(
              if (selected) {
                PlayTheme.colors.iconInteractive
              } else {
                PlayTheme.colors.iconInteractiveInactive
              }
          )

          PlayBottomNavigationItem(
              icon = {
                Icon(
                    asset = vectorResource(id = section.icon),
                    tint = tint
                )
              },
              text = {
                Text(
                    text = stringResource(section.title).toUpperCase(Locale.ROOT),
                    color = tint,
                    style = MaterialTheme.typography.button,
                    maxLines = 1
                )
              },
              selected = selected,
              onSelected = { onSectionSelected(section) },
              animSpec = springSpec,
              modifier = BottomNavigationItemPadding
                  .clip(BottomNavIndicatorShape)
          )
        }
      }
    }

  }
}

// Bottom Navigation Item
@Composable
fun PlayBottomNavigationItem(
  icon: @Composable () -> Unit,
  text: @Composable () -> Unit,
  selected: Boolean,
  onSelected: () -> Unit,
  animSpec: AnimationSpec<Float>,
  modifier: Modifier = Modifier
) {
  Box(
      modifier = modifier.selectable(selected = selected, onClick = onSelected),
      gravity = ContentGravity.Center
  ) {
    // Animate the icon/text positions within the item based on selection
    val animationProgress = animate(if (selected) 1f else 0f, animSpec)
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
  icon: @Composable () -> Unit,
  text: @Composable () -> Unit,
  @FloatRange(from = 0.0, to = 1.0) animationProgress: Float
) {
  Layout(
      children = {
        Box(Modifier.layoutId("icon"), children = icon)
        val scale = lerp(start = 0.6f, stop = 1f, fraction = animationProgress)
        Box(
            modifier = Modifier
                .layoutId("text")
                .drawLayer(
                    alpha = animationProgress,
                    scaleX = scale,
                    scaleY = scale,
                    transformOrigin = BottomNavLabelTransformOrigin
                ),
            paddingStart = TextIconSpacing,
            children = text
        )
      }
  ) { measurable, constraints ->
    val iconPlaceable = measurable.first { it.id == "icon" }
        .measure(constraints)
    val textPlaceable = measurable.first { it.id == "text" }
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
): MeasureScope.MeasureResult {
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
  indicator: @Composable () -> Unit,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  // Track how "selected" each item is [0, 1]
  val clock = AnimationClockAmbient.current
  val selectionFractions = remember(itemCount) {
    List(itemCount) { i ->
      AnimatedFloatModel(if (i == selectedIndex) 1f else 0f, clock)
    }
  }

  // When selection changes, animate the selection fractions
  onCommit(selectedIndex) {
    selectionFractions.forEachIndexed { index, selectionFraction ->
      val target = if (index == selectedIndex) 1f else 0f
      if (selectionFraction.targetValue != target) {
        selectionFraction.animateTo(target, animSpec)
      }
    }
  }

  // Animate the position of the indicator
  val indicatorLeft = animatedFloat(0f)
  Layout(
      modifier = modifier.preferredHeight(BottomNavHeight),
      children = {
        content()
        Box(Modifier.layoutId("indicator"), children = indicator)
      }
  ) { measurable, constraints ->
    check(itemCount == (measurable.size - 1)) // account for indicator

    // Divide the width into n + 1 slots and give the selected item 2 slots
    val unselectedWidth = constraints.maxWidth / (itemCount + 1)
    val selectedWidth = constraints.maxWidth - (itemCount - 1) * unselectedWidth
    val indicatorMeasurable = measurable.first { it.id == "indicator" }

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

    // Animate the indicator position
    val targetIndicatorLeft = selectedIndex * unselectedWidth.toFloat()
    if (indicatorLeft.targetValue != targetIndicatorLeft) {
      indicatorLeft.animateTo(targetIndicatorLeft, animSpec)
    }

    layout(
        width = constraints.maxWidth,
        height = itemPlaceable.maxByOrNull { it.height }?.height ?: 0
    ) {
      indicatorPlaceable.place(x = indicatorLeft.value.toInt(), y = 0)
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
  strokeWidth: Dp = 2.dp,
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