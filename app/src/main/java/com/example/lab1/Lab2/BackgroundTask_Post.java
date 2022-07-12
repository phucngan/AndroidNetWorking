package com.example.lab1.Lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_Post extends AsyncTask<Void, Void , Void> {
    String link = Bai2L2Activity.SERVER_BAI2;
    TextView tvResult;
    String rong,dai;
    public String str;
    ProgressDialog progressDialog;
    Context context;
    //    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        progressDialog = new ProgressDialog(context.getApplicationContext());
//        progressDialog.setMessage("Sending...");
//        progressDialog.setIndeterminate(false);
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//    }
    @Override
    protected Void doInBackground(Void... voids) {
        link += "?rong=" + this.rong + "&dai=" + this.dai;
        Log.d("//////////",link);
        try {
            URL url = new URL(link);
            String param = "rong=" + URLEncoder.encode(rong,"utf-8") + "dai=" + URLEncoder.encode(dai,"utf-8");
            Log.d("//", param);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            Log.d("==",urlConnection.toString());

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line ="";
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            str = stringBuffer.toString();
            urlConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public BackgroundTask_Post(TextView tvResult, String rong, String dai, Context context) {
        this.tvResult = tvResult;
        this.rong = rong;
        this.dai = dai;
        this.context = context;
    }


    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
//        if (progressDialog.isShowing()){
//            progressDialog.dismiss();
//        }
        Log.e("//","str "+str);
        tvResult.setText(str);
    }
}
