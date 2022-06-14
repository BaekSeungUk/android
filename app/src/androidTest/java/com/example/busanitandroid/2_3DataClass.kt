package com.example.basickotlin

import android.provider.ContactsContract

//데이터 클래스 - data라는 키워드를 이용
data class DataClass(val name:String, val email: String){
    lateinit var addr:String
    constructor(name: String, email: String, addr:String):this(name, email){
        this.addr = addr
    }
}

class NonDataClass(val name:String, val email: String){
    lateinit var addr:String
    constructor(name: String, email: String, addr: String):this(name,email){
        this.addr = addr
    }
}

//fun main() {
//    var data1 = DataClass("sik", "sik@email.com", "seoul")
//    var data_1 = DataClass("sik", "sik@email.com", "seoul")
//    var data2 = NonDataClass("sik", "sik@email.com", "seoul")
//    var data_2 = NonDataClass("sik", "sik@email.com", "seoul")
//
//    //toString() -> 객체의 데이터를 반환
//    println("""
//        data Class.toString() : ${data1.toString()}
//        NonDataclass.toString() : ${data2.toString()}
//    """.trimIndent())
//
//    //equals -> 객체 비교
//    println("""
//        data Class.equals() : ${data1.equals(data_1)}
//        NonDataclass.equals() : ${data2.equals(data_2)}
//    """.trimIndent())
//}

//오브젝트 클래스
// object뒤에 콜론을 입력하고, 그뒤에 상위 또는 인터페이스를 입력한다.
open class Super3{
    open var data = 10
    open fun someFun(){
        println("부모 클래스 함수 : ${data}")
    }
}

val obj = object:Super3(){
    override var data: Int = 20
    override fun someFun() {
        println("자식 클래스 함수 : ${data}")
    }
}

//fun main() {
//    obj.data = 30
//    obj.someFun()
//}

//컴페니언 클래스
// 멤버 변수나 함수를 클래스 이름으로 접근 하고자 할때 사용
class MyClass{
    companion object{
        var data = 10
        fun some(){
            println(data)
        }
    }
}

fun main() {
    MyClass.data = 30
    MyClass.some()
}