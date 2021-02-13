package com.davisilvaprojetos.apiyoutube.api;

import com.davisilvaprojetos.apiyoutube.model.Resultado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeService {
    /*
    https://www.googleapis.com/youtube/v3/
    search
    ?part=snippet
    &order=date
    &maxResults=20
    &key=AIzaSyCr1wu-2qV6n9scn2tcrpxJAMJPeFcAgKk
    &channelId=UCVHFbqXqoYvEWM1Ddxl0QDg
    &q=desenvolvimento+android


     */
    @GET("search")
    Call<Resultado>recuperarVideos(
            @Query("part") String part,
            @Query("order") String order,
            @Query("maxResults") String maxResults,
            @Query("key") String key,
            @Query("channelId") String channelId,
            @Query("q") String q


    );
}
