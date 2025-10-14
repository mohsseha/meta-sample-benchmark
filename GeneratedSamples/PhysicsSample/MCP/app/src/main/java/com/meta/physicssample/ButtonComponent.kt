package com.meta.physicssample

import com.meta.spatial.core.Component
import com.meta.spatial.core.ComponentCompanion

class ButtonComponent(
    var pressed: Boolean = false
) : Component() {
    companion object : ComponentCompanion()
}
