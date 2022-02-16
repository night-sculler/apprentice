package com.night.sculler.pattern.decorator;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/12/7
 */
public class BaseBatterCake implements BatterCake{
    @Override
    public String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
