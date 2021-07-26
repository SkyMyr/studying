package com.didi.job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_Fibonacci {

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * @param n n
     * @return 第n项
     */
    public int fib(int n) {
        // 递归需要考虑时间复杂度，用数组记录的方式
        int x = 0, y = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (x + y) % 1000000007;
            x = y;
            y = sum;
        }
        return x;
    }

    /**
     * 和为 K 的最少斐波那契数字数目
     * 贪心思路：对于任意给定的k，选择不大于k的最大的斐波那契数，论证两个：不会选择两个连续的数；每个斐波那契数不会选择多次
     * @param k k
     * @return minNum
     */
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1, ans = 0;
        List<Integer> list = new ArrayList<>(Arrays.asList(a, b));
        while (a + b <= k) {
            int sum = a + b;
            list.add(sum);
            a = b;
            b = sum;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= k) {
                k -= list.get(i);
                ans++;
            }
            if (k == 0) {
                break;
            }
        }
        return ans;
    }
}
