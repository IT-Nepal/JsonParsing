package com.example.ubuntu.youtube_json;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataparse = "";
    String singleparse = "";
    @Override
    protected Void doInBackground(Void... voids) {
try {
    URL url = new URL("https://api.myjson.com/bins/w92v8");
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    InputStream inputStream = httpURLConnection.getInputStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    String line = "";
    while(line != null){
        line = bufferedReader.readLine();
        data = data + line;
    }
    JSONArray jsonArray = new JSONArray(data);
    for(int i = 0; i<jsonArray.length(); i++){
        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//        single json object
        singleparse = "Name:" + jsonObject.get("name") + "\n" +
                "Password:" + jsonObject.get("password") + "\n" +
                "Address:" + jsonObject.get("address") + "\n";

        dataparse = dataparse + singleparse;
    }
}catch(Exception e){
    e.printStackTrace();
}
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.textView.setText(this.dataparse);
    }
}
