package com.meta.mruksample.experiences

import android.content.Context
import com.meta.spatial.sdk.mruk.MRUK
import com.meta.spatial.sdk.mruk.QRCode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QRCodeScannerExperience(private val context: Context) : Experience {

    private val mruk = MRUK.create(context)

    override fun start() {
        CoroutineScope(Dispatchers.Main).launch {
            val qrCodes = mruk.getQRCodes()
            for (qrCode in qrCodes) {
                val text = qrCode.getText()
                // Trigger an action based on the QR code text
            }
        }
    }

    override fun stop() {
        // Clean up resources
    }
}
