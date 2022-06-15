package com.bitc.ex5_noti_edu

import android.annotation.TargetApi
import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import com.bitc.ex5_noti_edu.databinding.ActivityMainBinding
import com.bitc.ex5_noti_edu.databinding.DialogInputBinding

class MainActivity : AppCompatActivity() {

    // minSdk버전이 21로 지정되어있어서 CallStyle을 사용하면 문제가 발생
    // 1. @RequiresApi(Build.VERSION_CODES.S) : 지정한 API레벨 이상에서 사용해야 함을 알림
    /*@RequiresApi(Build.VERSION_CODES.S)
    fun noti() {
        lateinit var person: Person
        lateinit var pendingIntent: PendingIntent
        val builder: Notification.Builder = Notification.Builder(this)
            .setStyle(Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent))
    }*/

    // 2. @TargetApi(Build.VERSION_CODES.S) : 지정한 API레벨보다 낮은 API에서 함수를 호출할 경우 에러가 발생
    /*@TargetApi(Build.VERSION_CODES.S)
    fun noti() {
        lateinit var person: Person
        lateinit var pendingIntent: PendingIntent
        val builder: Notification.Builder = Notification.Builder(this)
            .setStyle(Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent))
    }*/

    /*fun noti() {
        lateinit var person: Person
        lateinit var pendingIntent: PendingIntent
        val builder: Notification.Builder =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                // 휴대폰의 안드로이드버전이 안드로이드 12버전 (API 31) 이상일때 실행
                Notification.Builder(this)
                    .setStyle(Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent))
            } else {
                // 휴대폰의 안드로이드버전이 안드로이드 12버전 (API 31) 이전버전 일때 실행
            TODO("VERSION.SDK_INT < S")
            }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        // 한줄 지우기 단축키 : ctrl + y

        //토스메세지 생성
        val toast = Toast.makeText(this,"권한을 허용해주세요.", Toast.LENGTH_LONG)

        //버튼 클리시 토스트메세지 발생
        /*val toastBtn = findViewById<Button>(R.id.toastBtn) // 바인딩기법 적용x
        toastBtn.setOnClickListener {
            toast.show()
        }*/
        val toastBtn = binding.toastBtn
        toastBtn.setOnClickListener {
            toast.show()
        }

        // 권한 체크
       /* val status = ContextCompat.checkSelfPermission(this,
            "android.permission.ACCESS_FINE_LOCATION")
        if (status == PackageManager.PERMISSION_GRANTED) {
            Log.d("myLog","권한 허용")
        }else {
            Log.d("myLog","권한 거부")
            toast.show()
        }*/

        // 권한 요청
/*        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            isGranted ->
            if (isGranted) {
                Log.d("myLog","권한을 허용하였습니다.")
            } else {
                Log.d("myLog","권한을 거부하였습니다.")
                toast.show()
            }
        }
        requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")*/

        //데이트 피커 다이얼로그 사용
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            DatePickerDialog(this, object:DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("myLog","year: ${year}, month : ${month}, dayOfMonth: ${dayOfMonth}")
                }
            }, 2022,5,15).show()
        }*/

        // 타임 피커 다이얼로그 사용
        /*TimePickerDialog(this, object  : TimePickerDialog.OnTimeSetListener{
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                Log.d("myLog","time : ${hourOfDay}, minute : ${minute}")
            }
        },15,0,true).show()*/

        // 알림창 띄우기
        /*AlertDialog.Builder(this).run {
            setTitle("테스트 알림")
            setIcon(android.R.drawable.ic_dialog_info)
            setMessage("정말 종료하시겠습니까?")
            setPositiveButton("확인",null)
            setNegativeButton("취소",null)
            setNeutralButton("자세히",null)
            show()
        }*/

        // 목록을 출력하는 알림 창
        val items = arrayOf("사과","바나나","배","키위")
        /*AlertDialog.Builder(this).run {
            setTitle("다음중 좋아하는 과일이은?")
            setItems(items,object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Log.d("myLog","선택한 과일은 : ${items[which]}")
                }
            })
            setPositiveButton("선택",null)
            setNegativeButton("취소",null)
            show()
        }*/

        //체크박스를 이용한 다중선택
        /*AlertDialog.Builder(this).run {
            setTitle("다음중 좋아하는 과일은?")
            setMultiChoiceItems(items, booleanArrayOf(false,true,false,false)
                , object :DialogInterface.OnMultiChoiceClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        Log.d("myLog",
                            "${items[which]} 가(이) ${if(isChecked) "선택되었습니다." else "선택 해제 되었습니다."}")
                    }
                })
            setPositiveButton("닫기",null)
            show()
        }*/
        
        // 라디오버튼을 이용한 단일 선택
        /*AlertDialog.Builder(this).run { 
            setTitle("좋아하는 과일은 하나만 선택해주세요")
            setSingleChoiceItems(items, 0, object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Log.d("myLog","${items[which]} 가(이) 선택 되었습니다.")
                }
            })
            setPositiveButton("닫기",null)
            show()
        }*/

        // 뒤로가기 버튼 or 바깥영역 터치시 알림창 닫히지 않도록 설정
       /* AlertDialog.Builder(this).run {
            setTitle("좋아하는 과일은 하나만 선택해주세요")
            setSingleChoiceItems(items, 0, object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Log.d("myLog","${items[which]} 가(이) 선택 되었습니다.")
                }
            })
            setPositiveButton("닫기",null)
            setCancelable(false) // 뒤로가기 버튼 눌렀을때 닫히지 않도록 설정
            show()
        }.setCanceledOnTouchOutside(false) // 바깥영역 터치시 닫히지 않도록 설정*/

        // 커스텀 다이얼로그 만들기
        // 1. 레이아웃 xml파일 생성
        // 2. LayoutInflater로 초기화(xml파일에 선언한 뷰를 코드에서 이용하고자 생성)
        // xml파일 초기화
        /*val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_input,null)
        AlertDialog.Builder(this).run { 
            setTitle("커스텀 다이얼로그")
            setView(dialogView)
            setPositiveButton("닫기",null)
            show()
        }*/
        
        // 뷰바인딩을 적용한 xml파일 초기화
        /*val dialogBinding = DialogInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AlertDialog.Builder(this).run {
            setTitle("커스텀 다이얼로그")
            setView(dialogBinding.root)
            setPositiveButton("닫기", null)
            show()
        }*/

        // 소리얻기
        val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val ringtone = RingtoneManager.getRingtone(applicationContext, notification)
        
        // 버튼을 누를때마다 ringtone.play() 실행
        val ringBtn = binding.ringBtn
        ringBtn.setOnClickListener {
            ringtone.play()
        }
        
        // 음원 재생
        // 버튼을 누를때마다 음원재생
        val player : MediaPlayer = MediaPlayer.create(this,R.raw.music)
        binding.musicBtn.setOnClickListener {
            player.start()
        }
        
        //진동 얻기
        // 1. 진동 권한 설정
        // 2. 진동객체 얻기
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            getSystemService(VIBRATOR_SERVICE) as Vibrator
        }

        // 진동알림(기본세기)
        binding.vibrateBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(500,
                        VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                vibrator.vibrate(500)
            }
        }

        //진동알림(패턴반복)
        binding.vibrateBtn2.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    // 매개변수1 : 진동이 울리는 시간 패턴
                    // 매개변수2 : 진동 세기 패턴배열
                    // 매개변수3 : 반복 횟수
                VibrationEffect.createWaveform(longArrayOf(500,1000,500,2000),
                    intArrayOf(0,50,0,200), -1)
                )
            } else {
                vibrator.vibrate(longArrayOf(500,1000,500,2000),-1)
            }
        }
    }
}