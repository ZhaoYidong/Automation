package com.yico.automation.utils

import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioManager
import android.provider.Settings
import android.util.Log
import android.widget.Toast
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

    fun screenOff(context: Context) {
        Thread.sleep(3000)
        try {
            val policyManager =
                context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            policyManager.lockNow()
        } catch (e: java.lang.Exception) {
            goHome(context)
        }
    }

    fun goHome(context: Context) {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun changeSystemBrightness(context: Context, brightness: Int) {
        if (Settings.System.canWrite(context)) {
            Settings.System.putInt(
                context.contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness
            )
        } else {
            Toast.makeText(context, "没有调节屏幕亮度的权限", Toast.LENGTH_SHORT).show()
        }
    }

}