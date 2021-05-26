/*
Copyright 2016 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.example.layoutapp.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationManagerCompat;

import com.example.layoutapp.MainActivity;

import java.util.concurrent.TimeUnit;

/**
 * Asynchronously handles snooze and dismiss actions for reminder app (and active Notification).
 * Notification for for reminder app uses BigTextStyle.
 */
public class BigTextIntentService extends IntentService {

    private static final String TAG = "BigTextService";

    public static final String ACTION_FILE = "FILE";
    public static final String ACTION_DELAY = "DELAY";

    private static final long DELAY_TIME = TimeUnit.SECONDS.toMillis(5);

    public BigTextIntentService() {
        super("BigTextIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent(): " + intent);

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FILE.equals(action)) {
                handleActionFile(action);
            } else if (ACTION_DELAY.equals(action)) {
                handleActionDelay();
            }
        }
    }

    /**
     * Handles action Dismiss in the provided background thread.
     * @param action
     */
    private void handleActionFile(String action) {
        Log.d(TAG, "handleActionDismiss()");

        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.cancel(MainActivity.notificationid);
        Intent intent = new Intent();
        intent.putExtra("action", action);
        intent.setAction("RECEIVER");
        sendBroadcast(intent);
    }

    /**
     * Handles action Snooze in the provided background thread.
     */
    private void handleActionDelay() {
        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.cancel(MainActivity.notificationid);
    }

}
