package com.ly.gbques;

/**
 * @author shkstart
 * @since 2020-11-14 20:29
 */
public class ArrStack {
    //实现栈
    private int maxSize;//栈容量
    private int top=-1;//表示栈顶
    private int[] arr;

    public ArrStack(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
    }

    //判断栈是否空
    public boolean isEmpty(){
        return top==-1;
    }
    //判断是否满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //进栈
    public void add(int num){
        //先判断是否满
        if(isFull()){
            return;
        }
        top+=1;
        arr[top]=num;
    }
    //出栈
    public int pop(){
        //先判断是否空
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int temp=arr[top];
        top-=1;
        return temp;
    }
    //遍历栈
    public void show(){
        if(isEmpty()){
            return;
        }
        for(int i=top;i>-1;i--){
            System.out.print(arr[i]+"\t");
        }
    }
}
