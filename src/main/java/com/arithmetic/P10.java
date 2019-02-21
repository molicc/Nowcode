package com.arithmetic;
/**
 * Created by Administrator on 2019/2/16.
 *
 * @author Administrator
 */

/**
 *我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *@className P10
 *@description TODO
 *@autor Administrator
 *@date 2019/2/16 22:09
 **/
public class P10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int i = solution10.RectCover(4);
        System.out.println(i);
    }
}

class Solution10 {
    /**
     * 依旧是斐波那契数列
     * 2*n的大矩形，和n个2*1的小矩形
     * 其中target*2为大矩阵的大小
     * 有以下几种情形：
     * target <= 0 大矩形为<= 2*0,直接return 1；
     * target = 1大矩形为2*1，只有一种摆放方法，return1；
     * target = 2 大矩形为2*2，有两种摆放方法，return2；
     * target = n 分为两步考虑：
     *         第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
     * 第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)
     * 因为，摆放了一块1*2的小矩阵（用√√表示），对应下方的1*2（用××表示）摆放方法就确定了，所以为f(targte-2)
     * @param target
     * @return
     */
    public int RectCover(int target) {
        int temp1=1,temp2=2,result = 0;
        if(target==1){
            return 1;
        }else if (target==2){
            return 2;
        }else {
            for (int i = 2; i < target; i++) {
                result=temp1+temp2;
                temp1=temp2;
                temp2=result;
            }
            return result;
        }
    }
}