package com.liu;


//粒度测试，同类中不同方法用synchronized修饰
public class SyncOtherMethod11 {

    public static void main(String[] args) {
        SyncOtherMethod11 instance = new SyncOtherMethod11();
        instance.method1();
    }

    private synchronized void method1() {
        System.out.println("我是method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("我是method2");
    }
}
