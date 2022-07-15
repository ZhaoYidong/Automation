package com.yico.automation.auto

import android.content.Context
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobiMaoTai {

    fun work(context: Context) {
        context as DailyRoutineService

        PhoneUtils.openApp(App.instance(), "com.moutai.mall")
        Thread.sleep(16000)
        ActionUtils.actionByFindText("申购", context.getNodeInfo())
        Thread.sleep(1000)
        ActionUtils.actionByFindText("预约申购", context.getNodeInfo(), false, 1)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("申购", context.getNodeInfo(), false, 1)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("确定申购", context.getNodeInfo(), false, index = 1)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("返回首页", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("申购", context.getNodeInfo())
        Thread.sleep(3000)
        ActionUtils.actionByFindText("预约申购", context.getNodeInfo(), false, 1)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("申购", context.getNodeInfo(), false, 1)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("确定申购", context.getNodeInfo(), false, index = 1)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("返回首页", context.getNodeInfo(), false)
        Thread.sleep(3000)
        ActionUtils.actionByFindText("个人", context.getNodeInfo())
        Thread.sleep(6000)
        ActionUtils.actionByFindText("申购单", context.getNodeInfo())

        Thread.sleep(3000)
    }

}