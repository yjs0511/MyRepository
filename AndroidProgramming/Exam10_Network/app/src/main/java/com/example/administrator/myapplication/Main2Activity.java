package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();

        fillItems();
    }

    public void fillItems(){
        List<Food> list = new ArrayList<>();

        list.add(new Food(R.drawable.food01, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food02, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food03, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food04, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food05, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food06, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));

        for( Food food : list ){
            // inplation
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.foods, null);

            // 데이터 세팅
            ImageView foodimage = (ImageView) itemLayout.findViewById(R.id.foodimage);
            foodimage.setImageResource(food.getImage());

            TextView name = (TextView) itemLayout.findViewById(R.id.name);
            name.setText(food.getName());

            TextView price = (TextView) itemLayout.findViewById(R.id.price);
            price.setText(food.getPrice());

            TextView content = (TextView) itemLayout.findViewById(R.id.content);
            content.setText(food.getContent());

            // itemContainer에 내부 객체로 추가
            itemContainer.addView(itemLayout);
        }
    }
}
