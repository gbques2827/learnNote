package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-14 22:18
 */
public class PrintMaxNum {
    public static void main(String[] args) {
        PrintMaxNum p=new PrintMaxNum();
        p.printMaxNum(3);
    }
    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数
    public void printMaxNum(int n){
        if(n<=0){
            return;
        }
        //效率高
        StringBuilder str=new StringBuilder();
        str.append(1);
        for(int i=0;i<n;i++){
            str.append(0);
        }
        int max=Integer.parseInt(str.toString());
        for(int i=0;i<max;i++){
            System.out.println(i);
        }

    }
}
