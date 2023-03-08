package com.yico.automation.auto

import android.content.Context
import android.util.Log
import com.yico.automation.App
import com.yico.automation.utils.ActionUtils
import com.yico.automation.utils.PhoneUtils

object JobArticle {

    fun work(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.ss.android.article.lite")
        context as DailyRoutineService
        Thread.sleep(3000)
        ActionUtils.actionByFindText("任务", context.getNodeInfo())
        Thread.sleep(1000)
        ActionUtils.slideByPoint(context, 8, "去顶部", false)
        Thread.sleep(3000)
        ActionUtils.clickByPointHighPrecision(context, 80, 48, "立即领取")
        Thread.sleep(3000)
        ActionUtils.clickByPointHighPrecision(context, 50, 60, "点击领取")

        Thread.sleep(3000)
    }

    fun eat(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.ss.android.article.lite")
        context as DailyRoutineService
        Thread.sleep(3000)
        ActionUtils.actionByFindText("任务", context.getNodeInfo())
        Thread.sleep(1000)
        ActionUtils.slideByPoint(context, 8, "去顶部", false)
        Thread.sleep(3000)
        ActionUtils.slideByPoint(context, 5, "吃饭补贴")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 6, 10, "吃饭补贴")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 18, "吃吃吃")
        for (index in 1..4) {
            Log.e("yico", "广告 $index")
            Thread.sleep((((0..5).random() + 30) * 1000L))//看广告
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 1, "关闭广告")
            Thread.sleep(3000)
            ActionUtils.clickByPoint(context, context.getNodeInfo(), (-3..3).random() + 10, 12, "看视频")
        }
    }

    fun treasureChest(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.ss.android.article.lite")
        context as DailyRoutineService
        Thread.sleep(3000)
        ActionUtils.actionByFindText("任务", context.getNodeInfo())
        Thread.sleep(3000)
        for (index in 1..8) {
            Log.e("yico", "第 $index 轮")
            ActionUtils.clickByPoint(context, context.getNodeInfo(), 18, 16, "开宝箱得金币")
            for (index in 1..4) {
                Log.e("yico", "广告 $index")
                Thread.sleep(3000)
                ActionUtils.clickByPoint(context, context.getNodeInfo(), (-3..3).random() + 10, 11, "看广告")
                ActionUtils.clickByPoint(context, context.getNodeInfo(), (-3..3).random() + 10, 12, "看广告")
                Thread.sleep((((0..5).random() + 30) * 1000L))//看广告
                ActionUtils.clickByPointHighPrecision(context,  92, 8, "关闭广告")
            }
            Thread.sleep((6 * 60 * 1000L))
        }
        Log.e("yico", "结束")
    }

    fun watchVideo(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.ss.android.article.lite")
        context as DailyRoutineService
        Thread.sleep(3000)
        for (a in 1..5) {
            Log.e("yico", "大循环 $a")
            for (b in 0..a) {
                ActionUtils.slideByPoint(context, 6, "列表滑动 $b")
                Thread.sleep(3000)
            }
            ActionUtils.clickByPoint(context, context.getNodeInfo(), (11..18).random(), (8..12).random(), "随机点视频")
            val count = (55..65).random()
            for (c in 1..count) {
                Thread.sleep(((-5..5).random() + 10) * 1000L)
                if (c % 7 == 0) {
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 10, "点赞")
                    Thread.sleep(300)
                    ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 10, "点赞")
                    Thread.sleep(1000)
                }
                ActionUtils.slideByPoint(context, 6, "视频滑动 $c")
            }
            Thread.sleep(3000)
            context.back()
        }
        Log.e("yico", "结束")
    }

    fun watchNews(context: Context) {
        PhoneUtils.openApp(App.instance(), "com.ss.android.article.lite")
        context as DailyRoutineService
        Thread.sleep(3000)
        ActionUtils.actionByFindText("任务", context.getNodeInfo())
        Thread.sleep(3000)
        ActionUtils.slideByPoint(context, 8, "去顶部", false)
        Thread.sleep(3000)
        ActionUtils.slideByPoint(context, 8, "去顶部", false)
        Thread.sleep(3000)
        ActionUtils.slideByPoint(context, 8, "去阅读")
        Thread.sleep(3000)
        ActionUtils.clickByPoint(context, context.getNodeInfo(), 10, 9, "去阅读")
        Thread.sleep(3000)

        for (a in 1..100) {
            Log.e("yico", "新闻 $a")
            var count = (1..3).random()
            for (c in 1..count) {
                ActionUtils.slideByPoint(context, 6, "滑动 $c")
                Thread.sleep((1..3).random() * 1000L)
            }
            ActionUtils.clickByPoint(context, context.getNodeInfo(), (-2..2).random() + 10, (-2..2).random() + 10, "点新闻")
            Thread.sleep(1000)
            if (ActionUtils.hasText("首页", context.getNodeInfo()) && ActionUtils.hasText("放映厅", context.getNodeInfo())) {
                ActionUtils.clickByPoint(context, context.getNodeInfo(), (-2..2).random() + 10, (-2..2).random() + 10, "点新闻")
            }
            count = (2..3).random()
            for (c in 0..count) {
                Thread.sleep((2..3).random() * 1000L)
                ActionUtils.slideByPoint(context, 6, "滑动 $c")
            }
            if (!(ActionUtils.hasText("首页", context.getNodeInfo()) && ActionUtils.hasText("放映厅", context.getNodeInfo()))) {
                context.back()
                Thread.sleep(3000)
            }
        }
        Log.e("yico", "结束")
    }

}