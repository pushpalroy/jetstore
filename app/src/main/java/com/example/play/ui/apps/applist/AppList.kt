package com.example.play.ui.apps.applist

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.data.models.App
import com.example.play.data.models.AppCollection
import com.example.play.data.models.CollectionType
import com.example.play.theme.PlayTheme

@Composable
fun AppsCollection(
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
          onClick = { /* todo */ },
          modifier = Modifier.align(Alignment.CenterVertically)
      ) {
        Icon(
            asset = Icons.Outlined.ArrowForward,
            tint = PlayTheme.colors.iconTint
        )
      }
    }
    if (featured && appCollection.type == CollectionType.Featured) {
      FeaturedApps(appCollection.apps, onAppClick)
    } else {
      Apps(appCollection.apps, onAppClick)
    }
  }
}

@Composable
private fun FeaturedApps(
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
private fun Apps(
  apps: List<App>,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier.padding(start = 16.dp)
) {
  LazyRowFor(items = apps, modifier = modifier) { app ->
    AppItem(app, onAppClick)
    Spacer(modifier = Modifier.preferredWidth(1.dp))
  }
}