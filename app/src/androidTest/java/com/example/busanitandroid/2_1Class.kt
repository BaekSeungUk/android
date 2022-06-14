package com.example.basickotlin

//클래스
class ClassBasic {
    //변수 선언
    var name = "sik"

    //생성자
    constructor(name: String){
        this.name = name
    }

    //함수 선언
    fun some(){
        println("name : ${name}")
    }

    //내부 클래스
    class innerClass{
        //수행문 or 변수 or 함수 등등 ..
    }

    //생성자
    // 주 생성자와 보조 생성자로 구분
    // 주 생성자는 필수는 아님. 한 클래스에 하나만 생성 가능
    // 주 생성자의 선언 방법1 - constructor키워드 선언
    class Tester constructor(){}

    // 주 생성자의 선언 방법2 - constructor키워드 생략
    class Tester2(){}

    // 주 생성자의 선언 방법3 - 매개변수가 없는 주 생성자 자동 선언
    class Tester3{}
}

class User2(name: String, count:Int){
    // init키워드 - 주생성자 본문 구현
    // 객체 생성시 자동으로 실행
    init {
        println("객체 생성시 자동 실행 : ${name}, ${count}")
    }
    var name2 = name
    var count2 = count
    fun test(){
        // 생성자 매개변수를 함수에서 사용하는 법1
        // 함수내부에서 생성자의 매개변수를 호출할때는
        // 클래스 내부에서 지역변수를 선언하여, 생성자 매개변수를 할당하여 사용가능하다.
        println("테스트 함수에서 생성자의 매개변수 호출 : ${name2} , ${count2}")
    }
}

// 생성자 매개변수를 함수에서 사용하는 법2
// 생성자 매개변수를 val 키워드를 사용하여 선언
class User3(val name:String, val count: Int){
    fun test(){
        println("${name} , ${count}")
    }
}

// 보조 생성자
// 보조생성자 선언 - 클래스 내부에 constructor 키워드를 사용
// 여러개를 추가 가능
class User4{
    constructor(name: String){
        println("보조 생성사1 : ${name}")
    }

    constructor(name: String, count: Int){
        println("보조 생성자2 : ${name} , ${count}")
    }
}

// 보조생성자에 주생성자 연결
class User5(name:String){
    init {
        println("name : ${name}")
    }

    // 보조 생성자로 객체 생성시
    // 클래스내에 주 생성자가 있다면, this()구문을 이용해서 생성자를 호출
    constructor(name:String, count: Int):this(name){
        println("보조 생성자, 주 생성자 연결 1 : ${name} , ${count}")
    }

    constructor(name:String, count: Int, email:String):this(name, count){
        println("보조 생성자1 , 보조 생성자2 연결 : ${name} , ${count} , ${email}")
    }
}

fun main() {
//    var user = User2("sik", 4)
//    var user4 = User4("sik")
    var user5 = User5("sik" , 6 , "sik@email.com")
}