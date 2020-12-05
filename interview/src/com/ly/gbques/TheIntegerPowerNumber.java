package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-14 21:25
 */
public class TheIntegerPowerNumber {
    public static void main(String[] args) {
        TheIntegerPowerNumber t=new TheIntegerPowerNumber();
        System.out.println(t.Power(2.0,3));
    }
    /*
    *题目：
    *  给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    *  保证base和exponent不同时为0
    * */
    public double Power(double x, int n) {
        double y=1;
        if(x==0 && n==0){
            throw new RuntimeException("不能同时为0");
        }
        if(n>0){
            for(int i=0;i<n;i++){
                y*=x;
            }
        }else {
            for(int i=n;i<0;i++){
                y*=1/x;
            }
        }

        return y;
    }
}
