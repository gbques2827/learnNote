package com.ly.gbques;

/**
 * @author ly
 * @since 2020-11-27 21:53
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[]nums={1,2,3,4,5};
        ReOrderArray array=new ReOrderArray();
        array.reOrderArray(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }

    /*
    题目：
    需要保证奇数和奇数，偶数和偶数之间的相对位置不变，
    这和书本不太一样。例如对于 [1,2,3,4,5]，调整后得到
    [1,3,5,2,4]，而不能是 {5,1,3,4,2} 这种相对位置改变的结果。
    */

    /*
    * 思路：判断是否奇数 num%2==0
    * */
    public void reOrderArray(int[] nums) {
        //用一个数计算有多少奇数
        int count=0;
        for(int num:nums){
            if(!isEven(num)){
                count++;
            }
        }
        //奇数个数为count
        int[] copy=nums.clone();
        int i=0;
        int j=count;
        for(int num: copy){
            if(isEven(num)){
                nums[j++]=num;
            }else {
                nums[i++]=num;
            }
        }
    }

    //判断是否奇数
    private boolean isEven(int x) {
        return x % 2 == 0;
    }
}
