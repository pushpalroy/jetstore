package com.example.play.data.models

import androidx.compose.runtime.Immutable

@Immutable
data class AppCollection(
  val id: Long,
  val name: String,
  val apps: List<App>,
  val type: CollectionType = CollectionType.Normal
)

enum class CollectionType {
  Normal,
  Featured
}

/**
 * A fake repo
 */
object AppRepo {
  fun getApps(): List<AppCollection> = appCollections
  fun getApp(appId: Long) = apps.find { it.id == appId }!!
  fun getRelated(@Suppress("UNUSED_PARAMETER") appId: Long) = related

  fun getForYouApps(): List<AppCollection> = forYouCollection
  fun getTopChartsApps(): List<AppCollection> = topChartsCollection
  fun getCategoriesApps(): List<AppCollection> = categoriesCollection
}

/**
 * Fake static data
 */

val discoverRecommended = AppCollection(
    id = 1L,
    name = "Discover recommended games",
    type = CollectionType.Featured,
    apps = apps.subList(0, 5)
)

val suggestedForYou = AppCollection(
    id = 2L,
    name = "Suggested for you",
    type = CollectionType.Normal,
    apps = apps.subList(6, 12)
)

val greatIndie = AppCollection(
    id = 3L,
    name = "Great indie games",
    type = CollectionType.Normal,
    apps = apps.subList(12, 20)
)

val newAndUpdated = suggestedForYou.copy(
    id = 4L,
    name = "New and updated games"
)

val puzzle = discoverRecommended.copy(
    id = 5L,
    name = "Puzzle games"
)

val strategy = discoverRecommended.copy(
    id = 6L,
    name = "Strategy games"
)

val appCollections = listOf(
    discoverRecommended,
    suggestedForYou,
    greatIndie
)

val forYouCollection = listOf(
    discoverRecommended,
    suggestedForYou,
    greatIndie
)

val topChartsCollection = listOf(
    greatIndie,
    newAndUpdated,
    suggestedForYou
)

val categoriesCollection = listOf(
    strategy,
    puzzle,
    discoverRecommended
)

val related = listOf(
    strategy,
    suggestedForYou
)