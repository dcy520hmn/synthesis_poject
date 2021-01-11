package com.dcy.designMode.buiderMode;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        ConcreteBuilder1 b1 = new ConcreteBuilder1();
        ConcreteBuilder2 b2 = new ConcreteBuilder2();
        director.construct(b1);
        director.construct(b2);

        Product p1 = b1.getResult();
        Product p2 = b2.getResult();

        p1.show();
        p2.show();
    }
}
