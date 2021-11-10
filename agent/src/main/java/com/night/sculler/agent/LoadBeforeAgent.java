package com.night.sculler.agent;

import java.lang.instrument.Instrumentation;

/**
 * The type Load before agent.
 *
 * @author night -sculler
 * @version 1.0.0.release
 * @date 2021 /10/27
 */
public class LoadBeforeAgent {
    /**
     * Premain.
     *
     * @param args            the args
     * @param instrumentation the instrumentation
     */
    public static void premain(String args, Instrumentation instrumentation) {
        instrumentation.addTransformer(new Transformer("com.night.sculler.agent.BizService", "sayHello"));
    }
}
