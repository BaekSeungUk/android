package com.bitc.exam9_sqlite_edu

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import com.bitc.exam9_sqlite_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // db 객체 생성
        val db:SQLiteDatabase = DBHelper(this).writableDatabase
        // db생성
//        val db = openOrCreateDatabase("tesdb", Context.MODE_PRIVATE,null)
        // 테이블 생성
        // execSQL : create, alter, drop, insert, update, delete 문을 실행하는 함수
       /* db.execSQL("create table USER_DB(" +
                "_id integer primary key autoincrement," +
                "name not null," +
                "phone)")*/
        // insert문 실행
      /*  db.execSQL("insert into USER_DB(name,phone) values(?,?)",
                arrayOf("sik","01012345678")
        )*/
        // ContentValues함수를 이용한 insert함수 사용
        /*val values = ContentValues()
        values.put("name", "kim")
        values.put("phone", "01055559999")
        db.insert("USER_DB",null,values)*/

        // select문 실행
        // rawQuery : 반환값이 cursor 객체이다 (조회한 행의 집합)
//        val cursor = db.rawQuery("select * from USER_DB",null)

        // query함수 사용 - select문
       /* val cursor = db.query(
            "USER_DB",
            arrayOf("_id", "name", "phone"),
            null, //"phone=?"
            null, // arrayOf("01012345678")
            null,
            null,
            null
        )

        if (cursor != null) {
            while (cursor.moveToNext()) {
                // USER_DB 테이블에 컬럼이 _id(0) , name(1) , phone(2)
                val ID = cursor.getString(0)
                val name = cursor.getString(1)
                val phone = cursor.getString(2)
                Log.d("myLog","ID : ${ID} , name : ${name} , phone : ${phone}")
            }
        }*/
     /*   
        // TODO_TB 테이블에 데이터 삽입
        db.execSQL("insert into TODO_TB(todo) values(?)", arrayOf("할일 첫번째"))

        // TODO_TB 테이블에서 조회 및 데이터 출력
        val cursor2 = db.rawQuery("select * from TODO_TB",null)
        if (cursor2 != null) {
            while (cursor2.moveToNext()) {
                val todo = cursor2.getString(1)
                Log.d("myLog","할일 : ${todo}")
            }
        }*/
        
        // 등록버튼을 눌렀을때 name, phone 값을 DB에 저장하고 확인
        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.submit.setOnClickListener {
            manager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            val name = binding.name.text.toString()
            val phone = binding.phone.text.toString()
            binding.user.text = "입력한 내용은 name : ${name}, phone : ${phone}"
            binding.name.text.clear()
            binding.phone.text.clear()

            db?.execSQL("insert into USER_DB(name,phone) values(?,?)", arrayOf(name,phone))

            val cursor = db?.query(
                "USER_DB",
                arrayOf("name","phone"),
                "phone=?",
                arrayOf(phone),
                null,
                null,
                null
            )
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    val name = cursor.getString(0)
                    val phone = cursor.getString(1)
                    Log.d("myLog","select name : ${name} , phone : ${phone}")
                }
            }
        }
    }
}