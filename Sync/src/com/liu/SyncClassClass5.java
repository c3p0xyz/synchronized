package com.liu;

/*
*   类锁之同步代码块里加本类的Class文件
* */
public class SyncClassClass5 implements Runnable {

    static SyncClassClass5 instance1 = new SyncClassClass5();
    static SyncClassClass5 instance2 = new SyncClassClass5();

    @Override
    public void run() {
        method();
    }

    public void method(){
        synchronized (SyncClassClass5.class){
            System.out.println("类锁之Class文件 "+Thread.currentThread().getName()+" 开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){}

        System.out.println("finished");
    }
}
