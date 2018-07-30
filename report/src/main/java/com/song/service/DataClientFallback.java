package com.song.service;

import com.song.po.City;
import com.song.po.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallback implements DataClient {

	@Override
	public List<City> listCity() throws Exception {
		List<City> cityList = null;
		cityList = new ArrayList<>();
		
		City city = new City();
		city.setCityId("101010100");
		city.setCityName("北京");
		cityList.add(city);

		return cityList;
	}

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		return null;
	}

}