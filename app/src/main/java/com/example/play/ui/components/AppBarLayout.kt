package com.example.play.ui.components

import androidx.compose.foundation.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.play.theme.PlayTheme
import com.example.play.utils.statusBarsPadding

@Composable
fun AppBarLayout(upPress: () -> Unit) {
  Row(
      modifier = Modifier.fillMaxWidth()
          .statusBarsPadding()
          .padding(horizontal = 16.dp, vertical = 16.dp)
          .preferredSize(24.dp)
  ) {
    BackButton(
        modifier = Modifier.weight(1f), upPress = upPress
    )
    SearchButton(Modifier)
    MoreButton(Modifier)
  }
}

@Composable
fun BackButton(
  modifier: Modifier,
  upPress: () -> Unit
) {
  PlaySurface(modifier = modifier) {
    IconButton(
        onClick = upPress
    ) {
      Icon(
          asset = Outlined.ArrowBack,
          tint = PlayTheme.colors.iconTint
      )
    }
  }
}

@Composable
fun MoreButton(modifier: Modifier) {
  IconButton(
      onClick = {},
      modifier = modifier
  ) {
    Icon(
        asset = Outlined.MoreVert,
        tint = PlayTheme.colors.iconTint
    )
  }
}

@Composable
fun SearchButton(modifier: Modifier) {
  IconButton(
      onClick = {},
      modifier = modifier
  ) {
    Icon(
        asset = Outlined.Search,
        tint = PlayTheme.colors.iconTint
    )
  }
}

@Preview("Back Button")
@Composable
private fun BackButtonPreview() {
  PlayTheme {
    PlaySurface {
      AppBarLayout(
          upPress = {}
      )
    }
  }
}

@Preview("Back Button Dark")
@Composable
private fun BackButtonDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      AppBarLayout(
          upPress = {}
      )
    }
  }
}