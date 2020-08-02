package com.didi.job;

import java.util.*;

/**
 * @ClassNameTest_58
 * @Description 58笔试
 * @Author myr
 * @Date 2019/10/13 19:38
 * @Version 1.0
 **/
public class Test_58 {

    public static void main(String[] args) {
        //2、寻找数组中出现数的个数
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        System.out.println(getNum(m,n,x));
//        //3、上台阶
//        int n = scanner.nextInt();
//        System.out.println(xiaoba(n));
    }

    public static  long getNum(int m,int n,int x)
    {
        long num = 0;
        for(int i = m; i<=n;i++)
        {
            String a = i+"";
            num += a.length() - a.replace(x + "", "").length();
        }
        return num;
    }

    public static int xiaoba (int n)
    {
        int a = 1, b = 1;
        while( (n--) != 0 )
        {
            b += a;
            a = b - a;
        }
        return a;
    }
}

//三数之和
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
}

//回文子串
class Solution1 {
    public int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}