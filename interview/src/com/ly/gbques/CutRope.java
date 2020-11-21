package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-13 21:54
 */
public class CutRope {
    public static void main(String[] args) {
        CutRope cut=new CutRope();
        System.out.println(cut.cutRope(7));
    }
    //根据思路，3多的最大
    public int cutRope(int n){
       if(n==1 || n==2){
           return 1;
       }else if(n==3){
           return 2;
       }
       int sum=1;
       //这里不能小于4，因为一旦可以小于4就会被拆分为3和1小于4
       while (n>4){
           sum*=3;
           n-=3;
       }
       return n*sum;
    }
}
