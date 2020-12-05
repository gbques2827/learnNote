package com.ly.gbques.linkedlist;

/**
 * @author shkstart
 * @since 2020-11-15 21:57
 */
public class SingleChainList {
    //链表
    Node head= new Node(0,null);//头节点，该节点不能动
    //判端该节点是否为空
    public boolean isEmpty(){
        return head.getNext()==null;
    }
    //无序添加
    public void add(Node node){
        Node temp=head;
        while (temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(node);
    }
    //删除
    public void del(int no){
        if(isEmpty()){
            return;
        }
        Node temp=head;
        while (temp.getNext().getNext()!=null && temp.getNext().getNo()!=no){
            temp=temp.getNext();
        }
        //表示未找到该节点
        if(temp.getNext().getNext()==null && temp.getNext().getNo()!=no){
            return;
        }
        //节点,断掉
        if(temp.getNext().getNext()==null && temp.getNext().getNo()==no){
            temp.setNext(null);
        }else {
            //在之前有节点
            temp.setNext(temp.getNext().getNext());
        }

    }

    //展示
    public void show(){
        if(isEmpty()){
            return;
        }
        Node temp=head.getNext();
        while (temp!=null){
            System.out.println(temp);
            temp=temp.getNext();
        }
    }

    public static void main(String[] args) {
        SingleChainList singleChainList=new SingleChainList();
        Node node1=new Node(1,"zs");
        Node node2=new Node(2,"ls");
        Node node3=new Node(3,"ws");
        singleChainList.add(node1);
        singleChainList.add(node2);
        singleChainList.add(node3);
        singleChainList.del(2);
        singleChainList.show();
    }
}
