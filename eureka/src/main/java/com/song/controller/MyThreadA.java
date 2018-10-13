package com.song.controller;

public class MyThreadA extends Thread {

    private MyService myService;

    public MyThreadA(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {


        myService.awaitA();


    }
}
