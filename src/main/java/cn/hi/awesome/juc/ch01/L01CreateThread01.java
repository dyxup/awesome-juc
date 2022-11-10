package cn.hi.awesome.juc.ch01;

public class L01CreateThread01 {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getState());
        System.out.println(thread.getPriority());
        System.out.println(Thread.currentThread().getName() + " end");
        // 实际调用 run()
        thread.start();
        // 空Thread默认target是null
        // @Override
        //    public void run() {
        //        if (target != null) {
        //            target.run();
        //        }
        //    }
    }


}
