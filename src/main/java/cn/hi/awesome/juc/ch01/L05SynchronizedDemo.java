package cn.hi.awesome.juc.ch01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L05SynchronizedDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        TwoPlus t = new TwoPlus();
        // 方法上加synchronized锁的是this 所以plus3也会被阻塞
        executorService.submit(() -> {
            try {
                t.plus2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            t.plus3();
        });
        executorService.shutdown();
    }
}
@Slf4j
class TwoPlus {
    private int sum1 = 0;

    private int sum2 = 0;

    /**
     * 这里不能使用共享Integer实例
     */
    private final Integer sum1Lock = new Integer(1);

    private final Integer sum2Lock = new Integer(2);

    public void plus(int v1, int v2) {
        synchronized (sum1Lock) {
            sum1+=v1;
            log.info("plus sum1");
        }

        synchronized (sum2Lock) {
            sum2+=v2;
            log.info("plus sum2");
        }
    }

    public synchronized void plus2() throws InterruptedException {
        Thread.sleep(2000);
        log.info("plus sum2");
    }

    public synchronized void plus3() {
        log.info("plus sum3");
    }

}
