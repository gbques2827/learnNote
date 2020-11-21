package com.ly.gbques;

/**
 * @author ly
 * @since 2020-11-06
 */
public class SelectInCode {
    public static void main(String[] args) {
        //创建一个二维码
        int[][]arr={{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},{10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        SelectInCode selectInCode=new SelectInCode();
        System.out.println(selectInCode.Find(30,arr));
    }

   /* 题目：
   给定一个二维数组，其每一行从左到右递增排序，
   从上到下也是递增排序。给定一个数，判断这个数
   是否在该二维数组中
    [1,   4,  7, 11, 15],
    [2,   5,  8, 12, 19],
    [3,   6,  9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
   */

    /*思路：
    *确定一个方向，右到左到下
    * */
     /* if(target==matrix[i][j]){
                return true;
            }else if(target>matrix[i][j]){
                //大于往下走
                //和matrix[i+1][j]比较;
                i++;
            }else {
                //小于往左走
                //和matrix[i][j-1]比较
              j--;
            }*/
    public boolean Find(int target, int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0 || target<matrix[0][0]){
            return false;
        }
        int i=0;
        int j=matrix[0].length-1;
        //判断是否出界不出界就循环,从右上角开始查询
        while (matrix.length-1>=i && j>=0){
            if(target==matrix[i][j]){
                return true;
            }else if(target>matrix[i][j]){
                //大于往下走
                //和matrix[i+1][j]比较;
                i++;
            }else {
                //小于往左走
                //和matrix[i][j-1]比较
              j--;
            }
        }

        return false;
    }

}
