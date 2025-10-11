package com.meta.mruksample.experiences

import android.widget.Toast
import com.meta.spatial.sdk.MRUKView
import com.meta.spatial.sdk.Scene
import com.meta.spatial.sdk.qrcode.QRCode
import com.meta.spatial.sdk.qrcode.QRCodeObserver

class QRCodeScannerExperience(private val mrukView: MRUKView) {

    private val qrCodeObserver = object : QRCodeObserver {
        override fun onQRCodeDetected(qrCode: QRCode) {
            Log.d("QRCodeScannerExperience", "QR Code detected: ${qrCode.data}")
            Toast.makeText(mrukView.context, "QR Code detected: ${qrCode.data}", Toast.LENGTH_SHORT).show()
            // You can add logic here to respond to the QR code,
            // for example, by loading a model or displaying information.
        }
    }

    fun onSceneUpdate(scene: Scene) {
        // This experience does not depend on scene updates
    }

    fun start() {
        QRCode.addObserver(qrCodeObserver)
    }

    fun stop() {
        QRCode.removeObserver(qrCodeObserver)
    }
}
