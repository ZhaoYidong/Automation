package com.yico.automation.auto

import android.content.Context
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobJDT {

    fun work(context: Context) {
        context as DailyRoutineService

        PhoneUtils.openApp(App.instance(), "com.jd.jrapp")
        Thread.sleep(7000)
        context.back()
        Thread.sleep(3000)
        ActionUtils.actionByFindText("签到", context.getNodeInfo())
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 7, "签到领金贴")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("福利", context.getNodeInfo())
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 3, "赚更多黄金豆")
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 3, 12, "立即签到")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 5, "关闭")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 8, 12, "立即签到")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 5, "关闭")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 12, 12, "立即签到")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 5, "关闭")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 17, 12, "立即签到")
        Thread.sleep(3000)
    }

}