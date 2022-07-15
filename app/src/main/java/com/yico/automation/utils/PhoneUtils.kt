package com.yico.automation.utils

import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioManager
import android.util.Log
import com.yico.automation.App


object PhoneUtils {

    fun openApp(context: Context, pkgName: String) {
        val packageManager: PackageManager = App.instance().packageManager
        val intent = packageManager.getLaunchIntentForPackage(pkgName)
        if (intent != null) {
            context.startActivity(intent)
            Log.e("yico", "打开应用：$pkgName")
        } else {
            Log.e("yico", "找不到应用：$pkgName")
        }
    }

    fun silentSwitchOn(context: Context) {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.ringerMode = AudioManager.STREAM_MUSIC
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_SHOW_UI)
        Log.e("yico", "已被静音")
    }

    fun silentSwitchOff(context: Context) {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 10, AudioManager.FLAG_SHOW_UI)
        Log.e("yico", "取消静音")
    }

}