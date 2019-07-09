package com.example.democontentserver.data.model.remote;
import com.example.democontentserver.data.model.model.AuthPost;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("/posts")
    @FormUrlEncoded //application/x-www-form-urlencoded
    Call<AuthPost> savePost(@Field("title") String title,
                                 @Field("body") String body,
                                 @Field("userId") long userId);
}
