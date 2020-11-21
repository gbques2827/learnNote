package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-11 21:24
 */
public class JumpSteps {
    public static void main(String[] args) {
        JumpSteps jumpSteps=new JumpSteps();
        System.out.println( jumpSteps.JumpFloorII(4));
    }
    /*
     * 题目：
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级...
     * 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
     *
     * */
    /*
    * 思路：
    * 逆向思维：跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
    * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
    * f(n) = f(n-1) + f(n-2) + ... + f(0)
    * f(n) - f(n-1) = f(n-1)
    * f(n) = 2*f(n-1)
    * 所以 f(n) 是一个等比数列
    * */
    public int JumpFloorII(int target) {
        if(target<=1){
            return 1;
        }else {
            return JumpFloorII(target-1)*2;
        }
        //即2的指数级
        //return (int) Math.pow(2, target - 1);
    }
}
