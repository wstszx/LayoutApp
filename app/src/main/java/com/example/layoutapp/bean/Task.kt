package com.example.layoutapp.bean

data class Task(
    var create_time: Long = 0,
    var device_id: Int? = null,
    var id: Int? = null,
    var plan_id: String = "",
    var plan_date: String = ""
)

