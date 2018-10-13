package com.song.controller;

import sun.java2d.loops.GraphicsPrimitive;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A implements Runnable{

    private int a = 0;

    public A(){
        a = 100;
    }
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (a >0){
            //lock.lock();
            synchronized (this){
                a--;

                System.out.println(a);

            }

            //lock.unlock();

            try {
                Thread.sleep(100);
            } catch (Exception e){

            }

        }


    }



    public static void main(String[] args){
        A ob = new A();


        Thread t1 = new Thread(ob);
        Thread t2 = new Thread(ob);
        t1.start();
        t2.start();


    }
}
