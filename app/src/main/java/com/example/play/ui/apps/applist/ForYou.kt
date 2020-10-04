package com.example.play.ui.apps.applist

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.data.App
import com.example.play.data.AppCollection
import com.example.play.data.AppRepo
import com.example.play.data.CollectionType
import com.example.play.theme.PlayTheme
import com.example.play.utils.navigationBarsPadding

@Composable
fun ForYouLayout(
  data: List<AppCollection>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  Spacer(
      modifier = Modifier
          .preferredHeight(4.dp)
  )
  LazyColumnFor(items = data, modifier = modifier) { appCollection ->
    key(appCollection.id) {
      ForYou(
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

@Composable
fun ForYou(
  appCollection: AppCollection,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier,
  featured: Boolean = true
) {
  Column(modifier = modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 24.dp)
    ) {
      Text(
          text = appCollection.name,
          style = TextStyle(
              fontWeight = FontWeight.Medium,
              fontSize = 16.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textPrimary,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.weight(1f)
      )
      IconButton(
          onClick = {},
          modifier = Modifier.align(Alignment.CenterVertically)
      ) {
        Icon(
            asset = Icons.Outlined.ArrowForward,
            tint = PlayTheme.colors.iconTint
        )
      }
    }
    if (featured && appCollection.type == CollectionType.Featured) {
      FeaturedAppsList(appCollection.apps, onAppClick)
    } else {
      AppsList(appCollection.apps, onAppClick)
    }
  }
}

@Composable
private fun FeaturedAppsList(
  apps: List<App>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier.padding(start = 16.dp)
) {
  LazyRowFor(items = apps, modifier = modifier) { app ->
    PlayFeaturedAppItem(app, onAppClick)
    Spacer(modifier = Modifier.preferredWidth(1.dp))
  }
}

@Composable
private fun AppsList(
  apps: List<App>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier.padding(start = 16.dp)
) {
  LazyRowFor(items = apps, modifier = modifier) { app ->
    AppItem(app, onAppClick)
    Spacer(modifier = Modifier.preferredWidth(1.dp))
  }
}

@Preview("For You list preview")
@Composable
fun ForYouListPreview() {
  PlayTheme {
    ForYouLayout(data = AppRepo.getApps(), onAppClick = {})
  }
}

@Preview("For You list dark preview")
@Composable
fun ForYouListDarkPreview() {
  PlayTheme(darkTheme = true) {
    ForYouLayout(data = AppRepo.getApps(), onAppClick = {})
  }
}