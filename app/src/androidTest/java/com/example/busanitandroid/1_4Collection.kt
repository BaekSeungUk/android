package com.example.basickotlin

//컬렉션타입
// 배열- Array
// 같은 타입의 변수들로 이루어진 집합
// 배열을 구성하는 각각의 값을 배열요소(element)라고 하고,
// 배열에서의 위치를 기리키는 숫자는 인덱스(index)라고 한다.(인데스는 0부터 시작함)

// 배열생성
// 크기가 3인 배열을 생성하고, 각 값은 0으로 초기화
val array:Array<Int> = Array(3,{0})
// 배열에 접근할때 - 대괄호를 [] 이용하거나, set(), get() 함수를 이용한다.
//fun main() {
//    // 배열에 값을 할당
//    array[0] = 1
//    array[1] = 2
//    array.set(2,3)
//
//    // 배열의 값을 확인
//    println("배열의 데이터 확인 : ${array.get(0)} , ${array[1]} , ${array[2]}")
//    println("배열의 사이즈 : ${array.size}")
//}

//기초타입 배열 생성 - 선언과 동시에 크기할당, 초기값 일괄 할당
val boolArray:BooleanArray = BooleanArray(4,{false})
val char: CharArray = CharArray(3, {'a'})

// 기초타입 배열 생성2 - 선언과 동시에 초기값 할당
val intArray = intArrayOf(10,20,30)
val boolArray2 = booleanArrayOf(true,false,true)

val intArray2 = arrayOf<Int>(40,50,60)
val strArray = arrayOf("a","b","c")

//List, Set, Map
// List - 순서가 있다. 데이터 중복 허용
// Set - 순서가 없다, 데이터 중복이 안됨
// Map - key값과 value값으로 이루어진 데이터 집합, 순서가 없다. key값은 중복 불허용
fun main() {
    // listOf - 불변
    var list = listOf<Int>(1,2,3)

    // mutablListOf - 가변
    var list2 = mutableListOf<Int>(4,5,6)
    list2[0] = 8
    list2.set(2, 7)
    list2.add(3,9)
    list2.add(4, 9)
//    println("${list2.get(0)} , ${list2[1]} , ${list2[2]} , ${list2.get(3)} , ${list2.get(4)}")

    var set = mutableSetOf<Int>(1,2,3)
    set.add(5)
    set.add(1) // 중복된 값
    set.add(4)
//    println(set)

    var map = mutableMapOf<String, String>(Pair("first", "1"), "second" to "2")
    map.put("three","3") //map에 새로운 키,value 추가
    println(map)
    println(map.get("first") + map.get("second")) // 키값이 first, second에 해당하는 value값 가져오기
    println(map.keys) //전체 키값을 출력
}






