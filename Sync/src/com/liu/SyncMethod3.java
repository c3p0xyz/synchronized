package com.liu;

public class SyncMethod3 implements Runnable {

    static SyncMethod3 instance = new SyncMethod3();

    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        System.out.println(Thread.currentThread().getName()+" begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }

        System.out.println("Thread finished!");
    }
}
