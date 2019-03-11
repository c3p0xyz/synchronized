package com.liu;


//可重入粒度测试，递归调用本方法
public class SyncRecursion10 {

    int a = 0;
    public static void main(String[] args) {
        SyncRecursion10 instance = new SyncRecursion10();

        instance.method1();
    }

    private synchronized void method1() {
        System.out.println("这是method1,a="+a);
        if (a == 0){
            a++;
            method1();
        }
    }
}
