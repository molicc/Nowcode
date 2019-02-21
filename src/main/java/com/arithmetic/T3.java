package com.arithmetic;
/**
 * Created by Administrator on 2019/2/20.
 *
 * @author Administrator
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @className T3
 * @description TODO
 * @autor Administrator
 * @date 2019/2/20 20:04
 **/
public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int[][] ints = new int[m][3];
        int cost_sum = 0;
        Map<Integer, Integer> cost = new HashMap<>();
        //0未去过，1去过
        Map<Integer, Integer> flag = new HashMap<>();
        Map<Integer, Integer> from = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            cost.put(i, Integer.MAX_VALUE);
            flag.put(i, 0);
            from.put(i, -1);
        }
        flag.put(s, 1);
        while (flag.containsValue(0)) {
            //更新最小值
            for (int i = 0; i < m; i++) {
                if (ints[i][0] == s && flag.get(ints[i][1]) == 0 && cost_sum + ints[i][2] < cost.get(ints[i][1])) {
                    from.put(ints[i][1], ints[i][0]);
                    cost.put(ints[i][1], cost_sum + ints[i][2]);

                }
            }
            //选出最小值
            int min = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (flag.get(i) == 0 && cost.get(i) < min) {
                    flag.put(i, 1);
                    cost_sum += cost.get(i);
                }
            }
        }
        int back=t;
        int s_t=0;
        while (back!=-1){
            s_t+=cost.get(back);
            back=from.get(back);
        }
        System.out.println(s_t);

    }
}
