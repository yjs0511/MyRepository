package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LightAdapter extends BaseAdapter{

    private List<Light> list;
    public void setList(List<Light> list) {
        this.list = list;
    }

    private Context context;
    private LayoutInflater layoutInflater;

    public LightAdapter(Context context){ // 이렇게 하면 다른 액티비티에선 사용 못 함 메인 액티비티만 사용가능 >> 범용성 없음 >> context 사용 모든 액티비티는 context를 구현한다
                                          // context는 하나의 액티비티가(맞나?) 실행되기 위한 실행 환경을 가지고 있다
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() { // 데이터의 수가 몇개야? Light 의 수개 몇개야?
        return list.size();
    }   // 데이터의 개수(light)

    @Override
    public Object getItem(int position) {   // position 번째 Light 객체를 리턴
        return list.get(position);
    }   // 해당 인덱스의 데이터가 뭐냐

    @Override
    public long getItemId(int position) {   // id가 있는 데이터도 없는 데이터도 들어갈 수 있다 >> position은 인덱스 상의 위치, id는 다른 객체와 식별할 수 있는 값  >> 인덱스가 식별 번호가 된다
                                            // position 위치에 있는 객체의 식별 번호가 뭐냐?
        return position;                    // 값이 없으면 position을 바로 리턴
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {    // item 객체를 만들어서 리턴한다 >> xml 파일을 inflation에서 데이터를 세팅하고 세팅된 객체를 리턴하는 메소드
                                                                               // i는 리스트 상의 순번, view는 xml을 inflation한 것(스크롤이 올라가거나 내려가 사라진 객체를 재사용하는 것), viewGroup은 ListView(AdapterView)
                                                                               // View는 리스트 각각의 항목에 대한 객체
        if(convertView == null){    // null이 아니면 객체 재사용
            // inplation
            convertView = layoutInflater.inflate(R.layout.light_item, null);
        }

        // data setting
        Light light = list.get(position);

        ImageView lightImage = (ImageView) convertView.findViewById(R.id.lightimage);
        lightImage.setImageBitmap(light.getImage());

        TextView lightTitle = (TextView) convertView.findViewById(R.id.lighttitle);
        lightTitle.setText(light.getTitle());

        TextView lightContent = (TextView) convertView.findViewById(R.id.lightcontent);
        lightContent.setText(light.getContent());

        return convertView;
    }
}
