package com.proxy.client;


import com.proxy.actor.IActor;
import com.proxy.agent.Agent;

public class Client {
    public static void main(String[] args) {
       IActor actor = Agent.getActor();
       actor.dangerAct(6000);
    }
}
