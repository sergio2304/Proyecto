package com.testcode.linkapi.mapper;

import com.testcode.linkapi.dtos.UrlDataResponse;
import com.testcode.linkapi.dtos.UserDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapToNewFormat {
    public static UrlDataResponse map(UserDTO[] data){
        List<String> lista= new ArrayList<>();
        Arrays.asList(data).forEach(x->{
            lista.add(x.getId() + "|" + x.getLast_name()+"|"+x.getEmail());
        });
        UrlDataResponse reponse= new UrlDataResponse(lista.toArray(new String[0]));
        return  reponse;
    }
}
