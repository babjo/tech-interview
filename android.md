# Android Tech Interview

## 액티비티 생명 주기

A 액티비티 시작 -> A's `onCreate()` -> A's `onStart()` -> A's `onResume()` -> A 액티비티 실행

B 액티비티 실행되면, A's `onPause()` 호출.
A 액티비티가 화면상에서 보이지 않으면, A's `onStop()` 호출

A's `onPause()` 호출 후 A's `onStop()` 호출 이전 다시 A 액티비티가 화면상에 보이면 A's `onResume()` 호출과 함께 A 액티비티 실행
A's `onStop()` 호출 후 다시 A 액티비티가 화면상에서 보이면 A's `onRestart()` -> A's `onStart()` -> A's `onResume()` 호출과 함께 A 액티비티 실행

안드로이드 시스템 메모리 부족으로 A 액티비티를 종료 후 다시 A 액티비티를 시작하면 `onCreate()` 부터 다시 시작

finish() 메소드를 호출하거나 메모리 확보를 위해 액티비티를 제거할 때 `onDestroy()` 호출

> onStop()과 onDestroy()는 호출되지 않을 수 있음

![ActivityLifeCycle](_img/lifecycle.png)

## AsyncTask 를 직접 구현한다면 ?

`Thread`와 `Handler`를 이용한다.

```java
Thread t = new Thread(()->{
   (백그라운드에서 실행될 코드!)
   
   // Get a handler that can be used to post to the main thread
   Handler mainHandler = new Handler(context.getMainLooper());
   mainHandler.post(()->{
        (UI스레드에서 동작하게 하고 싶은 코드)
   });
});
t.start();
```

## Context 란?
어플리케이션의 현재 상태를 나타내는 객체로, 새롭게 생성된 객체가 컨택스트 객체를 통해 어플리케이션이 실행되고 있는 상황을 이해하는데 도움을 준다.
개발자 입장에서는 새로운 객체(뷰, 어뎁터 등)를 생성, 리소스 접근, 컴포넌트 접근을 위해 사용한다.

다음 방법으로 접근 가능 :  `getApplicationContext()`, `getContext()`, `getBaseContext()` or `this` (when in the activity class).

- 새로운 객체 생성 : 새로운 뷰, 어뎁터, 리스너
```java
TextView tv = new TextView(getContext());
ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), ...);
```

- 리소스 접근 : LAYOUT_INFLATER_SERVICE, SharedPreferences
```java
context.getSystemService(LAYOUT_INFLATER_SERVICE)
getApplicationContext().getSharedPreferences(*name*, *mode*);
```

- 컴포넌트 접근 : Regarding content providers, broadcasts, intent
```java
getApplicationContext().getContentResolver().query(uri, ...);
```