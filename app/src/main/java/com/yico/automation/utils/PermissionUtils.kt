package com.yico.automation.utils

import android.app.ActivityManager
import android.app.NotificationManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.result.ActivityResultLauncher
import java.util.*


object PermissionUtils {

    private const val EXTRA_FRAGMENT_ARG_KEY = ":settings:fragment_args_key"
    private const val EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":settings:show_fragment_args"

    fun isServiceRunning(context: Context, serviceSimpleName: String): Boolean {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningService = activityManager.getRunningServices(Int.MAX_VALUE) as ArrayList<ActivityManager.RunningServiceInfo>
        for (i in runningService.indices) {
            val service = runningService[i].service
            if (service.packageName.contains(context.packageName, ignoreCase = true)
                && service.className.contains(serviceSimpleName, ignoreCase = true)
            ) return true
        }
        return false
    }

    //此处需注意 simpleName 和 name 的区别：name获取有时候是全路径，有时候是除去包名的部分，判断会不准确，统一用是否包含 simpleName 来判断
    fun isAccessibilityEnabled(context: Context, simpleName: String, checkService: Boolean = false): Boolean {
        if (checkService && !isServiceRunning(context, simpleName)) return false

        var enable = try {
            Settings.Secure.getInt(context.applicationContext.contentResolver, Settings.Secure.ACCESSIBILITY_ENABLED)
        } catch (e: Settings.SettingNotFoundException) {
            0
        }
        if (enable != 1) return false
        val services = Settings.Secure.getString(
            context.applicationContext.contentResolver, Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
        ) ?: return false
        return services.split(":").any {
            it.contains(context.packageName, ignoreCase = true) && it.contains(simpleName, ignoreCase = true)
        }
    }

    fun isAccessibilityEnabled(context: Context, clazz: Class<*>, checkService: Boolean = false): Boolean {
        return isAccessibilityEnabled(context, clazz.simpleName, checkService)
    }

    fun gotoAccessibilitySetting(
        context: Context, clazz: Class<*>, withGuide: Boolean = false,
        activityResultLauncher: ActivityResultLauncher<Intent>? = null,
    ) {

        if (activityResultLauncher == null) {
            context.startActivity(getAccessibilityHighlightIntent(context, clazz))
        } else {
            activityResultLauncher.launch(getAccessibilityHighlightIntent(context, clazz))
        }

    }

    fun getAccessibilityHighlightIntent(context: Context, clazz: Class<*>): Intent {
        return Intent(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)).apply {
            val bundle = Bundle()
            val componentName = ComponentName(context.packageName, clazz.name).flattenToString()
            bundle.putString(EXTRA_FRAGMENT_ARG_KEY, componentName)
            putExtra(EXTRA_FRAGMENT_ARG_KEY, componentName)
            putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, bundle)
        }
    }

    fun isPolicyAccessEnabled(context: Context): Boolean {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return notificationManager.isNotificationPolicyAccessGranted
    }

    fun gotoPolicyAccessSetting(context: Context) {
        val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
        context.startActivity(intent)
    }

}