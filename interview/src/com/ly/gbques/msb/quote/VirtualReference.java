package com.ly.gbques.msb.quote;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ly
 * @since 2020-11-27 15:15
 */
public class VirtualReference {
    private static final List<Object> LIST=new LinkedList<>();
    //引用队列
    private static final ReferenceQueue<M> QUEUE=new ReferenceQueue<>();
    public static void main(String[] args) {
        PhantomReference<M> phantomReference=new PhantomReference<>(new M(),QUEUE);
        System.out.println(phantomReference.get());
    }
    //null，虚引用用于管理直接内存，即jvm之外的内存，只要在队列里面存在对象，说明该对象可以被回收了
    /*如果一个对象持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收，
    它不能单独使用也不能通过它访问对象，虚引用必须和引用队列ReferenceQueue联合使用。
    虚引用的主要作用和跟踪对象被垃圾回收的状态，仅仅是提供一种确保对象被finalize以后，做某些事情的机制。*/
}
