package com.song.service;

public interface WeatherDataCollectionService {

	/**
	 * 根据城市ID同步天气
	 * @param cityId
	 */
	void syncDateByCityId(String cityId);
}
