package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter{

    private List<Food> list;
    public void setList(List<Food> list) {
        this.list = list;
    }

    private Context context;
    private LayoutInflater layoutInflater;

    public FoodAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { // 데이터의 수가 몇개야? Light 의 수개 몇개야?
        return list.size();
    }

    @Override
    public Object getItem(int position) {   // position 번째 Light 객체를 리턴
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){    // null이 아니면 객체 재사용
            // inplation
            convertView = layoutInflater.inflate(R.layout.foods, null);
        }

        // data setting
        Food food = list.get(position);

        ImageView foodImage = (ImageView) convertView.findViewById(R.id.foodimage1);
        foodImage.setImageResource(food.getImage());

        TextView foodName = (TextView) convertView.findViewById(R.id.name);
        foodName.setText(food.getName());

        TextView foodPrice = (TextView) convertView.findViewById(R.id.price);
        foodPrice.setText(food.getPrice());

        TextView foodContent = (TextView) convertView.findViewById(R.id.content);
        foodContent.setText(food.getContent());

        return convertView;
    }
}
