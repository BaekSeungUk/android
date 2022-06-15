package com.bitc.ex5_noti_edu2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.bitc.ex5_noti_edu2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //알림빌더 작성
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            )

            // 채널에 다양한 정보 설정
            // 채널 설명 문자열
            channel.description = "my channel one description"
            // 홈화면의 아이콘에 배지 아이콘 출력 여부
            channel.setShowBadge(true)
            // 알림음 얻기
            val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()
            // 알림음 재생
            channel.setSound(uri, audioAttributes)
            // 불빛 표시 여부
            channel.enableLights(true)
            // 불빛이 표시가 된다면 불빛의 색상
            channel.lightColor = Color.RED
            // 징동을 울릴지 여부
            channel.enableVibration(true)
            // 진동이 울린다면 진동의 패턴
            channel.vibrationPattern = longArrayOf(100, 200, 100, 200)

            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)
            builder = NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        // 알림 객체 설정
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentTitle("알림 타이틀")
        builder.setContentText("알림 메세지 입니다.")

        binding.notifi.setOnClickListener {
            // 알림 발생
            manager.notify(11,builder.build())
        }

        // 알림터치 이벤트(특정 페이지로 이동)
        val intent = Intent(this, DetailActivity::class.java)
        val pendingIntent = PendingIntent
            .getActivity(this,10,intent,PendingIntent.FLAG_IMMUTABLE)
        builder.setContentIntent(pendingIntent)

        //액션 등록
        builder.addAction(
            NotificationCompat.Action.Builder(
                android.R.drawable.ic_notification_overlay ,
                "Action",
                pendingIntent
            ).build()
        )
    }
}