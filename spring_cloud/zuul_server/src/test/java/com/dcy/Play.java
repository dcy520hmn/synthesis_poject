package com.dcy;

import java.util.Scanner;

public class Play {
    /**
     * 1、输入一个大于6的偶数8（判断）
     * 2、循环遍历两个数相加等于8
     * 3、如果是在进行判断这两个数是否是质数
     * 4、是打印输出
     */
    public static  boolean judgePrimerNumber(int num1){
        boolean result = true;
        for (int i = 2; i < num1; i++) {
            if(num1%i==0){
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.println("请输入一个大于6的偶数");
        while((num = scanner.nextInt())<=6||(num%2!=0)){
            System.out.println("请输入一个大于6的偶数");
        }
        for (int i = 1; i <= num/2; i++) {
            if(judgePrimerNumber(i)&&judgePrimerNumber(num-i)){
                System.out.println(num+"="+i+"+"+(num-i));
            }
        }
    }
}
