package com.night.sculler.pattern.decorator;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2021/12/7
 */
public class Test {
    public static void main(String[] args) {
        BatterCake batterCake;

        batterCake = new BaseBatterCake();

        batterCake = new EggBatterCakeDecorator(batterCake);

        batterCake = new SavageDecorator(batterCake);

        System.out.println(batterCake.getMsg()+ ",总价" + batterCake.getPrice());
    }
}
