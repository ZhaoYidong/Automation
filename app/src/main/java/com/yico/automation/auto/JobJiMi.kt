package com.yico.automation.auto

import android.content.Context
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobJiMi {

    fun work(context: Context) {
        context as DailyRoutineService
        //TODO 定位弹窗
        PhoneUtils.openApp(App.instance(), "com.xgimi.zhushou")
        Thread.sleep(10000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 18)//我的
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 5, 12)//签到

        Thread.sleep(3000)
    }

}