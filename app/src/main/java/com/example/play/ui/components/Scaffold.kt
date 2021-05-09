package com.example.play.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.DrawerDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.example.play.theme.PlayTheme

/**
 * Wrap Material [androidx.compose.material.Scaffold] and set [PlayTheme] colors.
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PlayScaffold(
  modifier: Modifier = Modifier,
  scaffoldState: ScaffoldState = rememberScaffoldState(),
  topBar: @Composable (() -> Unit) = {},
  bottomBar: @Composable (() -> Unit) = {},
  snackBarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
  floatingActionButton: @Composable (() -> Unit) = {},
  floatingActionButtonPosition: FabPosition = FabPosition.End,
  isFloatingActionButtonDocked: Boolean = false,
  drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
  drawerShape: Shape = MaterialTheme.shapes.large,
  drawerElevation: Dp = DrawerDefaults.Elevation,
  drawerBackgroundColor: Color = PlayTheme.colors.uiBackground,
  drawerContentColor: Color = PlayTheme.colors.textSecondary,
  drawerScrimColor: Color = PlayTheme.colors.uiBorder,
  backgroundColor: Color = PlayTheme.colors.uiBackground,
  contentColor: Color = PlayTheme.colors.textSecondary,
  bodyContent: @Composable (PaddingValues) -> Unit
) {
  Scaffold(
    modifier = modifier,
    scaffoldState = scaffoldState,
    topBar = topBar,
    bottomBar = bottomBar,
    snackbarHost = snackBarHost,
    floatingActionButton = floatingActionButton,
    floatingActionButtonPosition = floatingActionButtonPosition,
    isFloatingActionButtonDocked = isFloatingActionButtonDocked,
    drawerContent = drawerContent,
    drawerShape = drawerShape,
    drawerElevation = drawerElevation,
    drawerBackgroundColor = drawerBackgroundColor,
    drawerContentColor = drawerContentColor,
    drawerScrimColor = drawerScrimColor,
    backgroundColor = backgroundColor,
    contentColor = contentColor,
    content = bodyContent
  )
}
