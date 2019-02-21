package com.arithmetic;
/**
 * Created by Administrator on 2019/2/18.
 *
 * @author Administrator
 */

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @className P14
 * @description TODO
 * @autor Administrator
 * @date 2019/2/18 20:00
 **/
public class P14 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution14 solution14 = new Solution14();
        ListNode listNode = solution14.FindKthToTail2(listNode1, 4);
        System.out.println(listNode);
    }
}

class Solution14 {
    /**
     * 先测算出个数，在重新处理
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode head, int k) {
        int count = 0;
        ListNode headcopy = head;
        while (head != null) {
            count++;
            head = head.next;
        }
        head = headcopy;
        int target = count - k + 1;
        if (target <= 0) {
            return null;
        }
        for (int i = 0; i < target - 1; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 两个指针，初始均指向开头，当第一个指针到K时，第二个指针同时移动，等第一个指针到末尾时，第二个指针指向的位置就是倒数第K个
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head, int k) {

        if(head==null||k<=0){
            return null;
        }
        ListNode pre=head;
        ListNode last=head;
        for(int i=1;i<k;i++){
            if(pre.next!=null){
                pre=pre.next;
            }else{
                return null;
            }
        }
        while(pre.next!=null){
            pre = pre.next;
            last=last.next;
        }
        return last;
    }
}