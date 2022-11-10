package cn.hi.awesome.juc.ch01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class L01CreateThread05 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用线程池创建线程
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // execute Runnable
        // submit Callable
        // submit Runnable
        pool.execute(() -> System.out.println("execute Runnable"));
        pool.submit(() -> System.out.println("submit Runnable"));
        Future<Integer> future = pool.submit(() -> {
            Thread.sleep(1000);
            return 1;
        });
        System.out.println(future.get());
        pool.shutdown();
    }
}
