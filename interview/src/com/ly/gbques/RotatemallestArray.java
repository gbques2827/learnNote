package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-11 21:51
 */
public class RotatemallestArray {
    public static void main(String[] args) {
        RotatemallestArray rotatemallestArray=new RotatemallestArray();
        int arr[]={3,4,5,1,2};
    }
    /*
    *题目：
    * 把一个数组最开始的若干个元素搬到数组的末尾，
    * 我们称之为数组的旋转。输入一个非递减排序的数组的
    * 一个旋转，输出旋转数组的最小元素
    * */
    public int minNumberInRotateArray(int [] array) {
        int min=array[0];
        for(int i=1;i<array.length;i++){
            if(min>=array[i]){
                min=array[i];
            }
        }
       return min;
    }

}
