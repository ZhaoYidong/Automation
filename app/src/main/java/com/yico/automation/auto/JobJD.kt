package com.yico.automation.auto

import android.content.Context
import android.util.Log
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobJD {

    fun work(context: Context) {
        context as DailyRoutineService

        PhoneUtils.openApp(App.instance(), "com.jingdong.app.mall")
        Thread.sleep(3000)
        if (!ActionUtils.actionByFindText("领京豆", context.getNodeInfo())) {
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 15, "关闭弹窗")
            Thread.sleep(3000)
            ActionUtils.actionByFindText("领京豆", context.getNodeInfo())
        }
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 4, "签到")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 3, 13, "双签领豆")
        Thread.sleep(6000)
//        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 15, "立即领取")
//        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 12, "完成双签领取")
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)
        context.back()
        Thread.sleep(3000)


        ActionUtils.actionByFindText("我的", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 3, 10, "京豆")
        Thread.sleep(3000)

        ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 8, "摇京豆-去看看")
        Thread.sleep(6000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12, "立即签到")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 12, "点击有惊喜")
    }

}