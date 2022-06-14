package com.example.basickotlin

//조건문
//When - 특정 변수의 값에 따라 여러가지 흐름으로 제어 가능
//형태
// when(변수) {
//      조건 -> 수행문
//      조건2 -> 수행문
//      else -> { // 조건,조건2외 의 경우일때
//          수행문
//      }
// }

fun main() {
    var data2:Any = 20
//    when(data2){
//        "10" -> println("data는 10이다")
//        "20" -> println("data는 20이다")
//        else -> {
//            println("해당하는 값이 항목에 없음.")
//        }
//    }

    //다양한 조건 활용
//    when(data2){
//        is String -> println("data2는 String타입이다.") // is 타입 -> 타입을 확인하는 연산자
//        10, 30 -> println("data2는 10 혹은 30이다.")
//        in 1..30 -> println("data2는 1부터 30사이의 값이다.") // in -> 범위지정
//        else -> println("data2가 올바르지 않습니다.")
//    }

    //when도 표현식으로 사용이 가능
    var data3 = 10
    var result = when{
        data3 <= 0 -> "0은 data3보다 작거나 같다"
        data3 > 100 -> "data3은 100보다 크다."
        else -> "data3은 그외 값이다."
    }
    println(result)
}