package com.yico.automation.auto

import android.content.Context
import android.util.Log
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobCommon {

    fun watchVideo(context: Context) {
        context as DailyRoutineService
        Thread.sleep(10 * 1000)
        for (i in 1..240) {
            Log.e("yico", "第 $i 个视频")
            ActionUtils.slideByPoint(context, 6, "列表滑动")
            Thread.sleep(5000)
            if (ActionUtils.hasText("直播间", context.getNodeInfo())) {
                continue
            }
            Thread.sleep(((-5..5).random() + 10) * 1000L)
        }
        Log.e("yico", "结束")
        PhoneUtils.screenOff(context)
    }

}