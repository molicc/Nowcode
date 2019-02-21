package com.arithmetic;
/**
 * Created by Administrator on 2019/2/16.
 *
 * @author Administrator
 */

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @className P1
 * @description TODO
 * @autor Administrator
 * @date 2019/2/16 16:34
 **/
public class P1 {
    public static void main(String[] args) {
        int [][] array ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Solution1 solution2 = new Solution1();
        boolean find = solution2.Find2(1, array);
        System.out.println(find);
    }
}


class Solution1 {
    /** 思路
     * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * 要查找数字比左下角数字小时，上移
     */
    public boolean Find1(int target, int[][] array) {
        //长
        int l1 = array[0].length;
        //宽
        int l2 = array.length-1;
        int i = 0;
        int j = l1 - 1;
        while (i <= l2 && j >= 0) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 把每一行看成有序递增的数组，
     * 利用二分查找，
     * 通过遍历每一行得到答案，
     * 时间复杂度是nlogn
     */
    public boolean Find2(int target, int[][] array) {
        int left = 0;
        int right=array[0].length-1;
        int i=0;
        int mid = (left+right)/2;
        while (i<=array.length-1){
            if (left<=right){
                if (target<array[i][mid]){
                    right=mid-1;
                }else if (target>array[i][mid]){
                    left=mid+1;
                }else {
                    return true;
                }
                mid=(left+right)/2;
            }else {
                i++;
                left=0;
                right=array[0].length-1;
                mid=(left+right)/2;
            }
        }
        return false;
    }


}


