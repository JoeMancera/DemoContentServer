package com.example.democontentserver.data.model.remote;
import android.util.Log;

import com.example.democontentserver.data.model.model.AuthPost;
import com.example.democontentserver.data.model.model.TicketPost;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @POST("v1/auth")
    @FormUrlEncoded //application/x-www-form-urlencoded
    Call<AuthPost> savePost(@Field("username") String title,
                            @Field("password") String body);
}
