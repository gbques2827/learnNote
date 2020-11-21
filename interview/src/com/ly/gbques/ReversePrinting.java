package com.ly.gbques;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ly
 * @since 2020-11-08
 */
public class ReversePrinting {
    public static void main(String[] args) {
        Node node1 = new Node(1, "zs");
        Node node2 = new Node(2, "ls");
        Node node3 = new Node(3, "ww");
        ListNode listNode = new ListNode(3);
        listNode.insert(node1);
        listNode.insert(node2);
        listNode.insert(node3);
        ReversePrinting reversePrinting=new ReversePrinting();
        ArrayList<Node> list=reversePrinting.printListFromTailToHead(listNode);
        //System.out.println(list.size());
        for(Node node:list){
            System.out.println(node);
        }
        //listNode.insert(node1);
        //listNode.pop();
        //直接pop打印就是逆序了
        //listNode.show();
    }

    /*题目：
    从尾到头反过来打印出每个结点的值*/

    /*思路：
     * 使用栈方法*/
    public ArrayList<Node> printListFromTailToHead(ListNode listNode) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> list = new ArrayList<>();
        int length=listNode.size();
        System.out.println(length);
        for(int i=0;i<length;i++){
            stack.add(listNode.pop());
        }
        System.out.println(stack.size());
        for(int i=0;i<stack.size();i++){
            list.add(stack.pop());
        }
        return list;
    }
}

//链表
//对节点进行操作
class ListNode {
    private int maxSize;//最大数
    private Node head = new Node(0, null);//头节点

    public ListNode(int maxSize) {
        this.maxSize = maxSize;
    }

    //判断是否空
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //计数
    public int size() {
        int size = 0;
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    //判断是否满
    public boolean isFull() {
        return size() >= maxSize;
    }

    //插入
    public void insert(Node node) {
        //如果满
        if (isFull()) {
            return;
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    //抛出
    public Node pop() {
        //如果空
        Node result = null;
        if (!isEmpty()) {
            Node temp = head;
            while (true) {
                if (temp.getNext().getNext() == null) {
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
            result = temp.getNext();
            temp.setNext(null);
            return result;

        } else {
            return result;
        }
    }

    //遍历
    public void show() {
        if (isEmpty()) {
            return;
        }
        Node temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

//节点
class Node {
    private int no;//编号
    private String name;//名字
    private Node next;//指针，指向下一个节点

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
