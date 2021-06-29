package com.example.layoutapp.bean

import android.graphics.Matrix


data class Plan(
    var planangle: Any? = null,
    var shapetype: Int = 1,
    var waveno: Int? = null,
    var planshapetype: Int = 1,
    var alternative: Int = 0,
    var stano: String? = null,
    var plancoy: Float = 0.0f,
    var coy: Float = 0.0f,
    var plancox: Float = 0.0f,
    var goodno: Int = 0,
    var layoutid: Int? = null,
    var cox: Float = 0.0f,
    var plandate: String? = null,
    var planstano: String? = null,
    var historyid: String? = null,
    var planorder: Any? = null,
    var angle: Float = 0.0f,
    var planid: Int? = null,
    var state: String? = null,
    var tag: Int? = null,
    var initwaveno: Int? = null,
    var matrix: Matrix? = null,
    var goodInfo: GoodInfo?
)

