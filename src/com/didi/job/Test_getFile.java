package com.didi.job;

import java.io.File;

/**
 * @ClassNameTest_getFile
 * @Description 递归获取一个目录下所有文件夹和文件
 * @Author myr
 * @Date 2019/10/30 9:35
 * @Version 1.0
 **/
public class Test_getFile {
    public static void main(String[] args) {
        String path = "F:\\美剧";
        File f = new File(path);
        Test_getFile.getFile(f,0);//根目录文件，0层
    }

    /**
     * 输出指定目录下所有文件---按文件/文件夹/不同后缀类型文件检索都可以
     * @param file
     */
    public static void getFile(File file, int level)
    {
        //文件第几层
        level++;
        if(file != null){
            //列出所有文件文件对象
            File[] f = file.listFiles();
            if(f != null){
                //遍历文件对象
                for(int i = 0; i < f.length; i++){
                    if(f[i].isFile()){//如果是文件的情况
                        System.out.println("this is a file: " + f[i].getName());
                        if(f[i].getName().endsWith(".mp4")){//检索想要的文件：如Java文件、word文件等
                            System.out.println("this is a MP4 -----" + f[i].getName() + level);
                        }
                    }else if(f[i].isDirectory()){//如果是文件夹的情况
                        System.out.println("this is a directory: " + f[i].getName() + level);
                        System.out.println(f[i].getAbsolutePath());//绝对路径
                    }
                    if(f[i].getName().equals("单身毒妈")){
                        //递归获取子文件夹下文件对象，这里获取“单身毒妈“目录下的
                        getFile(f[i],level);
                    }
                }
            }else{
                //递归打印
                System.out.println(file);
            }
        }
    }
    /*
    附：java文件常用操作：

1.获取File路径和检测状态: 
    1）操作File路径和名称: 
    File getAbsoluteFile() :获取绝对路径 
    String getAbsolutePath():获取绝对路径 
    String getPath() :获取文件路径 
    String getName() :获取文件名称 
    File getParentFile():获取上级目录文件 
    String getParent() :获取上级目录路径

    2）检测File状态的方法: 
    boolean canExecute() :判断是否是可执行文件 
    boolean canRead() :判断该文件是否可读 
    boolean canWrite():判断该文件是否可写 
    boolean isHidden():判断该文件是否是隐藏文件 
    long lastModified():判断该文件的最后修改时间 

    long length():获取该文件的长度大小(单位字节)

2.File类中方法
    1）文件操作: 
    boolean isFile() :是否是文件 
    boolean createNewFile() :创建新的文件 
    static File createTempFile(String prefix, String suffix) :创建临时文件 
    boolean delete() :删除文件 
    void deleteOnExit() :在JVM停止时删除文件 
    boolean exists():判断文件是否存在 
    boolean renameTo(File dest) :重新修改名称

    2）目录操作 
    boolean isDirectory() :判断是否是目录 
    boolean mkdir() :创建当前目录 
    boolean mkdirs() :创建当前目录和上级目录 
    String[] list() :列出所有的文件名 
    File[] listFiles() :列出所有文件对象 
    static File[] listRoots() :列出系统盘符
*/
}
