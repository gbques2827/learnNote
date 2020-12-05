package com.ly.gbques.msb.quote;

import java.lang.ref.SoftReference;

/**
 * @author ly
 * @since 2020-11-27 14:48
 */
public class SoftQuote {
    public static void main(String[] args) {
        SoftReference<byte[]> m=new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        //需要对最大堆内存进行设置-Xmx20M
        //再分配一个15m的空间，heap堆将装不下，这时候系统会回收垃圾，先回收一次，如果空间不够，直接把软引用干掉
        byte[]b=new byte[1024*1024*15];

        System.out.println(m.get());


        /*jdk8:
        * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	     *at com.ly.gbques.msb.quote.SoftQuote.main(SoftQuote.java:21)
        * */

        /*
        * jdk11:
        * [B@7c30a502
        * [B@7c30a502
        *null
        * */

        //软引用适合做缓存
    }
}
