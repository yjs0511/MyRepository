package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private ListView lightList;
    private LightAdapter lightAdapter;
    //private LightAdapter lightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        lightList = (ListView) findViewById(R.id.lightList);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Light light = (Light) lightAdapter.getItem(position);
                //imageLarge.setImageResource(light.getImageLarge());
                // Light light = (Light) lightAdapter.getItem(position);
                final Light light = (Light) lightAdapter.getItem(position);
                final Thread thread = new Thread(){
                    @Override
                    public void run() { // 작업 스레드
                        final Bitmap bitmap = getBitmap(light.getImageLargeFileName());
                        imageLarge.post(new Runnable() {
                            @Override
                            public void run() {
                                imageLarge.setImageBitmap(bitmap);    // 큰 이미지는 터치할 때만 뜨는 이미지이므로 굳이 객체에 저장할 필요는 없다. 서버에서 받아오면 끝

                            }
                        });

                    }
                };
                thread.start();
            }
        });
        fillItems();

    }

    public void fillItems(){    // 인플레이션 시켜서 이미지, 제목, 내용을 세팅하여 itemContainer에 추가
        // Http 통신 코드
        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    URL url = new URL("http://192.168.0.47:8080/myandroid/lightList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();  // 연결 객체를 얻는다. 연결 객체를 얻기만 함
                    conn.connect(); // 여기서 연결

                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){    // 응답이 200 인 경우 (정상인 경우)
                        InputStream is = conn.getInputStream();     // 본문행을 읽기 위해서 inputStream 사용
                        Reader reader = new InputStreamReader(is);  // 문자로 읽기 위해서 Reader 사용
                        BufferedReader br = new BufferedReader(reader); // 성능 향상을 위해 buffer 사용

                        String strJson = "";
                        while (true){
                            String data = br.readLine();    // 한줄씩 읽겠다
                            if(data == null) break;         // 더 읽을게 없으면 null 이므로 반복문 탈출
                            strJson += data;                // 붙여 넣는다
                        }

                        br.close();
                        reader.close();
                        is.close();
                        final List<Light> list =  parseJson(strJson);
                        lightList.post(new Runnable() {     // 보조 스레드에서 메인 스레드로 넘겨주는 것 , 어떠한 뷰가 와도 상관 없다.(앞의 lightList 자리에 listView 가 오든 imageLarge가 오든 노 상관)
                            @Override
                            public void run() {
                                lightAdapter = new LightAdapter(MainActivity.this); // 이것만 메인 스레드에서 실행한다
                                                                                    // -> 화면을 구성하는 자원을 사용해야 하기 때문에 메인 스레드에서 실행되야 한다.
                                lightAdapter.setList(list); // 로컬변수가 익명변수 안에서 사용될 때는 final 특성을 가진다
                                lightList.setAdapter(lightAdapter);
                                imageLarge.setImageBitmap(list.get(0).getImageLarge());
                            }
                        });
                    }

                    conn.disconnect();
                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
            }
        };
        thread.start();
    }

    public List<Light> parseJson(String strJson){
        List<Light> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);   // 처음에 json을 배열로 만들었기 때문에 array로 만들어서 파싱해야 한다
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Light light = new Light();
                light.setTitle(jsonObject.getString("title"));
                light.setContent(jsonObject.getString("content"));
                light.setImage(getBitmap(jsonObject.getString("image")));   // 그림을 바로 받을 순 없다.
                if(i==0) {
                    light.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                light.setImageLargeFileName(jsonObject.getString("imageLarge"));
                list.add(light);
            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }

        return list;
    }

    public Bitmap getBitmap(String fileName){
        Bitmap bitmap = null;

        try {
            URL url = new URL("http://192.168.0.47:8080/myandroid/getImage?fileName="+fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);     // inputStream을 통해 읽은 데이터를 bitmap으로 변환해준다.
            }

            conn.disconnect();

        } catch (Exception e) {
            Log.i("mylog", e.getMessage());
        }

        return bitmap;
    }
}
