package com.example

import ai.picovoice.porcupine.PorcupineManager
import ai.picovoice.picovoice.PorcupineException
import android.app.Service
import android.content.Intent
import android.os.IBinder

class WakeWordService : Service() {
    private var porcupineManager: PorcupineManager? = null

    override fun onCreate() {
        super.onCreate()
        try {
            // Need a valid AccessKey from Picovoice console
            porcupineManager = PorcupineManager.fromBuilder()
                .setAccessKey("YOUR_ACCESS_KEY")
                .setKeywordPath("hey_omega.ppn")
                .setWakeWordCallback {
                    // Logic to start the assistant interaction
                }
                .build(applicationContext)
            porcupineManager?.start()
        } catch (e: PorcupineException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        porcupineManager?.stop()
        porcupineManager?.delete()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
