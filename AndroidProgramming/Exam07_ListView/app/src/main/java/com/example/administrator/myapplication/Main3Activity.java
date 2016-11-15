package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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

    public void fillItems() {

        List<Food> list = new ArrayList<>();
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Food(R.drawable.food01,  "name",  "35,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));


        FoodAdapter foodAdapter = new FoodAdapter(this);
        foodAdapter.setList(list);

        foodList.setAdapter(foodAdapter);
    }
}
