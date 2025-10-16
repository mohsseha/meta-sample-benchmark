
package com.meta.spatial.sdk.sample.customcomponents

import com.meta.xr.sdk.component.Component
import com.meta.xr.sdk.component.RegisterComponent

@RegisterComponent
data class SharedDataComponent(var sharedCounter: Int = 0) : Component()
