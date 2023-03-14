package com.yico.automation.auto

import android.content.Context
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobTaoBao {

    fun work(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.taobao.taobao")
        context as DailyRoutineService
        Thread.sleep(5000)
        ActionUtils.actionByFindText("领淘金币", context.getNodeInfo(), false)
        Thread.sleep(15000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 8, "领今日金币")
        Thread.sleep(5000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("签到", context.getNodeInfo(), false)
        Thread.sleep(8000)
        ActionUtils.clickByPointScreen(context, 720, 1150, "领现金")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("签到", context.getNodeInfo(), false)
        Thread.sleep(8000)
        ActionUtils.clickByPointScreen(context, 1270, 1150, "点击领取")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("签到", context.getNodeInfo(), false)
        Thread.sleep(8000)
        Thread.sleep(5 * 1000)
        ActionUtils.clickByPointScreen(context, 1270, 1150, "点击领取")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("签到", context.getNodeInfo(), false)
        Thread.sleep(8000)
        Thread.sleep(10 * 1000)
        ActionUtils.clickByPointScreen(context, 1270, 1150, "点击领取")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("签到", context.getNodeInfo(), false)
        Thread.sleep(8000)
        Thread.sleep(30 * 1000)
        ActionUtils.clickByPointScreen(context, 1270, 1150, "点击领取")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("签到", context.getNodeInfo(), false)
        Thread.sleep(8000)
        Thread.sleep(60 * 1000)
        ActionUtils.clickByPointScreen(context, 1270, 1150, "点击领取")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("签到", context.getNodeInfo(), false)
        Thread.sleep(8000)
        Thread.sleep(5 * 60 * 1000)
        ActionUtils.clickByPointScreen(context, 1270, 1150, "点击领取")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)
    }

}