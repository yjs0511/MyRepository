package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    private ListView foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        foodList = (ListView) findViewById(R.id.foodList);

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

        list.add(new Food(R.drawable.food01, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food02, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food03, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food04, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food05, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));
        list.add(new Food(R.drawable.food06, "Name", "35,000 WON", "값도 비싸고 맛도 없고 비싸기만한 가게입니다. 이런 가게는 처음이지?"));

        FoodAdapter foodAdapter = new FoodAdapter(this);
        foodAdapter.setList(list);

        foodList.setAdapter(foodAdapter);
    }
}
