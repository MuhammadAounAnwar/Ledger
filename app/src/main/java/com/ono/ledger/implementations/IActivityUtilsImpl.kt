package com.ono.ledger.implementations

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ono.ledger.enums.Themes
import com.ono.ledger.interfaces.IActivityUtils

class IActivityUtilsImpl : IActivityUtils {
    override fun changeTheme(themes: Themes) {
        TODO("Not yet implemented")
    }

    override fun changeActivity(
        currentActivityContext: Context,
        nextActivityReference: Activity,
        bundle: Bundle?,
        bundleKey: String?
    ) {
        val intent = Intent(currentActivityContext, nextActivityReference::class.java)
        intent.putExtra(bundleKey, bundle)
        currentActivityContext.startActivity(intent)
    }

}