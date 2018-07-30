package com.song.service;

import com.song.po.City;

import java.util.List;

public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}