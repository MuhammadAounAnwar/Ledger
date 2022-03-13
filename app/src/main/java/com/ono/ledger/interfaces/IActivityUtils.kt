package com.ono.ledger.interfaces

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.ono.ledger.enums.Themes

interface IActivityUtils {

    fun changeTheme(themes: Themes)
    fun changeActivity(
        currentActivityContext: Context,
        nextActivityReference: Activity,
        bundle: Bundle?,
        bundleKey: String?
    )
}