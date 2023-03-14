package com.yico.automation.utils

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent

import android.widget.Toast


class ScreenOffAdminReceiver : DeviceAdminReceiver() {

    override fun onEnabled(context: Context, intent: Intent) {
        Toast.makeText(context, "设备管理器使用", Toast.LENGTH_SHORT).show()
    }

    override fun onDisabled(context: Context, intent: Intent) {
        Toast.makeText(context, "设备管理器没有使用", Toast.LENGTH_SHORT).show()
    }

}