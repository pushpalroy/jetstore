package com.example.play.ui.books

import android.animation.ValueAnimator
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import com.example.play.theme.PlayTheme

@Composable
fun Books(
) {
  Column(
    modifier = Modifier.padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    LottieLoadingView(LocalContext.current, "working.json")
    Text(
      text = "Coming Soon",
      style = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
      ),
      color = PlayTheme.colors.textSecondary,
      textAlign = Center,
      modifier = Modifier.padding(16.dp)
    )
  }
}

@Composable
fun LottieLoadingView(context: Context, file: String) {
  val lottieView = remember {
    LottieAnimationView(context).apply {
      setAnimation(file)
      repeatCount = ValueAnimator.INFINITE
    }
  }
  AndroidView(
    { lottieView }, modifier = Modifier
      .fillMaxWidth()
      .height(250.dp)
  ) { lottieAnimView ->
    lottieAnimView.playAnimation()
  }
}

@Preview
@Composable
private fun PlayBooksPreview() {
  PlayTheme {
    Books()
  }
}