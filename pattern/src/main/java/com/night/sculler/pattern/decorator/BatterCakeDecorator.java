package com.night.sculler.pattern.decorator;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/12/7
 */
public class BatterCakeDecorator implements BatterCake{

    private final BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    @Override
    public String getMsg() {
        return batterCake.getMsg();
    }

    @Override
    public int getPrice() {
        return batterCake.getPrice();
    }
}
