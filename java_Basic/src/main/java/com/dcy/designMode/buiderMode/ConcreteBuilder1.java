package com.dcy.designMode.buiderMode;

public class ConcreteBuilder1 implements Builder{


    private Product product = new Product();

    @Override
    public void clean() {
        product.add("开始清洁");
    }

    @Override
    public void assembleA() {
        product.add("开始组装件A");
    }

    @Override
    public void assembleB() {
        product.add("开始组装件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
