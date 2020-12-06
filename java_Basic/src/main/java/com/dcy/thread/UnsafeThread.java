package com.dcy.thread;

public class UnsafeThread{

   private Integer num = 1;

   public Integer numIncrement(){
       return num++;
   }

}
