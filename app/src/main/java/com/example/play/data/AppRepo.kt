package com.example.play.data

import androidx.compose.runtime.Immutable
import com.example.play.data.CollectionType.Featured
import com.example.play.data.CollectionType.Normal
import com.example.play.data.models.App

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
  fun getApps(): List<AppCollection> = appCollections
  fun getApp(appId: Long) = apps.find { it.id == appId }!!
  fun getRelated(@Suppress("UNUSED_PARAMETER") appId: Long) = related

  fun getForYouApps(): List<AppCollection> = forYouCollection
  fun getTopChartsApps(): List<AppCollection> = topChartsCollection
  fun getCategoriesApps(): List<AppCollection> = categoriesCollection
}

/**
 * Static data
 */

val apps = listOf(
    App(
        id = 1L,
        name = "Chess - Play and Learn",
        org = "Chess.com",
        info = "Contains Ads",
        size = "195 MB",
        category = "Arcade",
        type = "Action",
        ratings = "4.4",
        imageUrl = "https://lh3.googleusercontent.com/K9J_fanyAQcYPpoXqFhJPT8Uo7GT6KkQAraJEQFtOeinuZSZhRr5k9cnhOq3LcMT1_y0=s360"
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
        id = 5L,
        name = "Binance - Buy & Sell Bitcoin Securely",
        category = "Board",
        type = "Chess",
        ratings = "4.3",
        imageUrl = "https://lh3.googleusercontent.com/YaJVsuv4cxsegY_VYcsWpKY-4nt7g2il77XVWZrm_z9Knd3PJAGaBlBuQyahlm85aic=s360"
    ),
    App(
        id = 6L,
        name = "edX: Online Courses by Harvard, Imperial, MIT, IBM",
        size = "5.5 MB",
        imageUrl = "https://lh3.googleusercontent.com/gdytTaswCeQyqxcK-CS3BClqz7C3U0X6vLUbMOfq-91pgc0RReMOLIJLpYhsPsnzE2M=s360"
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
        id = 10L,
        name = "Steam Link",
        size = "85 MB",
        imageUrl = "https://lh3.googleusercontent.com/LJp18yPRgdNRXSykeH2rJtaqWH-wrR0S1amiwm1KTWKwe7bwblwzGpCsPg4Rqz19VDs=s360"
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
        id = 19L,
        name = "Morse Mania: Learn Morse Code",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/jtfbQ3eY_UewdSHxbCbFNBCV7tPKjjEH8CqJKJLiEARlXgpDNsvP5WV_jrLUapPKXA=s360"
    ),
    App(
        id = 20L,
        name = "Reaction training",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/arUzvoXLTbT0bLu-NyZ4nGZk23ttD2yaUfhciycaIEhilAMiqyb_6h5RDAIrbjvS1g=s360"
    )
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