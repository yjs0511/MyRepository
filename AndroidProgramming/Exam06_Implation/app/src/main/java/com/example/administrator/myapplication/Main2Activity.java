package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    public void fillItems() {
        LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.foods, null);

        ImageView lightimage = (ImageView) itemLayout.findViewById(R.id.foodimage1);
        lightimage.setImageResource(R.drawable.food01);

        TextView name = (TextView) itemLayout.findViewById(R.id.name);
        name.setText("Name");

        TextView price = (TextView) itemLayout.findViewById(R.id.price);
        price.setText("35,000 WON");

        TextView content = (TextView) itemLayout.findViewById(R.id.content);
        content.setText("Information about popular Korean food dishes and local restaurant listings in the Tri-state area.");

    }
}
