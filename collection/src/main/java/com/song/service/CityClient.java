package com.song.service;

import com.song.po.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("city")
public interface CityClient {


    @GetMapping("/cities")
    List<City> listCity() throws Exception;

}
