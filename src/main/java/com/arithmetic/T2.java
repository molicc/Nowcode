package com.arithmetic;
/**
 * Created by Administrator on 2019/2/20.
 *
 * @author Administrator
 */

import java.util.Scanner;

/**
 * @className T2
 * @description TODO
 * @autor Administrator
 * @date 2019/2/20 19:37
 **/
public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] ints = new int[t][4];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 4; j++) {
                ints[i][j]=scanner.nextInt();
            }
        }

        for (int k = 0; k <t ; k++) {
            if (ints[k][0]*6 > ints[k][1] + ints[k][2] * 2 + ints[k][3] * 3) {
                System.out.println("No");
            } else {
               if (ints[k][3]%2!=0&&ints[k][2]!=0&&ints[k][1]==0){
                   System.out.println("No");
               }else {
                   System.out.println("Yes");
               }
            }
        }
    }
}
