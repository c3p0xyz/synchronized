package com.liu;

//可重入粒度测试，子类调用父类方法
public class SyncSuperClass12 {

    public synchronized void doSomething(){
        System.out.println("我是父类方法");
    }
}

class TestClass extends SyncSuperClass12{
    public synchronized void doSomething(){
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.doSomething();
    }
}
