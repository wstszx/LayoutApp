package com.example.layoutapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.layoutapp.R;


public class AirView extends View {

    private static final float SCALE_RATIO = 0.0035967547f;
    private Path airOutline;
    private float baseAirWidth;
    private float baseAirHeight;
    private int color;
    public Matrix currentMatrix = new Matrix();
    private float baseAirCenterX;
    private float baseAirCenterY;
    private Paint deskPaint;

    public AirView(Context context) {
        this(context, null);
    }

    public AirView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AirView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AirView);
        color = ta.getColor(R.styleable.AirView_mColor, Color.BLACK);
        ta.recycle();  //注意回收
        init();
    }

    private void init() {
        deskPaint = new Paint();
        deskPaint.setColor(Color.GREEN);
        deskPaint.setStyle(Paint.Style.STROKE);
        deskPaint.setAntiAlias(true);
        //飞机轮廓
        airOutline = new Path();
        airOutline.moveTo(11217.9775280898f, 0);
        airOutline.lineTo(5235.05617977529f, -1246.44194756556f);
        airOutline.lineTo(2243.59550561798f, -1745.01872659178f);
        airOutline.lineTo(1246.44194756554f, -4237.90262172287f);
        airOutline.lineTo(-1246.44194756553f, -4487.19101123596f);
        airOutline.lineTo(-1495.73033707864f, -1994.3071161049f);
        airOutline.lineTo(-3490.03745318351f, -2243.595505618f);
        airOutline.lineTo(-4985.76779026217f, -3739.32584269665f);
        airOutline.lineTo(-5982.9213483146f, -3490.03745318353f);
        airOutline.lineTo(-5235.05617977527f, -1495.73033707868f);
        airOutline.lineTo(-5235.05617977527f, 1495.73033707862f);
        airOutline.lineTo(-5982.9213483146f, 3490.0374531835f);
        airOutline.lineTo(-4985.76779026217f, 3739.32584269662f);
        airOutline.lineTo(-3490.03745318351f, 2243.59550561797f);
        airOutline.lineTo(-1495.73033707864f, 1994.30711610484f);
        airOutline.lineTo(-1246.44194756553f, 4487.19101123593f);
        airOutline.lineTo(1246.44194756554f, 4237.90262172284f);
        airOutline.lineTo(2243.59550561798f, 1745.01872659175f);
        airOutline.lineTo(5235.05617977529f, 1246.44194756553f);
        airOutline.close();

        float airMaxX = 11217.9775280898f;
        float airMinX = -5982.9213483146f;
        float airMaxY = 4487.19101123593f;
        float airMinY = -4487.19101123596f;

//        飞机宽高
        baseAirWidth = (airMaxX - airMinX);
        baseAirHeight = (airMaxY - airMinY);

        //飞机中心点坐标
        baseAirCenterX = (airMaxX + airMinX) / 2;
        baseAirCenterY = (airMaxY + airMinY) / 2;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        float dx = (width / 2f - SCALE_RATIO * baseAirCenterX);
        float dy = (height / 2f - SCALE_RATIO * baseAirCenterY);
        this.currentMatrix.setScale(SCALE_RATIO, SCALE_RATIO);
        this.currentMatrix.postTranslate(dx, dy);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = getLeft();
        int top = getTop();


        Log.d("AirView", "left : " + left + ", top : " + top);

        canvas.setMatrix(this.currentMatrix);
        canvas.drawPath(airOutline, deskPaint);

    }
}
