package com.yico.automation.utils

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.graphics.Point
import android.graphics.Rect
import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo
import com.yico.automation.auto.DailyRoutineService


object ActionUtils {

    fun actionByTraverse(actionName: String, nodeInfo: AccessibilityNodeInfo?): Boolean {
        if (nodeInfo == null) return false
        val childCount = nodeInfo.childCount
        if (nodeInfo.isVisibleToUser
//            && nodeInfo.isClickable
//            && nodeInfo.isEnabled
            && nodeInfo.text != null
//            && actionString == nodeInfo.text.toString()
        ) {
            Log.e("yico", "文案 ${nodeInfo.text}")
            if (actionName == nodeInfo.text.toString()) {
                val p = nodeInfo.parent
                p.performAction(AccessibilityNodeInfo.ACTION_FOCUS)
                if (p.performAction(AccessibilityNodeInfo.ACTION_CLICK)) {
                    Log.e("yico", "$actionName 点击")
                }
                Log.e("yico", "$actionName 已点击")
                return true
            }
        }
        for (i in 0 until childCount) {
            Log.e("yico", "遍历进度 $i/$childCount")
            if (actionByTraverse(actionName, nodeInfo.getChild(i))) {
                return true
            }
        }
        Log.e("yico", "$actionName 未点击")
        return false
    }

    fun hasText(actionName: String, nodeInfo: AccessibilityNodeInfo?): Boolean {
        if (nodeInfo == null) return false
        val list = nodeInfo.findAccessibilityNodeInfosByText(actionName)
        if (list == null || list.size == 0) {
            Log.e("yico", "页面不包含 $actionName")
            return false
        }
        Log.e("yico", "页面包含 $actionName ${list.size}")
        return true
    }

    /**
     * @param actionName 目标控件文字内容
     * @param clickParent 是否点击目标控件的父控件
     * @param index 目标控件是列表时，点击列表中第几个控件
     */
    fun actionByFindText(
        actionName: String,
        nodeInfo: AccessibilityNodeInfo?,
        clickParent: Boolean = true,
        index: Int = -1
    ): Boolean {
        if (nodeInfo == null) return false
        val list = nodeInfo.findAccessibilityNodeInfosByText(actionName)
        if (list == null || list.size == 0) {
            Log.e("yico", "$actionName 未找到")
            return false
        }
        Log.e("yico", "$actionName 有${list.size}个")
        if (index != -1) {
            if (index >= list.size) {
                return false
            }
            if (clickParent) {
                list[index].parent?.apply {
                    performAction(AccessibilityNodeInfo.ACTION_FOCUS)
                    return performAction(AccessibilityNodeInfo.ACTION_CLICK).also { status ->
                        Log.e("yico", "$actionName 点击 $status")
                    }
                }
            } else {
                list[index].apply {
                    performAction(AccessibilityNodeInfo.ACTION_FOCUS)
                    return performAction(AccessibilityNodeInfo.ACTION_CLICK).also { status ->
                        Log.e("yico", "$actionName 点击 $status")
                    }
                }
            }
        } else {
            list.forEachIndexed { index, it ->
                if (clickParent) {
                    it.parent?.apply {
                        performAction(AccessibilityNodeInfo.ACTION_FOCUS)
                        performAction(AccessibilityNodeInfo.ACTION_CLICK).also { status ->
                            Log.e("yico", "$actionName 点击第${index}个 $status")
                            if (status) return true else return@forEachIndexed
                        }
                    }
                } else {
                    it.apply {
                        performAction(AccessibilityNodeInfo.ACTION_FOCUS)
                        performAction(AccessibilityNodeInfo.ACTION_CLICK).also { status ->
                            Log.e("yico", "$actionName 点击第${index}个 $status")
                            if (status) return true else return@forEachIndexed
                        }
                    }
                }
            }
        }
        Log.e("yico", "$actionName 点击失败")
        return false
    }

    /**
     * @param x 屏幕等分20份，输入横向相应位置的比例值
     * @param y 屏幕等分20份，输入纵向相应位置的比例值
     */
    fun clickByPoint(
        service: DailyRoutineService,
        nodeInfo: AccessibilityNodeInfo?,
        x: Int,
        y: Int,
        actionName: String = ""
    ): Boolean {
        if (nodeInfo == null) return false
        val rect = Rect()
        nodeInfo.getBoundsInScreen(rect)
        val px = (rect.left + rect.right) / 20 * x
        val py = (rect.top + rect.bottom) / 20 * y
        val point = Point(px, py)
        val builder = GestureDescription.Builder()
        val path = Path()
        path.moveTo(point.x.toFloat(), point.y.toFloat())
        builder.addStroke(GestureDescription.StrokeDescription(path, 0L, 100L))
        val gesture = builder.build()
        return service.dispatchGesture(
            gesture,
            object : AccessibilityService.GestureResultCallback() {
                override fun onCompleted(gestureDescription: GestureDescription?) {
                    super.onCompleted(gestureDescription)
                    Log.e("yico", "$actionName onCompleted")
                }

                override fun onCancelled(gestureDescription: GestureDescription?) {
                    super.onCancelled(gestureDescription)
                    Log.e("yico", "$actionName onCancelled")
                }
            },
            null
        )
    }

    /**
     * @param x 屏幕等分100份，输入横向相应位置的比例值
     * @param y 屏幕等分100份，输入纵向相应位置的比例值
     */
    fun clickByPointHighPrecision(
        service: DailyRoutineService,
        x: Int,
        y: Int,
        actionName: String = ""
    ): Boolean {
        val nodeInfo = service.getNodeInfo() ?: return false
        val rect = Rect()
        nodeInfo.getBoundsInScreen(rect)
        val px = (rect.left + rect.right) / 100 * x
        val py = (rect.top + rect.bottom) / 100 * y
        val point = Point(px, py)
        val builder = GestureDescription.Builder()
        val path = Path()
        path.moveTo(point.x.toFloat(), point.y.toFloat())
        builder.addStroke(GestureDescription.StrokeDescription(path, 0L, 100L))
        val gesture = builder.build()
        return service.dispatchGesture(
            gesture,
            object : AccessibilityService.GestureResultCallback() {
                override fun onCompleted(gestureDescription: GestureDescription?) {
                    super.onCompleted(gestureDescription)
                    Log.e("yico", "$actionName onCompleted")
                }

                override fun onCancelled(gestureDescription: GestureDescription?) {
                    super.onCancelled(gestureDescription)
                    Log.e("yico", "$actionName onCancelled")
                }
            },
            null
        )
    }

    /**
     * @param x 屏幕等分100份，输入横向相应位置的比例值
     * @param y 屏幕等分100份，输入纵向相应位置的比例值
     */
    fun clickByPointScreen(
        service: DailyRoutineService,
        x: Int,
        y: Int,
        actionName: String = ""
    ): Boolean {
        val nodeInfo = service.getNodeInfo() ?: return false
        val rect = Rect()
        nodeInfo.getBoundsInScreen(rect)
        val px = (rect.left + rect.right) / 1450f * x
        val py = (rect.top + rect.bottom) / 2960f * y
        val point = Point(px.toInt(), py.toInt())
        val builder = GestureDescription.Builder()
        val path = Path()
        path.moveTo(point.x.toFloat(), point.y.toFloat())
        builder.addStroke(GestureDescription.StrokeDescription(path, 0L, 100L))
        val gesture = builder.build()
        return service.dispatchGesture(
            gesture,
            object : AccessibilityService.GestureResultCallback() {
                override fun onCompleted(gestureDescription: GestureDescription?) {
                    super.onCompleted(gestureDescription)
                    Log.e("yico", "$actionName onCompleted")
                }

                override fun onCancelled(gestureDescription: GestureDescription?) {
                    super.onCancelled(gestureDescription)
                    Log.e("yico", "$actionName onCancelled")
                }
            },
            null
        )
    }

    fun slideByPoint(
        service: DailyRoutineService,
        distance: Int,
        actionName: String = "",
        strokeUp: Boolean = true
    ): Boolean {
        val nodeInfo = service.getNodeInfo() ?: return false
        val rect = Rect()
        nodeInfo.getBoundsInScreen(rect)
        val bottom = (rect.top + rect.bottom).toFloat()
        val px = (rect.left + rect.right) / 10
        val py = (rect.top + rect.bottom) / 10

        val start = if (strokeUp) (bottom - 500F) else 500F
        val end = if (strokeUp) (bottom - 500F - py * distance) else (500F + py * distance)
        val path = Path()
        path.moveTo(1000F, start)
        path.lineTo(1000F, end)

        val tag = if (strokeUp) "上划" else "下划"

        return service.dispatchGesture(
            GestureDescription.Builder()
                .addStroke(GestureDescription.StrokeDescription(path, 0L, 1000L)).build(),
            object : AccessibilityService.GestureResultCallback() {
                override fun onCompleted(gestureDescription: GestureDescription?) {
                    super.onCompleted(gestureDescription)
                    Log.e("yico", "$tag：$actionName onCompleted")
                }

                override fun onCancelled(gestureDescription: GestureDescription?) {
                    super.onCancelled(gestureDescription)
                    Log.e("yico", "$tag：$actionName onCancelled")
                }
            },
            null
        )
    }

}