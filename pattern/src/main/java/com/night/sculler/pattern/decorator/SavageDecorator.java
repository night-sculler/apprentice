package com.night.sculler.pattern.decorator;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/12/7
 */
public class SavageDecorator extends BatterCakeDecorator {
    public SavageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "一个香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
