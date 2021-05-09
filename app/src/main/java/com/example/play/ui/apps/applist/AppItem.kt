package com.example.play.ui.apps.applist

import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.text.style.TextOverflow.Ellipsis
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.R.drawable
import com.example.play.data.App
import com.example.play.data.AppRepo
import com.example.play.data.apps
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.PlayCard
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.components.RoundedCornerAppImage

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
      .size(
        width = 250.dp,
        height = 230.dp
      )
      .padding(bottom = 8.dp)
  ) {
    Column(
      modifier = Modifier
        .clickable(onClick = { onAppClick(app.id) })
        .fillMaxSize()
    ) {
      RoundedCornerAppImage(
        imageUrl = app.featureImageUrl,
        modifier = Modifier
          .fillMaxWidth()
          .heightIn(max = 145.dp)
          .padding(8.dp),
        cornerPercent = 8
      )
      Row {
        Box(
          modifier = Modifier
            .height(72.dp)
            .width(72.dp)
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
          modifier = Modifier.padding(start = 8.dp, top = 8.dp)
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
          Spacer(modifier = Modifier.height(3.dp))
          Row {
            Text(
              text = app.type,
              style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
              ),
              color = PlayTheme.colors.textSecondaryDark,
              maxLines = 1,
              overflow = Ellipsis,
              modifier = Modifier.padding(end = 8.dp)
            )
            Text(
              text = ".",
              maxLines = 1,
              overflow = Ellipsis,
              style = MaterialTheme.typography.subtitle2,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
              text = app.category,
              style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
              ),
              color = PlayTheme.colors.textSecondaryDark,
              maxLines = 1,
              overflow = Ellipsis,
              modifier = Modifier.padding(start = 8.dp)
            )
          }
          Spacer(modifier = Modifier.height(3.dp))
          Row {
            Text(
              text = app.ratings,
              style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
              ),
              color = PlayTheme.colors.textSecondaryDark,
              maxLines = 1,
              overflow = Ellipsis
            )
            Icon(
              painter = painterResource(id = drawable.ic_star_solid),
              tint = PlayTheme.colors.iconTint,
              modifier = Modifier
                .padding(start = 2.dp, end = 8.dp)
                .width(8.dp)
                .height(8.dp)
                .align(Alignment.CenterVertically),
              contentDescription = null
            )
            Text(
              text = app.size,
              style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
              ),
              color = PlayTheme.colors.textSecondaryDark,
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
//  val currentState by remember { mutableStateOf(EXPLODED) }
//  val (appIconExplodeState, updateAppIconExplode) = remember { mutableStateOf(IDLE) }
//  val appIconExplodeTransitionDef = getAppIconExplodeTransitionDefinition()
//  val toState = IDLE
//  val state = transition(
//      definition = appIconExplodeTransitionDef,
//      initState = appIconExplodeState,
//      toState = toState
//  )

  PlayCard(
    elevation = 0.dp,
    shape = MaterialTheme.shapes.large,
    modifier = modifier
      .size(
        width = 120.dp,
        height = 180.dp
      )
      .padding(bottom = 8.dp)
  ) {
    Column(
      modifier = Modifier
        .clickable(onClick = {
          //updateTransition(currentState)
          onAppClick(app.id)
        })
        .fillMaxSize()
    ) {
      Box(
        modifier = Modifier
          .height(120.dp)
          .fillMaxWidth()
      ) {
        RoundedCornerAppImage(
          imageUrl = app.imageUrl,
          modifier = Modifier
            .size(120.dp)
            .align(Alignment.TopStart)
            //.padding(state[appIconExplodePadding]),
            .padding(8.dp),
          cornerPercent = 20
        )
      }
      Spacer(modifier = Modifier.height(3.dp))
      Text(
        text = app.name,
        style = TextStyle(
          fontWeight = FontWeight.Normal,
          fontSize = 12.sp,
          letterSpacing = 0.15.sp
        ),
        color = PlayTheme.colors.textPrimary,
        maxLines = 1,
        overflow = Ellipsis,
        modifier = Modifier.padding(start = 8.dp)
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = app.size,
        style = TextStyle(
          fontWeight = FontWeight.Light,
          fontSize = 12.sp,
          letterSpacing = 0.15.sp
        ),
        color = PlayTheme.colors.textSecondaryDark,
        maxLines = 1,
        overflow = Ellipsis,
        modifier = Modifier.padding(start = 8.dp)
      )
    }
  }
}

@Composable
fun TopChartAppItem(
  app: App,
  onAppClick: (Long) -> Unit,
  modifier: Modifier = Modifier
) {
  PlaySurface(
    modifier = modifier
      .fillMaxWidth()
      .clickable(onClick = { onAppClick(app.id) })
  ) {
    Row(modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)) {
      Text(
        text = app.id.toString(),
        style = TextStyle(
          fontWeight = FontWeight.Normal,
          fontSize = 14.sp
        ),
        textAlign = Center,
        color = PlayTheme.colors.textSecondary,
        modifier = Modifier
          .align(Alignment.CenterVertically)
          .width(30.dp)
          .padding(end = 8.dp)
      )
      Box(
        modifier = Modifier
          .height(65.dp)
          .width(65.dp)
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
        modifier = Modifier
          .padding(start = 8.dp)
          .align(Alignment.CenterVertically)
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
        Row {
          Text(
            text = app.type,
            style = TextStyle(
              fontWeight = FontWeight.Light,
              fontSize = 12.sp,
              letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondaryDark,
            maxLines = 1,
            overflow = Ellipsis,
            modifier = Modifier.padding(end = 8.dp)
          )
          Text(
            text = ".",
            maxLines = 1,
            overflow = Ellipsis,
            style = MaterialTheme.typography.subtitle2,
            color = PlayTheme.colors.textSecondaryDark,
            modifier = Modifier.align(Alignment.CenterVertically)
          )
          Text(
            text = app.category,
            style = TextStyle(
              fontWeight = FontWeight.Light,
              fontSize = 12.sp,
              letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondaryDark,
            maxLines = 1,
            overflow = Ellipsis,
            modifier = Modifier.padding(start = 8.dp)
          )
        }
        Row {
          Text(
            text = app.ratings,
            style = TextStyle(
              fontWeight = FontWeight.Light,
              fontSize = 12.sp,
              letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondaryDark,
            maxLines = 1,
            overflow = Ellipsis
          )
          Icon(
            painter = painterResource(id = drawable.ic_star_solid),
            tint = PlayTheme.colors.iconTint,
            modifier = Modifier
              .padding(start = 2.dp, end = 8.dp)
              .width(8.dp)
              .height(8.dp)
              .align(Alignment.CenterVertically),
            contentDescription = null
          )
          Text(
            text = app.size,
            style = TextStyle(
              fontWeight = FontWeight.Light,
              fontSize = 12.sp,
              letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondaryDark,
            maxLines = 1,
            overflow = Ellipsis
          )
        }
      }
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

@Preview("Top Chart App Item")
@Composable
fun TopChartAppItemPreview() {
  PlayTheme {
    val app = AppRepo.getApp(2L)
    TopChartAppItem(
      app = app,
      onAppClick = { }
    )
  }
}