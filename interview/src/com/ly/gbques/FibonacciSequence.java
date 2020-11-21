package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-11 20:00
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence=new FibonacciSequence();
        System.out.println( fibonacciSequence.Fibonacci(4));
        System.out.println( fibonacciSequence.Fibonacci(39));
    }
    /*
    题目
    *求斐波那契数列的第 n 项，n <= 39
    * */
    /*
    * 思路：使用递归
    * */
    public int Fibonacci(int n) {
       if(n<=1){
          return n;
       }else {
           return Fibonacci(n-1)+Fibonacci(n-2);
       }
    }
}
