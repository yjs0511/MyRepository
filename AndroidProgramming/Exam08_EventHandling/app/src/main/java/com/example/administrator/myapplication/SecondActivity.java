package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();

        fillItems();
    }

    public void fillItems() {

        int[] arrImages = {
                R.drawable.food01,
                R.drawable.food02,
                R.drawable.food03,
                R.drawable.food04,
                R.drawable.food05
        };

        for(int i=0; i<5; i++) {

            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.foods, null);

            ImageView lightimage = (ImageView) itemLayout.findViewById(R.id.foodimage1);
            lightimage.setImageResource(arrImages[i]);

            TextView name = (TextView) itemLayout.findViewById(R.id.name);
            name.setText("Name");

            TextView price = (TextView) itemLayout.findViewById(R.id.price);
            price.setText("35,000 WON");

            TextView content = (TextView) itemLayout.findViewById(R.id.content);
            content.setText("Information about popular Korean food dishes and local restaurant listings in the Tri-state area.");

            itemContainer.addView(itemLayout);
        }
    }
}
