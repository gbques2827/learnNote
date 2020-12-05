package com.ly.gbques.msb.quote;

import java.lang.ref.WeakReference;

/**
 * @author ly
 * @since 2020-11-27 15:10
 */
public class WeakQuote {
    public static void main(String[] args) {
        WeakReference<M>m=new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        //一旦发生gc回收，弱引用就会被回收，面试弱引用是重点
    }
}
