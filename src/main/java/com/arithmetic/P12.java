package com.arithmetic;
/**
 * Created by Administrator on 2019/2/17.
 *
 * @author Administrator
 */

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @className P12
 * @description TODO
 * @autor Administrator
 * @date 2019/2/17 18:48
 **/
public class P12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        double v = solution12.Power3(3, -5);
        System.out.println(v);
    }
}

class Solution12 {
    /**
     * 寻常解法O(n)
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power1(double base, int exponent) {
        //0正1负
        int flag = 0;
        double result = 1d;
        if (exponent < 0) {
            flag = 1;
            exponent = Math.abs(exponent);
        } else if (exponent == 0) {
            return 1;
        }

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return flag == 0 ? result : 1 / result;
    }

    /**
     * 将指数二分进行迭代求解O(logn)，分奇偶讨论2^6=2^3*2^3，奇数转为偶数处理
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power2(double base, int exponent) {
        int flag = 0;
        if (exponent < 0) {
            exponent = -exponent;
            flag = 1;
        } else if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        //分拆
        double result = Power2(base, exponent >> 1);
        //合并
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        if (flag == 1) {
            return 1 / result;
        }
        return result;
    }

    /**
     * 快速幂
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power3(double base, int exponent) {
        double result = 1d;
        int flag = 0;
        if (exponent < 0) {
            exponent = -exponent;
            flag=1;
        } else if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            //翻倍，通过规律可
            base *= base;
            exponent >>= 1;
        }
        return flag == 0 ? result : 1 / result;

    }
}