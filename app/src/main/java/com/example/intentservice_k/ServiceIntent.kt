package com.example.intentservice_k

import android.app.IntentService
import android.content.Intent
import android.util.Log

class ServiceIntent : IntentService("MyIntentService") {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("InstanceService", "Service is Run...")
                Thread.sleep(1000)
            }
        } catch (o: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    companion object {
        var isRunning = false
        var instance: ServiceIntent? = null
        fun stopService() {
            Log.d("InstanceService", "Service is Stop...")
            isRunning = false
        }
    }
}
