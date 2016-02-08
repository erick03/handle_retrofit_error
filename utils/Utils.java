package com.tutorial.Utils;


import com.tutorial.webservice.TempError;
import com.tutorial.webservice.RestClient;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by evasquez on 7/2/16.
 */
public class Utils {

    public static TempError parseError(Response<?> response) {
        Converter<ResponseBody, TempError> converter =
                RestClient.getsInstance().getRetrofit().responseBodyConverter(TempError.class, new Annotation[0]);

        TempError error;
        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new TempError();
        }

        return error;
    }

}