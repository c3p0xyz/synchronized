package com.liu;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//两种不同形式的锁
public class SyncToLock13 {

    Lock lock = new ReentrantLock();

    public synchronized void method1(){
        System.out.println("我是synchronized形式的锁");
    }

    public void method2(){
        lock.lock();
        try {
            System.out.println("我是lock形式的锁");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SyncToLock13 instance = new SyncToLock13();
        instance.method1();
        instance.method2();
    }

}
