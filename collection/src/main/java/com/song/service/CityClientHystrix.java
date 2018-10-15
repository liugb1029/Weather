package com.song.service;

import com.song.po.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityClientHystrix implements CityClient {
    @Override
    public List<City> listCity() throws Exception {
        return new ArrayList<>();
    }
}
