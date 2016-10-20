# Java Tech Interview

## 자바쓰레드 `start()`는 두번 호출 될 수 있는가?

될 수 없다. 두번 호출하면 IllegalThreadStateException() 이 발생한다.

## `static` 메소드를 오버라이드 할 수 있는가?

할 수 없다. JVM이 일반 메소드를 호출할 때 메소드 구현의 실체를 따라가 호출하지만 `static` 메소드를 호출할 경우 컴파일 시점에 선언된 타입을 호출하기 때문
 
## serialization 인터페이스에는 어떤 메소드가 있는가?
 
serialization 인터페이스는 메소드가 없다. 단지 직렬화 할 수 있다는 마커 인터페이스이기 때문

## `super()`와 `this()`의 차이?

`super()`는 super 클래스의 생성자를 호출, `this()`는 동일한 클래스의 생성자를 호출

## 메소드 overridden 방지법은 ?

메소드에 final 키워드를 선언하여 서브 클래스에 재정의를 막을 수 있음