package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();
        fillItems();
    }
    public void fillItems(){    // 인플레이션 시켜서 이미지, 제목, 내용을 세팅하여 itemContainer에 추가

        List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1,  "인테리어 조명1",  "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light2,  "인테리어 조명2",  "욕실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light3,  "인테리어 조명3",  "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light4,  "인테리어 조명4",  "교장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));
        list.add(new Light(R.drawable.light5,  "인테리어 조명5",  "교무실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 보기 좋습니다."));

        for (Light light : list) {

            // Inplation
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.light_item, null);

            // Date Setting
            ImageView lightimage = (ImageView) itemLayout.findViewById(R.id.lightimage);
            lightimage.setImageResource(light.getImage());

            TextView lightTitle = (TextView) itemLayout.findViewById(R.id.lighttitle);
            lightTitle.setText(light.getTitle());

            TextView lightContent = (TextView) itemLayout.findViewById(R.id.lightcontent);
            lightContent.setText(light.getContent());

            // itemContainer에 내부 객체로 추가
            itemContainer.addView(itemLayout);
        }
    }
}
