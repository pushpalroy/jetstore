package com.example.play.data

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf

@Immutable
data class App(
  val id: Long,
  val name: String,
  val imageUrl: String,
  val featureImageUrl: String = "",
  val size: String = "",
  val category: String = "",
  val type: String = "",
  val ratings: String = "",
  val org: String = "XCompany",
  val info: String = "Contains Ads",
  val reviews: List<Review> = listOf(),
  val tags: Set<String> = emptySet()
)

@Immutable
data class Review(
  val id: Long = 1,
  val userName: String = "John Barretto",
  val userAvatarUrl: String = "",
  val reviewDesc: String = "Amazing App!",
  val ratings: Double = 4.5,
  val date: String = "9/25/20",
  val appId: Long = 1
)

@Stable
class Filter(
  id: Int,
  val name: String,
  enabled: Boolean = false
) {
  val enabled = mutableStateOf(enabled)
  val id = mutableStateOf(id)
}