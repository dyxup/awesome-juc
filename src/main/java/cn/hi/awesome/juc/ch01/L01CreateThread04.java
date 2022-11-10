package cn.hi.awesome.juc.ch01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class L01CreateThread04 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Callable

        // Runnable不能应用在异步场景
        // run返回void 且没有声明受检异常
        Callable<Integer> calculate = () -> {
            int x = 0;
            for (int i = 0; i < 5; i++) {
                x += i;
            }
            return x;
        };
        // FutureTask实现RunnableFuture接口，包装Callable以被Thread执行
        // 'run': 调用Runnable的call
        // 'get': 判断task状态，如果执行完就返回事先保存的result
        RunnableFuture<Integer> calcRunnable = new FutureTask<>(calculate);
        new Thread(calcRunnable).start();
        Thread.sleep(1000);
        System.out.println(calcRunnable.get());
    }
}
