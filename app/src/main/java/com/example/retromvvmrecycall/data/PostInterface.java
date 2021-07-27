package com.example.retromvvmrecycall.data;

import com.example.retromvvmrecycall.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface PostInterface {

    @GET("marvel")
    Call<List<PostModel>> getPosts();
}
