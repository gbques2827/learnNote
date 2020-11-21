package com.ly.gbques;

import java.util.Stack;

/**
 * @author shkstart
 * @since 2020-11-11 19:31
 */
public class StackQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();


    public static void main(String[] args) {
        StackQueue stackQueue =new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
    }
    /*
    问题：
    用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作
    * */
    /*
    * 思路：
    * 栈：先进后出，队列先进先出
    * 即push的时候不管，pop的时候逆序即可
    * */
    public void push(int node) {
        in.push(node);
    }

    public int pop(){
        //对in栈进行pop到out栈中
        while (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
       if(!out.isEmpty()){
           return out.pop();
       }else {
           throw new RuntimeException("该队列为空");
       }
    }
}
