package com.dcy.tmp;

/**
 * @author duanchunyu
 * @version 1.0.0
 * @Description 临时测试
 * @createTime 2021年05月08日 14:11:00
 */
public class Tmp {
    private final int threadLocalHashCode = nextHashCode();
    private static int nextHashCode() {
        return getAndAdd(1640531527);
    }

    private static int getAndAdd(int i) {
        return 0+i;
    }

    public static void main(String[] args) {
        Tmp tmp = new Tmp();
        System.out.println(tmp.threadLocalHashCode);
    }

}
