package com.didi.job;

/**
 * @ClassNameTest_tanxin
 * @Description TODO
 * @Author myr
 * @Date 2019/10/22 22:03
 * @Version 1.0
 **/
public class Test_tanxin {

    public static void main(String[] args) {
        greedyGiveMoney(56);
    }
    /**
     * 钱币找零问题
     *
     * @param money the money
     */
    public static void greedyGiveMoney(int money) {
        System.out.println("需要找零: " + money);
        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        for (int i = moneyLevel.length - 1; i >= 0; i--) {
            int num = money/ moneyLevel[i];
            int mod = money % moneyLevel[i];
            money = mod;
            if (num > 0) {
                System.out.println("需要" + num + "张" + moneyLevel[i] + "块的");
            }
        }
    }
}
