package com.liu;

public class SyncStaticAndNormal8 implements Runnable  {
    static SyncStaticAndNormal8 instance = new SyncStaticAndNormal8();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    private static synchronized void method1() {
        System.out.println(Thread.currentThread().getName()+" 静态加锁方法1开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 静态加锁方法1结束");
    }

    private synchronized void method2() {
        System.out.println(Thread.currentThread().getName()+" 非静态加锁方法2开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 非静态加锁方法2结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){}

        System.out.println("finished");
    }
}
