package com.example.play.data

import androidx.compose.runtime.Immutable
import com.example.play.data.CollectionType.Featured
import com.example.play.data.CollectionType.Normal

@Immutable
data class AppCollection(
  val id: Long,
  val name: String,
  val apps: List<App>,
  val type: CollectionType = Normal
)

enum class CollectionType {
  Normal,
  Featured
}

/**
 * A fake repo
 */
object AppRepo {
  fun getApps() = appCollections
  fun getApp(appId: Long) = apps.find { it.id == appId }!!
  fun getRelated(@Suppress("UNUSED_PARAMETER") appId: Long) = related

  fun getForYouApps(): List<AppCollection> = forYouCollection
  fun getTopChartsApps(): List<App> = topChartsCollection
  fun getCategoriesApps(): List<AppCollection> = categoriesCollection

  fun getReviews() = reviews
  fun getReview(reviewId: Long) = reviews.find { it.id == reviewId }!!
  fun getReviewsForApp(appId: Long) = reviews.filter { it.appId == appId }

  fun getScreenshots() = screenshots
}

/**
 * Static data
 */

val apps = listOf(
    App(
        id = 10L,
        name = "Steam Link",
        org = "Valve Corporation",
        size = "23 MB",
        info = "Contains Ads",
        category = "Arcade",
        type = "Action",
        ratings = "3.9",
        imageUrl = "https://lh3.googleusercontent.com/LJp18yPRgdNRXSykeH2rJtaqWH-wrR0S1amiwm1KTWKwe7bwblwzGpCsPg4Rqz19VDs=s360",
        featureImageUrl = "https://steamcdn-a.akamaihd.net/store/about/social-og.jpg"
    ),
    App(
        id = 1L,
        name = "Chess - Play and Learn",
        org = "Chess.com",
        info = "Contains Ads",
        size = "195 MB",
        category = "Arcade",
        type = "Action",
        ratings = "4.4",
        imageUrl = "https://lh3.googleusercontent.com/K9J_fanyAQcYPpoXqFhJPT8Uo7GT6KkQAraJEQFtOeinuZSZhRr5k9cnhOq3LcMT1_y0=s360",
        featureImageUrl = "https://lh3.googleusercontent.com/Hh7To4ss_l7t7_2P6qJ0AneK11Cq-6Vuv3PR1e6oLZ3dCJHUuCYkrVwGBriv1jTZ4voQ"
    ),
    App(
        id = 19L,
        name = "Morse Mania: Learn Morse Code",
        size = "125 MB",
        category = "Puzzle",
        type = "Merge",
        ratings = "4.2",
        imageUrl = "https://lh3.googleusercontent.com/jtfbQ3eY_UewdSHxbCbFNBCV7tPKjjEH8CqJKJLiEARlXgpDNsvP5WV_jrLUapPKXA=s360",
        featureImageUrl = "https://images.unsplash.com/photo-1548268770-66184a21657e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=882&q=80"
    ),
    App(
        id = 20L,
        name = "Reaction training",
        size = "12 MB",
        category = "Puzzle",
        type = "Merge",
        ratings = "4.4",
        imageUrl = "https://lh3.googleusercontent.com/arUzvoXLTbT0bLu-NyZ4nGZk23ttD2yaUfhciycaIEhilAMiqyb_6h5RDAIrbjvS1g=s360",
        featureImageUrl = "https://images.unsplash.com/photo-1516663713099-37eb6d60c825?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80"
    ),
    App(
        id = 5L,
        name = "Binance - Buy & Sell Bitcoin Securely",
        category = "Finance",
        size = "8 MB",
        type = "Utility",
        ratings = "4.3",
        imageUrl = "https://lh3.googleusercontent.com/YaJVsuv4cxsegY_VYcsWpKY-4nt7g2il77XVWZrm_z9Knd3PJAGaBlBuQyahlm85aic=s360",
        featureImageUrl = "https://images.unsplash.com/photo-1597781914467-a5b93258e748?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
    ),
    App(
        id = 2L,
        name = "Google Tasks: Any Task, Any Goal. Get Things Done",
        category = "Puzzle",
        type = "Merge",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/62OzNxLonba70XxMFP3X3dsdNS9lvG2xf5TqfhYDaw9iFn5as9gVSU23ExfCLoZXkMWA=s360"
    ),
    App(
        id = 7L,
        name = "Duolingo: Learn English Free",
        size = "38 MB",
        imageUrl = "https://lh3.googleusercontent.com/FxlchNPugeC6vhs1_z4qtCVONLxiG-mhKjPanEUKDqCXtR5525dl_PVnn470bBM2xHE=s360"
    ),
    App(
        id = 8L,
        name = "SoundCloud - Play Music, Audio & New Songs",
        size = "115 MB",
        imageUrl = "https://lh3.googleusercontent.com/lvYCdrPNFU0Ar_lXln3JShoE-NaYF_V-DNlp4eLRZhUVkj00wAseSIm-60OoCKznpw=s360"
    ),
    App(
        id = 9L,
        name = "9GAG: Funny gifs, pics, fresh memes & viral videos",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/QiE-x76mMbIxT5W2sBCdORRnz-YJys2ridssRJZmiE540_5ADuFnOg-9I0H6bTQOuw=s360"
    ),
    App(
        id = 11L,
        name = "Flutter Tutorials And Quizzes",
        size = "120 MB",
        imageUrl = "https://lh3.googleusercontent.com/s57DrI3ItMHxl5wO0huKBKlWJEFNvYqaXen6jJYNbR9vHhVWWfCvwQLOFyPqxeDBts6C=s360"
    ),
    App(
        id = 12L,
        name = "MX Player",
        size = "120 MB",
        imageUrl = "https://lh3.googleusercontent.com/e_rNLzyR9i3wwy8BwEsIS4uz0fFu29p5RoXoNZt2L0Ef7cJ2QhAcw1x_K51A19HpzQ=s360"
    ),
    App(
        id = 13L,
        name = "Call of Duty®: Mobile",
        size = "120 MB",
        imageUrl = "https://lh3.googleusercontent.com/6lEEhm2WZojAbZ1uqRJb-KEmT24xydDd5I0QjABtlNOeDr9NrNxztXe67AArHUFuqSI=s360"
    ),
    App(
        id = 14L,
        name = "Spotify Lite",
        size = "120 MB",
        imageUrl = "https://lh3.googleusercontent.com/FChZKPO457J28-5XfUXjVLWSjNDpOQ28FUPze-icpd0ylt3iraHKdP2125CrL2dnuQ=s360"
    ),
    App(
        id = 15L,
        name = "Spotify Lite",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/6K8o8mobG8O-6OYZPUBRQYvCALzkkjjRzLjHCeuB19gRSjdZ9T5djqb1WzmpldCcuVo=s360"
    ),
    App(
        id = 16L,
        name = "Crayon Icon Pack",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/MmLHNN4_lwIN7kMG7XWnOxSYbEju-FBMEn8oDj4Xt8t9EnnH6S6GQeMHJDWpGfeDOSpM=s360"
    ),
    App(
        id = 17L,
        name = "OLX: Buy & Sell Near You with Online Classifieds",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/tYdcwxICaq7q-Qe_jmQ-2YIMfZ011Tap8PtWLOOpLx23LJLvqr_YziUqek9nBEdVJE8=s360"
    ),
    App(
        id = 18L,
        name = "Gaana",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/vHw1Qv2MNAzoXiuJb8lNkybyHBzCsiWblKCefKnsukJlV9z4G0hGL_4uXzLUwxyT7a_q=s360"
    ),
    App(
        id = 3L,
        name = "Subway Surfers",
        size = "5.1 MB",
        category = "Puzzle",
        type = "casual",
        ratings = "4.4",
        imageUrl = "https://lh3.googleusercontent.com/jUsiig3d-ntQuAg5fttEZtLBycPhm2Jjpj6OOyFzjUQ6JTlLzyFjbDsOhi9faQjZNz4=s360"
    ),
    App(
        id = 4L,
        name = "Coin by Zerodha",
        size = "34 MB",
        category = "Simulation",
        type = "Offline",
        ratings = "4.7",
        imageUrl = "https://lh3.googleusercontent.com/_Bg6_dqP19XKe4riOzHwYFuLkplOTqjAv78DoZmKE2DOgIMvdsGyvd8V-SlKOjhfXw=s360"
    ),
    App(
        id = 6L,
        name = "edX: Online Courses by Harvard, Imperial, MIT, IBM",
        size = "5.5 MB",
        imageUrl = "https://lh3.googleusercontent.com/gdytTaswCeQyqxcK-CS3BClqz7C3U0X6vLUbMOfq-91pgc0RReMOLIJLpYhsPsnzE2M=s360"
    )
)

val reviews = listOf(
    Review(
        id = 1L,
        userName = "Alicia Mayer",
        userAvatarUrl = "https://i.pinimg.com/564x/33/a2/d4/33a2d4e2aef856528a8696e83651e5a9.jpg",
        reviewDesc = "A true delight. Never stop development, its wonderful. Amazing app! Just love it!",
        ratings = 4.5,
        date = "9/25/20",
        appId = 1L
    ),
    Review(
        id = 1L,
        userName = "Edward Frost",
        userAvatarUrl = "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=900&q=60",
        reviewDesc = "Amazing experience. The animations are really smooth. A true joy ride! Would suggest to have more features in the future.",
        ratings = 4.0,
        date = "9/25/20",
        appId = 1L
    ),
    Review(
        id = 1L,
        userName = "Vicky Sharma",
        userAvatarUrl = "https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1600&q=80",
        reviewDesc = "Bag experience. App keeps on crashing whenever I go to Apps section. I don't know what happened to this app . It was one of the best apps but now it's the worst. Sometimes not able to navigate to Movies section from Apps, also search option doesn't work everytime.",
        ratings = 2.5,
        date = "9/25/20",
        appId = 1L
    ),
    Review(
        id = 1L,
        userName = "Christopher Julie",
        userAvatarUrl = "https://i.pinimg.com/236x/e7/1f/fc/e71ffc23cf4c38cf1eea484c344d2e22.jpg",
        reviewDesc = "Nice app, needs lots of improvement though. Would love to use it for the rest of my life. ",
        ratings = 3.0,
        date = "9/25/20",
        appId = 1L
    ),
    Review(
        id = 1L,
        userName = "Mohit Singh",
        userAvatarUrl = "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=900&q=60",
        reviewDesc = "Worst app! Uninstalled it. Thank you.",
        ratings = 2.0,
        date = "9/25/20",
        appId = 1L
    ),
    Review(
        id = 1L,
        userName = "Tom Hanks",
        userAvatarUrl = "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2550&q=80",
        reviewDesc = "App is good but I'm not feeling comfortable with so many permissions, especially fine location and camera, I read the explanation for the necessity but I'm not buying it, camera & location permissions could have been asked when and if I wanted to share something to friends.",
        ratings = 4.0,
        date = "9/25/20",
        appId = 1L
    ),
    Review(
        id = 1L,
        userName = "R Chandler",
        userAvatarUrl = "https://images.unsplash.com/photo-1601568544619-b03062ca528a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2500&q=80",
        reviewDesc = "Nice app. Like using it. Feels like I'm using the playstore app. But since I've updated the app to the latest version, it has become laggy and gets crashed frequently.",
        ratings = 3.0,
        date = "9/25/20",
        appId = 1L
    )
)

val screenshots = listOf(
    "https://i.pinimg.com/564x/7c/3a/d8/7c3ad851224a3a66f887ac19d5afe4a6.jpg",
    "https://i.pinimg.com/564x/6d/16/62/6d1662ba3f9c1af5652ce32664342a10.jpg",
    "https://i.pinimg.com/564x/85/7c/c2/857cc2ded3f279d12f99f2543634f441.jpg",
    "https://i.pinimg.com/564x/87/ce/9f/87ce9fdf662bea4ae4c79b383c029345.jpg"
)

/**
 * Fake static data
 */

val discoverRecommended = AppCollection(
    id = 1L,
    name = "Discover recommended games",
    type = Featured,
    apps = apps.subList(0, 5)
)

val suggestedForYou = AppCollection(
    id = 2L,
    name = "Suggested for you",
    type = Normal,
    apps = apps.subList(6, 12)
)

val greatIndie = AppCollection(
    id = 3L,
    name = "Great indie games",
    type = Normal,
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

val topChartsCollection = apps

val categoriesCollection = listOf(
    strategy,
    puzzle,
    discoverRecommended
)

val related = listOf(
    strategy,
    suggestedForYou
)