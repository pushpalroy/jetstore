package com.example.play.ui.apps.applist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.data.App
import com.example.play.data.AppCollection
import com.example.play.data.AppRepo
import com.example.play.data.CollectionType
import com.example.play.theme.PlayTheme
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun ForYouLayout(
  data: List<AppCollection>,
  onAppSelected: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  Spacer(
    modifier = Modifier
      .height(4.dp)
  )
  LazyColumn(modifier = modifier) {
    items(data) { appCollection ->
      key(appCollection.id) {
        ForYou(
          appCollection = appCollection,
          onAppSelected = onAppSelected
        )
      }
    }
  }
  Spacer(
    modifier = Modifier
      .navigationBarsPadding(left = false, right = false)
      .height(8.dp)
  )
}

@Composable
fun ForYou(
  appCollection: AppCollection,
  onAppSelected: (Long) -> Unit,
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
          imageVector = Icons.Outlined.ArrowForward,
          tint = PlayTheme.colors.iconTint,
          contentDescription = null
        )
      }
    }
    if (featured && appCollection.type == CollectionType.Featured) {
      FeaturedAppsList(appCollection.apps, onAppSelected)
    } else {
      AppsList(appCollection.apps, onAppSelected)
    }
  }
}

@Composable
private fun FeaturedAppsList(
  apps: List<App>,
  onAppSelected: (Long) -> Unit
) {
  LazyRow(modifier = Modifier.padding(start = 16.dp)) {
    items(apps) { app ->
      PlayFeaturedAppItem(app, onAppSelected = onAppSelected)
      Spacer(modifier = Modifier.width(1.dp))
    }
  }
}

@Composable
private fun AppsList(
  apps: List<App>,
  onAppSelected: (Long) -> Unit
) {
  LazyRow(modifier = Modifier.padding(start = 16.dp)) {
    items(apps) { app ->
      AppItem(app = app, onAppSelected = onAppSelected)
      Spacer(modifier = Modifier.width(1.dp))
    }
  }
}

@Preview("For You list preview")
@Composable
fun ForYouListPreview() {
  PlayTheme {
    ForYouLayout(data = AppRepo.getApps(), onAppSelected = {})
  }
}

@Preview("For You list dark preview")
@Composable
fun ForYouListDarkPreview() {
  PlayTheme(darkTheme = true) {
    ForYouLayout(data = AppRepo.getApps(), onAppSelected = {})
  }
}