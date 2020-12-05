package com.ly.gbques.msb.quote;

/**
 * @author ly
 * @since 2020-11-27 14:36
 */
public class M {
    //当一个对象被垃圾回收器回收的时候调用，一般不要重写
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
