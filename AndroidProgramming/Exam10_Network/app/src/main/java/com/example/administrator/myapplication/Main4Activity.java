package com.example.administrator.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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

public class Main4Activity extends AppCompatActivity {
    private ImageView imageLarge;
    private ListView foodList;
    private NFoodAdapter foodAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        foodList = (ListView) findViewById(R.id.nfoodList);
        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                final NFood food = (NFood) foodAdapter.getItem(position);
                final Thread thread = new Thread() {
                    @Override
                    public void run() {
                        final Bitmap bitmap = getBitmap(food.getImageLargeFileName());
                        imageLarge.post(new Runnable() {
                            @Override
                            public void run() {
                                imageLarge.setImageBitmap(bitmap);
                            }
                        });
                    }

                };
                thread.start();
            }
        });
        fillItems();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void fillItems() {
        final Thread thread = new Thread() {
            @Override
            public void run(){
                try {
                    URL url = new URL("http://192.168.0.47:8080/myandroid/lightList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();  // 연결 객체를 얻는다. 연결 객체를 얻기만 함
                    conn.connect();

                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(reader);

                        String strJson = "";
                        while(true){
                            String data = br.readLine();
                            if(data == null) break;

                            strJson += data;
                        }

                        br.close(); reader.close(); is.close();
                        final List<NFood> list = parseJson(strJson);
                        foodList.post(new Runnable() {
                            @Override
                            public void run() {
                                foodAdapter = new NFoodAdapter(Main4Activity.this);
                                foodAdapter.setList(list);
                                foodList.setAdapter(foodAdapter);
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

    public Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;

        try {
            URL url = new URL("http://192.168.0.47:8080/myandroid/getImage?fileName=" + fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
            }

            conn.disconnect();

        } catch (Exception e) {
            Log.i("mylog", e.getMessage());
        }

        return bitmap;
    }

    public List<NFood> parseJson(String strJson){
        List<NFood> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                NFood food = new NFood();
                food.setName(jsonObject.getString("name"));
                food.setPrice(jsonObject.getString("price"));
                food.setContent(jsonObject.getString("content"));
                if(i == 0){
                    food.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                food.setImage(getBitmap(jsonObject.getString("image")));
                list.add(food);
            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }

        return list;
    }

}
