package com.example.democontentserver;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.democontentserver.data.model.model.AuthPost;
import com.example.democontentserver.data.model.model.TicketPost;
import com.example.democontentserver.data.model.remote.APIService;
import com.example.democontentserver.data.model.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mResponseTv;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String TAG = "MyActivity";

        final EditText titleEt = (EditText) findViewById(R.id.et_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                    sendPost(title, body);
                }
            }
        });
    }

    public void sendPost(String title, String body) {
        final String TAG = "MyActivity";
        mAPIService.savePost(title, body).enqueue(new Callback<AuthPost>() {
            @Override
            public void onResponse(Call<AuthPost> call, Response<AuthPost> response) {
                Log.i(TAG, "Response" + response.toString());
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<AuthPost> call, Throwable t) {
                Log.e(TAG, "Error." + t.getMessage());
                Log.e(TAG, "Causa." + t.getCause());
                Log.e(TAG, "Request." + call.request());
                Log.e(TAG, "se ejecuto." + call.isExecuted());
            }
        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}
