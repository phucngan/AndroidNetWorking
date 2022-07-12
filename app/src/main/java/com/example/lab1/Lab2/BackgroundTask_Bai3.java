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

public class BackgroundTask_Bai3 extends AsyncTask<Void, Void , Void> {
    String link = Bai3L2Activity.SERVER_BAI3;
    TextView tvResult;
    String canh;
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
        link += "?canh=" + this.canh;
        Log.d("//////////e",link);
        try {
            URL url = new URL(link);
            String param = "canh=" + URLEncoder.encode(canh,"utf-8");
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
    public BackgroundTask_Bai3(TextView tvResult, String canh, Context context) {
        this.tvResult = tvResult;
        this.canh = canh;
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
