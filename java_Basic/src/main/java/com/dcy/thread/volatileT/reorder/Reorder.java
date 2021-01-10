package com.dcy.thread.volatileT.reorder;

/**
 * 目标：测试volatile不可重新排序特性
 * 解释：通过x，y的赋值情况，实现出代码的执行顺序。
 * 理解：如果在本线程中观察，所有的操作都是有序的；（线程内似表现为串行）
 *       如果在一个线程中观察另一个线程，所有的操作都是无序的。（指令重排序）
 */
public class Reorder {
    private static int x;
    private static int y;

    private static int a;
     private static int b;
    volatile private static int c;
     private static int d;
    volatile private static int e;
    private static int f;


    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        while(true){
            x=0;
            y=0;
            a=0;
            b=0;
            c=0;
            d=0;
            e=0;
            f=0;
            count++;
            Thread thread1 = new Thread(() -> {
                a=1;
                c=3;
                x=b;
                d=4;
            });
            Thread thread2 = new Thread(() -> {
                b=2;
                e=5;
                y=a;
                f=6;
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            String ret = "count="+count+" "+x+" "+y;
            if(x!=0&&y!=0){
                System.err.println(ret);
                break;
            }else {
                System.out.println(ret);
            }
        }
    }

}
