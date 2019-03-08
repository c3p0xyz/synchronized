package com.liu;

/*
*   对象锁方式之同步代码块
*
* */

public class SyncCodeBlock2 implements Runnable{

    static SyncCodeBlock2 instance = new SyncCodeBlock2();

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " 开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}
