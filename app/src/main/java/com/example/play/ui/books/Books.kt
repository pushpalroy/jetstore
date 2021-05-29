package com.example.play.ui.books

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.play.theme.PlayTheme

@Composable
fun Books(
) {
  Column(
    modifier = Modifier.padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    //LottieLoadingView()
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

/**
 * Commented out because of build issue in snapshot version of lottie compose
 */
//@Composable
//fun LottieLoadingView(modifier: Modifier = Modifier) {
//  val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.working) }
//  LottieAnimation(
//    animationSpec,
//    modifier = Modifier
//      .size(250.dp)
//      .then(modifier)
//  )
//}

@Preview
@Composable
private fun PlayBooksPreview() {
  PlayTheme {
    Books()
  }
}