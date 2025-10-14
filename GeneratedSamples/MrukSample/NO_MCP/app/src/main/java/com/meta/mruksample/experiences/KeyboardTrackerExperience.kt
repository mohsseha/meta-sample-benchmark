package com.meta.mruksample.experiences

import android.content.Context
import com.meta.spatial.sdk.mruk.MRUK
import com.meta.spatial.sdk.mruk.TrackedKeyboard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KeyboardTrackerExperience(private val context: Context) : Experience {

    private val mruk = MRUK.create(context)
    private var keyboard: TrackedKeyboard? = null

    override fun start() {
        CoroutineScope(Dispatchers.Main).launch {
            keyboard = mruk.getTrackedKeyboard()
            keyboard?.let {
                // You can now get the position and rotation of the keyboard
                val position = it.getPosition()
                val rotation = it.getRotation()
            }
        }
    }

    override fun stop() {
        // Clean up resources
    }
}
