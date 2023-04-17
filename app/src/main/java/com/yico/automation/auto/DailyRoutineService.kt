package com.yico.automation.auto

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Toast
import com.yico.automation.utils.PhoneUtils

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
            Thread {
                sleep(10 * 1000)
                PhoneUtils.changeSystemBrightness(this@DailyRoutineService, 1)
            }.start()
            when (type) {
                "Article1" -> JobArticle.watchVideo(this@DailyRoutineService)
                "Article2" -> JobArticle.treasureChest(this@DailyRoutineService)
                "KuaiShou1" -> JobKuaiShou.watchChicken(this@DailyRoutineService)
                "KuaiShou2" -> JobKuaiShou.watchLiveStreaming(this@DailyRoutineService)
                "3" -> JobJDLite.watchActivity(this@DailyRoutineService)
                "5" -> JobJDLite.watchCommodity(this@DailyRoutineService)
                "6" -> JobJDLite.watchVideo(this@DailyRoutineService)
                "WatchVideo" -> JobCommon.watchVideo(this@DailyRoutineService)
                "WatchDY" -> JobCommon.watchDY(this@DailyRoutineService)
                "WatchNovel" -> JobCommon.watchNovel(this@DailyRoutineService)
                else -> everyDay()
            }
            PhoneUtils.changeSystemBrightness(this@DailyRoutineService, 100)
            watchDog = null
        }
    }

    private fun test() {
        JobJD.work(this)
    }

    private fun everyDay() {
        JobiQiYi.work(this)
        JobJDLite.work(this)
        JobTaoBao.work(this)
        JobJiMi.work(this)
        JobJDT.work(this)
        JobJD.work(this)
//        JobFanLi.work(this)
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