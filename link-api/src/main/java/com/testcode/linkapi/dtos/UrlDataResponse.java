package com.testcode.linkapi.dtos;

import java.util.Arrays;

public class UrlDataResponse {
    private String[] data;

    public UrlDataResponse(String[] data){
        this.data=data;
    }

    @Override
    public String toString() {
        return "{"
                + "\"data\":" + Arrays.toString(data)
                + "}";
    }
}
