package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

                AsyncTask<Void, Void, Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(Void... voids) {
                        return getBitmap(light.getImageLargeFileName());
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        imageLarge.setImageBitmap(bitmap);
                    }
                };

                asyncTask.execute();

                /*final Thread thread = new Thread(){
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
                thread.start();*/
            }
        });
        testAsyncTask();
        fillItems();

    }

    public void testAsyncTask(){    // 인플레이션 시켜서 이미지, 제목, 내용을 세팅하여 itemContainer에 추가
        Log.i("mylog", "1 " + Thread.currentThread().getName());
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {      // Void는 하나의 참조 타입으로 사용됨
            // 제너릭의 세번째 타입(Void)은 doInBackground()의 리턴 타입이면서 onPostExecute()의 매개 타입이다
            // 제너릭의 첫 번째 타입(String)은 doInBackground() 매개 변수의 타입이 되고 asyncTask.execute()의 매개 변수 타입이 된다
            @Override
            protected String doInBackground(String... voids) {  // 메인스레드에서 실행되는게 아니다    - 작업스레드에서 진행
                Log.i("mylog", "2 " + Thread.currentThread().getName());
                Log.i("mylog", voids[0]);
                //publishProgress();
                Log.i("mylog", voids[1]);
                //publishProgress();
                Log.i("mylog", voids[2]);
                //publishProgress();

                for (int i = 1; i <= 100; i++) {
                    if (i == 1) {
                        publishProgress(1); // AsyncTask<> 두번째 타입 지정하면 publishProgress()의 매개타입으로 사용 가능
                    } else if (i == 50) {
                        publishProgress(50);
                    } else if (i == 100) {
                        publishProgress(100);
                    }

                }
                return "작업 스레드 결과";    // Void 타입도 참조 타입이기 때문에 리턴값이 있어야한다 / 아무것도 없으므로 null
            }

            @Override
            protected void onProgressUpdate(Integer... values) {       // 작업 스레드의 진행 경과를 보여줌
                // doInBackground() 내에서 작업 경과를 보여줄 메소드(publishProgress())를 실행하면 이 메소드가 실행된다
                // 메인 스레드에서 실행경과를 보여달라고 해야 이게 실행된다 -> publishProgress()
                // 메인 스레드에서 실행되기 때문에 UI 변경 작업도 가능하다
                Log.i("mylog", "3 " + Thread.currentThread().getName());
            }

            @Override
            protected void onPostExecute(String aVoid) {       // 메인스레드에서 진행
                // 매개변수에 doInBackground()의 리턴값이 들어온다
                // 메인 스레드에서 실행되기 때문에 UI 변경 작업도 가능하다
                Log.i("mylog", "4 " + Thread.currentThread().getName());
                Log.i("mylog", aVoid);
            }
        };

            asyncTask.execute("실행 매개값1","실행 매개값2","실행 매개값3");     // 매개 값으로 asyncTask<>의 첫번째 타입이 들어가고 매개값은 doInBackground()의 매개값으로 들어간다
        }

    public void fillItems(){

        AsyncTask<Void, Void, List<Light>> asyncTask = new AsyncTask<Void, Void, List<Light>>() {

            @Override
            protected List<Light> doInBackground(Void... voids) {
                List<Light> list = null;

                try {
                    URL url = new URL("http://192.168.0.47:8080/myandroid/lightList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();  // 연결 객체를 얻는다. 연결 객체를 얻기만 함
                    conn.connect(); // 여기서 연결

                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {    // 응답이 200 인 경우 (정상인 경우)
                        InputStream is = conn.getInputStream();     // 본문행을 읽기 위해서 inputStream 사용
                        Reader reader = new InputStreamReader(is);  // 문자로 읽기 위해서 Reader 사용
                        BufferedReader br = new BufferedReader(reader); // 성능 향상을 위해 buffer 사용

                        String strJson = "";
                        while (true) {
                            String data = br.readLine();    // 한줄씩 읽겠다
                            if (data == null) break;         // 더 읽을게 없으면 null 이므로 반복문 탈출
                            strJson += data;                // 붙여 넣는다
                        }

                        br.close();
                        reader.close();
                        is.close();
                        list = parseJson(strJson);
                    }
                    conn.disconnect();

                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }

                return list;
            }

            @Override
            protected void onPostExecute(List<Light> lights) {
                lightAdapter = new LightAdapter(MainActivity.this);
                lightAdapter.setList(lights);
                lightList.setAdapter(lightAdapter);
                imageLarge.setImageBitmap(lights.get(0).getImageLarge());
            }
        };
        asyncTask.execute();
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
