package com.example.outopompomme;

import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiTest extends Thread{

    public void func() throws IOException, JSONException {
        String endPoint =  "http://apis.data.go.kr/1360000/VilageFcstInfoService/";
        String serviceKey = "LVI1FESH0%2FqMS1WY%2BHbQgM%2FtlFfB3uaux9%2Fa08Rnivc4vUZLLinMYgJpOwAGlE4bt8Yj4REmY6P7Hu78OGnLDQ%3D%3D\n";
        String pageNo = "1";
        String numOfRows = "10";
        String baseDate = "20210404"; //원하는 날짜
        String baseTime = "1100"; //원하는 시간
        String nx = "98"; //위경도임.
        String ny = "77"; //위경도 정보는 api문서 볼 것


        String s = endPoint+"getVilageFcst?serviceKey="+serviceKey
                +"&pageNo=" + pageNo
                +"&numOfRows=" + numOfRows
                +"+&dataType=JSON"
                + "&base_date=" + baseDate
                +"&base_time="+baseTime
                +"&nx="+nx
                +"&ny="+ny;

        URL url = new URL(s);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader bufferedReader = null;
        if (conn.getResponseCode() == 200) {
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            // connection error :(
            // 처리할 코드 작성
        }

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

// bufferedReader 사용 후에는 닫아주어야 합니다.
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        bufferedReader.close();
        String result= stringBuilder.toString();
        conn.disconnect();

        JSONObject mainObject = new JSONObject(result);
        JSONArray itemArray = mainObject.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");
        for(int i=0; i<itemArray.length(); i++){
            JSONObject item = itemArray.getJSONObject(i);
            String category = item.getString("category");
            String value = item.getString("fcstValue");
            System.out.println(category+"  "+value);
        }
    }
}
