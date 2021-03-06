package com.example.layoutapp

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.blankj.utilcode.constant.RegexConstants
import com.blankj.utilcode.util.*
import com.example.layoutapp.adapter.BottomSheetAdapter
import com.example.layoutapp.bean.Plan
import com.example.layoutapp.bean.Table
import com.example.layoutapp.bean.Task
import com.example.layoutapp.databinding.ActivityMainBinding
import com.example.layoutapp.databinding.BottomSheetDialogBinding
import com.example.layoutapp.service.ApiService
import com.example.layoutapp.service.BigTextIntentService
import com.example.layoutapp.utils.MockDatabase
import com.example.layoutapp.utils.NotificationUtil
import com.example.layoutapp.view.ScaleView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.switchmaterial.SwitchMaterial
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var smartTable: com.bin.david.form.core.SmartTable<Any>
    private lateinit var bottomSheetDialog: BottomSheetDialog
    lateinit var bottomSheetAdapter: BottomSheetAdapter
    lateinit var view: View
    private lateinit var switchMaterial: SwitchMaterial
    private lateinit var ivPic: ScaleView
    private lateinit var tvPos: TextView
    private val a = arrayOf("top", "com.cn", "com", "net", "cn", "cc", "gov", "cn", "hk");
    private lateinit var mSourceData: ArrayList<Table>
    private lateinit var mFilterData: ArrayList<Table>
    private lateinit var planList: ArrayList<Plan>

    private lateinit var etSearch: EditText
    private lateinit var materialDialog: MaterialDialog
    private lateinit var timer: Timer
    private lateinit var pollingTask: PollingTask
    private lateinit var notifyReceiver: NotifyReceiver
    private lateinit var planId: String
    private var id: Int = 0
    private lateinit var currentTask: Task


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }

    private fun initData() {
        planList = arrayListOf()
        timer = Timer()
        pollingTask = PollingTask()
        timer.schedule(pollingTask, 0, 1 * 1000.toLong())
    }

    inner class PollingTask : TimerTask() {
        override fun run() {
            Log.d("mylog", "run: ")
            getTaskByDate()
        }
    }

    private fun getTaskByDate() {
        val nowDate = TimeUtils.getNowString().split(" ")[0]

        ApiService.create().getTaskByDate(nowDate)
            .enqueue(object : Callback<MutableList<Task>> {
                override fun onResponse(
                    call: retrofit2.Call<MutableList<Task>>,
                    response: Response<MutableList<Task>>
                ) {
                    val taskList: MutableList<Task>? = response.body()
                    if (taskList != null && taskList.size > 0) {
                        sortTaskList(taskList)
                        currentTask = taskList[0]
                        if (currentTask.id > id) {
                            bottomSheetAdapter.data = taskList
                            bottomSheetAdapter.notifyDataSetChanged()
                            id = currentTask.id
                            planId = currentTask.plan_id
                            getPlan(planId)
                            generateBigTextStyleNotification(currentTask)
                        }
                    }
                }

                override fun onFailure(
                    call: retrofit2.Call<MutableList<Task>>,
                    t: Throwable
                ) {
                    ToastUtils.showShort(t.message)
                }

            })
    }

    private fun sortTaskList(taskList: MutableList<Task>) {
        Log.d("mylog", "sortTaskList1: $taskList")
        taskList.sortByDescending { it.id }
        Log.d("mylog", "sortTaskList2: $taskList")

    }

//    private fun getTaskById(minId: Int) {
//        ApiService.create().getTaskById(minId)
//            .enqueue(object : Callback<MutableList<Task>?> {
//                override fun onResponse(
//                    call: retrofit2.Call<MutableList<Task>?>,
//                    response: Response<MutableList<Task>?>
//                ) {
//                    val taskList: MutableList<Task>? = response.body()
//                    if (taskList != null && taskList.size > 0) {
////                        if (isShowPlan) {
////                            getPlan(taskList[0].plan_id)
////                            isShowPlan = false
////                        }
//                        val last = taskList.last()
//                        planId = last.plan_id
////                        SPUtils.getInstance().put("min_id", (last.id + 1).toString())
//                        bottomSheetAdapter.data = taskList.asReversed()
//                        bottomSheetAdapter.notifyDataSetChanged()
//                        getPlan(taskList[0].plan_id)
//                    }
//                }
//
//                override fun onFailure(call: retrofit2.Call<MutableList<Task>?>, t: Throwable) {
//
//                }
//            })
//    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
        pollingTask.cancel()
        unregisterReceiver(notifyReceiver)
    }

    private fun initView() {
        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        etSearch = activityMainBinding.etSearch
//        val ivAdd = activityMainBinding.ivAdd
//        val ivLess = activityMainBinding.ivLess
//        val seekBar = activityMainBinding.seekBar
        ivPic = activityMainBinding.ivPic
        tvPos = activityMainBinding.tvPos

        smartTable = activityMainBinding.smartTable
        switchMaterial = activityMainBinding.switchMaterial
        activityMainBinding.ivSetup.setOnClickListener { popSetupDialog() }

        notifyReceiver = NotifyReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("RECEIVER")
        registerReceiver(notifyReceiver, intentFilter)

        view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        val bottomSheetDialogBinding = BottomSheetDialogBinding.bind(view)
        val recyclerview = bottomSheetDialogBinding.recyclerview
        recyclerview.setHasFixedSize(true)
        bottomSheetAdapter = BottomSheetAdapter()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = bottomSheetAdapter
        recyclerview.itemAnimator = null

        bottomSheetAdapter.setOnItemClickListener(object : BottomSheetAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int, task: Task) {
                currentTask = task
                getPlan(task.plan_id)
            }

            override fun onItemLongClick(view: View, position: Int) {

            }
        })

        val linearSnapHelper = LinearSnapHelper()
        linearSnapHelper.attachToRecyclerView(recyclerview)

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                filterSmartTable(s)
            }
        })

        switchMaterial.let {
            it.setOnClickListener {
                Log.d("mylog", "onCreate: " + switchMaterial.isChecked)
                switchStartAndEnd(switchMaterial.isChecked)
            }
        }

        bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(view)

        activityMainBinding.ivToggle.setOnClickListener { bottomSheetDialog.show() }

//        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                Log.d("mylog", "onProgressChanged: " + progress)
////                ivPic.setScaleAndCenter(progress / 5f + 0.2f, ivPic.center)
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//
//            }
//        })
//        ivLess.setOnClickListener {
//            ivPic.scaleImg(seekBar.progress)
//            if (seekBar.progress - 1 >= 0) {
//                seekBar.progress = seekBar.progress - 1
//                ivPic.scaleImg(seekBar.progress)
////                ivPic.setScaleAndCenter(ivPic.scale - 0.2f, ivPic.center)
////                Log.d("mylog", "ivPic.scale1: " + ivPic.scale)
//
//            }
//        }
//        ivAdd.setOnClickListener {
//            if (seekBar.progress + 1 <= 5) {
//                seekBar.progress = seekBar.progress + 1
//                ivPic.scaleImg(seekBar.progress)
////                ivPic.setScaleAndCenter(ivPic.scale + 0.2f, ivPic.center)
////                Log.d("mylog", "ivPic.scale2: " + ivPic.scale)
//            }
//        }
    }

    private fun getPlan(planId: String) {
        switchMaterial.isChecked = false
        ApiService.create().getPlan(planId)
            .enqueue(object : Callback<ArrayList<Plan>?> {
                override fun onResponse(
                    call: retrofit2.Call<ArrayList<Plan>?>,
                    response: Response<ArrayList<Plan>?>
                ) {
                    if (response.body() != null) {
                        planList = response.body()!!
                        initTable(planList)
                    }
                }

                override fun onFailure(call: retrofit2.Call<ArrayList<Plan>?>, t: Throwable) {

                }
            })
    }

    //??????????????????
    private fun switchStartAndEnd(checked: Boolean) {
        if (checked) {
            tvPos.text = "????????????????????????"
        } else {
            tvPos.text = "????????????????????????"
        }
        if (planList.size > 0) {
            ivPic.drawAir(planList, checked)
        }
    }

    private fun filterSmartTable(s: Editable?) {
        if (StringUtils.isEmpty(s)) {
            mFilterData = mSourceData
            smartTable.setData(mFilterData as List<Any>?)
        } else {
            val filteredList = ArrayList<Table>()
            for (mSourceDatum in mSourceData) {
                if (mSourceDatum.number?.contains(s.toString()) == true) {
                    filteredList.add(mSourceDatum)
                }
            }
            if (filteredList.size > 0) {
                smartTable.setData(filteredList as List<Any>?)
            } else {
                filteredList.add(Table("-1", "???", "???"))
                smartTable.setData(filteredList as List<Any>?)
            }
        }
    }

    private fun initTable(planList: ArrayList<Plan>?) {
        mSourceData = arrayListOf()
        if (planList != null && planList.size > 0) {
            setPosition(planList, mSourceData)
        }
    }

    //??????????????????
    private fun setPosition(
        planList: ArrayList<Plan>,
        mSourceData: ArrayList<Table>
    ) {
//        GlobalScope.launch(Dispatchers.Main) {
//            try {
//
//                for (plan in planList) {
//
//                    withContext(Dispatchers.IO) {
//                        if (!StringUtils.isEmpty(plan.stano)) {
//                            val stations = ApiService.create().getStation(plan.stano)
//                            if (stations.size > 0) {
//                                val station = stations[0]
//                                plan.cox = station.cox
//                                plan.coy = station.coy
//                                plan.angle = station.angle
//                                plan.statypeno = station.typeno
//                            }
//                        }
//
//                        val goodInfos = ApiService.create().getGoodInfo(plan.goodno)
//                        if (goodInfos.size > 0) {
//                            val goodInfo = goodInfos[0]
//                            plan.goodInfo = goodInfo
//
//                        }
//                        Log.d(
//                            "may",
//                            "plan.cox: ${plan.cox}plan.coy: ${plan.coy}plan.angle: ${plan.angle}"
//                        )
//                    }
//
//                    withContext(Dispatchers.IO) {
//                        if (!StringUtils.isEmpty(plan.planstano)) {
//                            val planStations = ApiService.create().getStation(plan.planstano)
//                            if (planStations.size > 0) {
//                                val planStation = planStations[0]
//                                plan.plancox = planStation.cox
//                                plan.plancoy = planStation.coy
//                                plan.planangle = planStation.angle
//                                plan.planstatypeno = planStation.typeno
//                            }
//                        }
//
//                        Log.d(
//                            "may",
//                            "plan.plancox: ${plan.plancox}plan.plancoy: ${plan.plancoy}plan.planangle: ${plan.planangle}"
//                        )
//                    }
//                }
//                Log.d("may===", "isMainThread=" + ThreadUtils.isMainThread())
//            } catch (e: Exception) {
//                ToastUtils.showShort(e.message)
//            }
//        }
        for (plan in planList) {
            val table = Table(plan.goodname, plan.stano, plan.planstano)
            mSourceData.add(table)
        }
        ivPic.drawAir(planList, false)
        smartTable.setData(mSourceData as List<Any>?)
        smartTable.setZoom(false)
        val config = smartTable.config
        config.isShowXSequence = false
        config.isShowYSequence = false
        config.isShowTableTitle = false
        config.horizontalPadding = 0
    }


    private fun popSetupDialog() {
        materialDialog = MaterialDialog(this)
            .show {
                noAutoDismiss()
                cancelable(false)
                cancelOnTouchOutside(false)
                customView(R.layout.url_dialog)
                negativeButton(R.string.cancel) {
                    materialDialog.cancel()
                }
                positiveButton(R.string.confirm) {
                    val customView = getCustomView()
                    val etUrl = customView.findViewById<EditText>(R.id.et_url)
                    if (!StringUtils.isEmpty(etUrl.text)) {
//                        val completeUrl = getCompleteUrl("http://" + etUrl.text.toString())
                        if (etUrl.text.contains(":")) {
                            val split = etUrl.text.split(":")
                            val ip = split[0]
                            val port = split[1]
                            if (!StringUtils.isEmpty(ip) && port.isNotEmpty() && RegexUtils.isMatch(
                                    RegexConstants.REGEX_INTEGER,
                                    port
                                )
                            ) {
                                val isIp = RegexUtils.isIP(ip)
                                if (isIp) {
                                    materialDialog.cancel()
                                    SPUtils.getInstance()
                                        .put("url", "http://" + etUrl.text.toString())
                                    ToastUtils.showShort("?????????????????????")
                                } else {
                                    ToastUtils.showShort("????????????????????????")
                                }
                            } else {
                                ToastUtils.showShort("????????????????????????")
                            }
                        } else {
                            val isIp = RegexUtils.isIP(etUrl.text)
                            if (isIp) {
                                materialDialog.cancel()
                                SPUtils.getInstance().put("url", "http://" + etUrl.text.toString())
                                ToastUtils.showShort("?????????????????????")
                            } else {
                                ToastUtils.showShort("????????????????????????")
                            }
                        }
                    } else {
                        ToastUtils.showShort("??????????????????")
                    }
                }

            }

    }


    //    ??????????????????????????????
//    private fun getCompleteUrl(text: String): Boolean {
//        val sb = StringBuilder();
//        sb.append("(");
//        for (f in a) {
//            sb.append(f);
//            sb.append("|");
//        }
//        sb.deleteCharAt(sb.length - 1);
//        sb.append(")");
//
//        val p = Pattern.compile(
//            "((https?|s?ftp|irc[6s]?|git|afp|telnet|smb)://)?((\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})|((www\\.|[a-zA-Z\\.\\-]+\\.)?[a-zA-Z0-9\\-]+\\.$sb(:[0-9]{1,5})?))((/[a-zA-Z0-9\\./,;\\?'\\+&%\\$#=~_\\-]*)|([^\\u4e00-\\u9fa5\\s0-9a-zA-Z\\./,;\\?'\\+&%\\$#=~_\\-]*))",
//            Pattern.CASE_INSENSITIVE
//        );
//        val matcher = p.matcher(text);
//        return matcher.matches()
//    }


    /*
     * Generates a BIG_TEXT_STYLE Notification that supports both phone/tablet and wear. For devices
     * on API level 16 (4.1.x - Jelly Bean) and after, displays BIG_TEXT_STYLE. Otherwise, displays
     * a basic notification.
     */
    private fun generateBigTextStyleNotification(task: Task) {

        // Main steps for building a BIG_TEXT_STYLE notification:
        //      0. Get your data
        //      1. Create/Retrieve Notification Channel for O and beyond devices (26+)
        //      2. Build the BIG_TEXT_STYLE
        //      3. Set up main Intent for notification
        //      4. Create additional Actions for the Notification
        //      5. Build and issue the notification

        // 0. Get your data (everything unique per Notification).
        val bigTextStyleReminderAppData: MockDatabase.BigTextStyleReminderAppData =
            MockDatabase.getBigTextStyleData(TimeUtils.millis2String(task.create_time))


        // 1. Create/Retrieve Notification Channel for O and beyond devices (26+).
        val notificationChannelId: String =
            NotificationUtil.createNotificationChannel(this, bigTextStyleReminderAppData)


        // 2. Build the BIG_TEXT_STYLE.
        val bigTextStyle =
            NotificationCompat.BigTextStyle() // Overrides ContentText in the big form of the template.
//                .bigText(bigTextStyleReminderAppData.bigText) // Overrides ContentTitle in the big form of the template.
                .setBigContentTitle(bigTextStyleReminderAppData.bigContentTitle) // Summary line after the detail section in the big form of the template.
                // Note: To improve readability, don't overload the user with info. If Summary Text
                // doesn't add critical information, you should skip it.
                .setSummaryText(bigTextStyleReminderAppData.summaryText)


        // 3. Set up main Intent for notification.
        val notifyIntent = Intent(this, MainActivity::class.java)

        // When creating your Intent, you need to take into account the back state, i.e., what
        // happens after your Activity launches and the user presses the back button.

        // There are two options:
        //      1. Regular activity - You're starting an Activity that's part of the application's
        //      normal workflow.

        //      2. Special activity - The user only sees this Activity if it's started from a
        //      notification. In a sense, the Activity extends the notification by providing
        //      information that would be hard to display in the notification itself.

        // For the BIG_TEXT_STYLE notification, we will consider the activity launched by the main
        // Intent as a special activity, so we will follow option 2.

        // For an example of option 1, check either the MESSAGING_STYLE or BIG_PICTURE_STYLE
        // examples.

        // For more information, check out our dev article:
        // https://developer.android.com/training/notify-user/navigation.html

        // Sets the Activity to start in a new, empty task
        notifyIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val notifyPendingIntent = PendingIntent.getActivity(
            this,
            0,
            notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )


        // 4. Create additional Actions (Intents) for the Notification.

        val fileIntent = Intent(this, BigTextIntentService::class.java)
//        bindService(fileIntent, ServiceConn(), Context.BIND_AUTO_CREATE)
        fileIntent.action = BigTextIntentService.ACTION_FILE
        val filePendingIntent = PendingIntent.getService(this, 0, fileIntent, 0)
        val fileAction: NotificationCompat.Action = NotificationCompat.Action.Builder(
            R.drawable.file,
            "??????",
            filePendingIntent
        )
            .build()


//        // Delay Action.
        val delayIntent = Intent(this, BigTextIntentService::class.java)
        delayIntent.action = BigTextIntentService.ACTION_DELAY
        val delayPendingIntent = PendingIntent.getService(this, 0, delayIntent, 0)
        val delayAction: NotificationCompat.Action = NotificationCompat.Action.Builder(
            R.drawable.delay,
            "????????????",
            delayPendingIntent
        )
            .build()


        // 5. Build and issue the notification.

        // Because we want this to be a new notification (not updating a previous notification), we
        // create a new Builder. Later, we use the same global builder to get back the notification
        // we built here for the snooze action, that is, canceling the notification and relaunching
        // it several seconds later.

        // Notification Channel Id is ignored for Android pre O (26).
        val notificationCompatBuilder = NotificationCompat.Builder(
            applicationContext, notificationChannelId
        )

        val notification =
            notificationCompatBuilder // BIG_TEXT_STYLE sets title and content for API 16 (4.1 and after).
                .setStyle(bigTextStyle) // Title for API <16 (4.0 and below) devices.
                .setContentTitle(bigTextStyleReminderAppData.contentTitle) // Content for API <24 (7.0 and below) devices.
                .setContentText(bigTextStyleReminderAppData.contentText)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.ic_launcher_foreground
                    )
                )
                .setContentIntent(notifyPendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL) // Set primary color (important for Wear 2.0 Notifications).
                .setColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.design_default_color_background
                    )
                ) // SIDE NOTE: Auto-bundling is enabled for 4 or more notifications on API 24+ (N+)
                // devices and all Wear devices. If you have more than one notification and
                // you prefer a different summary notification, set a group key and create a
                // summary notification via
                // .setGroupSummary(true)
                // .setGroup(GROUP_KEY_YOUR_NAME_HERE)
                .setCategory(Notification.CATEGORY_REMINDER) // Sets priority for 25 and below. For 26 and above, 'priority' is deprecated for
                // 'importance' which is set in the NotificationChannel. The integers representing
                // 'priority' are different from 'importance', so make sure you don't mix them.
                .setPriority(bigTextStyleReminderAppData.priority) // Sets lock-screen visibility for 25 and below. For 26 and above, lock screen
                // visibility is set in the NotificationChannel.
                .setVisibility(bigTextStyleReminderAppData.channelLockscreenVisibility) // Adds additional actions specified above.
                .addAction(fileAction)
                .addAction(delayAction)
                .setAutoCancel(true)
                .build()
        NotificationManagerCompat.from(this).notify(notificationid, notification)

    }

    inner class NotifyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.getStringExtra("action")) {
                "FILE" -> {
//                    min_id = SPUtils.getInstance().getString("min_id", "")
                    getPlan(planId)
                    switchMaterial.isChecked = false
                    if (bottomSheetAdapter.data.size > 0) {
                        for (index in bottomSheetAdapter.data.indices) {
                            if (currentTask.id == bottomSheetAdapter.data[index].id) {
                                bottomSheetAdapter.currentIndex = index
                                bottomSheetAdapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
        }
    }


    companion object {
        @JvmField
        var notificationid: Int = 888
    }

}

