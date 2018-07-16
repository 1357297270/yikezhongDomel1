package com.example.mvprecycle;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * data;2018/7/12
 * author:任志军
 */

public interface getInterface {
    @GET("https://www.apiopen.top/satinApi?type=3&page=1")
   Call<ResponseBody> getLastData();
}
