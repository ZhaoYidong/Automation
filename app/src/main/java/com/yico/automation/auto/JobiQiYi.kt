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
        Thread.sleep(5000)
        ActionUtils.actionByFindText("会员", context.getNodeInfo())
        Thread.sleep(3000)
        ActionUtils.actionByFindText("每日签到", context.getNodeInfo())
        Thread.sleep(10000)
    }

}