//package com.example.ex8_component
//
//import android.app.Activity
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.PersistableBundle
//import android.util.Log
//import androidx.activity.result.ActivityResultLauncher
//import androidx.activity.result.contract.ActivityResultContracts
//import com.example.ex8_component.databinding.ActivityMainBinding
//
//class MainActivity_back : AppCompatActivity() {
//    var cnt = 0
//    override fun onDestroy() {
//        // 액티비티가 종료(비활성화) 될때
//        super.onDestroy()
//        Log.d("myLog","onDestroy")
//    }
//
//    override fun onStop() {
//        // 액티비티가 비활성화 될때 onPause보다 뒤에 실행
//        super.onStop()
//        Log.d("myLog","onStop")
//    }
//
//    override fun onPause() {
//        // 액티비티가 일시 정지 될때
//        super.onPause()
//        Log.d("myLog","onPause")
//    }
//
//    override fun onStart() {
//        // 액티비티가 실행(재실행) 될때 1
//        super.onStart()
//        Log.d("myLog","onStart")
//    }
//
//    override fun onResume() {
//        // 액티비티가 재실행(혹은 실행) 될때 2 - 실행을 시킨 이후
//        super.onResume()
//        Log.d("myLog","onResume")
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        cnt = savedInstanceState.getInt("cnt")
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("cnt",cnt)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        // 앱 실행시 최초 한번만 호출
//        super.onCreate(savedInstanceState)
//        Log.d("myLog","onCreate")
////        setContentView(R.layout.activity_main)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        //데이터를 다시 돌려받을때_2
//        //ActivityResultLauncher 생성
//        val requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
//            ActivityResultContracts.StartActivityForResult()){
//                val resultData = it.data?.getStringExtra("resultData")
//                Log.d("myLog","resultData : ${resultData}")
//            }
//
//
//        binding.btn?.setOnClickListener {
//            val intent = Intent(this,DetailActivity::class.java)
//            //인텐트에 엑스트라 데이터 추가
//            intent.putExtra("myData1","sik")
//            intent.putExtra("myData2",20)
////            startActivity(intent)
//
//            //데이터를 다시 돌려받을때_1 : startActivityForResult 사용
////            startActivityForResult(intent,10)
//
//            //데이터를 다시 돌려받을때_2 : requestLauncher 이용
//            requestLauncher.launch(intent)
//        }
//        val data = savedInstanceState?.getInt("cnt")
//        if(data != null){
//            cnt = data
//            binding.cntView.text = cnt.toString()
//        }
//        binding.cntBtn.setOnClickListener {
//            cnt += 1
//            binding.cntView.text = cnt.toString()
//        }
//    }
//
//    //데이터를 다시 돌려받을때_1
//    // 결과를 돌려받은후 처리
////    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
////        super.onActivityResult(requestCode, resultCode, data)
////        if(requestCode == 10 && resultCode == Activity.RESULT_OK){
////            val result = data?.getStringExtra("resultData")
////            Log.d("myLog","result : ${result}")
////        }
////    }
//}