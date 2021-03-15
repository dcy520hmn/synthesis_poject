package com.dcy.hotspot.executeSystem.dynamic;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Show methodHandle base operation
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintlnMh(obj).invokeExact("ictext");
        getPrintReflect(obj).invoke(obj,"icText");
    }

    //implement by methodHandle
    private static MethodHandle getPrintlnMh(Object reveiver) throws Throwable {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(reveiver.getClass(), "println", methodType)
                .bindTo(reveiver);
    }

    //implement by reflect
    private static Method getPrintReflect(Object reveiver) throws Throwable {
        Class<?> reveiverClass = reveiver.getClass();
        Method method = reveiverClass.getMethod("println", String.class);
        return method;
    }

    //to think about why don's use reflect to support dynamic language
}
