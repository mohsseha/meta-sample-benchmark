
package com.meta.spatial.customcomponentssample.systems

import android.util.Log
import com.meta.spatial.core.DataModel
import com.meta.spatial.core.EntityContext
import com.meta.spatial.core.Query
import com.meta.spatial.core.System
import com.meta.spatial.customcomponentssample.components.SharedDataComponent

class SharedDataSystem : System() {

    private val dataModel: DataModel = EntityContext.getDataModel()!!
    private var lastUpdateVersion = 0L

    override fun execute() {
        val query = Query.where {
            changedSince(SharedDataComponent.id, lastUpdateVersion)
        }

        for (entity in query.eval(dataModel)) {
            val sharedDataComponent = entity.getComponent(SharedDataComponent.id) as? SharedDataComponent
            if (sharedDataComponent != null) {
                Log.i("SharedDataSystem", "Shared text: ${sharedDataComponent.sharedText}")
            }
        }

        lastUpdateVersion = dataModel.getLastUpdateVersion()
    }
}
