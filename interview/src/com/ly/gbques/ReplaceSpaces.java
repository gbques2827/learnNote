package com.ly.gbques;

/**
 * @author ly
 * @since 2020-11-06
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        String str = "A B CBBB M";
        //A%20B%20CBBB%20M,简单实现
        //System.out.println(str.replaceAll(" ","%20"));
        ReplaceSpaces replaceSpaces=new ReplaceSpaces();
        System.out.println(replaceSpaces.replace(str));
    }

    /*
    题目
    将一个字符串中的空格替换成 "%20
    Input:
    "A B"
    Output:
    "A%20B"
    "*/

    public String replace(String  str) {
        //思路，将字符串当成数组
        //StringBuilder > StringBuffer > String
        StringBuilder stringBuilder=new StringBuilder();
        //char可以转化为数值
        //byte-short-int-float-double
        //char-int-float-double
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==32){
                stringBuilder.append("%".charAt(0));
                stringBuilder.append("2".charAt(0));
                stringBuilder.append("0".charAt(0));
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
