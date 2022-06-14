package com.example.basickotlin

// 반복문
//for문

//for문 형태
// for(i in 범위){ 수행문 }

fun main() {
    //1부터 10까지 출력
    for (i in 1..10){
        print(" "+i)
    }
    println()
    //1부터 9까지 1씩 증가(10은 미포함)
    for(i in 1 until 10){
        print(" "+i)
    }
    println()
    //2부터 10까지 2씩 증가
    for (i in 2..10 step 2){
        print(" "+i)
    }
    println()
    // 10부터 1까지 1씩 감소
    for (i in 10 downTo 1){
        print(" "+i)
    }
    println()
    //while문
    // 형태
    // while(조건문) { 수행문 }

    // 1부터 10까지 누적합
    var x = 0
    var sum1 = 0
    while (x<10){
        ++x
        sum1 += x
    }
    println(sum1)
}




