package com.example.play.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow.Ellipsis
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.R
import com.example.play.theme.AlphaNearOpaque
import com.example.play.theme.PlayTheme
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun ToolBar(modifier: Modifier = Modifier) {
  PlaySurface(modifier = modifier.statusBarsPadding()) {
    PlaySurface(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        elevation = 4.dp,
        color = PlayTheme.colors.uiBackground
    ) {
      TopAppBar(
          backgroundColor = PlayTheme.colors.uiBackground.copy(alpha = AlphaNearOpaque),
          contentColor = PlayTheme.colors.textSecondary
      ) {
        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterVertically)
                .weight(1f, false)
        ) {
          Icon(
              imageVector = Icons.Outlined.Menu,
              tint = PlayTheme.colors.iconTint,
              contentDescription = null
          )
        }
        Text(
            text = "Search for apps & games",
            color = PlayTheme.colors.textSecondary,
            textAlign = TextAlign.Start,
            maxLines = 1,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 16.sp
            ),
            overflow = Ellipsis,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(4f, true)
        )
        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterVertically)
                .weight(1f, false)
        ) {
          Icon(
              imageVector = Icons.Outlined.Mic,
              tint = PlayTheme.colors.iconTint,
              contentDescription = null
          )
        }
        CircularLocalImage(
            resId = R.drawable.user_profile_pic,
            modifier = Modifier
                .sizeIn(maxHeight = 45.dp, maxWidth = 45.dp)
                .align(Alignment.CenterVertically)
                .padding(end = 8.dp)
                .weight(1f, false)
                .clickable(onClick = {})
        )
      }
    }
  }
}

@Preview
@Composable
fun ToolBarPreview() {
  PlayTheme {
    ToolBar()
  }
}