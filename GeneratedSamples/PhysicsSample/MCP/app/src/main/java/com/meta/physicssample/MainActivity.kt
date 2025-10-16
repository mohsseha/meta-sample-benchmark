package com.meta.physicssample

import android.os.Bundle
import com.meta.spatial.toolkit.AppSystemActivity
import com.meta.physicssample.systems.ButtonSystem
import com.meta.physicssample.systems.SpinnerSystem
import com.meta.physicssample.systems.TriggerSystem

class MainActivity : AppSystemActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        systemManager.registerSystem(ButtonSystem())
        systemManager.registerSystem(SpinnerSystem())
        systemManager.registerSystem(TriggerSystem())
    }
}
