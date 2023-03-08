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

    fun watchChicken(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.kuaishou.nebula")
        context as DailyRoutineService
        Thread.sleep(6000)

        (1..5).forEach { _ ->
            ActionUtils.actionByFindText("去赚钱", context.getNodeInfo())
            Thread.sleep(10000)
            ActionUtils.clickByPointScreen(context, 880, 1600, "喂鸭")
            Thread.sleep(5000)
            ActionUtils.clickByPointScreen(context, 1000, 2000, "领取饲料")
            Thread.sleep(3000)
            ActionUtils.clickByPointScreen(context, 350, 2400, "去观看")
            Thread.sleep(3000)

            for (i in 1..15) {
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

        }

        ActionUtils.actionByFindText("去赚钱", context.getNodeInfo())
        Thread.sleep(3000)
        ActionUtils.clickByPointScreen(context, 880, 1600, "喂鸭")
        Thread.sleep(5000)
        (1..10).forEach { _ ->
            ActionUtils.clickByPointScreen(context, 1200, 1600, "吃吃吃")
            Thread.sleep(5000)
            ActionUtils.clickByPointScreen(context, 750, 1850, "继续喂喂喂")
            Thread.sleep(5000)
        }

        Log.e("yico", "结束")
    }

    fun watchLiveStreaming(context: Context) {
        //看直播
        PhoneUtils.openApp(App.instance(), "com.kuaishou.nebula")
        context as DailyRoutineService
        Thread.sleep(15000)
        for (a in 1..15) {
            Log.e("yico", "大循环 $a")
            val count = (3..5).random()
            for (b in 1..count) {
                ActionUtils.slideByPoint(context, 6, "列表滑动 $b")
                Thread.sleep(3000)
            }
            ActionUtils.clickByPoint(
                context,
                context.getNodeInfo(),
                (11..18).random(),
                (8..12).random(),
                "随机点视频"
            )
            Thread.sleep(65 * 1000)
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