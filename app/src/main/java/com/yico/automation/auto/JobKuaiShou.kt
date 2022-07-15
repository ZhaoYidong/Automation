package com.yico.automation.auto

import android.content.Context
import android.util.Log
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobKuaiShou {

    fun watchVideo(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.kuaishou.nebula")
        context as DailyRoutineService
        Thread.sleep(5000)

        for (i in 1..45) {
            Log.e("yico", "第 $i 个视频")
            if (ActionUtils.actionByFindText("继续看视频", context.getNodeInfo())) {
                Thread.sleep(3000)
            }
            ActionUtils.slideByPoint(context, 6, "列表滑动")
            Thread.sleep(3000)
            for (a in 1..3) {
                Log.e("yico", "第 $a 次检测")
                if (ActionUtils.hasText("查看图集", context.getNodeInfo())) {
                    ActionUtils.slideByPoint(context, 6, "列表滑动")
                    Thread.sleep(3000)
                    ActionUtils.slideByPoint(context, 6, "列表滑动")
                    Thread.sleep(3000)
                }
                if (ActionUtils.hasText("查看长图", context.getNodeInfo())) {
                    ActionUtils.slideByPoint(context, 6, "列表滑动")
                    Thread.sleep(3000)
                    ActionUtils.slideByPoint(context, 6, "列表滑动")
                    Thread.sleep(3000)
                }
                if (ActionUtils.hasText("点击进入直播间", context.getNodeInfo())) {
                    ActionUtils.slideByPoint(context, 6, "列表滑动")
                    Thread.sleep(3000)
                    ActionUtils.slideByPoint(context, 6, "列表滑动")
                    Thread.sleep(3000)
                }
            }
            Thread.sleep(((-5..5).random() + 15) * 1000L)
        }
        Log.e("yico", "结束")
    }

    fun watchLiveStreaming(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.kuaishou.nebula")
        context as DailyRoutineService
        Thread.sleep(5000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 13, 18, "去赚钱")
        Thread.sleep(3000)
        ActionUtils.slideByPoint(context, 8, "看直播")
        Thread.sleep(3000)
        ActionUtils.slideByPoint(context, 8, "看直播")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 7, "看视频赚钱")
        Thread.sleep(3000)
        for (a in 1..15) {
            Log.e("yico", "大循环 $a")
            val count = (3..5).random()
            for (b in 1..count) {
                ActionUtils.slideByPoint(context, 6, "列表滑动 $b")
                Thread.sleep(3000)
            }
            ActionUtils.clickByPoint(context, context.getNodeInfo(), (11..18).random(), (8..12).random(), "随机点视频")
            Thread.sleep(45 * 1000)
            context.back()
            Thread.sleep(3000)
            ActionUtils.actionByFindText("退出直播间", context.getNodeInfo())
            Thread.sleep(3000)
            if (!ActionUtils.hasText("规则", context.getNodeInfo())) {
                context.back()
                Thread.sleep(3000)
                ActionUtils.actionByFindText("退出直播间", context.getNodeInfo())
                Thread.sleep(3000)
            }
        }
        Log.e("yico", "结束")
    }

}