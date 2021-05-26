package com.example.layoutapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import androidx.annotation.Nullable;

import com.example.layoutapp.bean.Plan;
import com.example.layoutapp.bean.Position;
import com.example.layoutapp.utils.MapMath;
import com.example.layoutapp.utils.SvgPathToAndroidPath;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class ScaleView2 extends androidx.appcompat.widget.AppCompatImageView {
//    private final String path = "M345.768,8.462l-16.779,0l-1.798,2.308l-64.12,0l0,-7.692l-14.981,0l0,7.692l-14.382,0l-1.199,-0.769l-1.199,0l-1.198,0.769l-116.854,0l0,0.769l-10.787,0l-11.985,54.615l-4.794,-10l-8.989,0.769l-2.397,10.769l-73.708,9.231l0.599,3.077l-1.199,0l12.584,115.385l1.798,0.769l1.199,3.846l16.779,-3.077l14.981,21.538l72.509,7.692l0,6.923l1.199,0l0,6.154l6.592,0l0,5.385l61.723,0l0,0.769l30.562,0.769l1.199,3.846l7.191,0l1.199,-4.615l50.936,0l0.599,-0.769l25.169,0l1.198,2.308l6.592,0l1.198,-2.308l61.723,0l0.599,0.769l47.94,0l0,-0.769l62.322,0l0,0.769l66.517,0l2.996,-2.308l2.996,3.846l11.985,-10l5.393,-12.308l33.558,-30l13.783,0l4.195,-7.692l11.985,-0.769l4.195,5.385l104.869,-12.308l3.595,-3.846l25.768,-3.077l0,6.154l16.18,-2.308l-1.199,-5.385l2.397,-2.308l2.996,0l0,-80.769l-2.397,0l-2.397,-2.308l-40.15,-3.077l-4.794,-5.385l-75.506,-8.462l-38.352,0l-4.794,-3.846l-22.771,-0.769l-64.12,-60.769l-5.393,0l0,-3.077l-67.715,0.769l-49.738,12.308l-8.989,0l-0.599,-2.308l-20.375,0l0,-5.385l-2.397,0l0,7.692l-20.974,0l-0.599,0l-1.199,-2.308l-19.176,0z";

//    private final String path = "M7.52,21.48C4.25,19.94 1.91,16.76 1.55,13L0.05,13C0.56,19.16 5.71,24 12,24l0.66,-0.03 -3.81,-3.81 -1.33,1.32zM8.41,14.96c-0.19,0 -0.37,-0.03 -0.52,-0.08 -0.16,-0.06 -0.29,-0.13 -0.4,-0.24 -0.11,-0.1 -0.2,-0.22 -0.26,-0.37 -0.06,-0.14 -0.09,-0.3 -0.09,-0.47h-1.3c0,0.36 0.07,0.68 0.21,0.95 0.14,0.27 0.33,0.5 0.56,0.69 0.24,0.18 0.51,0.32 0.82,0.41 0.3,0.1 0.62,0.15 0.96,0.15 0.37,0 0.72,-0.05 1.03,-0.15 0.32,-0.1 0.6,-0.25 0.83,-0.44s0.42,-0.43 0.55,-0.72c0.13,-0.29 0.2,-0.61 0.2,-0.97 0,-0.19 -0.02,-0.38 -0.07,-0.56 -0.05,-0.18 -0.12,-0.35 -0.23,-0.51 -0.1,-0.16 -0.24,-0.3 -0.4,-0.43 -0.17,-0.13 -0.37,-0.23 -0.61,-0.31 0.2,-0.09 0.37,-0.2 0.52,-0.33 0.15,-0.13 0.27,-0.27 0.37,-0.42 0.1,-0.15 0.17,-0.3 0.22,-0.46 0.05,-0.16 0.07,-0.32 0.07,-0.48 0,-0.36 -0.06,-0.68 -0.18,-0.96 -0.12,-0.28 -0.29,-0.51 -0.51,-0.69 -0.2,-0.19 -0.47,-0.33 -0.77,-0.43C9.1,8.05 8.76,8 8.39,8c-0.36,0 -0.69,0.05 -1,0.16 -0.3,0.11 -0.57,0.26 -0.79,0.45 -0.21,0.19 -0.38,0.41 -0.51,0.67 -0.12,0.26 -0.18,0.54 -0.18,0.85h1.3c0,-0.17 0.03,-0.32 0.09,-0.45s0.14,-0.25 0.25,-0.34c0.11,-0.09 0.23,-0.17 0.38,-0.22 0.15,-0.05 0.3,-0.08 0.48,-0.08 0.4,0 0.7,0.1 0.89,0.31 0.19,0.2 0.29,0.49 0.29,0.86 0,0.18 -0.03,0.34 -0.08,0.49 -0.05,0.15 -0.14,0.27 -0.25,0.37 -0.11,0.1 -0.25,0.18 -0.41,0.24 -0.16,0.06 -0.36,0.09 -0.58,0.09L7.5,11.4v1.03h0.77c0.22,0 0.42,0.02 0.6,0.07s0.33,0.13 0.45,0.23c0.12,0.11 0.22,0.24 0.29,0.4 0.07,0.16 0.1,0.35 0.1,0.57 0,0.41 -0.12,0.72 -0.35,0.93 -0.23,0.23 -0.55,0.33 -0.95,0.33zM16.96,9.04c-0.32,-0.33 -0.7,-0.59 -1.14,-0.77 -0.43,-0.18 -0.92,-0.27 -1.46,-0.27L12,8v8h2.3c0.55,0 1.06,-0.09 1.51,-0.27 0.45,-0.18 0.84,-0.43 1.16,-0.76 0.32,-0.33 0.57,-0.73 0.74,-1.19 0.17,-0.47 0.26,-0.99 0.26,-1.57v-0.4c0,-0.58 -0.09,-1.1 -0.26,-1.57 -0.18,-0.47 -0.43,-0.87 -0.75,-1.2zM16.57,12.2c0,0.42 -0.05,0.79 -0.14,1.13 -0.1,0.33 -0.24,0.62 -0.43,0.85 -0.19,0.23 -0.43,0.41 -0.71,0.53 -0.29,0.12 -0.62,0.18 -0.99,0.18h-0.91L13.39,9.12h0.97c0.72,0 1.27,0.23 1.64,0.69 0.38,0.46 0.57,1.12 0.57,1.99v0.4zM12,0l-0.66,0.03 3.81,3.81 1.33,-1.33c3.27,1.55 5.61,4.72 5.96,8.48h1.5C23.44,4.84 18.29,0 12,0z";

    //    private final String path = "M1.2,153.85l1.2,6.15l-2.4,0l25.17,230.77l3.6,1.54l2.4,7.69l33.56,-6.15l29.96,43.08l145.02,15.38l0,13.85l2.4,0l0,12.31l13.18,0l0,10.77l123.45,0l0,1.54l61.12,1.54l2.4,7.69l14.38,0l2.4,-9.23l101.87,0l1.2,-1.54l50.34,0l2.4,4.62l13.18,0l2.4,-4.62l123.45,0l1.2,1.54l95.88,0l0,-1.54l124.64,0l0,1.54l133.03,0l5.99,-4.62l5.99,7.69l23.97,-20l10.79,-24.62l67.12,-60l27.57,0l8.39,-15.38l23.97,-1.54l8.39,10.77l209.74,-24.62l7.19,-7.69l51.54,-6.15l0,12.31l32.36,-4.62l-2.4,-10.77l4.79,-4.62l5.99,0l0,-161.54l-4.79,0l-4.79,-4.62l-80.3,-6.15l-9.59,-10.77l-151.01,-16.92l-76.7,0l-9.59,-7.69l-45.54,-1.54l-128.24,-121.54l-10.79,0l0,-6.15l-135.43,1.54l-99.48,24.62l-17.98,0l-1.2,-4.62l-40.75,0l0,-10.77l-4.79,0l0,15.38l-41.95,0l-1.2,0l-2.4,-4.62l-38.35,0l-3.6,-4.62l-33.56,0l-3.6,4.62l-128.24,0l0,-15.38l-29.96,0l0,15.38l-28.76,0l-2.4,-1.54l-2.4,0l-2.4,1.54l-233.71,0l0,1.54l-21.57,0l-23.97,109.23l-9.59,-20l-17.98,1.54l-4.79,21.54z";
//    北京地图path
//    private final String path = "M421.139,189.75L420.782,186.894L419.95,184.989L425.045,182.863L425.426,181.18L424.23699999999997,176.413H422.56899999999996L415.90299999999996,172.964L412.21299999999997,176.654C412.21299999999997,176.654,411.08799999999997,183.239,411.381,181.534C411.66999999999996,179.82999999999998,407.688,185.822,407.688,185.822L407.094,190.108L407.926,192.371L412.807,191.537L416.5,192.608L418.284,190.941L421.139,189.75Z";
//    新疆地图
//    private final String path = "M153.889,69.508L156.216,69.494L154.788,74.019L156.81300000000002,76.399L157.049,78.065L161.574,82.589L162.76500000000001,86.042L168.71800000000002,86.399L171.33800000000002,88.664H172.76700000000002L176.22000000000003,96.043L179.67100000000002,104.974L177.88700000000003,110.331L178.24500000000003,112.35600000000001L175.03000000000003,117.83300000000001L175.86300000000003,122.11900000000001L187.05500000000004,126.88200000000002L199.08000000000004,128.67000000000002L211.58300000000003,137.241L215.63200000000003,138.67000000000002L215.86900000000003,140.931L218.48800000000003,146.40900000000002L221.10700000000003,153.555L224.44000000000003,159.508L222.53700000000003,161.77100000000002V165.818L218.25100000000003,167.84400000000002L207.65500000000003,172.12800000000001L200.74800000000002,177.847L195.86700000000002,180.107L195.03300000000002,183.56L196.46300000000002,200.11L192.532,199.514L190.74900000000002,200.94500000000002L164.43400000000003,206.06400000000002L160.74300000000002,208.92000000000002L161.10100000000003,215.82600000000002L169.07900000000004,222.37400000000002L166.45900000000003,226.66000000000003L162.76900000000003,228.32800000000003L162.17200000000003,230.35200000000003L163.00700000000003,232.61100000000002H165.02800000000002L166.22000000000003,234.04000000000002L158.48200000000003,236.657L153.95700000000002,234.99L151.57500000000002,233.566H145.86L135.62,228.924H129.074L123.95300000000002,230.352H118.23900000000002L109.30800000000002,235.231L102.16500000000002,234.397L95.02000000000002,236.897L89.06400000000002,234.98999999999998L85.37500000000003,231.77899999999997L75.85000000000002,230.35199999999998L69.65900000000002,234.63199999999998L66.20700000000002,233.20699999999997L63.349000000000025,230.94399999999996L56.44200000000002,229.27699999999996L55.37200000000002,228.08799999999997L52.51500000000002,227.85099999999997L42.73300000000002,233.79599999999996L32.69600000000002,232.54599999999996L31.87400000000002,232.18699999999995L32.98700000000002,223.56399999999996L28.463000000000022,222.37299999999996L19.057000000000023,215.47099999999998L16.437000000000022,215.22999999999996L14.414000000000023,210.70499999999996L15.841000000000022,206.06199999999995L15.364000000000022,203.80199999999996L11.913000000000022,201.53599999999997L10.721000000000021,199.27599999999998L3.5780000000000216,195.22699999999998V194.03799999999998L7.030000000000022,192.60699999999997L9.053000000000022,193.79699999999997L11.078000000000022,191.77199999999996L10.480000000000022,184.98699999999997L11.078000000000022,179.27099999999996L6.432000000000023,174.62899999999996L3.3370000000000224,175.46199999999996L2.1480000000000223,172.12599999999995L3.933000000000022,168.67399999999995L2.981000000000022,165.45999999999995L6.0190000000000214,162.71099999999996L7.267000000000022,161.52899999999997V158.91099999999997L11.552000000000021,156.88699999999997L15.83800000000002,156.05399999999997L19.649000000000022,154.62499999999997L22.748000000000022,155.45699999999997L25.008000000000024,154.62499999999997L25.841000000000022,155.21999999999997L26.197000000000024,158.07899999999998L28.219000000000023,158.91099999999997L32.98400000000002,158.67299999999997C32.98400000000002,158.67299999999997,36.550000000000026,153.94399999999996,38.462000000000025,152.59999999999997C40.373000000000026,151.25399999999996,49.65200000000002,154.98099999999997,49.65200000000002,154.98099999999997L55.36900000000002,150.93299999999996L71.92100000000002,147.24399999999997L72.99000000000002,144.97999999999996L74.42000000000003,138.66999999999996L79.06300000000003,134.97999999999996H80.49600000000004V133.07399999999996L80.73200000000004,117.23799999999996L81.56500000000004,114.02599999999995L77.04400000000004,112.35799999999995L76.80400000000004,111.16699999999994L81.56600000000005,109.73899999999995L93.95000000000005,108.66599999999995L95.85500000000005,111.16699999999996L100.14200000000005,112.11899999999996L101.33400000000005,112.35799999999996L102.99900000000005,110.09599999999996L100.73400000000005,107.83299999999996L109.90300000000005,89.25899999999996L111.33400000000005,88.30599999999995L119.66900000000004,92.35299999999995H123.35800000000003L125.02500000000003,94.61699999999995L133.00400000000005,92.11499999999995L135.02700000000004,78.90299999999995L138.47900000000004,76.63799999999995L142.52700000000004,76.39999999999995L145.38600000000005,72.94799999999995L146.45700000000005,69.49399999999996L148.72000000000006,68.30299999999995L153.889,69.508Z";

//    private final double[][] airPositions = {
//            {11217.9775280898, 0},
//            {5235.05617977529, -1246.44194756556},
//            {2243.59550561798, -1745.01872659178},
//            {1246.44194756554, -4237.90262172287},
//            {-1246.44194756553, -4487.19101123596},
//            {-1495.73033707864, -1994.3071161049},
//            {-3490.03745318351, -2243.595505618},
//            {-4985.76779026217, -3739.32584269665},
//            {-5982.9213483146, -3490.03745318353},
//            {-5235.05617977527, -1495.73033707868},
//            {-5235.05617977527, 1495.73033707862},
//            {-5982.9213483146, 3490.0374531835},
//            {-4985.76779026217, 3739.32584269662},
//            {-3490.03745318351, 2243.59550561797},
//            {-1495.73033707864, 1994.30711610484},
//            {-1246.44194756553, 4487.19101123593},
//            {1246.44194756554, 4237.90262172284},
//            {2243.59550561798, 1745.01872659175},
//            {5235.05617977529, 1246.44194756553}
//    };

    private Paint deskPaint;
    private Path deckOutline;
    private ArrayList<Plan> planList;
    private boolean isFirstDraw = true;

    public Matrix currentMatrix = new Matrix();
    public float currentRotateDegrees = 1.0f;
    public float currentScale = 1.0f;
    public float baseWidth;
    public float baseHeight;
    public float baseCenterX;
    public float baseCenterY;

    public Position center;
    private Path airOutline;
    private float baseAirWidth;
    private float baseAirHeight;
    private float baseAirCenterX;
    private float baseAirCenterY;
    private ArrayList<Matrix> matrixList;
    private int left;
    private int top;
    private Paint airPaint;
    private float width;
    private float height;
    private ScaleGestureDetector sgd;
    private static final int TOUCH_STATE_NO = 0; // no touch
    private static final int TOUCH_STATE_SCROLL = 1; // scroll(one point)
    private static final int TOUCH_STATE_SCALE = 2; // scale(two points)
    private static final int TOUCH_STATE_ROTATE = 3; // rotate(two points)
    private static final int TOUCH_STATE_TWO_POINTED = 4; // two points touch
    private Matrix saveMatrix = new Matrix();
    private PointF startTouch = new PointF();
    private PointF lastMove = new PointF();
    private PointF mid = new PointF();
    private int currentTouchState = ScaleView2.TOUCH_STATE_NO; // default touch state
    private float saveZoom = 0f;
    private float saveRotateDegrees = 0.0f;
    private float oldDist = 0, oldDegree = 0;
    private boolean isScaleAndRotateTogether = false;
    private float minZoom = 0.5f;
    private float maxZoom = 3.0f;
    private float currentZoom = 1.0f;


    public ScaleView2(Context context) {
        this(context, null);
    }

    public ScaleView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        deskPaint = new Paint();
        deskPaint.setStyle(Paint.Style.STROKE);
        deskPaint.setAntiAlias(true);

        airPaint = new Paint();
        airPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        airPaint.setAntiAlias(true);
        airPaint.setColor(Color.BLUE);

        SvgPathToAndroidPath lParser = new SvgPathToAndroidPath();
        center = new Position((float) (this.getWidth() / 2), (float) (this.getHeight() / 2));

        currentMatrix = new Matrix();

//        parserPath = lParser.parser(path);

//        positions = new ArrayList<>();
//        Position position = new Position(1500, 239.99999999999923);
//        Position position1 = new Position(978.260869565223, 306.66666666666697);
//        Position position2 = new Position(717.3913043478296, 333.3333333333338);
//        Position position3 = new Position(630.4347826086984, 466.66666666666765);
//        Position position4 = new Position(413.04347826087246, 480.00000000000006);
//        Position position5 = new Position(391.30434782608955, 346.66666666666777);
//        Position position6 = new Position(217.39130434782766, 360.0000000000007);


//        positions.add(position);
//        positions.add(position1);
//        positions.add(position2);
//        positions.add(position3);
//        positions.add(position4);
//        positions.add(position5);
//        positions.add(position6);

        deckOutline = new Path();
        deckOutline.moveTo(13461.5730337079f, 15580.5243445693f);
        deckOutline.lineTo(13710.861423221f, 14583.3707865169f);
        deckOutline.lineTo(13212.2846441948f, 14583.3707865169f);
        deckOutline.lineTo(18447.34082397f, -22809.8876404494f);
        deckOutline.lineTo(19195.2059925094f, -23059.1760299626f);
        deckOutline.lineTo(19693.7827715356f, -24305.6179775281f);
        deckOutline.lineTo(26673.8576779026f, -23308.4644194757f);
        deckOutline.lineTo(32906.0674157303f, -30288.5393258427f);
        deckOutline.lineTo(63069.9625468165f, -32781.4232209738f);
        deckOutline.lineTo(63069.9625468165f, -35025.0187265918f);
        deckOutline.lineTo(63568.5393258427f, -35025.0187265918f);
        deckOutline.lineTo(63568.5393258427f, -37019.3258426966f);
        deckOutline.lineTo(66310.7116104869f, -37019.3258426966f);
        deckOutline.lineTo(66310.7116104869f, -38764.3445692884f);
        deckOutline.lineTo(91987.4157303371f, -38764.3445692884f);
        deckOutline.lineTo(91987.4157303371f, -39013.6329588015f);
        deckOutline.lineTo(104701.123595506f, -39262.9213483146f);
        deckOutline.lineTo(105199.700374532f, -40509.3632958802f);
        deckOutline.lineTo(108191.161048689f, -40509.3632958802f);
        deckOutline.lineTo(108689.737827715f, -39013.6329588015f);
        deckOutline.lineTo(129879.25093633f, -39013.6329588015f);
        deckOutline.lineTo(130128.539325843f, -38764.3445692884f);
        deckOutline.lineTo(140598.651685393f, -38764.3445692884f);
        deckOutline.lineTo(141097.228464419f, -39512.2097378277f);
        deckOutline.lineTo(143839.400749064f, -39512.2097378277f);
        deckOutline.lineTo(144337.97752809f, -38764.3445692884f);
        deckOutline.lineTo(170014.68164794f, -38764.3445692884f);
        deckOutline.lineTo(170263.970037453f, -39013.6329588015f);
        deckOutline.lineTo(190207.041198502f, -39013.6329588015f);
        deckOutline.lineTo(190207.041198502f, -38764.3445692884f);
        deckOutline.lineTo(216133.033707865f, -38764.3445692884f);
        deckOutline.lineTo(216133.033707865f, -39013.6329588015f);
        deckOutline.lineTo(243804.04494382f, -39013.6329588015f);
        deckOutline.lineTo(245050.486891386f, -38265.7677902622f);
        deckOutline.lineTo(246296.928838951f, -39512.2097378277f);
        deckOutline.lineTo(251282.696629213f, -36271.4606741573f);
        deckOutline.lineTo(253526.292134831f, -32282.8464419476f);
        deckOutline.lineTo(267486.441947566f, -22560.5992509363f);
        deckOutline.lineTo(273220.074906367f, -22560.5992509363f);
        deckOutline.lineTo(274965.093632959f, -20067.7153558052f);
        deckOutline.lineTo(279950.861423221f, -19818.4269662921f);
        deckOutline.lineTo(281695.880149813f, -21563.4456928839f);
        deckOutline.lineTo(325321.348314607f, -17574.8314606742f);
        deckOutline.lineTo(326817.078651685f, -16328.3895131086f);
        deckOutline.lineTo(337536.479400749f, -15331.2359550562f);
        deckOutline.lineTo(337536.479400749f, -17325.5430711611f);
        deckOutline.lineTo(344267.265917603f, -16577.6779026217f);
        deckOutline.lineTo(343768.689138577f, -14832.6591760299f);
        deckOutline.lineTo(344765.842696629f, -14084.7940074906f);
        deckOutline.lineTo(346012.284644195f, -14084.7940074906f);
        deckOutline.lineTo(346012.284644195f, 12090.4868913858f);
        deckOutline.lineTo(345015.131086142f, 12090.4868913858f);
        deckOutline.lineTo(344017.97752809f, 12838.3520599251f);
        deckOutline.lineTo(327315.655430712f, 13835.5056179775f);
        deckOutline.lineTo(325321.348314607f, 15580.5243445693f);
        deckOutline.lineTo(293911.011235955f, 18322.6966292135f);
        deckOutline.lineTo(277956.554307116f, 18322.6966292135f);
        deckOutline.lineTo(275962.247191011f, 19569.138576779f);
        deckOutline.lineTo(266489.288389513f, 19818.4269662921f);
        deckOutline.lineTo(239815.430711611f, 39512.2097378277f);
        deckOutline.lineTo(237571.835205993f, 39512.2097378277f);
        deckOutline.lineTo(237571.835205993f, 40509.3632958801f);
        deckOutline.lineTo(209402.247191011f, 40260.074906367f);
        deckOutline.lineTo(188711.310861423f, 36271.4606741573f);
        deckOutline.lineTo(184971.985018727f, 36271.4606741573f);
        deckOutline.lineTo(184722.696629213f, 37019.3258426966f);
        deckOutline.lineTo(176246.891385768f, 37019.3258426966f);
        deckOutline.lineTo(176246.891385768f, 38764.3445692884f);
        deckOutline.lineTo(175249.737827715f, 38764.3445692884f);
        deckOutline.lineTo(175249.737827715f, 36271.4606741573f);
        deckOutline.lineTo(166524.644194757f, 36271.4606741573f);
        deckOutline.lineTo(166275.355805243f, 36271.4606741573f);
        deckOutline.lineTo(165776.779026217f, 37019.3258426966f);
        deckOutline.lineTo(157799.550561798f, 37019.3258426966f);
        deckOutline.lineTo(157051.685393258f, 37767.191011236f);
        deckOutline.lineTo(150071.610486891f, 37767.191011236f);
        deckOutline.lineTo(149323.745318352f, 37019.3258426966f);
        deckOutline.lineTo(122649.887640449f, 37019.3258426966f);
        deckOutline.lineTo(122649.887640449f, 39512.2097378277f);
        deckOutline.lineTo(116417.677902622f, 39512.2097378277f);
        deckOutline.lineTo(116417.677902622f, 37019.3258426966f);
        deckOutline.lineTo(110434.756554307f, 37019.3258426966f);
        deckOutline.lineTo(109936.179775281f, 37268.6142322097f);
        deckOutline.lineTo(109437.602996255f, 37268.6142322097f);
        deckOutline.lineTo(108939.026217228f, 37019.3258426966f);
        deckOutline.lineTo(60327.7902621723f, 37019.3258426966f);
        deckOutline.lineTo(60327.7902621723f, 36770.0374531835f);
        deckOutline.lineTo(55840.5992509363f, 36770.0374531835f);
        deckOutline.lineTo(50854.8314606742f, 19070.5617977528f);
        deckOutline.lineTo(48860.5243445693f, 22311.3108614232f);
        deckOutline.lineTo(45121.1985018727f, 22062.0224719101f);
        deckOutline.lineTo(44124.0449438202f, 18571.9850187266f);
        deckOutline.close();

        float maxX = 346012.284644195f;
        float minX = 13212.2846441948f;
        float maxY = 40509.3632958801f;
        float minY = -40509.3632958802f;

//        甲板宽高
        baseWidth = (maxX - minX);
        baseHeight = (maxY - minY);
//算出甲板中心点坐标
        baseCenterX = (maxX + minX) / 2;
        baseCenterY = (maxY + minY) / 2;

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


        sgd = new ScaleGestureDetector(getContext(), new ZoomListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float newDist;
        float newDegree;

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                saveMatrix.set(currentMatrix);
                startTouch.set(event.getX(), event.getY());
                lastMove.set(event.getX(), event.getY());
                currentTouchState = ScaleView2.TOUCH_STATE_SCROLL;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getPointerCount() == 2) {
                    saveMatrix.set(currentMatrix);
                    saveZoom = currentZoom;
                    saveRotateDegrees = currentRotateDegrees;
                    startTouch.set(event.getX(0), event.getY(0));
                    currentTouchState = ScaleView2.TOUCH_STATE_TWO_POINTED;

                    mid = midPoint(event);
                    oldDist = distance(event, mid);
                    oldDegree = rotation(event, mid);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                //                if (withFloorPlan(event.getX(), event.getY())) {
////                    Log.i(TAG, event.getX() + " " + event.getY());
//                    // layers on touch
//                    for (MapBaseLayer layer : layers) {
//                        layer.onTouch(event);
//                    }
//                }
                currentTouchState = ScaleView2.TOUCH_STATE_NO;
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(event.getX() - lastMove.x) > 0
                        && Math.abs(event.getY() - lastMove.y) > 0) {
                    switch (currentTouchState) {
                        case ScaleView2.TOUCH_STATE_SCROLL:
                            currentMatrix.set(saveMatrix);
                            currentMatrix.postTranslate(event.getX() - startTouch.x, event.getY() -
                                    startTouch.y);
//                            refresh();
                            break;
                        case ScaleView2.TOUCH_STATE_TWO_POINTED:
                            if (!isScaleAndRotateTogether) {
                                float x = oldDist;
                                float y = MapMath.getDistanceBetweenTwoPoints(event.getX(0),
                                        event.getY(0), startTouch.x, startTouch.y);
                                float z = distance(event, mid);
                                float cos = (x * x + y * y - z * z) / (2 * x * y);
                                float degree = (float) Math.toDegrees(Math.acos(cos));

                                if (degree < 120 && degree > 45) {
                                    oldDegree = rotation(event, mid);
                                    currentTouchState = ScaleView2.TOUCH_STATE_ROTATE;
                                } else {
                                    oldDist = distance(event, mid);
                                    currentTouchState = ScaleView2.TOUCH_STATE_SCALE;
                                }
                            } else {
                                currentMatrix.set(saveMatrix);
                                newDist = distance(event, mid);
                                newDegree = rotation(event, mid);

                                float rotate = newDegree - oldDegree;
                                float scale = newDist / oldDist;
                                if (scale * saveZoom < minZoom) {
                                    scale = minZoom / saveZoom;
                                } else if (scale * saveZoom > maxZoom) {
                                    scale = maxZoom / saveZoom;
                                }
                                currentZoom = scale * saveZoom;
                                currentRotateDegrees = (newDegree - oldDegree + currentRotateDegrees)
                                        % 360;
                                currentMatrix.postScale(scale, scale, mid.x, mid.y);
                                currentMatrix.postRotate(rotate, mid.x, mid.y);
//                                refresh();
                            }
                            break;
                        case ScaleView2.TOUCH_STATE_SCALE:
                            currentMatrix.set(saveMatrix);
                            newDist = distance(event, mid);
//                            newDegree = rotation(event, mid);
//                            float rotate = newDegree - oldDegree;
                            float scale = newDist / oldDist;
                            if (scale * saveZoom < minZoom) {
                                scale = minZoom / saveZoom;
                            } else if (scale * saveZoom > maxZoom) {
                                scale = maxZoom / saveZoom;
                            }
                            currentZoom = scale * saveZoom;
                            currentMatrix.postScale(scale, scale, mid.x, mid.y);
//                            refresh();
                            break;
                        case ScaleView2.TOUCH_STATE_ROTATE:
                            currentMatrix.set(saveMatrix);
                            newDegree = rotation(event, mid);
                            float rotate = newDegree - oldDegree;
                            currentRotateDegrees = (rotate + saveRotateDegrees) % 360;
                            currentRotateDegrees = currentRotateDegrees > 0 ? currentRotateDegrees :
                                    currentRotateDegrees + 360;
                            currentMatrix.postRotate(rotate, mid.x, mid.y);
//                            refresh();
//                        Log.i(TAG, "rotate:" + currentRotateDegrees);
                            break;
                        default:
                            break;
                    }
                    lastMove.set(event.getX(), event.getY());
                }
                break;
            default:
                break;
        }
        return true;
    }

    private PointF midPoint(MotionEvent event) {
        return MapMath.getMidPointBetweenTwoPoints(event.getX(0), event.getY(0)
                , event.getX(1), event.getY(1));
    }

    private float distance(MotionEvent event, PointF mid) {
        return MapMath.getDistanceBetweenTwoPoints(event.getX(0), event.getY(0)
                , mid.x, mid.y);
    }

    private float rotation(MotionEvent event, PointF mid) {
        return MapMath.getDegreeBetweenTwoPoints(event.getX(0), event.getY(0)
                , mid.x, mid.y);
    }

    public static class ZoomListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactor = detector.getScaleFactor();
            return true;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
//        int height1 = heightSize - getPaddingTop() - getPaddingBottom();
        Log.d("ScaleView", "onMeasure: widthMeasureSpec:" + width + "heightMeasureSpec:" + height + "width:" + getWidth() + "height:" + getHeight());

//        图片比例
        float ratioT = baseWidth / baseHeight;
//        控件比例
        float ratioScreen = width * 1.0f / height;

//        float newScale = 1.0f;

        if (ratioT > ratioScreen) {
            this.currentScale = width / baseWidth;
        } else {
            this.currentScale = height / baseHeight;
        }
        float dx = (width / 2f - this.currentScale * baseCenterX);
        float dy = (height / 2f - this.currentScale * baseCenterY);
        Log.d("ScaleView", "onMeasure: dx:" + dx + "dy:" + dy);

        this.currentMatrix.setScale(this.currentScale, this.currentScale);
        this.currentMatrix.postTranslate(dx, dy);


//        float airDx = (width / 2f - this.currentScale * baseAirCenterX);
//        float airDy = (height / 2f - this.currentScale * baseAirCenterY);

//        this.airMatrix.setScale(this.currentScale, this.currentScale);
//        this.airMatrix.postTranslate(airDx, airDy);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("ScaleView", "onDraw: ");

        width = this.getWidth();
        height = this.getHeight();

        left = getLeft();
        top = getTop();

        if (isFirstDraw) {
            this.currentMatrix.postTranslate(left, top);
            isFirstDraw = false;
            Log.d("ScaleViewSize", "left : " + left + ", top : " + top);
        }
        canvas.save();

        canvas.setMatrix(this.currentMatrix);
        canvas.drawPath(deckOutline, deskPaint);


        if (matrixList != null && matrixList.size() > 0) {
            for (Matrix matrix : matrixList) {
                canvas.restore();
                canvas.setMatrix(matrix);
                canvas.drawPath(airOutline, airPaint);
            }
        }
    }

    public void drawAir(@NotNull ArrayList<Plan> planList, boolean isChecked) {
        this.planList = planList;
        matrixList = new ArrayList<>();
        for (int i = 0; i < planList.size(); i++) {
            Matrix matrix = new Matrix();
            matrix.setScale(this.currentScale, this.currentScale);
            matrix.postRotate(planList.get(i).getAngle());
//            位移到开始或结束坐标位置
            if (isChecked) {
                matrix.postTranslate(planList.get(i).getCox() * currentScale + left, planList.get(i).getCoy() * currentScale + top);
            } else {
                matrix.postTranslate(planList.get(i).getPlancox() * currentScale + left, planList.get(i).getPlancoy() * currentScale + top);
            }
            matrixList.add(matrix);
        }
        invalidate();
    }


    public void mapCenterWithPoint(float x, float y) {
        float[] goal = {x, y};
        this.currentMatrix.mapPoints(goal);
        float deltaX = this.getWidth() / 2.0f - goal[0];
        float deltaY = this.getHeight() / 2.0f - goal[1];
        this.currentMatrix.postTranslate(deltaX, deltaY);
    }

    public void setCurrentRotateDegrees(float degrees, float x, float y) {
        currentMatrix.postRotate(degrees - this.currentRotateDegrees, x, y);

        currentRotateDegrees = degrees % 360;
    }

    public void rotate(float d) {
        mapCenterWithPoint((float) center.getX(), (float) center.getY());
        setCurrentRotateDegrees(d * 360, this.getWidth() / 2.0f, this.getHeight() / 2.0f);
    }

    public void scaleImg(int progress) {
        currentMatrix.postScale(progress, progress, width / 2, height / 2);
    }
}
