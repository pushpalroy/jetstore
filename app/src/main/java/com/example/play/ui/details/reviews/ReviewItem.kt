package com.example.play.ui.details.reviews

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.text.style.TextOverflow.Ellipsis
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.play.data.AppRepo
import com.example.play.data.Review
import com.example.play.theme.PlayTheme
import com.example.play.ui.components.CircularAppImage
import com.example.play.ui.components.PlaySurface
import com.example.play.ui.components.progressindicator.StarRatings

@Composable
fun ReviewItem(review: Review) {
  PlaySurface(
      modifier = Modifier.padding(bottom = 16.dp)
  ) {
    Column {
      Row(
          modifier = Modifier.padding(bottom = 8.dp)
      ) {
        CircularAppImage(
            imageUrl = review.userAvatarUrl,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .align(Alignment.CenterVertically)
                .weight(2f, false)
        )
        Text(
            text = review.userName,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textPrimary,
            maxLines = 1,
            overflow = Ellipsis,
            modifier = Modifier.align(Alignment.CenterVertically)
                .weight(12f, true)
                .padding(start = 8.dp)
        )
        Icon(
            asset = Icons.Filled.MoreVert, modifier = Modifier
            .align(Alignment.CenterVertically)
            .weight(1f, false)
            .clickable(onClick = {})
        )
      }
      Row(
          modifier = Modifier.padding(bottom = 8.dp)
      ) {
        StarRatings(
            ratings = review.ratings, modifier = Modifier
            .align(Alignment.CenterVertically),
            sizeInDp = 10.dp
        )
        Text(
            text = review.date,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondary,
            modifier = Modifier.padding(start = 8.dp)
        )
      }
      Text(
          text = review.reviewDesc,
          style = TextStyle(
              fontWeight = FontWeight.Normal,
              fontSize = 12.sp,
              letterSpacing = 0.15.sp
          ),
          color = PlayTheme.colors.textSecondaryDark
      )
      Row(
          modifier = Modifier.padding(top = 24.dp)
      ) {
        Text(
            text = "Was this review helpful?",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                letterSpacing = 0.15.sp
            ),
            color = PlayTheme.colors.textSecondary,
            modifier = Modifier.align(Alignment.CenterVertically)
                .weight(3f, true)
        )
        Row(
            modifier = Modifier.align(Alignment.CenterVertically)
                .weight(1f, false)
        ) {
          Chip(text = "Yes")
          Spacer(modifier = Modifier.width(8.dp))
          Chip(text = "No")
        }
      }
    }
  }
}

// Chip
@Composable
private fun Chip(
  strokeWidth: Dp = 1.dp,
  color: Color = PlayTheme.colors.uiBorder,
  shape: Shape = RoundedCornerShape(50),
  text: String = "Yes"
) {
  Text(
      text = text,
      style = TextStyle(
          fontWeight = FontWeight.Normal,
          fontSize = 10.sp,
          textAlign = Center,
          letterSpacing = 0.15.sp
      ),
      color = PlayTheme.colors.textSecondary,
      modifier = Modifier
          .border(strokeWidth, color, shape)
          .padding(top = 2.dp, bottom = 2.dp)
          .width(40.dp)
          .height(15.dp)
          .clickable(onClick = {})
  )
}

@Preview("Review Item")
@Composable
private fun ReviewItemPreview() {
  PlayTheme {
    PlaySurface {
      ReviewItem(
          AppRepo.getReview(1L)
      )
    }
  }
}

@Preview("Review Item Dark")
@Composable
private fun ReviewItemDarkPreview() {
  PlayTheme(darkTheme = true) {
    PlaySurface {
      ReviewItem(
          AppRepo.getReview(1L)
      )
    }
  }
}