package com.song.controller;

import com.song.job.WeatherDataSyncJob;
import com.song.po.City;
import com.song.service.CityClient;
import com.song.service.RibbonService;
import com.song.service.WeatherDataCollectionService;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.JobExecutionContextImpl;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.quartz.Scheduler.DEFAULT_GROUP;


@RestController
public class CollectionController {

    private static Logger logger = LoggerFactory.getLogger(CollectionController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RibbonService ribbonService;

    @Autowired
    private CityClient cityClient;

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @GetMapping("/service/{name}")
    public List<ServiceInstance> serviceUrl(@PathVariable("name") String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        return instances;
    }

    @GetMapping("/services")
    public List<String> services(String serviceName) {
        List<String> services = discoveryClient.getServices();
        return services;
    }

    @GetMapping("/test")
    public List<City> test() throws Exception{
        return cityClient.listCity();
    }
    @GetMapping("/test1")
    public String test1() throws Exception{
        return ribbonService.ribbon1();
    }

    @GetMapping("/execute")
    public String execute() throws Exception{
        try {
            logger.info("Weather Data Sync Job. Start！");
            // 获取城市ID列表
            List<City> cityList = new ArrayList<>();

            try {

                // 由城市数据API微服务提供数据
                cityList = cityClient.listCity();

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
            return "ok";

        } catch (Exception e){
            return e.getMessage();
        }

    }
}
