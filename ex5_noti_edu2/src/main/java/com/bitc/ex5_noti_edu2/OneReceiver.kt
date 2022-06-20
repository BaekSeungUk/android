package com.bitc.ex5_noti_edu2

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class OneReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        // 알림의 입력 글 획득
        val replyTxt = RemoteInput.getResultsFromIntent(intent)?.getCharSequence("key_text_reply")
        Log.d("myLog","reply txt : ${replyTxt}")

        val manager = context.getSystemService(
            AppCompatActivity.NOTIFICATION_SERVICE
        ) as NotificationManager
        manager.cancel(11)
    }
}