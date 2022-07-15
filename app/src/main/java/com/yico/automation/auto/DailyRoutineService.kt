package com.yico.automation.auto

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class DailyRoutineService : AccessibilityService() {

    private var watchDog: Watchdog? = null
    private var type = ""

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("yico", "onStartCommand")
        type = intent?.getStringExtra("type") ?: ""
        if (type == "stop") {
            watchDog?.interrupt()
            watchDog?.stop()
            return super.onStartCommand(intent, flags, startId)
        }
        if (watchDog == null) {
            watchDog = Watchdog().apply {
                start()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private inner class Watchdog : Thread() {
        override fun run() {
            Log.e("yico", "run")
            when (type) {
                "1" -> JobArticle.watchVideo(this@DailyRoutineService)
                "2" -> JobArticle.treasureChest(this@DailyRoutineService)
                "3" -> JobJDLite.watchActivity(this@DailyRoutineService)
                "5" -> JobJDLite.watchCommodity(this@DailyRoutineService)
                "6" -> JobJDLite.watchVideo(this@DailyRoutineService)
                "7" -> JobKuaiShou.watchVideo(this@DailyRoutineService)
                "8" -> JobKuaiShou.watchLiveStreaming(this@DailyRoutineService)
                else -> everyDay()
            }
            watchDog = null
        }
    }

    private fun test() {
        JobJD.work(this)
    }

    private fun everyDay() {
        JobiQiYi.work(this)
        JobJDLite.work(this)
        JobJiMi.work(this)
        JobJDT.work(this)
        JobJD.work(this)
        JobTaoBao.work(this)
        JobFanLi.work(this)
    }

    fun getNodeInfo(): AccessibilityNodeInfo? {
        return rootInActiveWindow
    }

    fun back() {
        Log.e("yico", "back")
        performGlobalAction(GLOBAL_ACTION_BACK)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}

    override fun onInterrupt() {}

    override fun onDestroy() {
        super.onDestroy()
        Log.e("yico", "onDestroy")
    }

}