package com.example.lab1.Lab1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class AsyncTaskRunner extends AsyncTask<String , String, String> {
    private String resp;
    ProgressDialog progressDialog;
    TextView tvResult;
    EditText time;
    Context context;

    public AsyncTaskRunner (Context context, TextView tvResult, EditText time){
        this.context =context;
        this.tvResult = tvResult;
        this.time = time;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context , "ProgressDialog", "Wait for" + time.getText().toString()+" Seconds");
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("Sleeping ... ");
        try {
            int time = Integer.parseInt(strings[0]) * 1000;
            Thread.sleep(time);
            resp = "Sleep for " + strings[0] + " Seconds";
        }catch (Exception e){
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
            tvResult.setText(s);
        }
    }
}
