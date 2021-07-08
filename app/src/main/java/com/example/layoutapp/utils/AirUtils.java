package com.example.layoutapp.utils;

import android.graphics.Path;
import android.graphics.PointF;

public class AirUtils {

    public static Path getJ15Collapse() {
        Path path = new Path();
        path.moveTo(13812f, 0);
        path.lineTo(12940.2f, -355.373f);
        path.lineTo(11810f, -585.377f);
        path.lineTo(9271.64f, -809.285f);
        path.lineTo(7481.66f, -1121.73f);
        path.lineTo(7005.42f, -1224.91f);
        path.lineTo(6520.98f, -1455.04f);
        path.lineTo(5428.92f, -2150.02f);
        path.lineTo(4001.29f, -3220.01f);
        path.lineTo(3496.42f, -3215.28f);
        path.lineTo(4111.91f, -1900.01f);
        path.lineTo(3636.55f, -1989.18f);
        path.lineTo(3355.63f, -2137.6f);
        path.lineTo(2097.09f, -3519.99f);
        path.lineTo(-2558.09f, -3519.71f);
        path.lineTo(-3796.09f, -3287.92f);
        path.lineTo(-6273.78f, -3287.92f);
        path.lineTo(-6140.97f, -2144.05f);
        path.lineTo(-5023.96f, -1766.71f);
        path.lineTo(-6187.2f, -1663.23f);
        path.lineTo(-6178.41f, -731.017f);
        path.lineTo(-5573f, -578.236f);
        path.lineTo(-5853f, -568.236f);
        path.lineTo(-6239.9f, -293.489f);
        path.lineTo(-6820.2f, -199.851f);
        path.lineTo(-7372.99f, -0.0255f);
        path.lineTo(-6820.2f, 199.802f);
        path.lineTo(-6239.91f, 293.441f);
        path.lineTo(-5853f, 568.188f);
        path.lineTo(-5573f, 578.189f);
        path.lineTo(-6178.41f, 730.969f);
        path.lineTo(-6187.2f, 1663.19f);
        path.lineTo(-5023.96f, 1766.66f);
        path.lineTo(-6140.97f, 2144f);
        path.lineTo(-6273.79f, 3287.87f);
        path.lineTo(-3796.1f, 3287.88f);
        path.lineTo(-2558.1f, 3519.67f);
        path.lineTo(2097.08f, 3519.96f);
        path.lineTo(3355.63f, 2137.57f);
        path.lineTo(3636.55f, 1989.15f);
        path.lineTo(4111.9f, 1899.99f);
        path.lineTo(3496.41f, 3215.25f);
        path.lineTo(4001.28f, 3219.98f);
        path.lineTo(5428.92f, 2150f);
        path.lineTo(6520.97f, 1455.03f);
        path.lineTo(7005.41f, 1224.89f);
        path.lineTo(7481.66f, 1121.72f);
        path.lineTo(9271.64f, 809.274f);
        path.lineTo(10941.1f, 665.844f);
        path.lineTo(11810f, 585.372f);
        path.lineTo(12940.2f, 355.37f);
        path.lineTo(13812f, 0);
        path.close();

        return path;
    }

    public static PointF getJ15CollapseDistance() {
        float j15CollapseMaxX = 13812f;
        float j15CollapseMinX = -7372.99f;
        float j15CollapseMaxY = 3519.96f;
        float j15CollapseMinY = -3519.99f;

        float j15CollapseDx = (j15CollapseMaxX + j15CollapseMinX) / 2;
        float j15CollapseDy = (j15CollapseMaxY + j15CollapseMinY) / 2;

        return new PointF(j15CollapseDx, j15CollapseDy);
    }


    public static Path getJ15Expand() {
        Path path = new Path();
        path.moveTo(12940.2f, -355.381f);
        path.lineTo(11810f, -585.386f);
        path.lineTo(9271.64f, -809.293f);
        path.lineTo(7481.66f, -1121.74f);
        path.lineTo(7005.41f, -1224.9f);
        path.lineTo(6520.97f, -1455.03f);
        path.lineTo(4001.29f, -3220.02f);
        path.lineTo(3496.43f, -3215.26f);
        path.lineTo(4111.91f, -1900f);
        path.lineTo(3636.55f, -1989.16f);
        path.lineTo(3355.63f, -2137.58f);
        path.lineTo(-1291.69f, -7242.04f);
        path.lineTo(-3281.74f, -7242.18f);
        path.lineTo(-3281.73f, -7350.14f);
        path.lineTo(117.071f, -7350.14f);
        path.lineTo(248.271f, -7296.14f);
        path.lineTo(116.126f, -7241.97f);
        path.lineTo(-3281.74f, -7242.18f);
        path.lineTo(-2215.99f, -1738.55f);
        path.lineTo(-5436.3f, -4897.76f);
        path.lineTo(-5957.29f, -4707.86f);
        path.lineTo(-6400.06f, -4371.73f);
        path.lineTo(-6140.97f, -2144.06f);
        path.lineTo(-5023.96f, -1766.71f);
        path.lineTo(-6187.2f, -1663.24f);
        path.lineTo(-6178.41f, -731.026f);
        path.lineTo(-5573f, -578.244f);
        path.lineTo(-5853f, -568.244f);
        path.lineTo(-6239.9f, -293.498f);
        path.lineTo(-6820.2f, -199.86f);
        path.lineTo(-7372.99f, -0.0339f);
        path.lineTo(-6820.21f, 199.795f);
        path.lineTo(-6239.91f, 293.436f);
        path.lineTo(-5853f, 568.184f);
        path.lineTo(-5573f, 578.186f);
        path.lineTo(-6178.42f, 730.964f);
        path.lineTo(-6187.21f, 1663.18f);
        path.lineTo(-5023.97f, 1766.66f);
        path.lineTo(-6140.98f, 2144f);
        path.lineTo(-6400.08f, 4371.67f);
        path.lineTo(-5957.31f, 4707.8f);
        path.lineTo(-5436.32f, 4897.7f);
        path.lineTo(-2216f, 1738.51f);
        path.lineTo(-3281.77f, 7242.14f);
        path.lineTo(116.088f, 7241.94f);
        path.lineTo(248.233f, 7296.12f);
        path.lineTo(117.032f, 7350.11f);
        path.lineTo(-3281.77f, 7350.1f);
        path.lineTo(-3281.77f, 7242.14f);
        path.lineTo(-1291.48f, 7242.01f);
        path.lineTo(3355.62f, 2137.57f);
        path.lineTo(3636.54f, 1989.15f);
        path.lineTo(4111.9f, 1899.99f);
        path.lineTo(3496.42f, 3215.25f);
        path.lineTo(4001.27f, 3220.01f);
        path.lineTo(6520.97f, 1455.04f);
        path.lineTo(7005.41f, 1224.91f);
        path.lineTo(7481.66f, 1121.75f);
        path.lineTo(9271.64f, 809.313f);
        path.lineTo(11810f, 585.418f);
        path.lineTo(12940.2f, 355.42f);
        path.lineTo(14504f, 0.0234f);
        path.close();

        return path;
    }

    public static PointF getJ15ExpandDistance() {
        float j15ExpandMaxX = 12940.2f;
        float j15ExpandMinX = -7372.99f;
        float j15ExpandMaxY = 7350.11f;
        float j15ExpandMinY = -7350.14f;

        float j15ExpandDx = (j15ExpandMaxX + j15ExpandMinX) / 2;
        float j15ExpandDy = (j15ExpandMaxY + j15ExpandMinY) / 2;

        return new PointF(j15ExpandDx, j15ExpandDy);
    }


    public static Path getJ18Collapse() {
        Path path = new Path();
        path.moveTo(6499.99f, 8.9584f);
        path.lineTo(6492.32f, -249.155f);
        path.lineTo(6462.96f, -433.203f);
        path.lineTo(6396.07f, -618.135f);
        path.lineTo(6280.66f, -793.737f);
        path.lineTo(6154.48f, -908.341f);
        path.lineTo(5990.84f, -992.421f);
        path.lineTo(5855.65f, -1035.65f);
        path.lineTo(5479.72f, -1082.51f);
        path.lineTo(4710.74f, -1109.41f);
        path.lineTo(1781.24f, -1116.55f);
        path.lineTo(-76.9471f, -1121.07f);
        path.lineTo(-515.382f, -1162.6f);
        path.lineTo(-495.63f, -1371.11f);
        path.lineTo(-635.918f, -2120.76f);
        path.lineTo(-659.994f, -2258.73f);
        path.lineTo(-719.824f, -2335.7f);
        path.lineTo(-838.25f, -2414.66f);
        path.lineTo(-1029.68f, -2490.89f);
        path.lineTo(-1444.07f, -2573.4f);
        path.lineTo(-1989.89f, -2606.63f);
        path.lineTo(-2648.74f, -2555.88f);
        path.lineTo(-3118.23f, -2447.74f);
        path.lineTo(-3550.11f, -2252.45f);
        path.lineTo(-3642.29f, -2161.47f);
        path.lineTo(-3796.29f, -2042.96f);
        path.lineTo(-6706.59f, -2764.27f);
        path.lineTo(-7274.03f, -2654.26f);
        path.lineTo(-7264.51f, -2465.1f);
        path.lineTo(-7992.1f, -2168.47f);
        path.lineTo(-8503.47f, -2003.57f);
        path.lineTo(-8561.74f, -1788.55f);
        path.lineTo(-8770.3f, -1428.26f);
        path.lineTo(-9276.44f, -1236.4f);
        path.lineTo(-9291.63f, -1020.5f);
        path.lineTo(-10320.7f, -157.814f);
        path.lineTo(-10494.3f, -12.2278f);
        path.lineTo(-10464.3f, 456.787f);
        path.lineTo(-10346f, 123.596f);
        path.lineTo(-9306.71f, 1983.56f);
        path.lineTo(-9215.29f, 2040.16f);
        path.lineTo(-7088.53f, 2647.7f);
        path.lineTo(-6997.23f, 2654.91f);
        path.lineTo(-6928.44f, 2650.19f);
        path.lineTo(-6749.84f, 2220.64f);
        path.lineTo(-6669.63f, 1993.37f);
        path.lineTo(-4088.04f, 1543.91f);
        path.lineTo(-3631.94f, 2178.68f);
        path.lineTo(-3356.86f, 2350.96f);
        path.lineTo(-2887.65f, 2504.81f);
        path.lineTo(-2215.8f, 2595.36f);
        path.lineTo(-1540.63f, 2579.06f);
        path.lineTo(-1064.25f, 2496.29f);
        path.lineTo(-703.637f, 2311.53f);
        path.lineTo(-657.216f, 2150.43f);
        path.lineTo(-442.629f, 1118.39f);
        path.lineTo(4913.75f, 1118.29f);
        path.lineTo(5754.34f, 1070.29f);
        path.lineTo(6144.53f, 930.293f);
        path.lineTo(6278.44f, 811.046f);
        path.lineTo(6434.79f, 540.934f);
        path.lineTo(6486.14f, 318.596f);
        path.lineTo(7736.0346f, 50.278f);
        path.lineTo(7664.1704f, -150.2474f);
        path.lineTo(7407.0361f, -250.9646f);
        path.lineTo(7301.2348f, -529.2423f);
        path.lineTo(7104.3579f, -758.7f);
        path.lineTo(6812.3566f, -930.5691f);
        path.lineTo(6614.0965f, -994.8529f);
        path.lineTo(6130.029f, -1075.4099f);
        path.lineTo(5744.273f, -1130.8302f);
        path.lineTo(5472.8625f, -1140.9022f);
        path.lineTo(5473.824f, -1314.1041f);
        path.lineTo(4730.4702f, -1321.0155f);
        path.lineTo(4158.9156f, -1411.6924f);
        path.lineTo(4094.616f, -1454.5263f);
        path.lineTo(3546.2838f, -1454.5263f);
        path.lineTo(2137.0963f, -1414.4627f);
        path.lineTo(2059.5716f, -1439.8425f);
        path.lineTo(1302.0001f, -1533.8439f);
        path.lineTo(638.2676f, -1533.8439f);
        path.lineTo(-487.5372f, -1725.7323f);
        path.lineTo(-569.3849f, -1777.0502f);
        path.lineTo(-1234.0891f, -1736.4956f);
        path.lineTo(-1769.1736f, -1737.012f);
        path.lineTo(-1956.3759f, -1801.0394f);
        path.lineTo(-2087.0407f, -1801.0394f);
        path.lineTo(-2563.2189f, -2007.4765f);
        path.lineTo(-2669.6553f, -2005.2869f);
        path.lineTo(-2707.0628f, -1979.8474f);
        path.lineTo(-3963.9267f, -1342.9243f);
        path.lineTo(-3997.8084f, -1298.8643f);
        path.lineTo(-4034.1547f, -1206.0753f);
        path.lineTo(-5066.0016f, -962.6353f);
        path.lineTo(-5147.2233f, -845.8511f);
        path.lineTo(-5114.7308f, -549.1346f);
        path.lineTo(-5049.9706f, -249.2714f);
        path.lineTo(-5049.9106f, 151.3836f);
        path.lineTo(-5663.9654f, 876.117f);
        path.lineTo(-5435.9588f, 1067.6018f);
        path.lineTo(-5443.3416f, 1248.0629f);
        path.lineTo(-5253.165f, 1314.4222f);
        path.lineTo(-4632.0625f, 1577.0313f);
        path.lineTo(-4401.5889f, 1809.1057f);
        path.lineTo(-2293.2743f, 1854.1849f);
        path.lineTo(-3153.8935f, 2020.4755f);
        path.lineTo(-3057.0618f, 2020.1272f);
        path.lineTo(-215.5119f, 1463.4729f);
        path.lineTo(632.4594f, 1516.0733f);
        path.lineTo(1287.087f, 1516.0733f);
        path.lineTo(2073.9627f, 1443.392f);
        path.lineTo(2183.0673f, 1374.0145f);
        path.lineTo(3515.0271f, 1478.4084f);
        path.lineTo(4063.3593f, 1478.4084f);
        path.lineTo(4127.6589f, 1435.5746f);
        path.lineTo(4714.693f, 1345.8455f);
        path.lineTo(5457.9309f, 1345.8455f);
        path.lineTo(5157.9309f, 1188.5212f);
        path.lineTo(6007.433f, 1153.7052f);
        path.lineTo(6603.2822f, 1047.1435f);
        path.lineTo(6986.3525f, 899.7208f);
        path.lineTo(7232.7165f, 701.2461f);
        path.lineTo(7412.4803f, 328.1667f);
        path.lineTo(7685.2536f, 212.0954f);
        path.lineTo(7736.0346f, 50.278f);
        path.close();
        return path;
    }

    public static PointF getJ18CollapseDistance() {
        float j18CollapseMaxX = 7736.0346f;
        float j18CollapseMinX = -10494.3f;
        float j18CollapseMaxY = 2654.91f;
        float j18CollapseMinY = -2764.27f;

        float j18CollapseDx = (j18CollapseMaxX + j18CollapseMinX) / 2;
        float j18CollapseDy = (j18CollapseMaxY + j18CollapseMinY) / 2;

        return new PointF(j18CollapseDx, j18CollapseDy);
    }


    public static Path getJ18Expand() {
        Path path = new Path();
        path.moveTo(9434.0464f, -55.8736f);
        path.lineTo(8942.9237f, -134.4675f);
        path.lineTo(8942.9237f, -134.4675f);
        path.lineTo(6442.7163f, -441.5776f);
        path.lineTo(6361.2322f, -653.7106f);
        path.lineTo(6206.6887f, -857.7858f);
        path.lineTo(5887.2175f, -1028.3324f);
        path.lineTo(5392.3838f, -1094.7217f);
        path.lineTo(1069.4439f, -1118.4674f);
        path.lineTo(4779.7121f, -7566.4476f);
        path.lineTo(4836.4295f, -8100f);
        path.lineTo(4641.0347f, -8213.6124f);
        path.lineTo(454.6569f, -1118.4674f);
        path.lineTo(-217.2158f, -1117.5414f);
        path.lineTo(-719.7251f, -1985.133f);
        path.lineTo(-652.715f, -2146.5688f);
        path.lineTo(-728.15f, -2322.1774f);
        path.lineTo(-871.5912f, -2417.9545f);
        path.lineTo(-996.6392f, -2470.0175f);
        path.lineTo(-4140.6484f, -7939.0745f);
        path.lineTo(-4572.1334f, -8253.244f);
        path.lineTo(-4767.5283f, -8140.4327f);
        path.lineTo(-4590.0313f, -7675.8112f);
        path.lineTo(-1670.7832f, -2571.0928f);
        path.lineTo(-2310.2028f, -2593.29f);
        path.lineTo(-2903.8311f, -2508.2511f);
        path.lineTo(-3444.4466f, -2321.1892f);
        path.lineTo(-3654.633f, -2158.8106f);
        path.lineTo(-3588.0059f, -1095.1521f);
        path.lineTo(-4219.3978f, -1095.1521f);
        path.lineTo(-5105.1873f, -1099.4675f);
        path.lineTo(-5135.1876f, -1069.4675f);
        path.lineTo(-5134.9624f, -906.0885f);
        path.lineTo(-8568.6808f, -397.8562f);
        path.lineTo(-8942.5577f, -386.7424f);
        path.lineTo(-10111.7579f, -208.8383f);
        path.lineTo(-11866.4944f, -157.3398f);
        path.lineTo(-12219.7795f, -101.4069f);
        path.lineTo(-12504.6397f, 12.775f);
        path.lineTo(-12311.5886f, 240.4327f);
        path.lineTo(-12187.3904f, 1566.6519f);
        path.lineTo(-13063.4615f, 1692.8048f);
        path.lineTo(-13645.7026f, 1944.8385f);
        path.lineTo(-13724.8897f, 2100.5326f);
        path.lineTo(-13300.1843f, 2438.635f);
        path.lineTo(-12507.7119f, 2605.5057f);
        path.lineTo(-11498.0277f, 2645.7459f);
        path.lineTo(-10702.1347f, 2572.1087f);
        path.lineTo(-9987.5607f, 2372.3863f);
        path.lineTo(-9724.8896f, 2100.5326f);
        path.lineTo(-9846.1535f, 1912.3587f);
        path.lineTo(-10385.7425f, 1692.947f);
        path.lineTo(-11285.3918f, 1565.191f);
        path.lineTo(-11155.9558f, 180.1138f);
        path.lineTo(-10109.0407f, 240.5327f);
        path.lineTo(-5786.6143f, 807.6488f);
        path.lineTo(-5084.2324f, 914.7873f);
        path.lineTo(-5126.4016f, 1091.7444f);
        path.lineTo(-4249.3981f, 1100.5322f);
        path.lineTo(-2949.6392f, 1119.5328f);
        path.lineTo(-3654.9089f, 2150.5312f);
        path.lineTo(-3588.2087f, 2291.5324f);
        path.lineTo(-3243.055f, 2409.9381f);
        path.lineTo(-2718.6341f, 2544.9681f);
        path.lineTo(-2320.639f, 2593.6211f);
        path.lineTo(-1962.7035f, 2595.6176f);
        path.lineTo(-4808.8689f, 7549.9043f);
        path.lineTo(-4865.5964f, 8084.2578f);
        path.lineTo(-4670.1915f, 8197.0691f);
        path.lineTo(-4356.566f, 7811.0415f);
        path.lineTo(-1332.8432f, 2533.7911f);
        path.lineTo(-1060.6636f, 2492.4286f);
        path.lineTo(-840.4953f, 2403.5714f);
        path.lineTo(-706.2041f, 2295.75f);
        path.lineTo(-658.5289f, 2120.4453f);
        path.lineTo(-720.6489f, 1988.2485f);
        path.lineTo(-826.6388f, 1904.9599f);
        path.lineTo(-931.2553f, 1855.5626f);
        path.lineTo(-599.5674f, 1268.3106f);
        path.lineTo(-507.9253f, 1119.5328f);
        path.lineTo(185.2436f, 1119.5328f);
        path.lineTo(338.3065f, 1397.4404f);
        path.lineTo(4110.9509f, 7956.8047f);
        path.lineTo(4542.4345f, 8270.9731f);
        path.lineTo(4737.8293f, 8158.1618f);
        path.lineTo(4560.3324f, 7693.5404f);
        path.lineTo(788.4045f, 1136.6482f);
        path.lineTo(788.4045f, 1119.5328f);
        path.lineTo(5649.3161f, 1074.1253f);
        path.lineTo(5969.8258f, 1001.2085f);
        path.lineTo(6176.6024f, 885.1559f);
        path.lineTo(6337.8598f, 694.9593f);
        path.lineTo(6454.6019f, 388.5475f);
        path.lineTo(8942.9239f, 387.807f);
        path.lineTo(9434.0464f, 169.749f);
        path.lineTo(9434.0464f, -55.8736f);
        path.close();
        return path;
    }

    public static PointF getJ18ExpandDistance() {

        float j18ExpandMaxX = 9434.0464f;
        float j18ExpandMinX = -13724.8897f;
        float j18ExpandMaxY = 8270.9731f;
        float j18ExpandMinY = -8253.244f;

        float j18ExpandDx = (j18ExpandMaxX + j18ExpandMinX) / 2;
        float j18ExpandDy = (j18ExpandMaxY + j18ExpandMinY) / 2;

        return new PointF(j18ExpandDx, j18ExpandDy);
    }

    public static Path getZ20Expand() {
        Path path = new Path();
        path.moveTo(7662f, 30f);
        path.lineTo(7586.888f, 420.006f);
        path.lineTo(7344.36f, 759.996f);
        path.lineTo(6008.322f, 1170.54f);
        path.lineTo(5232f, 1250f);
        path.lineTo(4598.527f, 1247.14f);
        path.lineTo(9422f, 4740f);
        path.lineTo(9512f, 5250f);
        path.lineTo(9380.471f, 5381.53f);
        path.lineTo(4285.099f, 1637.81f);
        path.lineTo(4064.663f, 1249.92f);
        path.lineTo(2394.248f, 1237.19f);
        path.lineTo(242.95f, 7893.88f);
        path.lineTo(33.09f, 8050.02f);
        path.lineTo(-214.28f, 8137.08f);
        path.lineTo(-380.02f, 8052.63f);
        path.lineTo(1605.92f, 2049.77f);
        path.lineTo(2018.249f, 1576.76f);
        path.lineTo(2167.955f, 1236.17f);
        path.lineTo(802f, 1230f);
        path.lineTo(123.63f, 1169.17f);
        path.lineTo(-227.35f, 1051.35f);
        path.lineTo(-1140.22f, 527.776f);
        path.lineTo(-6688f, 140f);
        path.lineTo(-7908f, 2230f);
        path.lineTo(-7908f, 150f);
        path.lineTo(-8678f, 70f);
        path.lineTo(-8908f, -20f);
        path.lineTo(-8727.5f, -114.7724f);
        path.lineTo(-9124.7f, -774.0987f);
        path.lineTo(-8971.3f, -842.7897f);
        path.lineTo(-8802.1f, -826.6263f);
        path.lineTo(-7938f, -576.0193f);
        path.lineTo(-7938f, -2280f);
        path.lineTo(-7038f, -2330f);
        path.lineTo(-6829.53f, -917.8053f);
        path.lineTo(-6488f, -890f);
        path.lineTo(-6806.05f, -759.6967f);
        path.lineTo(-6730.2f, -244.8918f);
        path.lineTo(-6451.23f, -156.55f);
        path.lineTo(-5936.54f, -404.7305f);
        path.lineTo(-1140.22f, -527.7757f);
        path.lineTo(-227.35f, -1051.346f);
        path.lineTo(474.93f, -1201.17f);
        path.lineTo(2126.036f, -1235.978f);
        path.lineTo(-20.85f, -7808.169f);
        path.lineTo(57.15f, -8057.837f);
        path.lineTo(206.11f, -8273.668f);
        path.lineTo(389.83f, -8302.767f);
        path.lineTo(2631.2836f, -2279.922f);
        path.lineTo(2256.012f, -1654.01f);
        path.lineTo(2353.601f, -1237.005f);
        path.lineTo(4156.772f, -1245.146f);
        path.lineTo(9258.963f, -4964.402f);
        path.lineTo(9520.516f, -4967.364f);
        path.lineTo(9771.813f, -4892.398f);
        path.lineTo(9856.26f, -4726.662f);
        path.lineTo(5015.571f, -1249.023f);
        path.lineTo(5852.026f, -1201.026f);
        path.lineTo(7334.363f, -767.6591f);
        path.lineTo(7554.031f, -506.7587f);
        path.lineTo(7662f, -140f);
        path.lineTo(7662f, 30f);
        path.close();
        return path;
    }

    public static Path getZ9Expand() {
        Path path = new Path();
        path.moveTo(5242f, 0f);
        path.lineTo(5134f, -198f);
        path.lineTo(4364f, -532f);
        path.lineTo(2752f, -874f);
        path.lineTo(1491f, -994f);
        path.lineTo(-190f, -1020f);
        path.lineTo(-4187f, -276f);
        path.lineTo(-4407f, -1593f);
        path.lineTo(-5208f, -1602.9f);
        path.lineTo(-5232f, -332.58f);
        path.lineTo(-6955.9f, -145.9f);
        path.lineTo(-6955.9f, 145.9f);
        path.lineTo(-5525f, 332.58f);
        path.lineTo(-5208f, 1602.9f);
        path.lineTo(-4407f, 1593.9f);
        path.lineTo(-189.99f, 1020f);
        path.lineTo(1491f, 994.68f);
        path.lineTo(2752f, 874f);
        path.lineTo(4364f, 532.8f);
        path.lineTo(5134f, 197.98f);
        path.lineTo(5242f, -0.01f);
        path.close();
        return path;
    }

    public static PointF getZ9ExpandDistance() {
        float z9ExpandMaxX = 5242f;
        float z9ExpandMinX = -6955.9f;
        float z9ExpandMaxY = 1602.9f;
        float z9ExpandMinY = -1602.9f;

        float z9ExpandDx = (z9ExpandMaxX + z9ExpandMinX) / 2;
        float z9ExpandDy = (z9ExpandMaxY + z9ExpandMinY) / 2;

        return new PointF(z9ExpandDx, z9ExpandDy);
    }


    public static Path getZ9Collapse() {
        Path path = new Path();
        path.moveTo(5242f, 0f);
        path.lineTo(5152f, -184f);
        path.lineTo(4591f, -459f);
        path.lineTo(3609f, -730f);
        path.lineTo(1491f, -997f);
        path.lineTo(190f, -1020f);
        path.lineTo(-4122f, -1366f);
        path.lineTo(-4156f, -1594f);
        path.lineTo(-5450f, -1605f);
        path.lineTo(-5233f, -333f);
        path.lineTo(-6956f, -146f);
        path.lineTo(-6956f, 146f);
        path.lineTo(-5233f, 333f);
        path.lineTo(-5450f, 1605f);
        path.lineTo(-4156f, 1594f);
        path.lineTo(-4122f, 1366f);
        path.lineTo(-190f, 1020f);
        path.lineTo(1491f, 997f);
        path.lineTo(3517f, 750f);
        path.lineTo(4497f, 492f);
        path.lineTo(5152f, 184f);
        path.lineTo(5242f, 0f);
        path.close();
        return path;
    }

    public static PointF getZ9CollapseDistance() {
        float z9CollapseMaxX = 5242f;
        float z9CollapseMinX = -6956f;
        float z9CollapseMaxY = 1605f;
        float z9CollapseMinY = -1605f;

        float z9CollapseDx = (z9CollapseMaxX + z9CollapseMinX) / 2;
        float z9CollapseDy = (z9CollapseMaxY + z9CollapseMinY) / 2;

        return new PointF(z9CollapseDx, z9CollapseDy);
    }


    public static Path getZ9ExpandCircle() {
        Path path = new Path();
        path.moveTo(-173.6068f, -5926.13f);
        path.lineTo(-1958.943f, -5346.0391f);
        path.lineTo(-3477.6407f, -4242.6407f);
        path.lineTo(-4581.0391f, -2723.943f);
        path.lineTo(-5161.13f, -938.6068f);
        path.lineTo(-5161.13f, 938.6068f);
        path.lineTo(-4581.0391f, 2723.943f);
        path.lineTo(-3477.6407f, 4242.6407f);
        path.lineTo(-1958.943f, 5346.0391f);
        path.lineTo(-173.6068f, 5926.13f);
        path.lineTo(1703.6068f, 5926.13f);
        path.lineTo(3488.943f, 5346.0391f);
        path.lineTo(5007.6407f, 4242.6407f);
        path.lineTo(6111.0391f, 2723.943f);
        path.lineTo(6691.13f, 938.6068f);
        path.lineTo(6691.13f, -938.6068f);
        path.lineTo(6111.0391f, -2723.943f);
        path.lineTo(5007.6407f, -4242.6407f);
        path.lineTo(3488.943f, -5346.0391f);
        path.lineTo(1703.6068f, -5926.13f);
        path.lineTo(-173.6068f, -5926.13f);
        path.close();
        return path;
    }


    public static Path getLifts1() {
        Path path = new Path();
        path.moveTo(15400f, -14000f);
        path.lineTo(31404.0011f, -14000f);
        path.lineTo(31406.6931f, -27993.4827f);
        path.lineTo(26525.025f, -28971.0275f);
        path.lineTo(20400.5866f, -28998.3249f);
        path.lineTo(15401.3099f, -27993.4827f);
        path.close();
        return path;
    }

    public static Path getLifts2() {
        Path path = new Path();
        path.moveTo(-82600f, -14000f);
        path.lineTo(-66595.9989f, -14000f);
        path.lineTo(-66593.3069f, -27993.4827f);
        path.lineTo(-71474.975f, -28971.0275f);
        path.lineTo(-77599.4134f, -28998.3249f);
        path.lineTo(-82598.6901f, -27993.4827f);
        path.close();
        return path;
    }

    public static Path getJK() {
        Path path = new Path();
        path.moveTo(1283539.0393f, 654315.6353f);
        path.lineTo(1436539.0393f, 654315.6353f);
        path.lineTo(1436539.0393f, 680315.6353f);
        path.lineTo(1432539.0393f, 680315.6353f);
        path.lineTo(1432539.0393f, 695315.6351f);
        path.lineTo(1427500.2189f, 696278.7950f);
        path.lineTo(1421535.6244f, 696278.7950f);
        path.lineTo(1416536.3477f, 695309.1179f);
        path.lineTo(1416539.0393f, 680315.6353f);
        path.lineTo(1334539.0393f, 680315.6353f);
        path.lineTo(1334541.7309f, 695309.1179f);
        path.lineTo(1329542.4542f, 696313.9600f);
        path.lineTo(1323535.6244f, 696313.9600f);
        path.lineTo(1318536.3477f, 695309.1179f);
        path.lineTo(1318539.0393f, 680315.6353f);
        path.lineTo(1283539.0393f, 680315.6353f);
        path.close();
        return path;
    }

    public static Path getRealJK() {
        Path path = new Path();
        path.moveTo(-118000f, -13000f);
        path.lineTo(-118000f, 13000f);
        path.lineTo(-83004.0015f, 13000f);
        path.lineTo(-83002.6916f, 27993.4825f);
        path.lineTo(-78003.4149f, 28998.3247f);
        path.lineTo(-71996.5851f, 28998.3247f);
        path.lineTo(-66997.3084f, 27993.4825f);
        path.lineTo(-67000f, 13000f);
        path.lineTo(14995.9985f, 13000f);
        path.lineTo(14997.3084f, 27993.4825f);
        path.lineTo(19969.9936f, 28963.1596f);
        path.lineTo(25961.1796f, 28963.1596f);
        path.lineTo(31000f, 27993.4729f);
        path.lineTo(31000f, 13000f);
        path.lineTo(35000f, 13000f);
        path.lineTo(35000f, -13000f);
        path.close();
        return path;
    }

    public static Path getRealDesk() {
        Path path = new Path();
        path.moveTo(-114700f, -28300f);
        path.lineTo(-115500f, -27500f);
        path.lineTo(-115500f, -22400f);
        path.lineTo(-145790.6737f, -20116.1605f);
        path.lineTo(-141267.8558f, 19999.8343f);
        path.lineTo(-130000f, 19999.5762f);
        path.lineTo(-130000f, 22565.6009f);
        path.lineTo(-121000f, 22565.6009f);
        path.lineTo(-121000f, 27500f);
        path.lineTo(-115500f, 27500f);
        path.lineTo(-114699.8263f, 28300.1738f);
        path.lineTo(-83004.0015f, 28299.0758f);
        path.lineTo(-78003.4149f, 28998.3147f);
        path.lineTo(-71996.5851f, 28998.3147f);
        path.lineTo(-67002.1245f, 28309.6646f);
        path.lineTo(-65226.1176f, 30850f);
        path.lineTo(-32000f, 30850f);
        path.lineTo(-27800f, 29740.0281f);
        path.lineTo(-10100f, 29740.0281f);
        path.lineTo(-2000f, 29740.0281f);
        path.lineTo(13661.1813f, 29740.0281f);
        path.lineTo(14999.6702f, 28457.9725f);
        path.lineTo(19996.5851f, 28963.1496f);
        path.lineTo(25961.1796f, 28963.1496f);
        path.lineTo(31000f, 28300.0001f);
        path.lineTo(34999.9988f, 28300.0001f);
        path.lineTo(35499.9988f, 29800.0001f);
        path.lineTo(36999.9988f, 29800.0001f);
        path.lineTo(37499.9988f, 28800.0001f);
        path.lineTo(43907.5703f, 28557.2891f);
        path.lineTo(44288.7243f, 28014.8879f);
        path.lineTo(65891.9909f, 26794.993f);
        path.lineTo(71000f, 19500f);
        path.lineTo(71000f, 16498.0399f);
        path.lineTo(159090f, 9040f);
        path.lineTo(159090f, -9040f);
        path.lineTo(61838.22f, -17271.71f);
        path.lineTo(49300f, -38950.01f);
        path.lineTo(22927.9988f, -38935.8352f);
        path.lineTo(7352.3736f, -35869.3739f);
        path.lineTo(7352.3736f, -35869.3739f);
        path.lineTo(7000.0309f, -35800.0062f);
        path.lineTo(7000.031f, -35000f);
        path.lineTo(-114700f, -28300f);
        path.close();
        return path;
    }

    public static Path getRealDesk1() {
        Path path = new Path();
        path.moveTo(159090f, -9040f);
        path.lineTo(158727f, -10191f);
        path.lineTo(157828f, -10937f);
        path.lineTo(151524f, -11590f);
        path.lineTo(124144f, -13868f);
        path.lineTo(92294f, -16512f);
        path.lineTo(64693f, -17734f);
        path.lineTo(53830f, -36972f);
        path.lineTo(52387f, -38680f);
        path.lineTo(49927f, -40121f);
        path.lineTo(39744f, -40167f);
        path.lineTo(23000f, -40167f);
        path.lineTo(7000f, -36990f);
        path.lineTo(7000f, -35000f);
        path.lineTo(-16000f, -35000f);
        path.lineTo(-16000f, -37600f);
        path.lineTo(-17557f, -37600f);
        path.lineTo(-17987f, -41100f);
        path.lineTo(-22250f, -41100f);
        path.lineTo(-22250f, -37600f);
        path.lineTo(-23000f, -37600f);
        path.lineTo(-23000f, -35000f);
        path.lineTo(-102300f, -35000f);
        path.lineTo(-103000f, -33999f);
        path.lineTo(-103000f, -33145f);
        path.lineTo(-110620f, -32209f);
        path.lineTo(-111200f, -31740f);
        path.lineTo(-111200f, -28300f);
        path.lineTo(-114700f, -28300f);
        path.lineTo(-115500f, -27500f);
        path.lineTo(-115500f, -22400f);
        path.lineTo(-147306f, -19994f);
        path.lineTo(-142394f, 20000f);
        path.lineTo(-130000f, 20000f);
        path.lineTo(-130000f, 22573f);
        path.lineTo(-121006f, 22566f);
        path.lineTo(-121000f, 27497f);
        path.lineTo(-115500f, 27500f);
        path.lineTo(-114700f, 28300f);
        path.lineTo(-83004f, 28299f);
        path.lineTo(-83003f, 27993f);
        path.lineTo(-78003f, 28998f);
        path.lineTo(-71997f, 28998f);
        path.lineTo(-67003f, 28310f);
        path.lineTo(-67003f, 27995f);
        path.lineTo(-65226f, 30850f);
        path.lineTo(-32000f, 30850f);
        path.lineTo(-32000f, 32240f);
        path.lineTo(-31845f, 32714f);
        path.lineTo(-31200f, 33037f);
        path.lineTo(-28600f, 33037f);
        path.lineTo(-28112f, 32871f);
        path.lineTo(-27800f, 32241f);
        path.lineTo(-27800f, 29737f);
        path.lineTo(-10100f, 29737f);
        path.lineTo(-10100f, 31400f);
        path.lineTo(-9800f, 32349f);
        path.lineTo(-8450f, 33053f);
        path.lineTo(-3650f, 33050f);
        path.lineTo(-2702f, 32751f);
        path.lineTo(-2000f, 31403f);
        path.lineTo(-2000f, 29740f);
        path.lineTo(13661f, 29740f);
        path.lineTo(15000f, 28458f);
        path.lineTo(14997f, 27993f);
        path.lineTo(19970f, 28963f);
        path.lineTo(25961f, 28963f);
        path.lineTo(31000f, 28000f);
        path.lineTo(31000f, 28300f);
        path.lineTo(35000f, 28300f);
        path.lineTo(35000f, 22000f);
        path.lineTo(55700f, 22000f);
        path.lineTo(55700f, 23290f);
        path.lineTo(60200f, 23290f);
        path.lineTo(68087f, 22759f);
        path.lineTo(68744f, 22718f);
        path.lineTo(71000f, 19500f);
        path.lineTo(71000f, 17570f);
        path.lineTo(92500f, 16497f);
        path.lineTo(132402f, 13199f);
        path.lineTo(156250f, 11202f);
        path.lineTo(157906f, 10904f);
        path.lineTo(158973f, 9761f);
        path.lineTo(159090f, 9043f);
        path.close();
        return path;
    }

    public static Path getFJLifts1() {
        Path path = new Path();
        path.moveTo(-82598.6901f, 27993.4827f);
        path.lineTo(-82600f, 14000f);
        path.lineTo(-66595.9989f, 14000f);
        path.lineTo(-66593.3069f, 27993.4827f);
        path.lineTo(-71474.975f, 28971.0275f);
        path.lineTo(-77599.4134f, 28998.3249f);
        path.close();

        path.moveTo(15401.3099f, 27993.4827f);
        path.lineTo(15400f, 14000f);
        path.lineTo(31404.0011f, 14000f);
        path.lineTo(31406.6931f, 27993.4827f);
        path.lineTo(26525.025f, 28971.0275f);
        path.lineTo(20400.5866f, 28998.3249f);
        path.close();
        return path;
    }


    public static Path getFireCurtain1() {
        Path path = new Path();
        path.moveTo(-1500f, -13000f);
        path.lineTo(-1500f, 11229.96556f);

        path.moveTo(-39200f, -13000f);
        path.lineTo(-39200f, 13000f);

        path.moveTo(-87700f, -13000f);
        path.lineTo(-87700f, 13000f);
        return path;
    }


    public static Path getHangarDoor1() {
        Path path = new Path();
        path.moveTo(33342.24283f, 13000f);
        path.lineTo(33286.78157f, 11369.04359f);
        path.lineTo(-3809.818223f, 11369.04359f);
        path.lineTo(-3778.037101f, 12979.61857f);
        path.close();

        path.moveTo(-48540.31751f, 13000f);
        path.lineTo(-48595.77877f, 11369.04359f);
        path.lineTo(-85692.37857f, 11369.04359f);
        path.lineTo(-85660.59745f, 12979.61857f);
        path.close();
        return path;
    }


    public static PointF getTurntable1() {
        PointF pointF = new PointF();
        pointF.x = 23000;
        pointF.y = -995;
        return pointF;
    }

    public static PointF getTurntable2() {
        PointF pointF = new PointF();
        pointF.x = -75000;
        pointF.y = -995;
        return pointF;
    }

    //跑道一号线
    public static Path getRunway1() {
        Path path = new Path();
        path.moveTo(48947.17601f, -38485.72592f);
        path.lineTo(49215.92187f, -36301.40353f);
        path.lineTo(-144767.4507f, -12479.01783f);
        path.lineTo(-144990.4617f, -14669.21091f);
        path.close();

        path.moveTo(54071.5311f, -27025.8255f);
        path.lineTo(-145500f, -2465.7471f);

        path.moveTo(51639.39738f, -16857.96591f);
        path.lineTo(51931.73328f, -14668.05454f);
        path.lineTo(-142205.1473f, 9171.974999f);
        path.lineTo(-142475.2162f, 6987.301662f);
        path.close();
        return path;
    }


    //起飞线1
    public static Path getTakeoffLine1() {
        Path path = new Path();
        path.moveTo(153650f, 0);
        path.lineTo(41129.6614f, 11824.4624f);

        path.moveTo(153650f, 0);
        path.lineTo(-50665.2205f, -22443.4199f);
        return path;
    }

    //阻拦索1
    public static Path getInterceptionCable1() {
        Path path = new Path();
        path.moveTo(-57121.1217f, -30241.5309f);
        path.lineTo(-64669.2297f, -27567.8506f);
        path.lineTo(-61009.9022f, 2234.9803f);
        path.lineTo(-53203.201f, 2994.5925f);

        path.moveTo(-65861.7709f, -29697.9657f);
        path.lineTo(-76357.3457f, -26123.1543f);
        path.lineTo(-72706.387f, 3611.5181f);
        path.lineTo(-64672.5783f, 4419.4831f);

        path.moveTo(-80046.9292f, -27612.4625f);
        path.lineTo(-88560.2262f, -24643.6943f);
        path.lineTo(-84899.8309f, 5167.8338f);
        path.lineTo(-76523.0233f, 5957.324f);

        path.moveTo(-88054.8739f, -27390.0248f);
        path.lineTo(-100665.4263f, -23168.7366f);
        path.lineTo(-97005.8298f, 6630.8278f);
        path.lineTo(-88434.8183f, 7466.9464f);
        return path;
    }



    //舰岛
    public static Path getJianDao() {
        Path path = new Path();
        path.moveTo(-3176f, 20000f);
        path.lineTo(-56100f, 20000f);
        path.lineTo(-57000f, 20900f);
        path.lineTo(-57000f, 27400f);
        path.lineTo(-56100f, 28300f);
        path.lineTo(-2900f, 28300f);
        path.lineTo(-2000f, 27400f);
        path.lineTo(-2000f, 20900f);
        path.close();
        return path;
    }

    //安全区
    public static Path getSafeArea() {
        Path path = new Path();
        path.moveTo(-142133f, 12630f);
        path.lineTo(-101439f, 7633f);
        path.lineTo(-91650f, 8146f);
        path.lineTo(-50569f, 3102f);
        path.lineTo(-37020f, -277f);
        path.lineTo(79410f, -14571f);
        path.moveTo(-99612f, -28424f);
        path.lineTo(-60505f, -33225f);

        path.moveTo(33998f, 7590f);
        path.lineTo(34000f, 22390f);

        path.moveTo(-8392f, -3775f);
        path.lineTo(33998f, 7590f);

        return path;
    }

    public static Path getPianLiuBan() {
        Path path = new Path();
        path.moveTo(40460f, -16479f);
        path.lineTo(35190f, -16479f);
        path.lineTo(35190f, -7449f);
        path.lineTo(40460f, -7449f);
        path.close();

        path.moveTo(40370f, 7445f);
        path.lineTo(35190f, 7445f);
        path.lineTo(35190f, 16464f);
        path.lineTo(40370f, 16464f);
        path.close();

        path.moveTo(-51110f, -25822f);
        path.lineTo(-56430f, -25822f);
        path.lineTo(-56430f, -16803f);
        path.lineTo(-51110f, -16803f);
        path.close();
        return path;
    }


    public static class ZSJQJPointInfo {

        public static PointF centerPF1 = new PointF(84000.000f, -2000.000f);
        public static PointF centerPF2 = new PointF(39000.000f, -28000.000f);
        public static PointF centerPF3 = new PointF(-6700.000f, -21700.000f);
        public static PointF centerPF4 = new PointF(-116000.000f, -12300.000f);

        public static float[] linePF1 = new float[]{88300f, -2000.000f, 99300f, -2000.000f};
        public static float[] linePF2 = new float[]{43300f, -28000.000f, 54300f, -28000.000f};
        public static float[] linePF3 = new float[]{-2400f, -21700.000f, 8600f, -21700.000f};
        public static float[] linePF4 = new float[]{-111700f, -12300.000f, -100700f, -12300.000f};
        public static PointF circleWidth = new PointF(1500, 4300);

    }
}
