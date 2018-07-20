package com.example.ra.gmailgoogle.network;

import com.example.ra.gmailgoogle.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("inbox.json")
    Call<List<Message>> getInbox();
}
