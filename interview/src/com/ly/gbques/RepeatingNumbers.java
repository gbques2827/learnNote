package com.ly.gbques;

/**
 * @author ly
 * @since 2020-11-06
 */
public class RepeatingNumbers {
    public static void main(String[] args) {
        //创建一个数组
        int[]nums={2, 3, 1, 0, 2, 5};
        int[] duplication = new int[1];
        RepeatingNumbers numbers=new RepeatingNumbers();
        boolean flag=numbers.duplicate(nums,duplication);
        System.out.println(flag);
        System.out.println(duplication[0]);
        //结果
        /*true
        2*/

    }

    //写一个方法
    /*在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个
    数字重复几次。请找出数组中任意一个重复的数字*/
    //思路
    //先判断是数字是否排在正确的位置上，即num[2]==2,num[0]==0
    //如果不在就判断2==nums[2]，即nums[i]==nums[nums[i]]，这样就可以判断是否重复了
    public boolean duplicate(int[] nums,int[] duplication) {
        if(nums==null){
            return false;
        }
        for(int i=0;i<nums.length;i++){
            //nums[i]!=i,表示未在正确位置，正确位置0在num[0],1在num[1]
            //{2, 3, 1, 0, 2, 5}
            while (nums[i]!=i){
                //这里比较的就是2==nums[2],即双重判断，不在同一位置却相等，所以重复了
                //这里控制跨数字进行比较
                if(nums[i]==nums[nums[i]]){
                    duplication[0]=nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    //交换方法
    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
