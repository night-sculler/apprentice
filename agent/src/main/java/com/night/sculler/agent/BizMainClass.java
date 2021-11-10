package com.night.sculler.agent;

/**
 * The type Biz main class.
 *
 * @author night -sculler
 * @version 1.0.0.release
 * @date 2021 /10/27
 */
public class BizMainClass {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BizService bizService = new BizService();
        String name = "ellen";
        if (null != args && args.length > 0) {
            name = args[0];
        }
        bizService.sayHello(name);
    }
}
