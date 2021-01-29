package com.dcy.lambda;

public class Nice {
    public Nice() {
    }

    public Nice(MyInterface myInterface){

    }

    public static void main(String[] args) {
        new Nice(()->{
            return "a";
        });
    }
}
