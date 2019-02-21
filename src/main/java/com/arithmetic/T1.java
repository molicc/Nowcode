package com.arithmetic;
/**
 * Created by Administrator on 2019/2/20.
 *
 * @author Administrator
 */

import java.util.Scanner;

/**
 * @className T1
 * @description TODO
 * @autor Administrator
 * @date 2019/2/20 19:26
 **/
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        int f=scanner.nextInt();
        int d=scanner.nextInt();
        int p=scanner.nextInt();
        int time =0 ;
        for (int i = 1; i <= f; i++) {
            d-=x;
            if (d>=0){
                time++;
            }
        }
        d-=(p+x);
        while (d>=0){
            time++;
            d-=(p+x);
        }
        System.out.println(time);
    }
}
