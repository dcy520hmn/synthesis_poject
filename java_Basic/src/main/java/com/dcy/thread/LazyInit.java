package com.dcy.thread;

public class LazyInit {
    private UnsafeThread unsafeThread = null;

    public  UnsafeThread getUnsafeThread(){
        synchronized (this){
            if(unsafeThread == null){
                unsafeThread = new UnsafeThread();
            }
        }
        System.out.println(unsafeThread);
        return unsafeThread;
    }
}
