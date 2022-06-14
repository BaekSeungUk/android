package com.example.basickotlin


// 상속 - open키워드를 사용해서
open class Super(name: String){
    init {
        println("부모 클래스 생성")
    }
}

// 자식클래스 -> 클래스의 타입에 부모클래스를 명시해준다.
//class Sub(name: String):Super(name){
//    init {
//        println("자식 클래스 생성")
//    }
//}

//자식클래스 보조 생성자만 있는경우
class Sub:Super{
    constructor(name:String):super(name){
        println("자식 클래스 생성 2")
    }
}

//fun main() {
//    val sub = Sub("sik")
//}

// 오버라이딩(재정의)
open class Super2{
    // 변수에 open 키워드 이용하여 작성
    open var superData = 10
    open fun testFun(){
        println("부모 클래스의 함수 호출 : ${superData}")
    }
}

class Sub2:Super2(){
    // ovveride 키워드를 이용하여 부모클래스의 변수(함수 등등) 재정의
    override var superData = 20
    override fun testFun() {
        println("자식 클래스의 함수 호출 : ${superData}")
    }
}

//fun main() {
//    val obj = Sub2()
//    obj.testFun()
//}

//접근 제한자
// public , internal, protected, private
//최상단에서 선언할경우
public var pub = 1 // 모든 파일에서 접근 가능
internal var inter = 2 // 같은 모듈 내에서 접근가능
private var pri = 3 // 파일내부에서만 접근 가능

open class Public{
    // 클래스 내부에서 선언한 경우
    open public var pub2 = 1 // 모든 클래스에서 접근 가능
    open internal var inter2 = 2 // 같은 모듈내에서 접근 가능
    private var pri2 = 3 // 클래스 내부에서만 이용가능
    open protected var pro2 = 6
}

class Child: Public(){
    override var pro2: Int = 8
    override var pub2: Int = 5
    override var inter2: Int = 6
    protected var pro = 4 // 상속관계의 하위(자식) 클래스에서만 사용 가능
}

fun main() {
    var child = Child()
    child.inter2
    child.pub2
}