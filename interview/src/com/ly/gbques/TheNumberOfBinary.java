package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-14 21:14
 */
public class TheNumberOfBinary {
    public static void main(String[] args) {
        TheNumberOfBinary t=new TheNumberOfBinary();
        System.out.println( t.NumberOf1(10));
    }
    /*
    * 题目：
    * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
    * */
    /*
    * 思路：
    * 只要不为0就有一位为1
    * n &= (n - 1)之后消除最低位的1
    * */
    public int NumberOf1(int n) {
        int count=0;
        while (n !=0){
            count++;
            n&=(n-1);
        }
        return count;
    }
}
