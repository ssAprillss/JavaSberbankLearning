package com.company.task4;


public class Main {
    public static void main(String[] args){
        int[] input = {2,9,24,4,5};
        LinkedList linkedList = new LinkedList(input);
        linkedList.add(3);
        linkedList.print();
        linkedList.add(0,24);
        linkedList.print();
        linkedList.remove(1);
        linkedList.print();
        System.out.println(linkedList.get(3));
        linkedList.set(3,222);
        System.out.println(linkedList.get(3));
        linkedList.sortDes();
        linkedList.print();
    }

}
