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
  val size: String = "7 MB",
  val category: String = "Utility",
  val filterCategory: String = "Top free",
  val type: String = "Action",
  val ratings: String = "4.1",
  val org: String = "XCompany",
  val info: String = "Contains Ads",
  val reviews: List<Review> = listOf(),
  val tags: Set<String> = emptySet()
)

@Immutable
data class Movie(
  val id: Long,
  val name: String,
  val imageUrl: String = "",
  val category: String = "Drama",
  val filterCategory: String = "For You",
  val ratings: String = "3.5",
  val price: String = "₹50.00",
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