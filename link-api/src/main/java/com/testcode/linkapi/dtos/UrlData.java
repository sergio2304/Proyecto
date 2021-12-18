package com.testcode.linkapi.dtos;

import java.util.Arrays;

public class UrlData {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private UserDTO[] data;
    private Support support;


    public UserDTO[] getData() {
        return data;
    }

    public void setData(UserDTO[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{\"UrlData\":{"
                + "\"page\":\"" + page + "\""
                + ", \"per_page\":\"" + per_page + "\""
                + ", \"total\":\"" + total + "\""
                + ", \"total_pages\":\"" + total_pages + "\""
                + ", \"data\":" + Arrays.toString(data)
                + ", \"support\":" + support
                + "}}";
    }
}
