package com.example.basickotlin

//함수
// fun이라는 키워드를 이용하여 생성
// 반환타입을 선언 혹은 생략 가능하고, 생략하면 자동으로 Unit타입이 적용된다.
// 매개변수는 val이 자동으로 적용된다.

// 함수 선언 형식
// fun 함수명(매개변수명:타입):반환타입{ 수행문 }

// 함수의 매개변수에는 기본값 선언이 가능
fun addNum(a:Int, b:Int = 2):Int{
    return a+b
}

fun main() {
    // 매개변수명을 생략하여 호출
    println("매개변수 b에 기본값 적용 : "+addNum(10))
    println("매개변수를 임의로 할당 : "+ addNum(2,5))

    //매개변수를 지정하여 호출
    println("매개변수를 지정하여 호출 : "+ addNum(b=3, a=1))
}