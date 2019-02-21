package com.arithmetic;
/**
 * Created by Administrator on 2019/2/16.
 *
 * @author Administrator
 */

/**
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *@className P6
 *@description TODO
 *@autor Administrator
 *@date 2019/2/16 20:46
 **/
public class P6 {
    public static void main(String[] args) {

    }
}
class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        int small=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i+1]<array[i]){
                small=array[i+1];
                break;
            }
        }
        return small;
    }
}