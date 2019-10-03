package com.didi.job;
import  java.util.*;

/**
 * @ClassNameTest_leetCode128
 * @Description 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 * 示例:
    输入: [100, 4, 200, 1, 3, 2]
    输出: 4
    解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @Author myr
 * @Date 2019/9/26 14:58
 * @Version 1.0
 **/

public class Test_leetCode128 {
    /**
     * 数字用一个 HashSet 保存（或者用 Python 里的 Set），实现 O(1)O(1) 时间的查询，同时，我们只对 当前数字 - 1 不在哈希表里的数字，
     * 作为连续序列的第一个数字去找对应的最长序列，这是因为其他数字一定已经出现在了某个序列里。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
