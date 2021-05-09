package com.example.play.ui.components

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.play.theme.PlayTheme

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
    modifier = modifier,
    colors = SwitchDefaults.colors(
      PlayTheme.colors.switchColor
    )
  )
}