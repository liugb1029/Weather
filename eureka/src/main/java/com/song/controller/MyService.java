package com.song.controller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();


    public void awaitA() {
        try {
            lock.lock();
            System.out.println("add lock A");
            conditionA.await();
            System.out.println("await A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("unlock a");
        }
    }



    public void awaitB() {
        try {
            lock.lock();
            System.out.println("add lock B");
            conditionB.await();
            System.out.println("await B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("unlock b");
        }
    }

    public void signalA(){
        try {
            lock.lock();
            conditionA.signal();
            System.out.println("signalA");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalB(){
        try {
            lock.lock();
            conditionB.signal();
            System.out.println("signalB");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws Exception{
 /*       MyService myService = new MyService();
        Thread t = new MyThreadA(myService);
        Thread t1 = new MyThreadB(myService);
        t.start();
        t1.start();

        Thread.sleep(5000);
        myService.signalA();
        Thread.sleep(5000);
        myService.signalB();*/




    }




}
