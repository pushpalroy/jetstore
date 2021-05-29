package com.example.play.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // This app draws behind the system bars, so we want to handle fitting system windows
    WindowCompat.setDecorFitsSystemWindows(window, true)

    setContent {
      PlayApp { finish() }
    }
  }
}