package com.ly.gbques.msb.quote;

import java.io.IOException;

/**
 * @author ly
 * @since 2020-11-27 14:42
 */
public class StrongQuote {
    public static void main(String[] args) throws IOException {
        M m=new M();
        m=null;
        System.gc();
        System.out.println(m);
        System.in.read();//阻塞Main线程，给垃圾回收线程时间执行

        //finalize：说明垃圾回收器执行了
        //null

    }
}
