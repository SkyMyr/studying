package com.didi.job;

import java.util.*;

/**
 * @ClacursNameTest_amazon
 * @Description 途家笔试
 * @Author myr
 * @Date 2019/10/9 9:04
 * @Version 1.0
 **/
public class Test_amazon {

    //旅行
    /*private static int n;
    private static int ans = Integer.MAX_VALUE;
    private static int[][] dp;
    private static int[] visit;
    private static Set<Integer> set;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();
        dp = new int[n+1][n+1];
        visit = new int[n+1];
        set = new HashSet<Integer>();
        for (int i = 0; i < r ; i++) {
            set.add(scanner.nextInt());
        }
        for (int i = 0; i < m ; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            dp[x][y] = dp[y][x] = z;
        }
        for (int i = 0; i < n ; i++) {
            if(set.contains(i)){
                set.remove(i);
                visit[i] = 1;
                ans = Math.min(dfs(i,0),ans);
                visit[i] = 0;
                set.add(i);
            }
        }
        System.out.println(ans);
    }

    private static int dfs(int x, int s)
    {
        if(s > ans)
            return Integer.MAX_VALUE;
        if(set.isEmpty())
            return s;
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i <= n ; i++) {
            if(dp[x][i] > 0 && visit[i] == 0){
                boolean flag = set.remove(i);
                visit[i] = 1;
                tmp = Math.min(dfs(i, s+dp[x][i]),tmp);
                visit[i] = 0;
                if(flag)
                    set.add(i);
            }
        }
        return tmp;
    }*/



    //逃离村庄
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//法师初始值
        int s = scanner.nextInt();//距离S
        int t = scanner.nextInt();//时间t
        int curs = 0,total = t;
        while(m >= 10 && t > 0 && s-curs > 0)
        {
            if(s-curs > 13){
                curs += 50;
                m -= 10;
                t--;
            }else{
                System.out.println("Yes\n" + (total-t+1) );
            }
        }
        //技能
        while(t > 0 && s-curs > 0)
        {
            if((m==0 || m==1) && t >= 7 && s-curs > 78){
                t -=7;
                curs +=100;
            }else if(m >= 2 && m <= 5 && t >= 3 && s-curs > 26){
                m -= 2;
                t -= 3;
                curs += 50;
            }else if(m >=6 && t >= 2 && s-curs > 13){
                m -= 6;
                t -= 2;
                curs += 50;
            }else{
                //11赶路
                curs += 13;
                t --;
            }
        }
        if(s <= curs){
            System.out.println("Yes\n" + (total-t));
        }else{
            System.out.println("No\n" + curs);
        }
    }

}
