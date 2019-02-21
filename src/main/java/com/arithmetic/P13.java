package com.arithmetic;
/**
 * Created by Administrator on 2019/2/17.
 *
 * @author Administrator
 */

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @className P13
 * @description TODO
 * @autor Administrator
 * @date 2019/2/17 21:10
 **/
public class P13 {
    public static void main(String[] args) {
        long time = System.nanoTime();
        Solution13 solution13 = new Solution13();
        int[] ints = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        solution13.reOrderArray3(ints);
        System.out.println(System.nanoTime()-time);
        for (int i : ints
        ) {
            System.out.println(i);
        }

    }
}

class Solution13 {
    /**
     * 找到偶数后第一个奇数位置，将奇数与成片偶数进行交换
     *
     * @param array
     */
    public void reOrderArray1(int[] array) {
        int left = 0;
        int temp;
        while (left < array.length) {
            if (array[left] % 2 != 0) {
                left++;
            } else {
                for (int i = left + 1; i < array.length; i++) {
                    //如果是奇数
                    if (array[i] % 2 != 0) {
                        temp = array[i];
                        while (i > left) {
                            array[i] = array[i - 1];
                            i--;
                        }
                        array[left] = temp;
                        left++;
                        break;
                    }
                    if (i == array.length - 1) {
                        return;
                    }
                }
            }
        }

    }
    /**
     * 新建数组
     */
    public void reOrderArray2(int[] array) {
        int[] ints = new int[array.length];
        int index=0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2!=0){
                ints[index]=array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0){
                ints[index]=array[i];
                index++;
            }
        }
        for (int i = 0; i < ints.length; i++) {
          array[i]=ints[i];
        }

    }

    /**
     * 冒泡法
     * @param array
     */
    public void reOrderArray3(int[] array) {
        int temp;
        for (int i = array.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {

                if (array[j]%2==0&&array[j+1]%2!=0){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }


}