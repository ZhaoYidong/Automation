package com.yico.automation.auto

import android.content.Context
import android.util.Log
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobiQiYi {

    fun work(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.qiyi.video")
        context as DailyRoutineService
        Thread.sleep(10000)
        context.back()
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 18, "会员")
        Thread.sleep(5000)

        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 15, "立即摇奖")
        Thread.sleep(5000)
        ActionUtils.actionByFindText("点击摇一摇", context.getNodeInfo(), false)
        Thread.sleep(5000)
        context.back()
        Thread.sleep(3000)
        ActionUtils.actionByFindText("点击摇一摇", context.getNodeInfo(), false)
        Thread.sleep(5000)
        context.back()
        Thread.sleep(3000)
        ActionUtils.actionByFindText("点击摇一摇", context.getNodeInfo(), false)
        Thread.sleep(5000)
        context.back()
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)

        ActionUtils.actionByFindText("每日签到", context.getNodeInfo())
        Thread.sleep(5000)
        context.back()
        Thread.sleep(5000)

    }

}