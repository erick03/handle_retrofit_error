package com.tutorial.webservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by evasquez on 7/2/16.
 */
public interface RestInterface {
    @POST("test")
    Call<TempError> testForErrorRequest(@Body MyObject myObject);

}