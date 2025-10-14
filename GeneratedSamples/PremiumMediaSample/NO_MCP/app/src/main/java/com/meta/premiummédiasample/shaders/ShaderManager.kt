package com.meta.premiummédiasample.shaders

import android.content.Context
import com.meta.spatial.graphics.Material
import com.meta.spatial.graphics.Shader
import com.meta.spatial.graphics.Texture
import java.io.IOException

class ShaderManager(private val context: Context) {

    fun createReflectionMaterial(sceneTexture: Texture): Material {
        val shader = loadShader("shaders/reflection.glsl")
        val material = Material(shader)
        material.setTexture("u_SceneTexture", sceneTexture)
        material.setVector4("u_Color", floatArrayOf(0.5f, 0.5f, 0.5f, 1.0f))
        return material
    }

    private fun loadShader(path: String): Shader {
        try {
            val inputStream = context.assets.open(path)
            val bytes = inputStream.readBytes()
            inputStream.close()
            return Shader(bytes)
        } catch (e: IOException) {
            throw RuntimeException("Failed to load shader: $path", e)
        }
    }
}
