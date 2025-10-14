
package com.meta.spatial.customcomponentssample.systems

import com.meta.spatial.core.*
import com.meta.spatial.customcomponentssample.components.RotatorComponent
import com.meta.spatial.math.Quat
import com.meta.spatial.math.Transform
import com.meta.spatial.math.Vec3

class RotationSystem : System() {

    private val dataModel: DataModel = EntityContext.getDataModel()!!
    private var lastUpdateVersion = 0L

    override fun execute() {
        val query = Query.where {
            has(RotatorComponent.id)
            has(Transform.id)
            changedSince(Transform.id, lastUpdateVersion)
        }

        for (entity in query.eval(dataModel)) {
            val rotatorComponent = entity.getComponent(RotatorComponent.id) as? RotatorComponent
            val transformComponent = entity.getComponent(Transform.id) as? Transform

            if (rotatorComponent != null && transformComponent != null) {
                val rotationAmount = rotatorComponent.rotationSpeed * 0.01f // A small amount to rotate each frame
                val rotation = Quat.fromAngleAxis(rotationAmount, Vec3.UP)
                transformComponent.rotation = transformComponent.rotation.mul(rotation)
                entity.addComponent(transformComponent) // Mark the component as dirty
            }
        }

        lastUpdateVersion = dataModel.getLastUpdateVersion()
    }
}
