package com.meta.premiumsamples.premiummediasample.shaders

import android.content.Context
import com.meta.spatial.sdk.render.shader.Shader
import com.meta.spatial.sdk.render.shader.program.ShaderProgram
import com.meta.spatial.sdk.render.shader.program.VertexFragmentShaderProgram
import java.io.IOException

class ShaderManager(private val context: Context) {

    fun loadShaderProgram(vertexShaderPath: String, fragmentShaderPath: String): ShaderProgram? {
        return try {
            val vertexShader = loadShader(vertexShaderPath)
            val fragmentShader = loadShader(fragmentShaderPath)
            VertexFragmentShaderProgram(vertexShader, fragmentShader)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    private fun loadShader(path: String): Shader {
        val inputStream = context.assets.open(path)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val shaderCode = String(buffer)
        return Shader(shaderCode)
    }
}
