package com.yico.automation.auto

import android.content.Context
import android.util.Log
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobFanLi {

    fun work(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.fanli.android.apps")
        context as DailyRoutineService
        Thread.sleep(8000)
        ActionUtils.actionByFindText("去允许", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("不允许", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("我知道了", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 6, "签到赚钱")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 9, "立即签到领钱")
        Thread.sleep(3000)
    }

    fun signIn(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.fanli.android.apps")
        context as DailyRoutineService
        Thread.sleep(8000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 6, "签到赚钱")
        Thread.sleep(3000)
        ActionUtils.actionByFindText("去允许", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("我知道了", context.getNodeInfo(), false)
        for (index in 0..10) {
            Log.e("yico", "广告 $index")
            Thread.sleep(5000)
            when (index % 3) {
                0 -> ActionUtils.clickByPoint(context, context.getNodeInfo(), 3, 12, "领金币1")
                1 -> ActionUtils.clickByPoint(context, context.getNodeInfo(), 8, 12, "领金币2")
                2 -> ActionUtils.clickByPoint(context, context.getNodeInfo(), 12, 12, "领金币3")
            }
            Thread.sleep(70 * 1000)//看广告
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 2, "关闭广告")
        }
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 9)//立即签到领钱
    }

    fun punch(context: Context) {//骗人
        PhoneUtils.openApp(App.instance(), "com.fanli.android.apps")
        context as DailyRoutineService
        Thread.sleep(8000)
        ActionUtils.actionByFindText("去允许", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("不允许", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 9, 8, "打卡领现金")
        Thread.sleep(6000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12, "翻倍")
        Thread.sleep(60 * 1000)//看广告
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 2, "关闭广告")
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12, "开心收下")

        for (index in 1..5) {
            Log.e("yico", "广告 $index")
            when (index) {
                1 -> {
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 2, 12, "开1")
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 2, 12, "开1")
                }
                2 -> {
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 5, 12, "开2")
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 5, 12, "开2")
                }
                3 -> {
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12, "开3")
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12, "开3")
                }
                4 -> {
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 14, 12, "开4")
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 14, 12, "开4")
                }
                5 -> {
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 12, "开5")
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 12, "开5")
                }
            }
            Thread.sleep(60 * 1000)//看广告
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 2, "关闭广告")
            Thread.sleep(5000)
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12, "翻倍")
            Thread.sleep(60 * 1000)//看广告
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 2, "关闭广告")
            Thread.sleep(5000)
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12, "开心收下")
            Thread.sleep(5000)
        }
    }


}