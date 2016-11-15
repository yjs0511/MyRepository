package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private Button button2;
    private ListView lightList;
    private List<Light> list;
    //private LightAdapter lightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {     // 클릭 이벤트가 일어나는 걸 기다린다 인터페이스 타입
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class); // 이 클래스를 SecondActivity 로 바꾸고 싶다   this를 쓰면 onclickListner 를 가리키기 때문에 이렇게 하면 안됨 바깥 객체 사용
                startActivity(intent);
            }
        });

        lightList = (ListView) findViewById(R.id.lightList);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Light light = list.get(position);
                imageLarge.setImageResource(light.getImageLarge());
                // Light light = (Light) lightAdapter.getItem(position);
            }
        });
        fillItems();

    }



    public void fillItems(){    // 인플레이션 시켜서 이미지, 제목, 내용을 세팅하여 itemContainer에 추가

        list = new ArrayList<>();
        // List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명1",  "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명2",  "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명3",  "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명4",  "교장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명5",  "교무실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));

        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명1",  "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명2",  "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명3",  "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명4",  "교장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명5",  "교무실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));

        LightAdapter lightAdapter = new LightAdapter(this);
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);
    }

    public void onClickButton1(View view){
        Intent intent = new Intent(this, SecondActivity.class); // 이 클래스를 SecondActivity 로 바꾸고 싶다
        startActivity(intent);
    }
}
