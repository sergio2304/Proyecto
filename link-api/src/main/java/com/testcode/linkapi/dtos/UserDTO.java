package com.testcode.linkapi.dtos;


import java.io.Serializable;


public class UserDTO implements Serializable {
    String id;
    String first_name;
    String  last_name;
    String email;
    String avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "{\"UserDTO\":{"
                + "\"id\":\"" + id + "\""
                + ", \"last_name\":\"" + last_name + "\""
                + ", \"email\":\"" + email + "\""
                + "}}";
    }
}
