package com.arithmetic;
/**
 * Created by Administrator on 2019/2/17.
 *
 * @author Administrator
 */

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @className P11
 * @description TODO
 * @autor Administrator
 * @date 2019/2/17 17:18
 **/
public class P11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int i = solution11.NumberOf1B(7);
        System.out.println(i);

    }
}

class Solution11 {
    /**
     * 设置一个标志位进行检测，从右往左移动进行按位与，结果不为零则此位置为1
     * @param n
     * @return
     */
    public int NumberOf1A(int n) {
        int count = 0;
        int index=1;
        while (index<=n){
            if ((n & index) !=0){
                count++;
            }
            index=index << 1;
        }
        return count;
    }

    /**
     * 最优解：通过n与n-1的按位与消除了最右侧的1,n有几个1就能消除几次，最后当n为0时，统计出结果。
     * @param n
     * @return
     */
    public int NumberOf1B(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }


}