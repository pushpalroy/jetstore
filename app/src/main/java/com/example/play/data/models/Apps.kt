package com.example.play.data.models

import androidx.compose.runtime.Immutable

@Immutable
data class App(
  val id: Long,
  val name: String,
  val imageUrl: String,
  val size: String = "",
  val category: String = "",
  val type: String = "",
  val ratings: String = "",
  val org: String = "XCompany",
  val info: String = "Contains Ads",
  val tags: Set<String> = emptySet()
)
