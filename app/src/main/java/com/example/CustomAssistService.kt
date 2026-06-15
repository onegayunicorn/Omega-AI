package com.example

import android.os.Bundle
import android.service.voice.VoiceInteractionService
import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.*
import org.tensorflow.lite.Interpreter

class CustomAssistService : VoiceInteractionService() {
    companion object {
        const val TAG = "CustomAI_Assistant"
    }

    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json()
        }
    }

    private var localInterpreter: Interpreter? = null

    override fun onReady() {
        super.onReady()
        // Initialize TFLite model here (needs model file in assets)
        Log.d(TAG, "Assistant Ready")
    }

    suspend fun processQueryLocal(query: String): String {
        // Run TFLite inference
        return "Local AI: Processed $query"
    }

    suspend fun processQueryCloud(query: String): String {
        // Call Cloud API (Gemini via Ktor)
        return "Cloud AI: Response for $query"
    }

    override fun onDestroy() {
        super.onDestroy()
        client.close()
        localInterpreter?.close()
    }
}
