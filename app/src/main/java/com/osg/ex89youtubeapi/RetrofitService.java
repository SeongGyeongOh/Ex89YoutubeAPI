package com.osg.ex89youtubeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    //요청 파라미터 : part, key, q, maxResults 네 개를 넣을 것임
    @GET("/youtube/v3/search")
    Call<String> serchVideos(@Query("key") String key,
                             @Query("part") String part,
                             @Query("q") String q,
                             @Query("maxResults") int maxResults);
}
