package com.proxy.agent;

import com.proxy.actor.Actor;
import com.proxy.actor.IActor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Agent {
    public static IActor getActor(){
        Actor actor = new Actor();
        IActor actorProxy = (IActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                Float money = (Float)args[0];
                Object rtValue = null;
                if("basicAct".equals(methodName)){
                    if(money > 2000){
                        rtValue = method.invoke(actor,money/2);
                    }else{
                        System.out.println("钱不够");
                    }
                }
                if("dangerAct".equals(methodName)){
                    if(money > 5000){
                        rtValue =  method.invoke(actor,money/2);
                    }else{
                        System.out.println("钱不够");
                    }
                }
                return rtValue;
            }
        });
        return actorProxy;
    }
}
