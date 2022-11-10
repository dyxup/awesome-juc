package cn.hi.awesome.juc.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class L02ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            LockSupport.parkNanos(500L*1000L*1000L);
            printMonitorThreadStatus();
        };
        Thread t1 = new Thread(task, "t1");
        Thread t2 = new Thread(task, "t2");
        Thread t3 = new Thread(task, "t3");
        monitorList.add(t1);
        monitorList.add(t2);
        monitorList.add(t3);
        monitorList.add(Thread.currentThread());
        t1.start();
        Thread.sleep(600);
        t2.start();
        Thread.sleep(600);
        t3.start();
        Thread.sleep(600);
        printMonitorThreadStatus();
    }

    static List<Thread> monitorList = new ArrayList<>();

    static void printMonitorThreadStatus() {
        monitorList.forEach(t -> {
            System.out.println("thread: " + t.getName() + ", status: " + t.getState());
        });
    }
}
