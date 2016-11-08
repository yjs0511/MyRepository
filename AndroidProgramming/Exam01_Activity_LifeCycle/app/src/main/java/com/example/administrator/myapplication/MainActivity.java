package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                 // 부모에 있는 코드를 반드시 실행해야 추가한 기능을 실행할 수 있기 때문에 부모 코드 사용
        setContentView(R.layout.activity_main);             // xml의 내용을 객체로 만드는 작업을 함(정적 필드인 layout에 activity_main 이라는 필드값을 넣어준다)
                                                                // xml 파일의 내용을 읽고 화면으로 쓰겠다
                                                                // 화면을 생성하기 역할을 onCreate()가 한다 자동으로 실행됨
                                                                // 객체 생성부터 소멸까지 자동으로 실행되는 메소드를 라이프 사이클 메소드라 한다
        Log.i("mylog", "onCreate()");
    }

    @Override
    protected void onDestroy() {    // 화면이 파괴될 때 자동 실행
        super.onDestroy();
        Log.i("mylog", "onDestroy()");
    }
}