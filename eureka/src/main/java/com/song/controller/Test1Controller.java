package com.song.controller;


import com.song.config.ConnectionSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test1Controller {

    @Autowired
    private ConnectionSettings connectionSettings;

    @RequestMapping("/abc")
    public String index(){
        return connectionSettings.getUsername();
    }

    @RequestMapping("/dd")
    public String dd(){
        return connectionSettings.getPassword();
    }

}
