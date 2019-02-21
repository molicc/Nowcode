package com.arithmetic;
/**
 * Created by Administrator on 2019/2/16.
 *
 * @author Administrator
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @className P3
 * @description TODO
 * @autor Administrator
 * @date 2019/2/16 19:12
 **/
public class P3 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        Solution3 solution3 = new Solution3();
        ArrayList<Integer> integers = solution3.printListFromTailToHead2(listNode);
        System.out.println(integers.toString());
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution3 {
    /**
     * 利用栈实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<Integer> ints = new Stack<>();
        while (listNode!= null) {
            ints.push(listNode.val);
            listNode = listNode.next;
        }
        while (!ints.isEmpty()) {
           integers.add(ints.pop());
        }
        return integers;
    }

    /**
     * 利用递归
     * @param listNode
     * @return
     */
    ArrayList<Integer> integers = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead2(listNode.next);
            integers.add(listNode.val);
        }
        return integers;
    }

}