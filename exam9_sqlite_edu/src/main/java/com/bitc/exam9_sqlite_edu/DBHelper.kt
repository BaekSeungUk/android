package com.bitc.exam9_sqlite_edu

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context):SQLiteOpenHelper(context,"testDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // 앱이 설치된 후 SQLiteOpenHelper 클래스가 이용되는 순간 한번 호출
        /*db?.execSQL("create table TODO_TB(" +
                "_id integer primary key autoincrement," +
                "todo not null)")*/
        db?.execSQL("create table USER_DB(" +
                "_id integer primary key autoincrement," +
                "name not null," +
                "phone)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // 생성자에게 지정한 DB 버전 정보가 변경될 때 마다 호출
    }
}