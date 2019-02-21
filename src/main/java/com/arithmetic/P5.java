package com.arithmetic;
/**
 * Created by Administrator on 2019/2/16.
 *
 * @author Administrator
 */

import java.util.Stack;

/**
 *用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *@className P5
 *@description TODO
 *@autor Administrator
 *@date 2019/2/16 20:36
 **/
public class P5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        solution5.push(1);
        System.out.println(solution5.pop());
        solution5.push(2);
        solution5.push(3);
        System.out.println(solution5.pop());

    }
}

class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 仅处理入队
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 弹出栈顶元素后，将剩余元素重新置回stack1中
     * @return
     */
    public int pop() {
        int result;
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        result=stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}