package com.example.layoutapp.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PointF
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import kotlin.math.max
import kotlin.math.min

class ScaleScrollImageView : AppCompatImageView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    )

    var isScrollable = true

    private var scaleFactor = 0f
    private var prevScaleFactor = 0f

    private var minScaleFactor = 0f
    private var maxScaleFactor = 0f

    private val scaleFocus = PointF()

    private val offset = PointF()
    private val prevOffset = PointF()
    private val offsetLimit = PointF()

    private var isScaled = false

    private var isDrawn = false

    // gesture detectors and listeners

    private val scaleGestureListener =
        object : ScaleGestureDetector.SimpleOnScaleGestureListener() {

            override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
                detector?.let {
                    isScaled = true
                    prevOffset.set(offset)
                    prevScaleFactor = scaleFactor
                    scaleFocus.set(detector.focusX + offset.x, detector.focusY + offset.y)
                    return true
                }
                return super.onScaleBegin(detector)
            }

            override fun onScale(detector: ScaleGestureDetector?): Boolean {
                detector ?: return false

                scaleFactor *= detector.scaleFactor
                scaleFactor = max(minScaleFactor, min(scaleFactor, maxScaleFactor))
                isScrollable = scaleFactor == minScaleFactor

                offsetLimit.set(
                    scaleFactor * drawable.intrinsicWidth - measuredWidth,
                    scaleFactor * drawable.intrinsicHeight - measuredHeight
                )

                offset.x =
                    scaleFocus.x * (scaleFactor / prevScaleFactor) - scaleFocus.x + prevOffset.x
                offset.y =
                    scaleFocus.y * (scaleFactor / prevScaleFactor) - scaleFocus.y + prevOffset.y

                fixOffsets()

                fitToScreen()

                ViewCompat.postInvalidateOnAnimation(this@ScaleScrollImageView)
                return true
            }

            override fun onScaleEnd(detector: ScaleGestureDetector?) {
                isScaled = false
                super.onScaleEnd(detector)
            }
        }

    private val scaleGestureDetector = ScaleGestureDetector(context, scaleGestureListener)

    private val gestureListener = object : GestureDetector.SimpleOnGestureListener() {
        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            if (isScaled) return false

            offset.x += distanceX
            offset.y += distanceY

            fixOffsets()

            fitToScreen()

            ViewCompat.postInvalidateOnAnimation(this@ScaleScrollImageView)
            return true
        }

        override fun onDoubleTap(e: MotionEvent?): Boolean {
            e ?: return false

            prevOffset.set(offset)
            prevScaleFactor = scaleFactor
            scaleFocus.set(e.x + offset.x, e.y + offset.y)

            if (scaleFactor == minScaleFactor) {
                scaleFactor *= 2
                isScrollable = false
            } else {
                scaleFactor = minScaleFactor
                isScrollable = true
            }

            offsetLimit.set(
                scaleFactor * drawable.intrinsicWidth - measuredWidth,
                scaleFactor * drawable.intrinsicHeight - measuredHeight
            )

            offset.x = scaleFocus.x * (scaleFactor / prevScaleFactor) - scaleFocus.x + prevOffset.x
            offset.y = scaleFocus.y * (scaleFactor / prevScaleFactor) - scaleFocus.y + prevOffset.y

            fixOffsets()

            fitToScreen()

            ViewCompat.postInvalidateOnAnimation(this@ScaleScrollImageView)
            return true
        }
    }

    private val gestureDetector = GestureDetector(context, gestureListener)

    // override methods

    override fun setImageBitmap(bm: Bitmap?) {
        isDrawn = false
        super.setImageBitmap(bm)
    }

    override fun setImageDrawable(drawable: Drawable?) {
        isDrawn = false
        super.setImageDrawable(drawable)
    }

    override fun setImageResource(resId: Int) {
        isDrawn = false
        super.setImageResource(resId)
    }

    override fun setImageURI(uri: Uri?) {
        isDrawn = false
        super.setImageURI(uri)
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        var retVal = scaleGestureDetector.onTouchEvent(e)
        retVal = gestureDetector.onTouchEvent(e) || retVal
        return retVal || super.onTouchEvent(e)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas ?: return
        drawable ?: return
        if (!isDrawn) {
            minScaleFactor = min(
                measuredWidth.toFloat() / drawable.intrinsicWidth.toFloat(),
                measuredHeight.toFloat() / drawable.intrinsicHeight.toFloat()
            )
            maxScaleFactor = minScaleFactor * 8
            scaleFactor = minScaleFactor

            offsetLimit.set(
                scaleFactor * drawable.intrinsicWidth - measuredWidth,
                scaleFactor * drawable.intrinsicHeight - measuredHeight
            )

            fitToScreen()

            isDrawn = true
        }

        canvas.apply {
            save()
            translate(-offset.x, -offset.y)
            scale(scaleFactor, scaleFactor)
            drawable.draw(this)
            restore()
        }
    }

    // private methods

    private fun fitToScreen() {
        if (scaleFactor * drawable.intrinsicWidth < measuredWidth) {
            offset.x = offsetLimit.x / 2
        }
        if (scaleFactor * drawable.intrinsicHeight < measuredHeight) {
            offset.y = offsetLimit.y / 2
        }
    }

    private fun fixOffsets() {
        if (offset.x > offsetLimit.x) offset.x = offsetLimit.x
        else if (offset.x < 0) offset.x = 0f
        if (offset.y > offsetLimit.y) offset.y = offsetLimit.y
        else if (offset.y < 0) offset.y = 0f
    }
}