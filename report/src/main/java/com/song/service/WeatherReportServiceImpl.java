package com.song.service;

import com.song.po.Weather;
import com.song.po.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private DataClient dataClient;

	@Override
	public Weather getDataByCityId(String cityId) {

		// 由天气数据API微服务来提供
		WeatherResponse resp = dataClient.getDataByCityId(cityId);
		Weather data = null;
		if (resp != null ) {
			data = resp.getData();
		}
		return data;
	}

}