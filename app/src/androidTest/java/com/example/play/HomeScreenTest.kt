package com.example.play

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.example.play.theme.PlayTheme
import com.example.play.ui.MainActivity
import com.example.play.ui.PlayApp
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

  @get:Rule
  val composeTestRule = createAndroidComposeRule<MainActivity>()
  // createComposeRule() if you don't need access to the activityTestRule

  @Test
  fun testTopCharts() {
    // Start the app
    composeTestRule.setContent {
      PlayTheme {
        PlayApp {}
      }
    }
    composeTestRule.onNodeWithText("Top Charts").performClick()
    composeTestRule.onNodeWithText("Show installed apps").assertIsDisplayed()
    composeTestRule.onNodeWithText("Top grossing").performClick()
    composeTestRule.onRoot().printToLog("TAG")
  }
}