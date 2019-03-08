package com.liu;

/*
*   类锁方式之在普通方法前加 static 修饰
* */
public class SyncClassStatic4 implements  Runnable{

    static SyncClassStatic4 instance1 = new SyncClassStatic4();
    static SyncClassStatic4 instance2 = new SyncClassStatic4();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method(){
        System.out.println("类锁之static "+Thread.currentThread().getName()+"开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 结束");
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
