package com.meta.mruksample.mruk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.meta.mruksample.R
import java.util.concurrent.CompletableFuture

class QrCodeScannerActivity : AppCompatActivity() {

    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code_scanner)
        statusText = findViewById(R.id.qr_code_status_text)

        startQrCodeScanning()
    }

    private fun startQrCodeScanning() {
        statusText.text = "Scanning for QR codes..."
        CompletableFuture.runAsync {
            Thread.sleep(3000) // Simulate scanning
            runOnUiThread {
                statusText.text = "QR code found!"
            }
        }
    }
}