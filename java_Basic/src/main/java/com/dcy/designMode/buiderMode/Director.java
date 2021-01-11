package com.dcy.designMode.buiderMode;

public class Director {

    public void construct(Builder builder){
        builder.assembleA();
        builder.assembleB();
    }

}
