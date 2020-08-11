package com.proxy.actor;

public class Actor implements IActor{

    @Override
    public void basicAct(float money) {
        System.out.println("基本演出"+money);
    }

    @Override
    public void dangerAct(float money) {
        System.out.println("危险演出!"+money);
    }
}
