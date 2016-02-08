package com.tutorial.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by evasquez on 7/2/16.
 */
public class TempError implements Constants, Serializable {

    @SerializedName(SUCCESS_TEMP_ERROR)
    private String mSuccess;
    @SerializedName(ERROR_TEMP_ERROR)
    private String mError;

    /**
     *
     * @return
     * The Success
     */
    public String getSuccess() {
        if(mSuccess != null){
            return mSuccess;
        }
        return "";
    }

    /**
     *
     * @param success
     * The Success
     */
    public void setSuccess(String success) {
        this.mSuccess = success;
    }

    /**
     *
     * @return
     * The Error
     */
    public String getError() {
        if (mError != null){
            return mError;
        }
        return "";
    }

    /**
     *
     * @param error
     * The Error
     */
    public void setError(String error) {
        this.mError = error;
    }
}