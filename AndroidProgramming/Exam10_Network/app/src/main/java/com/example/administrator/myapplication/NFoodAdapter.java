package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NFoodAdapter extends BaseAdapter {

    private List<NFood> list;
    public void setList(List<NFood> list){this.list = list;}

    private Context context;
    private LayoutInflater layoutInflater;

    public NFoodAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.foods, null);
        }

        NFood food = list.get(position);

        ImageView foodimage = (ImageView) convertView.findViewById(R.id.foodimage);
        foodimage.setImageBitmap(food.getImage());

        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(food.getName());

        TextView price = (TextView) convertView.findViewById(R.id.price);
        price.setText(food.getPrice());

        TextView content = (TextView) convertView.findViewById(R.id.content);
        content.setText(food.getContent());

        return convertView;
    }
}
