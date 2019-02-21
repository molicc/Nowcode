package com.arithmetic;
/**
 * Created by Administrator on 2019/2/16.
 *
 * @author Administrator
 */

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * @className P7
 * @description TODO
 * @autor Administrator
 * @date 2019/2/16 20:55
 **/
public class P7 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.Fibonacci(7));
    }
}

class Solution7 {
    public int Fibonacci(int n) {
        int temp1 = 1, temp2 = 1, result = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 2; i < n; i++) {
                result = temp1 + temp2;
                temp1 = temp2;
                temp2 = result;
            }
            return result;
        }
    }
}