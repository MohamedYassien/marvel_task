package com.example.marveltask.repository;

import com.example.marveltask.repository.model.MarvelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApiService {
    @GET("characters")
    Call<MarvelResponse> getCharacters(
            @Query("limit") int limit,
            @Query("offset") int offset,
            @Query("ts") long timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );
}

