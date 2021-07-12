package com.night.sculler.mvc.controller;

/**
 * session context holder
 *
 * @author houlongjie
 * @version 1.0.0
 * @date 2021/7/12
 */
public class SessionContextHolder {
    /**
     * sessionContextHolder
     */
    private static final ThreadLocal<SessionContext> SESSION_CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * get session context
     *
     * @return session context
     */
    public static SessionContext get() {
        return SESSION_CONTEXT_HOLDER.get();
    }

    /**
     * set session context
     *
     * @param context context
     */
    public static void set(SessionContext context) {
        if (null == context) {
            reset();
        } else {
            SESSION_CONTEXT_HOLDER.set(context);
        }
    }

    /**
     * reset
     */
    public static void reset() {
        SESSION_CONTEXT_HOLDER.remove();
    }
}
