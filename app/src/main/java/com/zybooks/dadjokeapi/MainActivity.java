package com.zybooks.dadjokeapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private Button btnJokes;

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://icanhazdadjoke.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJokes = (Button)findViewById(R.id.btnJokes);

        btnJokes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sendAndRequestResponse();
           }
        });

    }

    private void sendAndRequestResponse() {
        mRequestQueue = Volley.newRequestQueue(this);

        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               Toast.makeText(getApplicationContext(), "Response:" + response.toString(), Toast.LENGTH_LONG).show();

           }, new Response.ErrorListener() {
               @Override
                public void onErrorResponse(VolleyError error) {
                   Log.i(TAG, "Error :" + error.toString());
                }
            }
        });

    }


}