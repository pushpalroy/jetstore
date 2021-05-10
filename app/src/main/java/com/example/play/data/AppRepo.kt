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

@Immutable
data class MovieCollection(
  val id: Long,
  val name: String,
  val movies: List<Movie>,
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
  fun getApp(appId: Long?) = products.find { it.id == appId }
  fun getForYouApps(): List<AppCollection> = forYouAppsCollection
  fun getTopChartsApps(): List<App> = topChartsAppCollection

  fun getGames() = gamesCollections
  fun getForYouGames(): List<AppCollection> = forYouGamesCollection
  fun getTopChartsGames(): List<App> = topChartsGamesCollection

  fun getMovies() = moviesCollections
  fun getMovie(movieId: Long) = movies.find { it.id == movieId }!!
  fun getForYouMovies(): List<MovieCollection> = forYouMoviesCollection
  fun getTopSellingMovies(): List<Movie> = topSellingMoviesCollection
  fun getNewReleasesMovies(): List<Movie> = newReleasesMoviesCollection

  fun getReviews() = reviews
  fun getReview(reviewId: Long) = reviews.find { it.id == reviewId }!!

  fun getScreenshots() = screenshots
  fun getFilters() = filters
  fun getFilter(filterId: Int) = filters.find { it.id.value == filterId }
}

/**
 * Static apps data
 */

val apps = listOf(
    App(
        id = 1L,
        name = "SoundCloud - Play Music, Audio & New Songs",
        size = "115 MB",
        filterCategory = "Trending",
        imageUrl = "https://lh3.googleusercontent.com/lvYCdrPNFU0Ar_lXln3JShoE-NaYF_V-DNlp4eLRZhUVkj00wAseSIm-60OoCKznpw=s360"
    ),
    App(
        id = 2L,
        name = "Flipkart Online Shopping App",
        category = "Puzzle",
        type = "Merge",
        size = "12 MB",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/q8hxnbpJCYfHipSOG_5tZe5jK_89T6QIsqrEklvGpMFKH8b98pDHJf2tPcn2bxEN96ON=s360-rw"
    ),
    App(
        id = 3L,
        name = "Duolingo: Learn English Free",
        filterCategory = "Top grossing",
        size = "38 MB",
        imageUrl = "https://lh3.googleusercontent.com/FxlchNPugeC6vhs1_z4qtCVONLxiG-mhKjPanEUKDqCXtR5525dl_PVnn470bBM2xHE=s360"
    ),
    App(
        id = 4L,
        name = "Binance - Buy & Sell Bitcoin Securely",
        category = "Finance",
        size = "8 MB",
        filterCategory = "Top paid",
        type = "Utility",
        ratings = "4.3",
        imageUrl = "https://lh3.googleusercontent.com/YaJVsuv4cxsegY_VYcsWpKY-4nt7g2il77XVWZrm_z9Knd3PJAGaBlBuQyahlm85aic=s360",
        featureImageUrl = "https://images.unsplash.com/photo-1597781914467-a5b93258e748?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"
    ),
    App(
        id = 5L,
        name = "9GAG: Funny gifs, pics, fresh memes & viral videos",
        size = "125 MB",
        filterCategory = "Trending",
        imageUrl = "https://lh3.googleusercontent.com/QiE-x76mMbIxT5W2sBCdORRnz-YJys2ridssRJZmiE540_5ADuFnOg-9I0H6bTQOuw=s360"
    ),
    App(
        id = 6L,
        name = "Flutter Tutorials And Quizzes",
        size = "120 MB",
        filterCategory = "Top grossing",
        imageUrl = "https://lh3.googleusercontent.com/s57DrI3ItMHxl5wO0huKBKlWJEFNvYqaXen6jJYNbR9vHhVWWfCvwQLOFyPqxeDBts6C=s360"
    ),
    App(
        id = 7L,
        name = "MX Player",
        size = "120 MB",
        filterCategory = "Top grossing",
        imageUrl = "https://lh3.googleusercontent.com/e_rNLzyR9i3wwy8BwEsIS4uz0fFu29p5RoXoNZt2L0Ef7cJ2QhAcw1x_K51A19HpzQ=s360"
    ),
    App(
        id = 8L,
        name = "Spotify Lite",
        size = "120 MB",
        filterCategory = "Trending",
        imageUrl = "https://lh3.googleusercontent.com/FChZKPO457J28-5XfUXjVLWSjNDpOQ28FUPze-icpd0ylt3iraHKdP2125CrL2dnuQ=s360"
    ),
    App(
        id = 9L,
        name = "Spotify Lite",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/6K8o8mobG8O-6OYZPUBRQYvCALzkkjjRzLjHCeuB19gRSjdZ9T5djqb1WzmpldCcuVo=s360"
    ),
    App(
        id = 10L,
        name = "Crayon Icon Pack",
        size = "125 MB",
        filterCategory = "Trending",
        imageUrl = "https://lh3.googleusercontent.com/MmLHNN4_lwIN7kMG7XWnOxSYbEju-FBMEn8oDj4Xt8t9EnnH6S6GQeMHJDWpGfeDOSpM=s360"
    ),
    App(
        id = 11L,
        name = "OLX: Buy & Sell Near You with Online Classifieds",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/tYdcwxICaq7q-Qe_jmQ-2YIMfZ011Tap8PtWLOOpLx23LJLvqr_YziUqek9nBEdVJE8=s360"
    ),
    App(
        id = 12L,
        name = "Gaana",
        size = "125 MB",
        imageUrl = "https://lh3.googleusercontent.com/vHw1Qv2MNAzoXiuJb8lNkybyHBzCsiWblKCefKnsukJlV9z4G0hGL_4uXzLUwxyT7a_q=s360"
    ),
    App(
        id = 13L,
        name = "Coin by Zerodha",
        size = "34 MB",
        category = "Simulation",
        filterCategory = "Top grossing",
        type = "Offline",
        ratings = "4.7",
        imageUrl = "https://lh3.googleusercontent.com/_Bg6_dqP19XKe4riOzHwYFuLkplOTqjAv78DoZmKE2DOgIMvdsGyvd8V-SlKOjhfXw=s360"
    ),
    App(
        id = 14L,
        name = "edX: Online Courses by Harvard, Imperial, MIT, IBM",
        size = "5.5 MB",
        filterCategory = "Top grossing",
        imageUrl = "https://lh3.googleusercontent.com/gdytTaswCeQyqxcK-CS3BClqz7C3U0X6vLUbMOfq-91pgc0RReMOLIJLpYhsPsnzE2M=s360"
    ),
    App(
        id = 15L,
        name = "LinkedIn Lite: Easy Job Search, Jobs & Networking",
        category = "Puzzle",
        size = "8 MB",
        type = "Merge",
        filterCategory = "Top grossing",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/8r-ZTPoTIywU_aK2OXmLKg5WOdzXRxv7UUpiIk7kY7Du12fXKDwxUb2M_vBFp4pPvmpK=s360-rw"
    ),
    App(
        id = 16L,
        name = "Recipe book: Recipes & Shopping List",
        category = "Puzzle",
        size = "10 MB",
        type = "Merge",
        filterCategory = "Top paid",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/k0c3sF-Vu8L7ksIZw0mYmzC5k-lk7YAYrj5eDF4aNoQtnVIkmS02Vr6x7zzWYcwqQ9eB=s360-rw"
    ),
    App(
        id = 17L,
        name = "Uber Lite",
        category = "Puzzle",
        type = "Merge",
        size = "12.5 MB",
        filterCategory = "Top paid",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/WCnDKoA309Xj7K6iZYpilRN5XYjN8BfUo6ieCRJDvRdAGlFO--hCE-BlzKb6qYy691St=s360-rw"
    ),
    App(
        id = 18L,
        name = "OYO : Book Safe Rooms With Best Hotel Booking App",
        category = "Puzzle",
        type = "Merge",
        filterCategory = "Trending",
        size = "7 MB",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/hXpVzlM5gVL6hMCLacy3Y9zd2ecDVlU7TsHgSDB1R9u8OjUCUJ1bCrsUsT4bP-PyCSo=s360-rw"
    ),
    App(
        id = 19L,
        name = "Google Tasks: Any Task, Any Goal. Get Things Done",
        category = "Puzzle",
        type = "Merge",
        size = "18 MB",
        filterCategory = "Top paid",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/62OzNxLonba70XxMFP3X3dsdNS9lvG2xf5TqfhYDaw9iFn5as9gVSU23ExfCLoZXkMWA=s360"
    ),
    App(
        id = 20L,
        name = "YouTube",
        category = "Puzzle",
        size = "13 MB",
        type = "Merge",
        filterCategory = "Trending",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/lMoItBgdPPVDJsNOVtP26EKHePkwBg-PkuY9NOrc-fumRtTFP4XhpUNk_22syN4Datc=s360-rw"
    ),
    App(
        id = 21L,
        name = "PhonePe – UPI Payments, Recharges & Money Transfer",
        category = "Puzzle",
        type = "Merge",
        ratings = "4.6",
        filterCategory = "Trending",
        size = "8.5 MB",
        imageUrl = "https://lh3.googleusercontent.com/6iyA2zVz5PyyMjK5SIxdUhrb7oh9cYVXJ93q6DZkmx07Er1o90PXYeo6mzL4VC2Gj9s=s360-rw"
    ),
    App(
        id = 22L,
        name = "Canva: Graphic Design, Video Collage, Logo Maker",
        category = "Puzzle",
        type = "Merge",
        size = "11 MB",
        filterCategory = "Top paid",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/yjs-jdlPQ7nAkhUL8o1NlfmRTbICrhXEWdYYJRs69AgzLlabi5tkhR5x7S9uxaUcvk-v=s360-rw"
    ),
    App(
        id = 23L,
        name = "Over: Add Text to Photos & Graphic Design Maker",
        category = "Puzzle",
        type = "Merge",
        size = "17 MB",
        filterCategory = "Top paid",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/q8MEeQeJT9o-ypEnADc5JNpJwf9A-v3904DGNXfa-Xr31OUCmC0I1XBImgx0gU9W0No=s360-rw"
    ),
    App(
        id = 24L,
        name = "Draw Cartoons 2 PRO",
        category = "Puzzle",
        type = "Merge",
        size = "20 MB",
        filterCategory = "Top paid",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/g7u_ULrX0bpkPWucspc0iWfLpe-jcYIsyKDKvuu_41KqM1s2HVvYPdGpVZ9636n-2trq=s360-rw"
    ),
    App(
        id = 25L,
        name = "Google Meet - Secure Video Meetings",
        category = "Puzzle",
        type = "Merge",
        size = "15 MB",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/dNVT9ozasUGWx5L62LYd9qPUkx0PbrjbPZW7nrNbzV96l5n6eJnw_ygT8Mp91PWUEWlB=s360-rw"
    ),
    App(
        id = 26L,
        name = "ZOOM Cloud Meetings",
        category = "Puzzle",
        type = "Merge",
        size = "19 MB",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/1DqxbUca62LmV1ehZirHGWYBef9Jrtl3DhZ4m6YBnWCUX-XNr3lcnYKb31R-7ukpKAw=s360-rw"
    ),
    App(
        id = 27L,
        name = "Udemy - Online Coursese",
        category = "Puzzle",
        type = "Merge",
        size = "9 MB",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/VyIvp4Wl7DOFnIcsxrIw0pq43zUd8Yb4n96DpDRDrSsBkxIodDMMDfQk4XunNT5oDJ7Z=s360-rw"
    ),
    App(
        id = 28L,
        name = "Yousician - An Award Winning Music Education App",
        category = "Puzzle",
        type = "Merge",
        size = "11 MB",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/_guPX0UdwfwdpBYuHgBQsboW3MrkIqdoOFTYRxVTrznMwDmtcqNhpuLDvthX8es3Bg=s360-rw"
    ),
    App(
        id = 29L,
        name = "Google Classroom",
        category = "Puzzle",
        type = "Merge",
        size = "14.5 MB",
        ratings = "4.6",
        imageUrl = "https://lh3.googleusercontent.com/w0s3au7cWptVf648ChCUP7sW6uzdwGFTSTenE178Tz87K_w1P1sFwI6h1CLZUlC2Ug=s360-rw"
    ),
    App(
        id = 30L,
        name = "BYJU'S – The Learning App",
        category = "Puzzle",
        type = "Merge",
        ratings = "4.6",
        size = "8 MB",
        imageUrl = "https://lh3.googleusercontent.com/rFv7fIYW4u6h-M8nt4P-A5R7-8unCYOiswLw14NTKUp6yQRAVTWJQL3I1SRjvfSVLg=s360-rw"
    )
)

/**
 * Static games data
 */

val games = listOf(
    App(
        id = 31L,
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
        id = 32L,
        name = "Call of Duty®: Mobile",
        size = "120 MB",
        category = "Puzzle",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/6lEEhm2WZojAbZ1uqRJb-KEmT24xydDd5I0QjABtlNOeDr9NrNxztXe67AArHUFuqSI=s360",
        featureImageUrl = "https://cdn.images.express.co.uk/img/dynamic/143/590x/Call-of-Duty-Mobile-Vs-PUBG-Mobile-1188640.jpg?r=1570646248837"
    ),
    App(
        id = 33L,
        name = "Temple Run 2",
        size = "120 MB",
        category = "Action",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/VnmCQlMIEtzfZI2ivx_5-eVhhnosH-eQ67p0RWwc8TpbD_jehkUxOejva-oEPcJ8OVi0=s360-rw",
        featureImageUrl = "https://i.ytimg.com/vi/9aK2zoFBbKY/maxresdefault.jpg"
    ),
    App(
        id = 34L,
        name = "Subway Surfers",
        size = "120 MB",
        category = "Puzzle",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/BZmWHOpvowCFLTqiydafFzcMJ09HKrH-Z50VvCo75eM0WSOKT3RApt2VOW9shuc5SYc=s360-rw",
        featureImageUrl = "https://lh3.googleusercontent.com/lJwwJ_2bppGIuocVBgpAh8x0wXQf5h0WxW27YsQXwIlqGQTUnS3vlyOj5QBceRlF_5M"
    ),
    App(
        id = 35L,
        name = "Hill Climb Racing",
        size = "120 MB",
        category = "Puzzle",
        type = "Merge",
        imageUrl = "https://play-lh.googleusercontent.com/N0UxhBVUmx8s7y3F7Kqre2AcpXyPDKAp8nHjiPPoOONc_sfugHCYMjBpbUKCMlK_XUs=s360-rw",
        featureImageUrl = "https://venturebeat.com/wp-content/uploads/2017/01/hill-climb-racing-2.jpg?w=1200&strip=all"
    ),
    App(
        id = 36L,
        name = "Chess - Play and Learn",
        org = "Chess.com",
        info = "Contains Ads",
        filterCategory = "Top paid",
        size = "195 MB",
        category = "Arcade",
        type = "Action",
        ratings = "4.4",
        imageUrl = "https://lh3.googleusercontent.com/K9J_fanyAQcYPpoXqFhJPT8Uo7GT6KkQAraJEQFtOeinuZSZhRr5k9cnhOq3LcMT1_y0=s360",
        featureImageUrl = "https://lh3.googleusercontent.com/Hh7To4ss_l7t7_2P6qJ0AneK11Cq-6Vuv3PR1e6oLZ3dCJHUuCYkrVwGBriv1jTZ4voQ"
    ),
    App(
        id = 37L,
        name = "Morse Mania: Learn Morse Code",
        size = "125 MB",
        category = "Puzzle",
        filterCategory = "Top grossing",
        type = "Merge",
        ratings = "4.2",
        imageUrl = "https://lh3.googleusercontent.com/jtfbQ3eY_UewdSHxbCbFNBCV7tPKjjEH8CqJKJLiEARlXgpDNsvP5WV_jrLUapPKXA=s360",
        featureImageUrl = "https://images.unsplash.com/photo-1548268770-66184a21657e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=882&q=80"
    ),
    App(
        id = 38L,
        name = "Reaction training",
        size = "12 MB",
        category = "Puzzle",
        filterCategory = "Top grossing",
        type = "Merge",
        ratings = "4.4",
        imageUrl = "https://lh3.googleusercontent.com/arUzvoXLTbT0bLu-NyZ4nGZk23ttD2yaUfhciycaIEhilAMiqyb_6h5RDAIrbjvS1g=s360",
        featureImageUrl = "https://images.unsplash.com/photo-1516663713099-37eb6d60c825?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80"
    ),
    App(
        id = 39L,
        name = "Pokémon GO",
        size = "120 MB",
        filterCategory = "Top grossing",
        category = "Puzzle",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/wPfLmWBJwsPdBhsFXc8X4QZOOvePWjoOBLFXXCwyegjRwYOuabmG5cynthlW0HDgy9s=s360-rw"
    ),
    App(
        id = 40L,
        name = "Call of Duty®: Mobile",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top grossing",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/6lEEhm2WZojAbZ1uqRJb-KEmT24xydDd5I0QjABtlNOeDr9NrNxztXe67AArHUFuqSI=s360"
    ),
    App(
        id = 41L,
        name = "Hunter Assassin",
        size = "120 MB",
        category = "Puzzle",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/lfGhy-VzmH1GDXparQE-vJ1JfxpwMlmTe8pf4A6qNFkxC3kTvH6fS5o1YufFdqxiOns=s360-rw"
    ),
    App(
        id = 42L,
        name = "8 Ball Pool",
        size = "120 MB",
        category = "Puzzle",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/m7UzuFoXqeQUzdI0FRjI4peJo901tFPDgHJpnFEXHgywmgPJMYa55g6Yr-ZrmQ6DcPg=s360-rw"
    ),
    App(
        id = 43L,
        name = "Drop Stack Ball - Fall Helix Blast Crash 3D",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top grossing",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/SHDsApVesAmjVVGqX8TEh5kXyPJ02TlttTRSKpnTmBel5MPTgBF58a5-uRhZK8ZzAW4=s360-rw"
    ),
    App(
        id = 44L,
        name = "Call of Duty®: Mobile",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top grossing",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/6lEEhm2WZojAbZ1uqRJb-KEmT24xydDd5I0QjABtlNOeDr9NrNxztXe67AArHUFuqSI=s360"
    ),
    App(
        id = 45L,
        name = "My Talking Tom Friends",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top grossing",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/hdoAZSg01No2pfqgyh1b6uXC0gcqCwh55Jtl7KrJjiTREcOdr-BYYXQ0tcIQOAgl9Xo=s360-rw"
    ),
    App(
        id = 46L,
        name = "Encounter Strike:Real Commando Secret Mission 2020",
        size = "120 MB",
        category = "Puzzle",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/lmUd79-D_inHLBUuyVna2CwYdlaI9HJv7Z0VABM_1JSZqHS_9bF82Cv6TSwH9Qw-uB4=s360-rw"
    ),
    App(
        id = 47L,
        name = "My Restaurant Empire - 3D Decorating Cooking Game",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top grossing",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/Pic8hEeJiDZqQEZXB5xIKKGKpLY9VqV_Az9nuIJJvmgTPcjsytByma7Cq8K3O7l_1TcU=s360-rw"
    ),
    App(
        id = 48L,
        name = "Minion Rush: Despicable Me Official Game",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top paid",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/NHE-zsGu_Gh_7fF9u2owPQKrXvEI0oU6wQCnbTDp20vrggqyMiuAgEtoRwRMf3TJ499C=s360-rw"
    ),
    App(
        id = 49L,
        name = "Red Ball 4",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top paid",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/_2RsmTzfPHkBeSmDVOzgKaSQGLNqYep9mRsuYErzIcQslzAt_0hQDgoP4wJCwvMJkizT=s360-rw"
    ),
    App(
        id = 50L,
        name = "Robbery Bob",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Trending",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/oojEzXAk52vIZwKvn8l21rhgA88MEVAqJdtUgDTT_oyr232a72JrguxvQbjC34MVEzY=s360-rw"
    ),
    App(
        id = 51L,
        name = "Color Roll 3D",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top paid",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/lHWilWQkmvm043AIhd3-r1dltPIzve94oQBjTTdbRdavfQkTeqVAFfZO9Vo7w7SlkYg=s360-rw"
    ),
    App(
        id = 52L,
        name = "Zooba: Free-for-all Zoo Combat Battle Royale Games",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Trending",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/2EKQP3Li2baLX2koNGZGypUUx1YRyZoC6h_fAKtdybOaPo-iRLM2rAF0dBGHRsm7O2M=s360-rw"
    ),
    App(
        id = 53L,
        name = "Cut the Rope FULL FREE",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top paid",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/8hBtAlIHv8Ga1TeFVlCNxk1-pw4eKKyGWs0FsmI0mmIvl0iJ512PQQVQB0o90afWkV8=s360-rw"
    ),
    App(
        id = 54L,
        name = "Block Craft 3D: Building Simulator Games For Free",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top paid",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/o1US_4bdFr8LZezyp5IQ0n3yAnmskur9iXxhM4xKFKfiE9k85_PsVd7fs2IiJie2H9Vj=s360-rw"
    ),
    App(
        id = 55L,
        name = "2 Player games : the Challenge",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Top paid",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/T3_DvXNVrVL6MgXXWKeMEnUj5iM4QUTf3-5EAv6jqAMl9SlF7Xdo8InJup3LYoPUw1Q=s360-rw"
    ),
    App(
        id = 56L,
        name = "Tic Tac Toe Glow",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Trending",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/7k1wSfnstoNib_lmlfIfFTcHOE4oypb-mmuzvhPLpfFRz55CnNJFagyd6u6G4fFrlDI=s360-rw"
    ),
    App(
        id = 57L,
        name = "Moto X3M Bike Race Game",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Trending",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/45etI4KOM_2Isg7IZfi9jn1fNBG6PlXyuONCUUOgrErsiOXCNX6snUVp3KMNXYTcR429=s360-rw"
    ),
    App(
        id = 58L,
        name = "Super Mario Run",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Trending",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/5LIMaa7WTNy34bzdFhBETa2MRj7mFJZWb8gCn_uyxQkUvFx_uOFCeQjcK16c6WpBA3E=s360-rw"
    ),
    App(
        id = 59L,
        name = "Parkour Race - Freerun Game",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Trending",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/qnYxsgX9_3M6vgpt4ejsSTZCJz7M1sdJi084XTqwmN26oty2AmSihVbujWn2VF6bkQ=s360-rw"
    ),
    App(
        id = 60L,
        name = "PAC-MAN",
        size = "120 MB",
        category = "Puzzle",
        filterCategory = "Trending",
        type = "Merge",
        imageUrl = "https://lh3.googleusercontent.com/V-lvUzA5kK0Xw3wdg8Ct3vfIMXUX5vXYcNLPmudaZ-eyQjedYz-luqIuLmJO6KodE0Y=s360-rw"
    )
)

/**
 * Static apps + games data
 */

val products = apps + games

/**
 * Static movies data
 */

val movies = listOf(
    Movie(
        id = 1L,
        name = "Superman: Man of Tomorrow",
        ratings = "3.2",
        category = "Action & adventure",
        price = "₹150.00",
        imageUrl = "https://lh3.googleusercontent.com/dq9PoMponaQ5UFTsAQi0vOn79DFfRsxqZjr8y5yRFt0M_hSHdEwqVGStSmBQm0j5JlLBGCidzSTMRU70oQ=w400-h600-rw",
    ),
    Movie(
        id = 2L,
        name = "Forensic",
        ratings = "4.0",
        category = "Drama",
        price = "₹25.00",
        imageUrl = "https://lh3.googleusercontent.com/DzW5k8YSYtq6PBziR4yUqs1wTMMzwGtxMeilrqMX8h356ZleokF4oGuE9HwN82mn10iun8u8WxEK3blVddkR=w400-h600-rw",
    ),
    Movie(
        id = 3L,
        name = "SCOOB!",
        ratings = "3.7",
        category = "Animation",
        price = "₹150.00",
        imageUrl = "https://lh3.googleusercontent.com/sPDsM5qC4YT8QvxCzJKN0Q7L2aOdY9pvx538A5Zgf3C3V4oEeAULsglEdcnosdHRl0w-rNcY0eTqB0nHZpU7=w400-h600-rw",
    ),
    Movie(
        id = 4L,
        name = "Musical Chair",
        ratings = "4.5",
        price = "₹25.00",
        imageUrl = "https://lh3.googleusercontent.com/ZoQLZbZrHac2QtoBKDLNqa7gNvfR2WeOpQFsiUHoP4n2SKs1HZQj2IlqifW1mPRDHhZ3l1OPqdZBTsrW7a0k=w400-h600-rw",
    ),
    Movie(
        id = 5L,
        name = "The Invisible Man (2020)",
        ratings = "3.4",
        price = "₹150.00",
        imageUrl = "https://lh3.googleusercontent.com/jHBu_2vyE321Z-0gDTAGEaf0QGfDsUTQflbdFhvBLqc0Llz_yivVtnLcD3hQp011J7kXw8aIk6b462eG5I8=w400-h600-rw",
    ),
    Movie(
        id = 6L,
        name = "Frozen II",
        ratings = "4.3",
        category = "Animation",
        price = "₹150.00",
        imageUrl = "https://lh3.googleusercontent.com/DyoOARBcD-KqMRlAwCF5QAyJ4gAFDMvYSNRFXDiGcZ2EiUrmqeWX2S_XBqEd4lk8jNQAgg=w400-h600-rw",
    ),
    Movie(
        id = 7L,
        name = "Southpaw",
        ratings = "3.9",
        price = "₹25.00",
        imageUrl = "https://lh3.googleusercontent.com/I6pQI79ekJOUBHA3I6bxqpD2NFf7HBLAy1BQ8_qdzTwSAm_G5hVvFE7qBTnV0rft4hw=w400-h600-rw",
    ),
    Movie(
        id = 8L,
        name = "Abominable",
        ratings = "3.9",
        category = "Animation",
        price = "₹120.00",
        imageUrl = "https://lh3.googleusercontent.com/eMfNdSAdPXVp1y9PHI9BjLmOJIrVosFoqbvGqK_mDUdne5qVNFfXsI-4XPGoOtBA41z2J_lRoKuqm3A7jw=w400-h600-rw",
    ),
    Movie(
        id = 9L,
        name = "Spider-Man: Homecoming",
        ratings = "4.5",
        category = "Action & adventure",
        price = "₹80.00",
        imageUrl = "https://lh3.googleusercontent.com/4SDU8LISodRn1IJF81UH8Ql1WsIAvDKojQevt8bNgpnYcEdNeHXS-Kpx7ZWhm792exQ=w400-h600-rw",
    ),
    Movie(
        id = 10L,
        name = "Oculus",
        ratings = "4.1",
        category = "Horror",
        price = "₹25.00",
        imageUrl = "https://lh3.googleusercontent.com/5mhpJv1ifXu3S7Cs0h3jQS0OLskwMu9Cf3cMakZ6ITuiPrJ366pEiS9w7HwJQMUTa11X=w400-h600-rw",
    )
)

/**
 * Static reviews data
 */

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

/**
 * Static screenshots data
 */

val screenshots = listOf(
    "https://i.pinimg.com/564x/7c/3a/d8/7c3ad851224a3a66f887ac19d5afe4a6.jpg",
    "https://i.pinimg.com/564x/6d/16/62/6d1662ba3f9c1af5652ce32664342a10.jpg",
    "https://i.pinimg.com/564x/85/7c/c2/857cc2ded3f279d12f99f2543634f441.jpg",
    "https://i.pinimg.com/564x/87/ce/9f/87ce9fdf662bea4ae4c79b383c029345.jpg"
)

/**
 * Static filters data
 */

val filters = listOf(
    Filter(id = 1, name = "Top free"),
    Filter(id = 2, name = "Top grossing"),
    Filter(id = 3, name = "Trending"),
    Filter(id = 4, name = "Top paid")
)

/**
 * Static apps collections
 */

val recommendedApps = AppCollection(
    id = 1L,
    name = "Recommended for you",
    type = Normal,
    apps = apps.subList(0, 8)
)

val suggestedApps = AppCollection(
    id = 2L,
    name = "Suggested for you",
    type = Normal,
    apps = apps.subList(8, 16)
)

val recentlyUpdatedApps = AppCollection(
    id = 3L,
    name = "Recently updated",
    type = Normal,
    apps = apps.subList(16, 24)
)

val entertainmentApps = AppCollection(
    id = 3L,
    name = "Entertainment",
    type = Normal,
    apps = apps.subList(24, 30)
)

val appCollections = listOf(
    recommendedApps,
    suggestedApps,
    recentlyUpdatedApps,
    entertainmentApps
)

val forYouAppsCollection = appCollections
val topChartsAppCollection = apps

/**
 * Static games collections
 */

val recommendedGames = AppCollection(
    id = 1L,
    name = "Discover recommended games",
    type = Featured,
    apps = games.subList(0, 8)
)

val suggestedGames = AppCollection(
    id = 2L,
    name = "Suggested for you",
    type = Normal,
    apps = games.subList(8, 16)
)

val recentlyUpdatedGames = AppCollection(
    id = 3L,
    name = "New and updated games",
    type = Normal,
    apps = games.subList(16, 24)
)

val topRatedGames = AppCollection(
    id = 3L,
    name = "Top rated games",
    type = Normal,
    apps = games.subList(24, 30)
)

val gamesCollections = listOf(
    recommendedGames,
    suggestedGames,
    recentlyUpdatedGames,
    topRatedGames
)

val forYouGamesCollection = gamesCollections
val topChartsGamesCollection = games

/**
 * Static movies collections
 */

val newReleaseMovies = MovieCollection(
    id = 1L,
    name = "New release hit films",
    movies = movies.subList(0, 4)
)

val topSellerMovies = MovieCollection(
    id = 2L,
    name = "Top sellers",
    movies = movies.subList(4, 8)
)

val moviesCollections = listOf(
    newReleaseMovies,
    topSellerMovies
)

val forYouMoviesCollection = moviesCollections
val topSellingMoviesCollection = movies
val newReleasesMoviesCollection = movies.reversed()