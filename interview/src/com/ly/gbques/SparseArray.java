package com.ly.gbques;

import java.io.*;

/**
 * @author ly
 * @since 2020-11-18 20:52
 */
public class SparseArray {

    public static void main(String[] args) {
        SparseArray sparseArray= new SparseArray();
        int[][]arr={{0,0,1},{2,0,1},{0,3,1}};
        File file =new File("E:/a.txt");
        sparseArray.zip(arr,file);
        /*335
          021
          102
          121
          213
          221*/
        sparseArray.unzip(file);
    }

    //对数组进行压缩到磁盘
    public void zip(int[][]arr, File file){
        //第一行存储，行，列，有效值
        int count=0;
        FileWriter fileWriter=null;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]!=0){
                    count++;
                }
            }
        }
        try {
            fileWriter=new FileWriter(file);
            str.append(arr.length).append(" ").append(arr[0].length).append(" ").append(count).append(" ").append("\n");
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    if(arr[i][j]!=0){
                        str.append(i).append(" ").append(j).append(" ").append(arr[i][j]).append(" ").append("\n");
                    }
                }
            }
            fileWriter.write(str.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter !=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //解压,直接输出在控制台上
    public void unzip(File file){
        FileReader fileReader=null;
       StringBuilder str=new StringBuilder();
        char[]buff=new char[1024];
        int length=0;
        try {
            fileReader=new FileReader(file);
            while ((length=fileReader.read(buff))>0){
                str.append(buff);
            }
            //System.out.println(str.toString());
            String[] sarr = str.toString().replaceAll("\n","").split(" ");
            //转化为数组
            int[][]parr=new int[Integer.parseInt(sarr[0])][Integer.parseInt(sarr[1])];
            for(int i=1;i<sarr.length/3;i++){
                parr[Integer.parseInt(sarr[i*3])][Integer.parseInt(sarr[i*3+1])]=Integer.parseInt(sarr[i*3+2]);
            }
            for(int i=0;i<parr.length;i++){
                for(int j=0;j<parr[0].length;j++){
                    System.out.print(parr[i][j]+"\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
