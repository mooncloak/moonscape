package com.mooncloak.moonscape.window

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.platform.WindowInfo

@Composable
private fun test(){
    LocalWindowInfo.current.containerSize
}