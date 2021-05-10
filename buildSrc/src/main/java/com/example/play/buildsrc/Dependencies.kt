package com.example.play.buildsrc

object Versions {
  const val ktlint = "0.41.0"
}

object Libs {
  const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha15"
  const val junit = "junit:junit:4.13"

  object Accompanist {
    private const val version = "0.9.0"
    const val coil = "com.google.accompanist:accompanist-coil:$version"
    const val insets = "com.google.accompanist:accompanist-insets:$version"
  }

  object Kotlin {
     const val version = "1.4.32"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
  }

  object Coroutines {
    private const val version = "1.4.1"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
  }

  object LottieView {
    private const val lottieVersion = "3.6.1"
    private const val lottieComposeVersion = "1.0.0-alpha06"
    const val lottie = "com.airbnb.android:lottie:${lottieVersion}"
    const val lottieCompose = "com.airbnb.android:lottie-compose:${lottieComposeVersion}"
  }

  object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:1.3.0-alpha02"
    const val coreKtx = "androidx.core:core-ktx:1.6.0-alpha01"

    object Activity {
      const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha07"
    }

    object Compose {
      const val snapshot = ""
      const val version = "1.0.0-beta06"

      const val runtime = "androidx.compose.runtime:runtime:$version"
      const val foundation = "androidx.compose.foundation:foundation:${version}"
      const val layout = "androidx.compose.foundation:foundation-layout:${version}"
      const val ui = "androidx.compose.ui:ui:${version}"
      const val uiUtil = "androidx.compose.ui:ui-util:${version}"
      const val material = "androidx.compose.material:material:${version}"
      const val animation = "androidx.compose.animation:animation:${version}"
      const val tooling = "androidx.compose.ui:ui-tooling:${version}"
      const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
      const val navigation = "androidx.navigation:navigation-compose:1.0.0-alpha10"
    }

    object Lifecycle {
      const val viewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04"
    }

    object Test {
      private const val version = "1.3.0"
      const val core = "androidx.test:core:$version"
      const val rules = "androidx.test:rules:$version"

      object Ext {
        private const val version = "1.1.2-rc01"
        const val junit = "androidx.test.ext:junit-ktx:$version"
      }

      const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
    }
  }
}
