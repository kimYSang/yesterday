package com.example.yesterday.yesterday.server;

import android.os.AsyncTask;
import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//로그인 서버와 연결하는 클래스
public class SetFoodServer extends AsyncTask<Void,Void,String> {
    String answer;

    public SetFoodServer() {
    }
    @Override
    protected String doInBackground(Void... params) {
        //request 를 보내줄 클라이언트 생성   (okhttp 라이브러리 사용)
        OkHttpClient client = new OkHttpClient();
        Response response;
        RequestBody requestBody = null;
        //보낼 데이터를 파라미터 형식으로 body에 넣음
        requestBody = new FormBody.Builder().build();
        // post형식으로 url로 만든 body를 보냄
        Request request = new Request.Builder()
                .url("http://"+ Server.WEBIP() + ":80/skuniv/SetFood")
                .post(requestBody)
                .build();
        try {
            response = client.newCall(request).execute();
            /////////////////////////////////// newcall 하고 응답받기를 기다리는중
            //제이슨 값 받기
            answer = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}