package com.example.play.ui.details

import android.annotation.SuppressLint
import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScope.align
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.R.drawable
import com.example.play.anim.AppIconState
import com.example.play.anim.AppIconState.INSTALLING
import com.example.play.anim.AppRatingBarState
import com.example.play.anim.getAppIconTransitionDefinition
import com.example.play.anim.getAppRatingBarTransitionDefinition
import com.example.play.data.models.App
import com.example.play.data.models.AppRepo
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.components.RoundedCornerAppImage
import com.example.play.ui.details.installbutton.animated.AnimatedInstallButton
import com.example.play.anim.appIconSize
import com.example.play.ui.components.progressindicator.AnimatedProgressIndicator
import com.example.play.theme.PlayTheme
import com.example.play.theme.Typography
import com.example.play.utils.statusBarsPadding

@Composable
fun AppDetails(
  appId: Long,
  upPress: () -> Unit
) {
  val app = remember(appId) { AppRepo.getApp(appId) }
  val (appIconSizeState, updateAppIconSize) = remember { mutableStateOf(INSTALLING) }
  val (progressState, updateProgress) = remember { mutableStateOf(false) }

  PlaySurface(modifier = Modifier.fillMaxSize()) {
    ScrollableColumn(Modifier.fillMaxSize()) {
      BackButton(upPress)
      Header(app, progressState, appIconSizeState)
      Stats(app)
      InstallButtonLayout(updateProgress, updateAppIconSize)
      AppImages(
          imageUrlList = listOf(
              "https://images.unsplash.com/photo-1559396011-30a1da2af2b6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80",
              "https://images.unsplash.com/photo-1599442338934-f473534070d9?ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
              "https://images.unsplash.com/photo-1595787572714-496673f87f71?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjExMDk0fQ&auto=format&fit=crop&w=1234&q=80",
              "https://images.unsplash.com/photo-1559396011-30a1da2af2b6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
          )
      )
      About()
      RatingsAndReviews()
    }
  }
}

@SuppressLint("Range")
@Composable
fun Header(
  app: App,
  showProgress: Boolean,
  appIconSizeState: AppIconState
) {
  val appIconTransitionDef = getAppIconTransitionDefinition()
  val toState = if (appIconSizeState == INSTALLING) {
    AppIconState.IDLE
  } else {
    INSTALLING
  }
  val state = transition(
      definition = appIconTransitionDef,
      initState = appIconSizeState,
      toState = toState
  )

  Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)) {
    Stack(
        modifier = Modifier
            .preferredHeight(100.dp)
            .preferredWidth(100.dp)
    ) {
      if (showProgress) {
        CircularProgressIndicator(
            color = PlayTheme.colors.accent,
            strokeWidth = 2.dp,
            modifier = Modifier.preferredSize(100.dp)
        )
      }
      RoundedCornerAppImage(
          imageUrl = app.imageUrl,
          modifier = Modifier
              .preferredWidth(state[appIconSize])
              .preferredHeight(state[appIconSize])
              .align(Alignment.Center)
              .padding(8.dp),
          cornerPercent = 20
      )
    }
    Column {
      Text(
          text = app.name,
          style = TextStyle(
              fontWeight = FontWeight.SemiBold,
              fontSize = 24.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textPrimary,
          modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
      )
      Text(
          text = app.org,
          maxLines = 1,
          style = Typography.subtitle2,
          fontWeight = FontWeight.W600,
          color = PlayTheme.colors.accent,
          modifier = Modifier.padding(start = 16.dp, top = 4.dp)
      )
      Text(
          text = app.info,
          maxLines = 1,
          style = Typography.caption,
          color = PlayTheme.colors.iconTint,
          modifier = Modifier.padding(start = 16.dp)
      )
    }
  }
}

@Composable
private fun Stats(app: App) {
  Row(
      modifier = Modifier
          .padding(top = 8.dp, start = 16.dp, end = 16.dp)
          .align(Alignment.CenterHorizontally)
  ) {
    Column(modifier = Modifier.padding(end = 12.dp)) {
      Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        Text(
            text = app.ratings,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            color = PlayTheme.colors.textSecondaryDark
        )
        Icon(
            asset = vectorResource(id = drawable.ic_star_solid),
            tint = PlayTheme.colors.textSecondaryDark,
            modifier = Modifier
                .padding(end = 8.dp)
                .preferredWidth(14.dp)
                .preferredHeight(14.dp)
                .align(Alignment.CenterVertically)
        )
      }
      Text(
          text = "636K Reviews",
          maxLines = 1,
          style = MaterialTheme.typography.caption,
          color = PlayTheme.colors.textSecondary
      )
    }
    Spacer(
        modifier = Modifier
            .preferredWidth(1.dp)
            .preferredHeight(24.dp)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
            .background(color = PlayTheme.colors.uiBorder)
    )
    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
      Icon(
          asset = vectorResource(id = drawable.ic_download),
          tint = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier
              .padding(end = 8.dp)
              .preferredWidth(21.dp)
              .preferredHeight(21.dp)
              .align(Alignment.CenterHorizontally)
      )
      Text(
          text = "9.9 MB",
          maxLines = 1,
          style = MaterialTheme.typography.caption,
          color = PlayTheme.colors.textSecondary,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
    }
    Spacer(
        modifier = Modifier
            .preferredWidth(1.dp)
            .preferredHeight(24.dp)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
            .background(color = PlayTheme.colors.uiBorder)
    )
    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
      Text(
          text = "3+",
          maxLines = 1,
          style = MaterialTheme.typography.subtitle1,
          fontWeight = FontWeight.Bold,
          color = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
      Text(
          text = "Rated For 3+",
          maxLines = 1,
          style = MaterialTheme.typography.caption,
          color = PlayTheme.colors.textSecondary,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
    }
    Spacer(
        modifier = Modifier
            .preferredWidth(1.dp)
            .preferredHeight(24.dp)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
            .background(color = PlayTheme.colors.uiBorder)
    )
    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
      Text(
          text = "10M+",
          maxLines = 1,
          style = MaterialTheme.typography.subtitle1,
          fontWeight = FontWeight.Bold,
          color = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
      Text(
          text = "Downloads",
          maxLines = 1,
          style = MaterialTheme.typography.caption,
          color = PlayTheme.colors.textSecondary,
          modifier = Modifier.align(Alignment.CenterHorizontally)
      )
    }
  }
}

@Composable
private fun About() {
  Column(
      modifier = Modifier.padding(top = 8.dp, start = 24.dp, end = 16.dp)
  ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(
          text = "About this app",
          style = TextStyle(
              fontWeight = FontWeight.Medium,
              fontSize = 16.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier.weight(1f)
      )
      IconButton(
          onClick = {},
          modifier = Modifier.align(Alignment.CenterVertically)
      ) {
        Icon(
            asset = Outlined.ArrowForward,
            tint = PlayTheme.colors.iconTint
        )
      }
    }
    Text(
        text = "Fun and addictive game. Start downloading and explore the new world!",
        style = MaterialTheme.typography.subtitle2,
        color = PlayTheme.colors.textSecondary
    )
  }
}

@Composable
private fun RatingsAndReviews() {
  Column(
      modifier = Modifier.padding(top = 4.dp, start = 24.dp, end = 16.dp, bottom = 8.dp)
  ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(
          text = "Ratings and reviews",
          style = TextStyle(
              fontWeight = FontWeight.Medium,
              fontSize = 16.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textSecondaryDark,
          modifier = Modifier.weight(1f)
      )
      IconButton(
          onClick = {},
          modifier = Modifier.align(Alignment.Top)
      ) {
        Icon(
            asset = Outlined.ArrowForward,
            tint = PlayTheme.colors.iconTint
        )
      }
    }
    Row(modifier = Modifier.padding(top = 16.dp)) {
      Text(
          text = "4.7",
          style = TextStyle(
              fontWeight = FontWeight.SemiBold,
              fontSize = 50.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textPrimary,
          modifier = Modifier.align(Alignment.Top)
      )
      Column(modifier = Modifier.padding(start = 24.dp)) {
        Row {
          Text(
              text = "5",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.8f, 4000),
              color = PlayTheme.colors.accent
          )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
          Text(
              text = "4",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.5f),
              color = PlayTheme.colors.accent
          )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
          Text(
              text = "3",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.3f, 4000),
              color = PlayTheme.colors.accent
          )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
          Text(
              text = "2",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.1f),
              color = PlayTheme.colors.accent
          )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Row {
          Text(
              text = "1",
              style = Typography.caption,
              color = PlayTheme.colors.textSecondaryDark,
              modifier = Modifier.align(Alignment.CenterVertically)
          )
          AnimatedProgressIndicator(
              state = getAppRatingBarState(progress = 0.2f, 4000),
              color = PlayTheme.colors.accent
          )
        }
      }
    }
  }
}

@Composable
fun getAppRatingBarState(
  progress: Float,
  durationMillis: Int = 3000
): TransitionState {
  val appRatingTransitionDef =
    getAppRatingBarTransitionDefinition(progress, durationMillis)
  return transition(
      definition = appRatingTransitionDef,
      initState = AppRatingBarState.START,
      toState = AppRatingBarState.END
  )
}

@Composable
private fun BackButton(upPress: () -> Unit) {
  IconButton(
      onClick = upPress,
      modifier = Modifier
          .statusBarsPadding()
          .padding(horizontal = 16.dp, vertical = 10.dp)
          .preferredSize(16.dp)
  ) {
    Icon(
        asset = Outlined.ArrowBack,
        tint = PlayTheme.colors.iconTint
    )
  }
}

@Composable
private fun AppImages(
  imageUrlList: List<String>,
  onImageClick: () -> Unit = {},
  modifier: Modifier = Modifier
) {
  val scroll = rememberScrollState(0f)
  ScrollableRow(
      scrollState = scroll,
      modifier = modifier
  ) {
    Spacer(modifier = Modifier.preferredWidth(16.dp))
    imageUrlList.forEach { imageUrl ->
      AppImageItem(imageUrl, onImageClick)
      Spacer(modifier = Modifier.preferredWidth(8.dp))
    }
  }
}

@Composable
private fun InstallButtonLayout(
  updateProgress: (Boolean) -> Unit,
  updateAppIconSize: (AppIconState) -> Unit
) {
  PlaySurface(
      modifier = Modifier
          .align(Alignment.CenterHorizontally)
          .padding(16.dp)
  ) {
    AnimatedInstallButton(updateProgress, updateAppIconSize)
  }
}

@Preview("App Detail")
@Composable
private fun AppDetailPreview() {
  PlayTheme {
    AppDetails(
        appId = 1L,
        upPress = { }
    )
  }
}

@Preview("App Detail Dark")
@Composable
private fun AppDetailDarkPreview() {
  PlayTheme(darkTheme = true) {
    AppDetails(
        appId = 1L,
        upPress = { }
    )
  }
}