package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-11 20:27
 */
public class RectangularOverlay {
    public static void main(String[] args) {
        RectangularOverlay rectangularOverlay=new RectangularOverlay();
        System.out.println(rectangularOverlay.Fibonacci(4));

    }
    /*
    题目：
    * 1.我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
    * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，
    * 总共有多少种方法？
    *
    *2.跳台阶思路一致
    */
    /*
    * 思路：
    * 即矩形有多少种摆法
    * 1->1
    * 2->2
    * 3->3
    * 4->5
    * 总结：f(n-1)+f(n-2)
    * */
    public int Fibonacci(int n) {
        if(n<=2){
            return n;
        }else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
}
