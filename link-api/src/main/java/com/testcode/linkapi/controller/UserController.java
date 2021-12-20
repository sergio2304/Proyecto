package com.testcode.linkapi.controller;

import com.testcode.linkapi.dtos.UrlData;
import com.testcode.linkapi.dtos.UrlDataResponse;
import com.testcode.linkapi.external.PropertyClass;
import com.testcode.linkapi.mapper.MapToNewFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private  String url= PropertyClass.getProperty("url");

    @GetMapping("/users")
    public  String getUsers(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
        ResponseEntity<UrlData> response=restTemplate.exchange(url, HttpMethod.GET,entity,UrlData.class);
        UrlData data = response.getBody();
        UrlDataResponse newData= MapToNewFormat.map(data.getData());
        return newData.toString();

        }catch (Exception e){

        return "La URL no contiene data.";
        }

    }
}
