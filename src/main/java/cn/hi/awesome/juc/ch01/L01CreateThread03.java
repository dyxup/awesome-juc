package cn.hi.awesome.juc.ch01;

public class L01CreateThread03 {
    public static void main(String[] args) {
        // create thread with Runnable
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ", i: " + i);
            }
        };
        int i = 1;
        new Thread(runnable, "RunnableThread-" + i++).start();
        new Thread(runnable, "RunnableThread-" + i++).start();
        new Thread(runnable, "RunnableThread-" + i++).start();
    }
}
