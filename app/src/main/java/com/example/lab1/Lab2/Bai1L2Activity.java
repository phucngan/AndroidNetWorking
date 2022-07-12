package com.example.lab1.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab1.MainActivity;
import com.example.lab1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Bai1L2Activity extends AppCompatActivity {
    TextView tvResult;
    Button btnSend;
    EditText edName,edScore;
    public String name,score;
    private String TAG = Bai1L2Activity.class.getSimpleName();
    public static final String Server_Name = "http://192.168.1.6:1900/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_l2);
        tvResult = findViewById(R.id.tvResultl2);
        edName = findViewById(R.id.edName);
        edScore = findViewById(R.id.edScore);
        btnSend = findViewById(R.id.btnB1L2);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edName.getText().toString();
                score = edScore.getText().toString();
                BackgroundTask_Get backgroundTask_get = new BackgroundTask_Get(tvResult, name, score, getApplicationContext());
                backgroundTask_get.execute();
                //new GetContacts().execute();
            }
        });

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String url = Server_Name + "?name=" + name + "&score=" + score;
            Log.e("//","=="+url);
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node

                    // looping through All Contacts
                    for (int i = 0; i < jsonObj.length(); i++) {
                        JSONObject c = jsonObj.getJSONObject("");
                        String id = c.getString("Name");
                        String name = c.getString("Score");
                        Log.e("//==","//"+id);
                        Log.e("//==","//"+name);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(Bai1L2Activity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();

        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            tvResult.setText("hello");
        }
    }


}