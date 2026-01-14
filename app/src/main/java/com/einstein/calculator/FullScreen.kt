package com.einstein.calculator

import android.app.Activity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat


fun FullScreen(activity: Activity, fullscreen: Boolean) {
    var controller = WindowInsetsControllerCompat(activity.window, activity.window.decorView);
    if (fullscreen) {
        // WindowCompat.setDecorFitsSystemWindows(activity.window, false)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

    } else {
        controller.show(WindowInsetsCompat.Type.systemBars())
    }

}
