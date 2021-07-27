package com.example.retromvvmrecycall.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retromvvmrecycall.data.PostsClient;
import com.example.retromvvmrecycall.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    MutableLiveData<List<PostModel>> postsmutableLiveData = new MutableLiveData<>();

    public void getPosts(){
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postsmutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }
}
