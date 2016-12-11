package com.example.pratik.postdatatoserver;

import com.example.pratik.postdatatoserver.Model.AddPostRequest;
import com.example.pratik.postdatatoserver.Model.AddPostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Pratik on 10-Dec-16.
 */

public interface RetrofitObjectAPI {
    @POST("/posts")
    Call<AddPostResponse> addPost(@Body AddPostRequest addPostRequest);
}
