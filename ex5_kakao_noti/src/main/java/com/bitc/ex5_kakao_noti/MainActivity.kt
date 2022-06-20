package com.bitc.ex5_kakao_noti

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.bitc.ex5_kakao_noti.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notiBtn.setOnClickListener {
            // 매니저 생성
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // 알림빌더
            val builder: NotificationCompat.Builder
            // 알림 호환성 추가
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // 26버전 이상
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    // 채널의 정보 설정
                    description = "My Channel One Description"
                    setShowBadge(true)
                    val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    val audioAttributes = AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                    setSound(uri, audioAttributes)
                    enableVibration(true)
                }
                // 채널에 NotificationManager에 등록
                manager.createNotificationChannel(channel)
                // 채널을 이용하여 Builder 생성
                builder = NotificationCompat.Builder(this, channelId)
            } else {
                // 26버전 이전
                builder = NotificationCompat.Builder(this)
            }

            // 알림에 대한 설정
            builder.run {
                setSmallIcon(R.drawable.small)
                setWhen(System.currentTimeMillis())
                setContentTitle("김영식")
                setContentText("안녕하세요. 오늘은 2022년 6월 20일 입니다. ")
                setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.big))
            }

            // 원격입력
            val KEY_TEXT_REPLY = "key_text_reply"
            var replyLabel = "답장"
            var remotInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
                setLabel(replyLabel)
                build()
            }

            // 리시버에 연결
            val replyIntent = Intent(this,ReplyReceiver::class.java)
            val replyPendingIntent = PendingIntent.getBroadcast(
                this,30,replyIntent,PendingIntent.FLAG_MUTABLE
            )

            // 알림에 액션추가
            builder.addAction(
                NotificationCompat.Action.Builder(
                    R.drawable.send,
                    "답장",
                    replyPendingIntent
                ).addRemoteInput(remotInput).build()
            )
            // 알림 실행
            manager.notify(11,builder.build())
        }
    }
}