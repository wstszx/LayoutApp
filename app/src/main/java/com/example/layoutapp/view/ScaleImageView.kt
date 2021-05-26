package com.example.layoutapp.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ScaleGestureDetector

class ScaleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private var mScaleFactor = 1f

    private val scaleListener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val TAG = "ScaleImageView"
            Log.d(TAG, "focusX: " + detector.focusX + "focusY:" + detector.focusY)
            mScaleFactor *= detector.scaleFactor
            // Don't let the object get too small or too large.
            mScaleFactor = 0.5f.coerceAtLeast(mScaleFactor.coerceAtMost(1.0f))
//            mScaleFactor = Math.max(0.5f, Math.min(mScaleFactor, 1.0f))
//            scaleX = mScaleFactor
//            scaleY = mScaleFactor
            scaleType = ScaleType.MATRIX
            matrix.setScale(mScaleFactor, mScaleFactor)
            imageMatrix = matrix
            invalidate()
            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {

            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {

        }
    }

    private val mScaleDetector = ScaleGestureDetector(context, scaleListener)


    override fun onTouchEvent(ev: MotionEvent): Boolean {
        // Let the ScaleGestureDetector inspect all events.
        mScaleDetector.onTouchEvent(ev)
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.apply {
            save()
            scale(mScaleFactor, mScaleFactor)
            // onDraw() code goes here
            restore()
        }
    }

}