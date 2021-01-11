package com.dcy.designMode.buiderMode;

public class ConcreteBuilder2 implements Builder{


    private Product product = new Product();

    @Override
    public void clean() {
        product.add("开始清洁");
    }

    @Override
    public void assembleA() {
        product.add("开始组装件X");
    }

    @Override
    public void assembleB() {
        product.add("开始组装件D");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
