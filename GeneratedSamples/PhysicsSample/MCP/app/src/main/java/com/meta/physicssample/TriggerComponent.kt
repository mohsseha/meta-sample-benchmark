package com.meta.physicssample

import com.meta.spatial.core.Component
import com.meta.spatial.core.ComponentCompanion

class TriggerComponent(
    var pulled: Boolean = false
) : Component() {
    companion object : ComponentCompanion()
}
