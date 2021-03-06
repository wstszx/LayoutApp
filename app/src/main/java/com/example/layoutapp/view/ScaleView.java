package com.example.layoutapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.StringUtils;
import com.example.layoutapp.bean.Plan;
import com.example.layoutapp.utils.AirUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class ScaleView extends androidx.appcompat.widget.AppCompatImageView {
//    private final String path = "M345.768,8.462l-16.779,0l-1.798,2.308l-64.12,0l0,-7.692l-14.981,0l0,7.692l-14.382,0l-1.199,-0.769l-1.199,0l-1.198,0.769l-116.854,0l0,0.769l-10.787,0l-11.985,54.615l-4.794,-10l-8.989,0.769l-2.397,10.769l-73.708,9.231l0.599,3.077l-1.199,0l12.584,115.385l1.798,0.769l1.199,3.846l16.779,-3.077l14.981,21.538l72.509,7.692l0,6.923l1.199,0l0,6.154l6.592,0l0,5.385l61.723,0l0,0.769l30.562,0.769l1.199,3.846l7.191,0l1.199,-4.615l50.936,0l0.599,-0.769l25.169,0l1.198,2.308l6.592,0l1.198,-2.308l61.723,0l0.599,0.769l47.94,0l0,-0.769l62.322,0l0,0.769l66.517,0l2.996,-2.308l2.996,3.846l11.985,-10l5.393,-12.308l33.558,-30l13.783,0l4.195,-7.692l11.985,-0.769l4.195,5.385l104.869,-12.308l3.595,-3.846l25.768,-3.077l0,6.154l16.18,-2.308l-1.199,-5.385l2.397,-2.308l2.996,0l0,-80.769l-2.397,0l-2.397,-2.308l-40.15,-3.077l-4.794,-5.385l-75.506,-8.462l-38.352,0l-4.794,-3.846l-22.771,-0.769l-64.12,-60.769l-5.393,0l0,-3.077l-67.715,0.769l-49.738,12.308l-8.989,0l-0.599,-2.308l-20.375,0l0,-5.385l-2.397,0l0,7.692l-20.974,0l-0.599,0l-1.199,-2.308l-19.176,0z";

//    private final String path = "M7.52,21.48C4.25,19.94 1.91,16.76 1.55,13L0.05,13C0.56,19.16 5.71,24 12,24l0.66,-0.03 -3.81,-3.81 -1.33,1.32zM8.41,14.96c-0.19,0 -0.37,-0.03 -0.52,-0.08 -0.16,-0.06 -0.29,-0.13 -0.4,-0.24 -0.11,-0.1 -0.2,-0.22 -0.26,-0.37 -0.06,-0.14 -0.09,-0.3 -0.09,-0.47h-1.3c0,0.36 0.07,0.68 0.21,0.95 0.14,0.27 0.33,0.5 0.56,0.69 0.24,0.18 0.51,0.32 0.82,0.41 0.3,0.1 0.62,0.15 0.96,0.15 0.37,0 0.72,-0.05 1.03,-0.15 0.32,-0.1 0.6,-0.25 0.83,-0.44s0.42,-0.43 0.55,-0.72c0.13,-0.29 0.2,-0.61 0.2,-0.97 0,-0.19 -0.02,-0.38 -0.07,-0.56 -0.05,-0.18 -0.12,-0.35 -0.23,-0.51 -0.1,-0.16 -0.24,-0.3 -0.4,-0.43 -0.17,-0.13 -0.37,-0.23 -0.61,-0.31 0.2,-0.09 0.37,-0.2 0.52,-0.33 0.15,-0.13 0.27,-0.27 0.37,-0.42 0.1,-0.15 0.17,-0.3 0.22,-0.46 0.05,-0.16 0.07,-0.32 0.07,-0.48 0,-0.36 -0.06,-0.68 -0.18,-0.96 -0.12,-0.28 -0.29,-0.51 -0.51,-0.69 -0.2,-0.19 -0.47,-0.33 -0.77,-0.43C9.1,8.05 8.76,8 8.39,8c-0.36,0 -0.69,0.05 -1,0.16 -0.3,0.11 -0.57,0.26 -0.79,0.45 -0.21,0.19 -0.38,0.41 -0.51,0.67 -0.12,0.26 -0.18,0.54 -0.18,0.85h1.3c0,-0.17 0.03,-0.32 0.09,-0.45s0.14,-0.25 0.25,-0.34c0.11,-0.09 0.23,-0.17 0.38,-0.22 0.15,-0.05 0.3,-0.08 0.48,-0.08 0.4,0 0.7,0.1 0.89,0.31 0.19,0.2 0.29,0.49 0.29,0.86 0,0.18 -0.03,0.34 -0.08,0.49 -0.05,0.15 -0.14,0.27 -0.25,0.37 -0.11,0.1 -0.25,0.18 -0.41,0.24 -0.16,0.06 -0.36,0.09 -0.58,0.09L7.5,11.4v1.03h0.77c0.22,0 0.42,0.02 0.6,0.07s0.33,0.13 0.45,0.23c0.12,0.11 0.22,0.24 0.29,0.4 0.07,0.16 0.1,0.35 0.1,0.57 0,0.41 -0.12,0.72 -0.35,0.93 -0.23,0.23 -0.55,0.33 -0.95,0.33zM16.96,9.04c-0.32,-0.33 -0.7,-0.59 -1.14,-0.77 -0.43,-0.18 -0.92,-0.27 -1.46,-0.27L12,8v8h2.3c0.55,0 1.06,-0.09 1.51,-0.27 0.45,-0.18 0.84,-0.43 1.16,-0.76 0.32,-0.33 0.57,-0.73 0.74,-1.19 0.17,-0.47 0.26,-0.99 0.26,-1.57v-0.4c0,-0.58 -0.09,-1.1 -0.26,-1.57 -0.18,-0.47 -0.43,-0.87 -0.75,-1.2zM16.57,12.2c0,0.42 -0.05,0.79 -0.14,1.13 -0.1,0.33 -0.24,0.62 -0.43,0.85 -0.19,0.23 -0.43,0.41 -0.71,0.53 -0.29,0.12 -0.62,0.18 -0.99,0.18h-0.91L13.39,9.12h0.97c0.72,0 1.27,0.23 1.64,0.69 0.38,0.46 0.57,1.12 0.57,1.99v0.4zM12,0l-0.66,0.03 3.81,3.81 1.33,-1.33c3.27,1.55 5.61,4.72 5.96,8.48h1.5C23.44,4.84 18.29,0 12,0z";

    //    private final String path = "M1.2,153.85l1.2,6.15l-2.4,0l25.17,230.77l3.6,1.54l2.4,7.69l33.56,-6.15l29.96,43.08l145.02,15.38l0,13.85l2.4,0l0,12.31l13.18,0l0,10.77l123.45,0l0,1.54l61.12,1.54l2.4,7.69l14.38,0l2.4,-9.23l101.87,0l1.2,-1.54l50.34,0l2.4,4.62l13.18,0l2.4,-4.62l123.45,0l1.2,1.54l95.88,0l0,-1.54l124.64,0l0,1.54l133.03,0l5.99,-4.62l5.99,7.69l23.97,-20l10.79,-24.62l67.12,-60l27.57,0l8.39,-15.38l23.97,-1.54l8.39,10.77l209.74,-24.62l7.19,-7.69l51.54,-6.15l0,12.31l32.36,-4.62l-2.4,-10.77l4.79,-4.62l5.99,0l0,-161.54l-4.79,0l-4.79,-4.62l-80.3,-6.15l-9.59,-10.77l-151.01,-16.92l-76.7,0l-9.59,-7.69l-45.54,-1.54l-128.24,-121.54l-10.79,0l0,-6.15l-135.43,1.54l-99.48,24.62l-17.98,0l-1.2,-4.62l-40.75,0l0,-10.77l-4.79,0l0,15.38l-41.95,0l-1.2,0l-2.4,-4.62l-38.35,0l-3.6,-4.62l-33.56,0l-3.6,4.62l-128.24,0l0,-15.38l-29.96,0l0,15.38l-28.76,0l-2.4,-1.54l-2.4,0l-2.4,1.54l-233.71,0l0,1.54l-21.57,0l-23.97,109.23l-9.59,-20l-17.98,1.54l-4.79,21.54z";
//    ????????????path
//    private final String path = "M421.139,189.75L420.782,186.894L419.95,184.989L425.045,182.863L425.426,181.18L424.23699999999997,176.413H422.56899999999996L415.90299999999996,172.964L412.21299999999997,176.654C412.21299999999997,176.654,411.08799999999997,183.239,411.381,181.534C411.66999999999996,179.82999999999998,407.688,185.822,407.688,185.822L407.094,190.108L407.926,192.371L412.807,191.537L416.5,192.608L418.284,190.941L421.139,189.75Z";
//    ????????????
//    private final String path = "M153.889,69.508L156.216,69.494L154.788,74.019L156.81300000000002,76.399L157.049,78.065L161.574,82.589L162.76500000000001,86.042L168.71800000000002,86.399L171.33800000000002,88.664H172.76700000000002L176.22000000000003,96.043L179.67100000000002,104.974L177.88700000000003,110.331L178.24500000000003,112.35600000000001L175.03000000000003,117.83300000000001L175.86300000000003,122.11900000000001L187.05500000000004,126.88200000000002L199.08000000000004,128.67000000000002L211.58300000000003,137.241L215.63200000000003,138.67000000000002L215.86900000000003,140.931L218.48800000000003,146.40900000000002L221.10700000000003,153.555L224.44000000000003,159.508L222.53700000000003,161.77100000000002V165.818L218.25100000000003,167.84400000000002L207.65500000000003,172.12800000000001L200.74800000000002,177.847L195.86700000000002,180.107L195.03300000000002,183.56L196.46300000000002,200.11L192.532,199.514L190.74900000000002,200.94500000000002L164.43400000000003,206.06400000000002L160.74300000000002,208.92000000000002L161.10100000000003,215.82600000000002L169.07900000000004,222.37400000000002L166.45900000000003,226.66000000000003L162.76900000000003,228.32800000000003L162.17200000000003,230.35200000000003L163.00700000000003,232.61100000000002H165.02800000000002L166.22000000000003,234.04000000000002L158.48200000000003,236.657L153.95700000000002,234.99L151.57500000000002,233.566H145.86L135.62,228.924H129.074L123.95300000000002,230.352H118.23900000000002L109.30800000000002,235.231L102.16500000000002,234.397L95.02000000000002,236.897L89.06400000000002,234.98999999999998L85.37500000000003,231.77899999999997L75.85000000000002,230.35199999999998L69.65900000000002,234.63199999999998L66.20700000000002,233.20699999999997L63.349000000000025,230.94399999999996L56.44200000000002,229.27699999999996L55.37200000000002,228.08799999999997L52.51500000000002,227.85099999999997L42.73300000000002,233.79599999999996L32.69600000000002,232.54599999999996L31.87400000000002,232.18699999999995L32.98700000000002,223.56399999999996L28.463000000000022,222.37299999999996L19.057000000000023,215.47099999999998L16.437000000000022,215.22999999999996L14.414000000000023,210.70499999999996L15.841000000000022,206.06199999999995L15.364000000000022,203.80199999999996L11.913000000000022,201.53599999999997L10.721000000000021,199.27599999999998L3.5780000000000216,195.22699999999998V194.03799999999998L7.030000000000022,192.60699999999997L9.053000000000022,193.79699999999997L11.078000000000022,191.77199999999996L10.480000000000022,184.98699999999997L11.078000000000022,179.27099999999996L6.432000000000023,174.62899999999996L3.3370000000000224,175.46199999999996L2.1480000000000223,172.12599999999995L3.933000000000022,168.67399999999995L2.981000000000022,165.45999999999995L6.0190000000000214,162.71099999999996L7.267000000000022,161.52899999999997V158.91099999999997L11.552000000000021,156.88699999999997L15.83800000000002,156.05399999999997L19.649000000000022,154.62499999999997L22.748000000000022,155.45699999999997L25.008000000000024,154.62499999999997L25.841000000000022,155.21999999999997L26.197000000000024,158.07899999999998L28.219000000000023,158.91099999999997L32.98400000000002,158.67299999999997C32.98400000000002,158.67299999999997,36.550000000000026,153.94399999999996,38.462000000000025,152.59999999999997C40.373000000000026,151.25399999999996,49.65200000000002,154.98099999999997,49.65200000000002,154.98099999999997L55.36900000000002,150.93299999999996L71.92100000000002,147.24399999999997L72.99000000000002,144.97999999999996L74.42000000000003,138.66999999999996L79.06300000000003,134.97999999999996H80.49600000000004V133.07399999999996L80.73200000000004,117.23799999999996L81.56500000000004,114.02599999999995L77.04400000000004,112.35799999999995L76.80400000000004,111.16699999999994L81.56600000000005,109.73899999999995L93.95000000000005,108.66599999999995L95.85500000000005,111.16699999999996L100.14200000000005,112.11899999999996L101.33400000000005,112.35799999999996L102.99900000000005,110.09599999999996L100.73400000000005,107.83299999999996L109.90300000000005,89.25899999999996L111.33400000000005,88.30599999999995L119.66900000000004,92.35299999999995H123.35800000000003L125.02500000000003,94.61699999999995L133.00400000000005,92.11499999999995L135.02700000000004,78.90299999999995L138.47900000000004,76.63799999999995L142.52700000000004,76.39999999999995L145.38600000000005,72.94799999999995L146.45700000000005,69.49399999999996L148.72000000000006,68.30299999999995L153.889,69.508Z";


    private Paint deskPaint;
    private Path deskPath;
    private ArrayList<Plan> planList;
    private boolean isChecked;

    public Matrix deskMatrix = new Matrix();
    public float currentRotateDegrees = 1.0f;
    public float deskScale = 1.0f;
    public float deskWidth;
    public float deskHeight;
    public float deskCenterX;
    public float deskCenterY;

    private ArrayList<Matrix> matrixList;
    private int left;
    private int top;
    private Paint airPaint;
    private float width;
    private float height;
    //imageView?????????
    private PointF viewSize;
    //???????????????
    private PointF imageSize;
    //????????????????????????
    private PointF scaleSize = new PointF();
    //??????????????????????????????
    private PointF originScale = new PointF();
    //imageview???bitmap???xy????????????
    private PointF bitmapOriginPoint = new PointF();
    //????????????
    private PointF clickPoint = new PointF();
    //?????????????????????????????????
    private long doubleClickTimeSpan = 250;
    //?????????????????????
    private long lastClickTime = 0;
    //?????????????????????
    private int doubleClickZoom = 2;
    //?????????????????????
    private int zoomInMode = ZoomMode.Ordinary;
    //????????????????????????
    private PointF tempPoint = new PointF();
    //??????????????????
    private float maxScrole = 4;
    //?????????????????????
    private float doublePointDistance = 0;
    //??????????????????????????????
    private PointF doublePointCenter = new PointF();
    //?????????????????????
    private float doubleFingerScrole = 0;
    //???????????????????????????
    private int lastFingerNum = 0;
    private Path jkPath;
    private Matrix jkMatrix;
    private Paint numberPaint;
    private float centerFontY;
    private float jkWidth;
    private float jkHeight;
    private float jkCenterX;
    private float jkCenterY;
    private float deskDx;
    private float deskDy;
    private float jkDx;
    private float jkDy;
    private Paint dashPaint;

    //?????????????????????
    public class ZoomMode {
        public final static int Ordinary = 0;//??????
        public final static int ZoomIn = 1;//????????????
        public final static int TowFingerZoom = 2;//????????????
    }


    public ScaleView(Context context) {
        this(context, null);
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        setOnTouchListener(this);
        setScaleType(ScaleType.MATRIX);

        deskPaint = new Paint();
        deskPaint.setStyle(Paint.Style.STROKE);
        deskPaint.setAntiAlias(true);
        deskPaint.setTypeface(Typeface.DEFAULT_BOLD);


        airPaint = new Paint();
        airPaint.setStyle(Paint.Style.STROKE);
        airPaint.setAntiAlias(true);
        airPaint.setTypeface(Typeface.DEFAULT_BOLD);

        numberPaint = new Paint();
        numberPaint.setColor(Color.RED);
        numberPaint.setAntiAlias(true);
        numberPaint.setTextSize(18);
        numberPaint.setTypeface(Typeface.DEFAULT_BOLD);
        numberPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics numberFontMetrics = numberPaint.getFontMetrics();
        centerFontY = (numberFontMetrics.bottom - numberFontMetrics.top) / 2 - numberFontMetrics.bottom;//???????????????????????????

//        ??????paint
        dashPaint = new Paint();
        dashPaint.setAntiAlias(true);
        dashPaint.setStyle(Paint.Style.STROKE);
        dashPaint.setPathEffect(new DashPathEffect(new float[]{1000, 1000}, 0));

        deskMatrix = new Matrix();// ????????????

//        ????????????
        deskPath = AirUtils.getRealDesk1();
        float deskMaxX = 159090f;
        float deskMinX = -147306f;
        float deskMaxY = 33053f;
        float deskMinY = -41100f;

//        ????????????
        deskWidth = (deskMaxX - deskMinX);
        deskHeight = (deskMaxY - deskMinY);
//???????????????????????????
        deskCenterX = (deskMaxX + deskMinX) / 2;
        deskCenterY = (deskMaxY + deskMinY) / 2;

        //        ????????????
        jkPath = AirUtils.getRealJK();
//        ??????????????????
        float jkMaxX = 35000f;
        float jkMinX = -118000f;
        float jkMaxY = 13000f;
        float jkMinY = -28998.3247f;

        //        ??????????????????
        jkWidth = jkMaxX - jkMinX;
        jkHeight = jkMaxY - jkMinY;

        //???????????????????????????
        jkCenterX = (jkMaxX + jkMinX) / 2;
        jkCenterY = (jkMaxY + jkMinY) / 2;

        jkMatrix = new Matrix();// ????????????

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        viewSize = new PointF(width, height);
        Log.d("ScaleView", "onMeasure: widthMeasureSpec:" + width + "heightMeasureSpec:" + height + "width:" + getWidth() + "height:" + getHeight());

//        ????????????
        float ratioT = deskWidth / deskHeight;
//        ????????????
        float ratioScreen = width * 1.0f / height;


        if (ratioT > ratioScreen) {
            this.deskScale = width / deskWidth;
            bitmapOriginPoint.x = 0;
            bitmapOriginPoint.y = viewSize.y / 2 - deskScale * deskHeight / 2;
            Log.d("ScaleViewSize", "bitmapOriginPoint.x : " + bitmapOriginPoint.x + ", bitmapOriginPoint.y : " + bitmapOriginPoint.y);
        } else {
            this.deskScale = height / deskHeight;
            bitmapOriginPoint.x = viewSize.x / 2 - deskScale * deskWidth / 2;
            bitmapOriginPoint.y = 0;
        }
        deskDx = (width / 2f - this.deskScale * deskCenterX);
        deskDy = (height / 4f - this.deskScale * deskCenterY);

        this.deskMatrix.setScale(this.deskScale, this.deskScale);
        this.deskMatrix.postTranslate(deskDx, deskDy);

        jkDx = (width / 2f - this.deskScale * jkCenterX + (jkCenterX - deskCenterX) * deskScale);
        jkDy = (height / 4f * 3 - this.deskScale * jkCenterY + (jkCenterY - deskCenterY) * deskScale);
        jkMatrix.setScale(this.deskScale, this.deskScale);
        jkMatrix.postTranslate(jkDx, jkDy);

        scaleSize.set(deskScale * deskWidth, deskScale * deskHeight);

        //??????????????????????????????
        originScale.set(deskScale, deskScale);
        doubleFingerScrole = deskScale;


//        showCenter();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("ScaleView", "onDraw: ");

        width = this.getWidth();
        height = this.getHeight();

        left = getLeft();
        top = getTop();

        if (planList != null && planList.size() > 0) {
            for (Plan plan : planList) {
                canvas.save();
                if (StringUtils.isEmpty(plan.getPlanstano())) {
                    airPaint.setColor(Color.BLACK);
                } else {
                    if (plan.getAlternative() == 0) {
                        airPaint.setColor(Color.BLUE);
                    } else if (plan.getAlternative() == 1) {
                        airPaint.setColor(Color.YELLOW);
                    }
                }
//                ???????????????????????????
                if (!isChecked) {
                    //?????????????????????????????????  0?????? 1??????
                    if (plan.getStationtype1() == 0) {
                        canvas.translate(jkDx + plan.getCox1() * deskScale,
                                jkDy - plan.getCoy1() * deskScale);
                    } else if (plan.getStationtype1() == 1) {
                        canvas.translate(deskDx + plan.getCox1() * deskScale,
                                deskDy - plan.getCoy1() * deskScale);
                    }
                    canvas.rotate(360 - plan.getAngle1());
                    //                ??????1-7    2567 ???18   3???9    1,4???15
//                        ??????????????????
                    canvas.drawText(plan.getStano() + "-" + plan.getGoodname(), 0,
                            centerFontY, numberPaint);
                    canvas.scale(this.deskScale, this.deskScale);
                    switch (plan.getTypeno()) {
                        case 2:
                        case 5:
                        case 6:
                        case 7:
                            if (plan.getShapetype() == 0) {
                                canvas.drawPath(AirUtils.getJ18Collapse(), airPaint);
                            } else if (plan.getShapetype() == 1) {
                                canvas.drawPath(AirUtils.getJ18Expand(), airPaint);
                            }
                            break;
                        case 3:
                            if (plan.getShapetype() == 0) {
                                canvas.drawPath(AirUtils.getZ9Collapse(), airPaint);
                            } else if (plan.getShapetype() == 1) {
                                canvas.drawPath(AirUtils.getZ9Expand(), airPaint);
                                canvas.drawPath(AirUtils.getZ9ExpandCircle(), airPaint);
                            }
                            break;
                        case 1:
                        case 4:
                            if (plan.getShapetype() == 0) {
                                canvas.drawPath(AirUtils.getJ15Collapse(), airPaint);
                            } else if (plan.getShapetype() == 1) {
                                canvas.drawPath(AirUtils.getJ15Expand(), airPaint);
                            }
                            break;
                    }
                } else {
                    if (!StringUtils.isEmpty(plan.getPlanstano()) && !StringUtils.equals(plan.getPlanstano(), "InSky")) {
//                        ?????????????????????????????????
                        if (plan.getStationtype2() == 0) {
                            canvas.translate(jkDx + plan.getCox2() * deskScale,
                                    jkDy - plan.getCoy2() * deskScale);
                        } else if (plan.getStationtype2() == 1) {
                            canvas.translate(deskDx + plan.getCox2() * deskScale,
                                    deskDy - plan.getCoy2() * deskScale);
                        }
                        canvas.rotate(360 - plan.getAngle2());
                        //                ??????1-7    2567 ???18   3???9    1,4???15
                        //                        ??????????????????
                        canvas.drawText(plan.getPlanstano() + "-" + plan.getGoodname(), 0,
                                centerFontY, numberPaint);
                        canvas.scale(this.deskScale, this.deskScale);
                        switch (plan.getTypeno()) {
                            case 2:
                            case 5:
                            case 6:
                            case 7:
                                if (plan.getPlanshapetype() == 0) {
                                    canvas.drawPath(AirUtils.getJ18Collapse(), airPaint);
                                } else if (plan.getPlanshapetype() == 1) {
                                    canvas.drawPath(AirUtils.getJ18Expand(), airPaint);
                                }
                                break;
                            case 3:
                                if (plan.getPlanshapetype() == 0) {
                                    canvas.drawPath(AirUtils.getZ9Collapse(), airPaint);
                                } else if (plan.getPlanshapetype() == 1) {
                                    canvas.drawPath(AirUtils.getZ9Expand(), airPaint);
                                    canvas.drawPath(AirUtils.getZ9ExpandCircle(), airPaint);
                                }
                                break;
                            case 1:
                            case 4:
                                if (plan.getPlanshapetype() == 0) {
                                    canvas.drawPath(AirUtils.getJ15Collapse(), airPaint);
                                } else if (plan.getPlanshapetype() == 1) {
                                    canvas.drawPath(AirUtils.getJ15Expand(), airPaint);
                                }
                                break;
                        }
                    }
                }

                canvas.restore();
            }
        }
        canvas.save();

        canvas.concat(this.deskMatrix);

        canvas.drawPath(deskPath, deskPaint);
        canvas.drawPath(AirUtils.getFJLifts1(), deskPaint);
        canvas.drawPath(AirUtils.getRunway1(), deskPaint);
        canvas.drawPath(AirUtils.getTakeoffLine1(), deskPaint);
        canvas.drawPath(AirUtils.getInterceptionCable1(), deskPaint);
        canvas.drawPath(AirUtils.getJianDao(), deskPaint);
        canvas.drawPath(AirUtils.getSafeArea(), deskPaint);
        canvas.drawPath(AirUtils.getPianLiuBan(), deskPaint);
        canvas.drawText("1fefefefef", AirUtils.ZSJQJPointInfo.centerPF1.x,
                AirUtils.ZSJQJPointInfo.centerPF1.y, numberPaint);

//        ????????????????????????
//        ?????????
        canvas.drawCircle(AirUtils.ZSJQJPointInfo.centerPF1.x,
                AirUtils.ZSJQJPointInfo.centerPF1.y,
                AirUtils.ZSJQJPointInfo.circleWidth.x, deskPaint);
        canvas.drawCircle(AirUtils.ZSJQJPointInfo.centerPF2.x,
                AirUtils.ZSJQJPointInfo.centerPF2.y,
                AirUtils.ZSJQJPointInfo.circleWidth.x, deskPaint);
        canvas.drawCircle(AirUtils.ZSJQJPointInfo.centerPF3.x,
                AirUtils.ZSJQJPointInfo.centerPF3.y,
                AirUtils.ZSJQJPointInfo.circleWidth.x, deskPaint);
        canvas.drawCircle(AirUtils.ZSJQJPointInfo.centerPF4.x,
                AirUtils.ZSJQJPointInfo.centerPF4.y,
                AirUtils.ZSJQJPointInfo.circleWidth.x, deskPaint);
//?????????
        canvas.drawCircle(AirUtils.ZSJQJPointInfo.centerPF1.x,
                AirUtils.ZSJQJPointInfo.centerPF1.y,
                AirUtils.ZSJQJPointInfo.circleWidth.y, dashPaint);
        canvas.drawCircle(AirUtils.ZSJQJPointInfo.centerPF2.x,
                AirUtils.ZSJQJPointInfo.centerPF2.y,
                AirUtils.ZSJQJPointInfo.circleWidth.y, dashPaint);
        canvas.drawCircle(AirUtils.ZSJQJPointInfo.centerPF3.x,
                AirUtils.ZSJQJPointInfo.centerPF3.y,
                AirUtils.ZSJQJPointInfo.circleWidth.y, dashPaint);
        canvas.drawCircle(AirUtils.ZSJQJPointInfo.centerPF4.x,
                AirUtils.ZSJQJPointInfo.centerPF4.y,
                AirUtils.ZSJQJPointInfo.circleWidth.y, dashPaint);

        canvas.drawLine(AirUtils.ZSJQJPointInfo.linePF1[0],
                AirUtils.ZSJQJPointInfo.linePF1[1],
                AirUtils.ZSJQJPointInfo.linePF1[2],
                AirUtils.ZSJQJPointInfo.linePF1[3], deskPaint);
        canvas.drawLine(AirUtils.ZSJQJPointInfo.linePF2[0],
                AirUtils.ZSJQJPointInfo.linePF2[1],
                AirUtils.ZSJQJPointInfo.linePF2[2],
                AirUtils.ZSJQJPointInfo.linePF2[3], deskPaint);
        canvas.drawLine(AirUtils.ZSJQJPointInfo.linePF3[0],
                AirUtils.ZSJQJPointInfo.linePF3[1],
                AirUtils.ZSJQJPointInfo.linePF3[2],
                AirUtils.ZSJQJPointInfo.linePF3[3], deskPaint);
        canvas.drawLine(AirUtils.ZSJQJPointInfo.linePF4[0],
                AirUtils.ZSJQJPointInfo.linePF4[1],
                AirUtils.ZSJQJPointInfo.linePF4[2],
                AirUtils.ZSJQJPointInfo.linePF4[3], deskPaint);
//        ?????????
//        canvas.drawText("2", AirUtils1.ZSJQJPointInfo.centerPF2.x, AirUtils1.ZSJQJPointInfo.centerPF2.y + centerFontY, deskPaint);
//        canvas.drawText("3", AirUtils1.ZSJQJPointInfo.centerPF3.x, AirUtils1.ZSJQJPointInfo.centerPF3.y + centerFontY, deskPaint);
//        canvas.drawText("4", AirUtils1.ZSJQJPointInfo.centerPF4.x, AirUtils1.ZSJQJPointInfo.centerPF4.y + centerFontY, deskPaint);


//?????????
        canvas.restore();
        canvas.concat(jkMatrix);
        canvas.drawPath(jkPath, deskPaint);
        canvas.drawPath(AirUtils.getFJLifts1(), deskPaint);
        canvas.drawCircle(AirUtils.getTurntable1().x, AirUtils.getTurntable1().y, 3500, deskPaint);
        canvas.drawCircle(AirUtils.getTurntable2().x, AirUtils.getTurntable2().y, 3500, deskPaint);
        canvas.drawPath(AirUtils.getFireCurtain1(), dashPaint);
        canvas.drawPath(AirUtils.getHangarDoor1(), deskPaint);

    }

    public void drawAir(@NotNull ArrayList<Plan> planList, boolean isChecked) {
        this.planList = planList;
        this.isChecked = isChecked;
        invalidate();

//        matrixList = new ArrayList<>();
//        for (int i = 0; i < planList.size(); i++) {
//            Plan plan = planList.get(i);
//            Matrix matrix = new Matrix();
//            matrix.setScale(this.deskScale, this.deskScale);
//            matrix.postRotate(360 - plan.getAngle());
////            ????????????????????????????????????
////            realBaseCenter * deskScale ?????????????????????????????????
////            Log.d("mylog", "drawAir: " + width / 2 + "=-==" + height / 2);
//            if (!isChecked) {
//                matrix.postTranslate(realDx + realBaseCenterX * deskScale + plan.getCox() * deskScale,
//                        realDy + realBaseCenterY * deskScale - plan.getCoy() * deskScale);
//            } else {
//                matrix.postTranslate(realDx + realBaseCenterX * deskScale + plan.getPlancox() * deskScale,
//                        realDy + realBaseCenterY * deskScale - plan.getPlancoy() * deskScale);
//            }
//            plan.setMatrix(matrix);
//        }
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (event.getAction() & MotionEvent.ACTION_MASK) {
//            case MotionEvent.ACTION_DOWN:
//                //??????????????????
//                //??????????????????????????????
//                clickPoint.set(event.getX(), event.getY());
//                Log.d("ScaleViewSize", "event.getRawX() : " + event.getRawX() + ", event.getRawY() : " + event.getRawY());
//                //???????????????????????????????????????????????????????????????????????????????????????????????????
//                if (event.getPointerCount() == 1) {
//                    //????????????????????????????????????????????????????????????
//                    if (System.currentTimeMillis() - lastClickTime <= doubleClickTimeSpan) {
//                        //?????????????????????????????????????????????????????????????????????
//                        if (zoomInMode == ZoomMode.Ordinary) {
//                            //?????????????????????????????????????????????x,y?????????????????????x,y?????????????????????????????????????????????????????????????????????????????????
//                            tempPoint.set((clickPoint.x - bitmapOriginPoint.x) / scaleSize.x, (clickPoint.y - bitmapOriginPoint.y) / scaleSize.y);
//                            //????????????
//                            scaleImage(new PointF(originScale.x * doubleClickZoom, originScale.y * doubleClickZoom));
//                            //????????????????????????????????????xy??????
//                            getBitmapOffset();
//                            Log.e("kzg", "9**********************bitmapOriginPoint:" + bitmapOriginPoint);
//                            //??????????????????????????????????????????????????????????????????????????????????????????xy????????????????????????????????????xy???????????????????????????????????????????????????
//                            float v1 = clickPoint.x - (bitmapOriginPoint.x + tempPoint.x * scaleSize.x);
//                            float v2 = clickPoint.y - (bitmapOriginPoint.y + tempPoint.y * scaleSize.y + viewSize.y / 2 - baseHeight * currentScale / 2);
//
////                            translationImage(new PointF(clickPoint.x - (bitmapOriginPoint.x + tempPoint.x * scaleSize.x),
////                                    clickPoint.y - (bitmapOriginPoint.y + tempPoint.y * scaleSize.y  + viewSize.y / 2 - baseHeight * originScale.x * doubleClickZoom / 2)));
//
//                            zoomInMode = ZoomMode.ZoomIn;
//                            doubleFingerScrole = originScale.x * doubleClickZoom;
//                        } else {
//                            //????????????
//                            showCenter();
//                            zoomInMode = ZoomMode.Ordinary;
//                        }
//                    } else {
//                        lastClickTime = System.currentTimeMillis();
//                    }
//                }
//                break;
//            case MotionEvent.ACTION_POINTER_DOWN:
//                //????????????????????????????????? ?????????????????????????????????
//                //??????????????????????????????????????????
//                doublePointDistance = getDoubleFingerDistance(event);
//                break;
//            case MotionEvent.ACTION_POINTER_UP:
//                //????????????????????????????????? ?????????????????????????????????
//                //?????????????????????????????????????????????????????????????????????????????????????????????????????????
//                zoomInMode = ZoomMode.ZoomIn;
//                //?????????????????????????????????
//                doubleFingerScrole = scaleSize.x / baseWidth * currentScale;
//                //???????????????????????????????????????
//                lastFingerNum = 1;
//                //??????????????????????????????????????????????????????????????????????????????????????????
//                if (scaleSize.x < viewSize.x && scaleSize.y < viewSize.y) {
//                    zoomInMode = ZoomMode.Ordinary;
//                    showCenter();
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
//                //???????????????????????????
//                /**************************************??????*******************************************/
//                if (zoomInMode != ZoomMode.Ordinary) {
//                    //?????????????????????????????????????????????????????????
//                    float currentX = 0;
//                    float currentY = 0;
//                    //????????????????????????????????????????????????
//                    int pointCount = event.getPointerCount();
//                    //?????????????????????????????????
//                    for (int i = 0; i < pointCount; i++) {
//                        currentX += event.getX(i);
//                        currentY += event.getY(i);
//                    }
//                    currentX /= pointCount;
//                    currentY /= pointCount;
//                    //???????????????????????????????????????????????????????????????????????????????????????????????????
//                    if (lastFingerNum != event.getPointerCount()) {
//                        clickPoint.x = currentX;
//                        clickPoint.y = currentY;
//                        lastFingerNum = event.getPointerCount();
//                    }
//                    //????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
//                    float moveX = currentX - clickPoint.x;
//                    float moveY = currentY - clickPoint.y;
//                    //????????????????????????????????????????????????????????????????????????????????????????????????????????????
//                    //?????????????????????????????????
//                    float[] moveFloat = moveBorderDistance(moveX, moveY);
//                    //???????????????????????????
//                    translationImage(new PointF(moveFloat[0], moveFloat[1]));
//                    clickPoint.set(currentX, currentY);
//                }
//                /**************************************??????*******************************************/
//                //???????????????????????????????????????????????????????????????
//                if (event.getPointerCount() == 2) {
//                    //?????????????????????????????????????????????????????????????????????????????????????????????
//                    if ((scaleSize.x / baseWidth * currentScale >= originScale.x * maxScrole || scaleSize.y / baseHeight * currentScale >= originScale.y * maxScrole) && getDoubleFingerDistance(event) - doublePointDistance > 0) {
//                        break;
//                    }
//                    //??????????????????????????????????????????????????????50????????????????????????????????????????????????????????????????????????????????????
//                    if (Math.abs(getDoubleFingerDistance(event) - doublePointDistance) > 50 && zoomInMode != ZoomMode.TowFingerZoom) {
//                        //???????????????????????????????????????????????????????????????
//                        doublePointCenter.set((event.getX(0) + event.getX(1)) / 2, (event.getY(0) + event.getY(1)) / 2);
//                        //?????????????????????????????????????????????
//                        clickPoint.set(doublePointCenter);
//                        //????????????????????????????????????
//                        getBitmapOffset();
//                        //?????????????????????????????????????????????x,y?????????????????????x,y?????????????????????????????????????????????????????????????????????????????????
//                        tempPoint.set((clickPoint.x - bitmapOriginPoint.x) / scaleSize.x, (clickPoint.y - bitmapOriginPoint.y) / scaleSize.y);
//                        //??????????????????????????????
//                        zoomInMode = ZoomMode.TowFingerZoom;
//                    }
//                    //???????????????????????????????????????????????????????????????????????????????????????
//                    if (zoomInMode == ZoomMode.TowFingerZoom) {
//                        //?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
//                        float scrole = doubleFingerScrole * getDoubleFingerDistance(event) / doublePointDistance;
//                        //???????????????????????????????????????
//                        scaleImage(new PointF(scrole, scrole));
//                        getBitmapOffset();
//                        translationImage(new PointF(clickPoint.x - (bitmapOriginPoint.x + tempPoint.x * scaleSize.x), clickPoint.y - (bitmapOriginPoint.y + tempPoint.y * scaleSize.y)));
//                    }
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                //???????????????????????????
//                Log.e("kzg", "***********************ACTION_UP");
//                lastFingerNum = 0;
//                break;
//        }
//        return true;
//    }

    /**
     * ??????????????????????????????
     */
//    private void showCenter() {
//        Log.d("ScaleView", "showCenter: ");
//        float scalex = width / baseWidth;
//        float scaley = height / baseHeight;
//
//        float scale = Math.min(scalex, scaley);
//        scaleImage(new PointF(scale, scale));
//
//        //???????????????????????????????????????????????????????????????????????????
//        if (scalex < scaley) {
//            translationImage(new PointF(0, viewSize.y / 2 - scaleSize.y / 2));
//            bitmapOriginPoint.x = 0;
//            bitmapOriginPoint.y = viewSize.y / 2 - scaleSize.y / 2;
//        } else {
//            translationImage(new PointF(viewSize.x / 2 - scaleSize.x / 2, 0));
//            bitmapOriginPoint.x = viewSize.x / 2 - scaleSize.x / 2;
//            bitmapOriginPoint.y = 0;
//        }
//        //??????????????????????????????
//        originScale.set(scale, scale);
//        doubleFingerScrole = scale;
//    }

//    public void scaleImage(PointF scaleXY) {
//        deskMatrix.setScale(scaleXY.x, scaleXY.y);
//        scaleSize.set(scaleXY.x * baseWidth, scaleXY.y * baseHeight);
//        setImageMatrix(deskMatrix);
//    }

    /**
     * ???????????????x???y??????????????????
     *
     * @param pointF
     */
//    public void translationImage(PointF pointF) {
//        Log.d("ScaleView", "translationImage: ");
//        deskMatrix.postTranslate(pointF.x, pointF.y);
//        setImageMatrix(deskMatrix);
//    }

    /**
     * ???????????????????????????????????????????????????
     *
     * @param moveX
     * @param moveY
     * @return
     */
//    public float[] moveBorderDistance(float moveX, float moveY) {
//        //??????bitmap??????????????????
//        getBitmapOffset();
//        Log.e("kzg", "**********************moveBorderDistance--bitmapOriginPoint:" + bitmapOriginPoint);
//        //??????bitmap??????????????????
//        float bitmapRightBottomX = bitmapOriginPoint.x + scaleSize.x;
//        float bitmapRightBottomY = bitmapOriginPoint.y + scaleSize.y;
//
//        if (moveY > 0) {
//            //?????????
//            if (bitmapOriginPoint.y + moveY > 0) {
//                if (bitmapOriginPoint.y < 0) {
//                    moveY = -bitmapOriginPoint.y;
//                } else {
//                    moveY = 0;
//                }
//            }
//        } else if (moveY < 0) {
//            //?????????
//            if (bitmapRightBottomY + moveY < viewSize.y) {
//                if (bitmapRightBottomY > viewSize.y) {
//                    moveY = -(bitmapRightBottomY - viewSize.y);
//                } else {
//                    moveY = 0;
//                }
//            }
//        }
//
//        if (moveX > 0) {
//            //?????????
//            if (bitmapOriginPoint.x + moveX > 0) {
//                if (bitmapOriginPoint.x < 0) {
//                    moveX = -bitmapOriginPoint.x;
//                } else {
//                    moveX = 0;
//                }
//            }
//        } else if (moveX < 0) {
//            //?????????
//            if (bitmapRightBottomX + moveX < viewSize.x) {
//                if (bitmapRightBottomX > viewSize.x) {
//                    moveX = -(bitmapRightBottomX - viewSize.x);
//                } else {
//                    moveX = 0;
//                }
//            }
//        }
//        return new float[]{moveX, moveY};
//    }

    /**
     * ??????view???bitmap????????????
     */
//    public void getBitmapOffset() {
//        float[] value = new float[9];
//        float[] offset = new float[2];
//        Matrix imageMatrix = getImageMatrix();
//        imageMatrix.getValues(value);
//        offset[0] = value[2];
//        offset[1] = value[5];
//        bitmapOriginPoint.set(offset[0], offset[1]);
//    }


    /**
     * ??????????????????????????????
     * <p>
     * //     * @param event
     *
     * @return
     */
//    public static float getDoubleFingerDistance(MotionEvent event) {
//        float x = event.getX(0) - event.getX(1);
//        float y = event.getY(0) - event.getY(1);
//        return (float) Math.sqrt(x * x + y * y);
//    }


//    private PointF midPoint(MotionEvent event) {
//        return MapMath.getMidPointBetweenTwoPoints(event.getX(0), event.getY(0)
//                , event.getX(1), event.getY(1));
//    }
//
//    private float distance(MotionEvent event, PointF mid) {
//        return MapMath.getDistanceBetweenTwoPoints(event.getX(0), event.getY(0)
//                , mid.x, mid.y);
//    }
//
//    private float rotation(MotionEvent event, PointF mid) {
//        return MapMath.getDegreeBetweenTwoPoints(event.getX(0), event.getY(0)
//                , mid.x, mid.y);
//    }
//
//    public static class ZoomListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
//        @Override
//        public boolean onScale(ScaleGestureDetector detector) {
//            float scaleFactor = detector.getScaleFactor();
//            return true;
//        }
//    }


//    public void mapCenterWithPoint(float x, float y) {
//        float[] goal = {x, y};
//        this.deskMatrix.mapPoints(goal);
//        float deltaX = this.getWidth() / 2.0f - goal[0];
//        float deltaY = this.getHeight() / 2.0f - goal[1];
//        this.deskMatrix.postTranslate(deltaX, deltaY);
//    }
//
//    public void setCurrentRotateDegrees(float degrees, float x, float y) {
//        deskMatrix.postRotate(degrees - this.currentRotateDegrees, x, y);
//
//        currentRotateDegrees = degrees % 360;
//    }
//
//    public void rotate(float d) {
//        mapCenterWithPoint((float) center.getX(), (float) center.getY());
//        setCurrentRotateDegrees(d * 360, this.getWidth() / 2.0f, this.getHeight() / 2.0f);
//    }
//
//    public void scaleImg(int progress) {
////        deskMatrix.setScale(originScale.x * doubleClickZoom,originScale.y * doubleClickZoom);
//        deskMatrix.setScale(originScale.x * 3f, originScale.y * 3f);
////        deskMatrix.postTranslate(200, 200);
//        invalidate();
////        setImageMatrix(deskMatrix);
////        deskMatrix.postScale(progress, progress, width / 2, height / 2);
//    }
}
