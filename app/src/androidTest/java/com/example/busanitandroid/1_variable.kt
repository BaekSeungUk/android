package com.example.basickotlin

//1_변수
//변수 선언 형식
// val (혹은) var 변수명:타입 = 값

//var - 변수
var a:Int = 10 //초기화 해야함

//val - 상수
val b:Int = 20

// 초기화 미루기
// lateint var -> 최상단,클래스내에서 초기화를 미룰수 있지만, String타입으로만 사용이 가능하다.
lateinit var late:String

// 함수 (메인함수)
// 실행 -> play버튼 클릭 혹은 ctrl+shift+F10
// 주석 -> ctrl+/
//fun main() {
//    var c:Int // 초기화 안해도 괜찮음 하지만, 값을 할당 해줘야 작업이 가능하다.
//    a=20
////    println("Hello World!")
////    b=30 -> 문법적 오류 발생
//    c = 30
//    println(c)
//}

class variable{
//    var d:Int -> 초기화 필요
lateinit var late2:String
}

//by lazy - 선언과 동시에 초기화를 해야함
// 호출시점에서 최초 1회 초기화가 됨.
// val 키워드로만 사용가능
val late2:Int by lazy { 
    println("lazy 키워드를 이용한 초기화 미루기 - 최초 1회만 실행")
    30
}

//fun main() {
//    println("메인 함수에서 실행")
//    println(late2+10) // 최초 호출
//    println(late2+30) // 두번째 호출
//}

//문자열
//String 삼중따옴표 -> 여러줄을 문자열로 사용가능
var str: String = """
    안녕하세요
    안드로이드 스튜디오 입니다.
    여러줄을 쓸수가 있네요.
""".trimIndent()

fun main() {
    //문자열 템플릿 -> $이용
    println("문자열 템플릿 실습 : ${str}")
}


