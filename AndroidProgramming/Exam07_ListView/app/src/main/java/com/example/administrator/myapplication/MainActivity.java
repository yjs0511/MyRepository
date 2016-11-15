package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lightList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightList = (ListView) findViewById(R.id.lightList);

        fillItems();

    }
    public void fillItems(){    // 인플레이션 시켜서 이미지, 제목, 내용을 세팅하여 itemContainer에 추가

        List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1,  "인테리어 조명1",  "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light2,  "인테리어 조명2",  "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light3,  "인테리어 조명3",  "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light4,  "인테리어 조명4",  "교장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light5,  "인테리어 조명5",  "교무실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));

        list.add(new Light(R.drawable.light1,  "인테리어 조명1",  "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light2,  "인테리어 조명2",  "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light3,  "인테리어 조명3",  "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light4,  "인테리어 조명4",  "교장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light5,  "인테리어 조명5",  "교무실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));

        LightAdapter lightAdapter = new LightAdapter(this);
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);
    }
}
