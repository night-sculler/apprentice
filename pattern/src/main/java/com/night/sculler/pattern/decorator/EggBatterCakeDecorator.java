package com.night.sculler.pattern.decorator;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/12/7
 */
public class EggBatterCakeDecorator extends BatterCakeDecorator{
    public EggBatterCakeDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "一个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
