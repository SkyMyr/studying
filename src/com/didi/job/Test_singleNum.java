package com.didi.job;

import java.util.HashMap;
import java.util.Map;

public class Test_singleNum {
    /**
     * 两个只出现一次的数字
     * 任何数和 00 做异或运算，结果仍然是原来的数
     * @param nums 数组
     * @return 数字
     */
    public int[] singleNumber2(int[] nums) {
        // 关键：
        //  1.两个只出现一次的数字在不同的组中；
        //  2.相同的数字会被分到相同的组中。
        // 思路：
        //  1.先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
        //  2.在异或结果中找到任意为 11 的位。
        //  3.根据这一位对所有的数字进行分组。
        //  4.在每个组内进行异或操作，得到两个数字。
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    /**
     * 一个只出现一次的数字（其他出现三次）
     * @param nums 数组
     * @return 数字
     */
    public int singleNumber3(int[] nums) {
        // 方法1 哈希表
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;

        // 方法2 位运算 每个位上的数字之和为3的倍数进行每一位的判断
//        int ans = 0;
//        for (int i = 0; i < 32; ++i) {
//            int total = 0;
//            for (int num: nums) {
//                total += ((num >> i) & 1);
//            }
//            if (total % 3 != 0) {
//                ans |= (1 << i);
//            }
//        }
//        return ans;
    }
}
