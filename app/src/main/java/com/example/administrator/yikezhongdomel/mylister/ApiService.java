package com.example.administrator.yikezhongdomel.mylister;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * data;2018/7/6
 * author:任志军
 */

public interface ApiService {
    //轮播图
    @GET("quarter/getAd")
    Call<ResponseBody> getLastimg();
//推荐页面（热门）
    @GET("quarter/getHotVideos?page=1&source=android&appVersion=101&token=34930A4E3647070F3F593404C9D1A5C6")
        Call<ResponseBody> getHotrecycle();
//段子
    @GET("quarter/getJokes?page=10&source=android&appVersion=101&token=34930A4E3647070F3F593404C9D1A5C6")
    Call<ResponseBody>  getCrossrecycle();
    //https://www.zhaoapi.cn/quarter/getJokes?page=1&source=android&appVersion=101&token=34930A4E3647070F3F593404C9D1A5C6
//视频
    @GET("quarter/getVideos?uid=13244&page=2&type=1&source=android&appVersion=101")
    Call<ResponseBody>  getVioderecycle();
  //  https://www.zhaoapi.cn/quarter/getVideos?uid=13244&page=2&type=1&source=android&appVersion=101
    //视频详情
    @GET("quarter/getVideoDetail?wid=574")
    Call<ResponseBody>  getViodeDetaile();
    //https://www.zhaoapi.cn/quarter/getVideoDetail?wid=255
}
