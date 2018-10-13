package com.song.controller;

public class MyThreadB extends Thread {

    private MyService myService;

    public MyThreadB(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {


        myService.awaitB();


    }
}
