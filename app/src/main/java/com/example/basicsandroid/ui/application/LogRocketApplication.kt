package com.example.basicsandroid.ui.application

import android.app.Application
import android.content.Context
import com.logrocket.core.Configuration
import com.logrocket.core.SDK


class LogRocketApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SDK.init(
            this,
            base
        ) { options: Configuration -> options.setAppID("qowrmy/android-log") }
    }
}
