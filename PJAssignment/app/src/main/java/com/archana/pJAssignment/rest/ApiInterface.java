package com.archana.pJAssignment.rest;

import com.archana.pJAssignment.model.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;


public interface ApiInterface {
    @GET("assessment_search_wrapper")
    Call<SearchResponse> getSearchedItems(@Query("query") String query);
}
