package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-13 19:52
 */
public class MazeProblem {
    public static void main(String[] args) {

    }
    //迷宫问题
    //定义规则，下，右，上，左
    //定义0表示没有走过，1表示墙，2表示可以走通，3表示已经走过但走不通
    //i，j表示出发的位置
    public boolean setWay(int[][]map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else if(map[i][j]==0){
            map[i][j]=2;
            if(setWay(map,i+1,j)){
                return true;
            }else if(setWay(map,i,j+1)){
                return true;
            }else if(setWay(map,i-1,j)){
                return true;
            }else if(setWay(map,i,j-1)){
                return true;
            }else {
                //说明走不通
                map[i][j]=3;
                return false;
            }
        }else {
            return false;
        }
    }
}
