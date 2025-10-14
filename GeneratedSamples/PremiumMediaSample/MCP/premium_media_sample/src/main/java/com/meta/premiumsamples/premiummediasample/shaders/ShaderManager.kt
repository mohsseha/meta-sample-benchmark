package com.meta.premiumsamples.premiummediasample.shaders

import android.content.Context
import com.meta.spatial.graphics.Shader
import com.meta.spatial.scene.SceneObject
import java.io.IOException

class ShaderManager(private val context: Context) {

    fun loadShader(vertexShaderPath: String, fragmentShaderPath: String): Shader? {
        return try {
            val vertexShader = context.assets.open(vertexShaderPath).readBytes()
            val fragmentShader = context.assets.open(fragmentShaderPath).readBytes()
            Shader(vertexShader, fragmentShader)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun applyShaderToSceneObject(sceneObject: SceneObject, shader: Shader) {
        // This is a conceptual example. The actual API for applying a shader
        // to a SceneObject might be different in the Meta Spatial SDK v0.8.0.
        // You would typically apply the shader to the material of the SceneObject.
        // For example:
        // sceneObject.material.shader = shader
    }
}
