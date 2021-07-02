package com.example.layoutapp.bean

import com.bin.david.form.annotation.SmartColumn
import com.bin.david.form.annotation.SmartTable

@SmartTable(name = "Aircraft_Status")
class Table(
    @SmartColumn(id = 0, name = "编号") var number: String?,
    @SmartColumn(id = 1, name = "起始") var start: String?,
    @SmartColumn(id = 2, name = "终止") var end: Any?
)

