package com.song.job;

import com.song.controller.CollectionController;
import com.song.po.City;
import com.song.service.CityClient;
import com.song.service.WeatherDataCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        CollectionController collectionController = (CollectionController) applicationContext.getBean("collectionController");

        try {
            collectionController.execute();
        } catch (Exception e){
            logger.error(e.getMessage());
        }

    }

}
