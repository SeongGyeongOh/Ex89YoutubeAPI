package com.osg.ex89youtubeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class YoutubeDataActivity extends AppCompatActivity {
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_data);

        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
    }

    public void clickBtn(View view) {
        //Youtube Data API 사용, 검색기능 ㄱㄱ
        //검색기능 API는 rest방식으로 데이터를 제공한다
        //GET  https://www.googleapis.com/youtube/v3/search

        //요청 파라미터 : part, key, q, maxResults 네 개를 넣을 것임
        String key ="AIzaSyAltfsrOvONgSUawBJ-S21X6AsC7p4aRes";
        String part="snippet";
        String query = et.getText().toString();
        int maxResults=10;


        //Retrofit으로 실행할 것 - Json으로 온 데이터를 String으로만 받아 보겠다
        Retrofit retrofit = RetrofitHelper.getInstance();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<String> call = retrofitService.serchVideos(key, part, query, maxResults);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data = response.body();
                tv.setText(data);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {}
        });




    }
}