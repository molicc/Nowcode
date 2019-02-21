package com.arithmetic;
/**
 * Created by Administrator on 2019/2/19.
 *
 * @author Administrator
 */

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @className P16
 * @description TODO
 * @autor Administrator
 * @date 2019/2/19 21:21
 **/
public class P16 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(8);
        ListNode listNode8 = new ListNode(3);
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        Solution16 solution16 = new Solution16();
        ListNode listNode = solution16.Merge2(listNode1,listNode5);
        System.out.println(listNode);
    }
}

class Solution16 {
    /**
     * 新建一个ListNode每次从两个总选择小的放入ListNode中。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        boolean flag;
        ListNode listNode = new ListNode(0);
        ListNode current=listNode;
        while (list1 != null && list2 != null) {
            ListNode temp = new ListNode((flag = list1.val < list2.val) ? list1.val : list2.val);
            if (flag == true) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
            current.next=temp;
            current=temp;
        }
        if (list1 != null) {
            current.next=list1;
        }
        if (list2 != null) {
            current.next=list2;

        }
        return listNode.next;
    }

    /**
     * 递归版本
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge2(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge2(list1, list2.next);
            return list2;
        }
    }
}