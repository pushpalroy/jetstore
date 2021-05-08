package com.example.play.ui.components

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Switch(
  switchState: Boolean = false,
  updateSwitchState: (Boolean) -> Unit,
  modifier: Modifier
) {
  Switch(
      checked = switchState,
      onCheckedChange = { checked ->
        updateSwitchState(checked)
      },
      modifier = modifier
  )
}