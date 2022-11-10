package cn.hi.awesome.juc.ch01;

public class L01CreateThread02 {
    public static void main(String[] args) {
        // 1. 继承 Thread Class
        // 2. 覆盖 run()
        new DemoThread().start();
        new DemoThread().start();
        System.out.println(Thread.currentThread().getName() + " end");
    }

    static int THREAD_NO = 1;
    static int FOR_TIMES = 5;

    static class DemoThread extends Thread {
        DemoThread() {
            super("DemoThread-" + THREAD_NO++);
        }

        @Override
        public void run() {
            for (int i = 0; i < FOR_TIMES; i++) {
                System.out.println(getName() + ", i: " + i);
            }
            System.out.println(getName() + " end");
        }
    }

}
