package com.dcy.designMode.buiderMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：具体构建出的产品
 *      一个产品中需要若个流程来进行操作，制作过程需要在Builder中来进行标准化。
 */
public class Product {
    List<String> operatorList = new ArrayList<>();

    /**
     * 记录所做的操作
     * @param operatorText
     */
    public void add(String operatorText){
        operatorList.add(operatorText);
    }

    /**
     * 展示所作的操作
     */
    public void show(){
        operatorList.forEach(operatorText->{
            System.out.println(operatorText);
        });
    }
}
