package com.song.job;

import com.song.po.City;
import com.song.service.CityClient;
import com.song.service.WeatherDataCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job. Start！");
        // 获取城市ID列表
        List<City> cityList = new ArrayList<>();

        try {

            // 由城市数据API微服务提供数据
            cityList = cityClient.listCity();
//            City city1 = new City();
//            city1.setCityCode("qingpu");
//            city1.setCityId("101020800");
//            city1.setCityName("青浦");
//            city1.setProvince("上海");
//            cityList.add(city1);
//
//            City city2 = new City();
//            city2.setCityCode("songjiang");
//            city2.setCityId("101020900");
//            city2.setCityName("松江");
//            city2.setProvince("上海");
//            cityList.add(city2);

        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId:" + cityId);

            weatherDataCollectionService.syncDateByCityId(cityId);
        }

        logger.info("Weather Data Sync Job. End!");
    }
}
