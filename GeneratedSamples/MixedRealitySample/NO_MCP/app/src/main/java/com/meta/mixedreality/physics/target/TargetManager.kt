
package com.meta.mixedreality.physics.target

import android.content.Context
import com.meta.xr.sdk.scene.Scene
import com.meta.xr.sdk.scene.Surface
import com.meta.xr.sdk.scene.SurfaceType
import com.meta.xr.sdk.spatial.SpatialEntity
import com.meta.xr.sdk.spatial.component.mesh.MeshComponent
import com.meta.xr.sdk.spatial.math.Vector3

class TargetManager {

    fun createTargets(context: Context, scene: Scene) {
        val walls = scene.getSurfaces(context, listOf(SurfaceType.WALL))
        for (wall in walls) {
            createTargetOnWall(wall)
        }
    }

    private fun createTargetOnWall(wall: Surface) {
        val target = SpatialEntity()

        val meshComponent = MeshComponent()
        // In a real application, you would load a target model here.
        // For this example, we'll use a cube.
        meshComponent.setMeshFromCube(Vector3(0.5f, 0.5f, 0.1f))
        target.addComponent(meshComponent)

        target.transform.position = wall.pose.position
        target.transform.rotation = wall.pose.rotation
    }
}
