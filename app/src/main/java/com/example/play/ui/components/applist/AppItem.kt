package com.example.play.ui.components.applist

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.weight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextOverflow.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.R.drawable
import com.example.play.data.models.App
import com.example.play.data.models.apps
import com.example.play.ui.components.PlayCard
import com.example.play.ui.components.RoundedCornerAppImage
import com.example.play.ui.theme.PlayTheme

@Composable
fun PlayFeaturedAppItem(
  app: App,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  PlayCard(
      shape = RectangleShape,
      elevation = 0.dp,
      modifier = modifier
          .preferredSize(
              width = 280.dp,
              height = 250.dp
          )
          .padding(bottom = 8.dp)
  ) {
    Column(
        modifier = Modifier
            .clickable(onClick = { onAppClick(app.id) })
            .fillMaxSize()
    ) {
      RoundedCornerAppImage(
          imageUrl = app.imageUrl,
          modifier = Modifier
              .fillMaxWidth()
              .preferredHeightIn(max = 155.dp)
              .padding(8.dp),
          cornerPercent = 10
      )
      Row {
        Stack(
            modifier = Modifier
                .preferredHeight(80.dp)
                .preferredWidth(80.dp)
        ) {
          RoundedCornerAppImage(
              imageUrl = app.imageUrl,
              modifier = Modifier
                  .fillMaxWidth()
                  .align(Alignment.TopStart)
                  .padding(8.dp),
              cornerPercent = 20
          )
        }
        Column(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        ) {
          Text(
              text = app.name,
              style = TextStyle(
                  fontWeight = FontWeight.Normal,
                  fontSize = 14.sp,
                  letterSpacing = 0.15.sp
              ),
              color = PlayTheme.colors.textPrimary,
              maxLines = 1,
              overflow = Ellipsis
          )
          Spacer(modifier = Modifier.preferredHeight(3.dp))
          Row {
            Text(
                text = app.type,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    letterSpacing = 0.15.sp
                ),
                color = PlayTheme.colors.textSecondary,
                maxLines = 1,
                overflow = Ellipsis,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = ".",
                maxLines = 1,
                overflow = Ellipsis,
                style = MaterialTheme.typography.subtitle2,
                color = PlayTheme.colors.textSecondary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = app.category,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    letterSpacing = 0.15.sp
                ),
                color = PlayTheme.colors.textSecondary,
                maxLines = 1,
                overflow = Ellipsis,
                modifier = Modifier.padding(start = 8.dp)
            )
          }
          Spacer(modifier = Modifier.preferredHeight(3.dp))
          Row {
            Text(
                text = app.ratings,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    letterSpacing = 0.15.sp
                ),
                color = PlayTheme.colors.textSecondary,
                maxLines = 1,
                overflow = Ellipsis
            )
            Icon(
                asset = vectorResource(id = drawable.ic_star_solid),
                tint = PlayTheme.colors.iconTint,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .preferredWidth(10.dp)
                    .preferredHeight(10.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = app.size,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    letterSpacing = 0.15.sp
                ),
                color = PlayTheme.colors.textSecondary,
                maxLines = 1,
                overflow = Ellipsis
            )
          }
        }
      }
    }
  }
}

@Composable
fun AppItem(
  app: App,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  PlayCard(
      elevation = 0.dp,
      shape = MaterialTheme.shapes.large,
      modifier = modifier
          .preferredSize(
              width = 120.dp,
              height = 180.dp
          )
          .padding(bottom = 8.dp)
  ) {
    Column(
        modifier = Modifier
            .clickable(onClick = { onAppClick(app.id) })
            .fillMaxSize()
    ) {
      Stack(
          modifier = Modifier
              .preferredHeight(120.dp)
              .fillMaxWidth()
      ) {
        RoundedCornerAppImage(
            imageUrl = app.imageUrl,
            modifier = Modifier
                .preferredSize(120.dp)
                .align(Alignment.TopStart)
                .padding(8.dp),
            cornerPercent = 20
        )
      }
      Spacer(modifier = Modifier.preferredHeight(3.dp))
      Text(
          text = app.name,
          style = TextStyle(
              fontWeight = FontWeight.Normal,
              fontSize = 12.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textSecondary,
          maxLines = 1,
          overflow = Ellipsis,
          modifier = Modifier.padding(start = 8.dp)
      )
      Spacer(modifier = Modifier.preferredHeight(4.dp))
      Text(
          text = app.size,
          style = TextStyle(
              fontWeight = FontWeight.Normal,
              fontSize = 12.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textSecondary,
          maxLines = 1,
          overflow = Ellipsis,
          modifier = Modifier.padding(start = 8.dp)
      )
    }
  }
}

@Preview("Featured App Item")
@Composable
fun PlayFeaturedAppItemPreview() {
  PlayTheme {
    val app = apps.first()
    PlayFeaturedAppItem(
        app = app,
        onAppClick = { }
    )
  }
}

@Preview("App Item")
@Composable
fun PlayAppItemPreview() {
  PlayTheme {
    val app = apps.first()
    AppItem(
        app = app,
        onAppClick = { }
    )
  }
}