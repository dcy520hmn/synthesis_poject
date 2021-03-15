package com.dcy.hotspot.memoryManager.outOfMempry;

import java.util.ArrayList;

/**
 * 堆异常
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        ArrayList<OOMObject> oomObjects = new ArrayList<>();
        while (true){
            OOMObject oomObject = new OOMObject();
            oomObjects.add(oomObject);
        }
    }
}
