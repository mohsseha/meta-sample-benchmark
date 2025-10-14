package com.meta.physicssample

import com.meta.spatial.core.Component
import com.meta.spatial.core.ComponentCompanion

class SpinnerComponent(
    var spinning: Boolean = false
) : Component() {
    companion object : ComponentCompanion()
}
