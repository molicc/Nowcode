package com.arithmetic;
/**
 * Created by Administrator on 2019/2/18.
 *
 * @author Administrator
 */

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @className P15
 * @description TODO
 * @autor Administrator
 * @date 2019/2/18 21:36
 **/
public class P15 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution15 solution15 = new Solution15();
        ListNode listNode = solution15.ReverseList(null);
        System.out.println(listNode);
    }
}

class Solution15 {
    /**
     * 设置两个指针,last指向上一个,next指向下一个,每轮循环让head指向第三个，next指向上一个，并将last移动到next
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode last ;
        ListNode next ;
        if (head==null){
            return null;
        }

        last = head;
        head = head.next;
        last.next = null;
        while (head != null) {
            next = head;
            head = next.next;
            next.next = last;
            last = next;
        }
        return last;
    }
}