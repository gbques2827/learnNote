package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-12 22:18
 */
public class RangeRobot {
    public static void main(String[] args) {
        RangeRobot rangeRobot=new RangeRobot();
        //System.out.println(rangeRobot.sum(130,125));
        System.out.println(rangeRobot.movingCount(2,5,5));
    }
    /*
    题目：
    地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
    每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标
    和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进
    入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38）
    ，因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？*/

    /*
    * 思路：这是一个回溯问题，先向右
    * */

    /*
    *
    * 1	1	1	0	0
      1	1	0	0	0
      1	0	0	0	0
      0	0	0	0	0
      0	0	0	0	0

    *
    * */
    //threshold为k，rows行，cols列
    public int movingCount(int threshold, int rows, int cols)
    {
        int flag[][] = new int[rows][cols];
        return helper(0,0,rows,cols,flag,threshold);
    }
    //回溯方法以特殊替代整体
    private int helper(int i,int j,int rows,int cols,int[][] flag,int threshold){
        if(i<0 || i>=rows || j<0 || j>=cols || numSum(i)+numSum(j) > threshold || flag[i][j]==1)
            return 0;
        flag[i][j]=1;
        return helper(i-1,j,rows,cols,flag,threshold)+
                helper(i+1,j,rows,cols,flag,threshold)+
                helper(i,j-1,rows,cols,flag,threshold)+
                helper(i,j+1,rows,cols,flag,threshold)+
                1;
    }
    private int numSum(int i){
        int sum = 0;
        do{
            sum += i%10;
        }while((i=i/10)>0);
        return sum;
    }
}
