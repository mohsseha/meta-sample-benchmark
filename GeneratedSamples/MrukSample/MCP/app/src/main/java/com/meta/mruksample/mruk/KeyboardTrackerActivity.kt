package com.meta.mruksample.mruk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.meta.mruksample.R
import java.util.concurrent.CompletableFuture

class KeyboardTrackerActivity : AppCompatActivity() {

    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyboard_tracker)
        statusText = findViewById(R.id.keyboard_status_text)

        startKeyboardTracking()
    }

    private fun startKeyboardTracking() {
        statusText.text = "Starting keyboard tracking..."
        CompletableFuture.runAsync {
            Thread.sleep(2000) // Simulate keyboard detection
            runOnUiThread {
                statusText.text = "Keyboard detected!"
            }
        }
    }
}