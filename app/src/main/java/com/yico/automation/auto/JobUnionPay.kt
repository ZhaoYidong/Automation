package com.yico.automation.auto

import android.content.Context
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobUnionPay {

    fun work(context: Context) {
        context as DailyRoutineService

        PhoneUtils.openApp(App.instance(), "com.unionpay")
        Thread.sleep(6000)
        ActionUtils.actionByFindText("我的", context.getNodeInfo())
        Thread.sleep(3000)
        ActionUtils.actionByFindText("签到", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12)

        Thread.sleep(3000)
    }

}