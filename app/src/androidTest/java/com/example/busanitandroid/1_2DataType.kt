package com.example.basickotlin

//any - 모든타입이 가능
val any:Any = 10
val any2:Any = "가나다"

class any3
val any4: Any = any3()

// unit - 반환문이 없는 함수의 타입
fun unit():Unit{
    println("unit 타입 명시")
}

fun unit2(){
    println("unit 타입 생략")
}

// Nothing
// null이나 예외를 리턴하는 타입
// 의도적으로 에러를 발생시킬때 사용

//예외를 던지는 Nothing
fun fail():Nothing{
    throw IllegalAccessException("에러발생")
}

//null을 리턴하는 Nothing
fun fail2():Nothing?{
    return null
}

// 널 허용 과 불허용
// 변수나 함수의 리턴값을 null로 받을수도 있다.
// 타입뒤 물음표를 붙인다.

var num:Int? = 10
var num2:Int = 20

fun main() {
    num = null
//    num2= null -> null값을 가질수 없다. 에러발생
    println("예외처리 Nothing 실행")
//    fail()
}














