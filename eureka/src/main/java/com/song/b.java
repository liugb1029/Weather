package com.song;


public class b extends a {

    public  int b = 2;

    //public  b()
    //{
    //    System.out.println(this+"b");
    //}
    public static void main(String[] args){
        a t1 = new b();
        System.out.println(t1);

        b t2 = (b)t1;
        System.out.println(t2);

        //System.out.println(t2);
    }
}
