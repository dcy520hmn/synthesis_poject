package com.dcy.designMode.buiderMode;

public interface Builder {
    //清洁操作
    void clean();
    //进行组装件A
    void assembleA();
    //进行组装件B
    void assembleB();
    //获得结果
    Product getResult();
}
