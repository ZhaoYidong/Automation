package com.yico.automation.auto

import android.content.Context
import android.util.Log
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobJDLite {

    fun work(context: Context) {
        context as DailyRoutineService
        PhoneUtils.openApp(App.instance(), "com.jd.jdlite")
        Thread.sleep(8000)

//        ActionUtils.actionByFindText("签到免单", context.getNodeInfo())
//        Thread.sleep(6000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 16, 10, "立即签到")
//        Thread.sleep(3000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 16, 14, "立即签到")
//        Thread.sleep(3000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 16, 17, "立即签到")
//        Thread.sleep(3000)
//        context.back()
//        Thread.sleep(3000)

        ActionUtils.actionByFindText("签到提现", context.getNodeInfo())
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 13, "签到")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("领红包", context.getNodeInfo())
        Thread.sleep(10000)
        for (i in 1..3) {
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 10, "领")
            Thread.sleep(5000)
        }
    }

    fun watchCommodity(context: Context) {
        context as DailyRoutineService
        PhoneUtils.openApp(App.instance(), "com.jd.jdlite")
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 18, "百元生活费")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 9, "赚金币")
        Thread.sleep(3000)
        ActionUtils.actionByFindText("逛商品赚金币", context.getNodeInfo())
        Thread.sleep(3000)
        for (c in 1..45) {
            Log.e("yico", "商品 $c")
            for (t in 1..5) {
                ActionUtils.slideByPoint(context, 6, "滑动")
                Thread.sleep(((-2..0).random() + 5) * 1000L)
            }
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 7, "下一个")
            Thread.sleep(3000)
        }
        Log.e("yico", "结束")
    }

    fun watchActivity(context: Context) {
        context as DailyRoutineService
        PhoneUtils.openApp(App.instance(), "com.jd.jdlite")
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 18, "百元生活费")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 9, "赚金币")
        Thread.sleep(3000)
        ActionUtils.actionByFindText("逛活动赚金币", context.getNodeInfo())
        Thread.sleep(3000)
        for (a in 1..10) {
            Log.e("yico", "活动 $a")
            for (t in 1..5) {
                ActionUtils.slideByPoint(context, 6, "滑动")
                Thread.sleep(((-2..0).random() + 5) * 1000L)
            }
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 7, "下一个")
            Thread.sleep(5000)
        }
        Log.e("yico", "结束")
    }

    fun watchVideo(context: Context) {
        context as DailyRoutineService
        PhoneUtils.openApp(App.instance(), "com.jd.jdlite")
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 18, "百元生活费")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 9, "赚金币")
        Thread.sleep(3000)
        ActionUtils.actionByFindText("看视频赚金币", context.getNodeInfo())
        Thread.sleep(3000)
        for (t in 1..60) {
            Thread.sleep(((-5..5).random() + 10) * 1000L)
            ActionUtils.slideByPoint(context, 6, "滑动")
        }
        Thread.sleep(3000)
        Log.e("yico", "结束")
    }

}