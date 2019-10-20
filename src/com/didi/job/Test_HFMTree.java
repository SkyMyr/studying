package com.didi.job;
import java.util.Scanner;
/**
 * @ClassNameTest_HFMTree
 * @Description ASCLL码和Unicode编码是定长的，而HFM编码是变长的,hfmTree 字符串，先统计各个字符的频率，然后排序，然后按最优二叉树进行编码输出带权路径长度或者各个字符的编码
 * @Author myr
 * @Date 2019/10/15 16:01
 * @Version 1.0
 **/
public class Test_HFMTree {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入字符串");
        String strIn= s.nextLine();
        System.out.println("请输入子串");
        String strCh = s.nextLine();

        boolean flag=true;
        if(!strIn.contains(strCh)){
            flag=false;
        }
        if(flag){//如果存在
            System.out.print("包含该字串,");
            int preStrLength = 0;
            System.out.print("且查找到该子串的位置为：");
            while(true){
                int pos = strIn.indexOf(strCh);
                if(pos==-1)break;
                System.out.print((pos + preStrLength));//字串位置
                System.out.print(' ');
                strIn= strIn.substring(pos +strCh.length() );//截取
                preStrLength +=(pos +strCh.length());
        }
        }else{
            System.out.println("不包含该字串");
        }
    }
}
