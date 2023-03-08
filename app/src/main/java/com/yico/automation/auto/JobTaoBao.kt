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

        ActionUtils.actionByFindText("领淘金币", context.getNodeInfo(), false)
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 2, 11, "领现金")
        Thread.sleep(8000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 8, "点击领取")
        Thread.sleep(10000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 8, "点击领取")
        Thread.sleep(15000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 8, "点击领取")
        Thread.sleep(30000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 8, "点击领取")
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 8, "立即领现金")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 2, 11, "领现金")
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 8, "立即领现金")
        Thread.sleep(3000)

//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 9, "收金币")
//        Thread.sleep(3000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 8, "收好友金币")
//        Thread.sleep(1000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 11, "收好友金币")
//        Thread.sleep(1000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 16, "收好友金币")
//        Thread.sleep(1000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 18, "收好友金币")
//        Thread.sleep(1000)
//        ActionUtils.slideByPoint(context, 8, "收金币")
//        Thread.sleep(3000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 5, "收好友金币")
//        Thread.sleep(1000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 8, "收好友金币")
//        Thread.sleep(1000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 11, "收好友金币")

        Thread.sleep(3000)
    }

}