package com.night.sculler.elk.slf4j;


import org.aspectj.lang.JoinPoint;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * 日志切面公共类
 *
 * @author houlongjie
 * @version 1.0
 * @date 2021/10/15
 */
public class LogTraceIdAspect {

    /**
     * traceId
     */
    private static final String TRACE_ID = "traceId";

    /**
     * 通用日志
     *
     * @param joinPoint joinPint
     */
    public void doBefore(JoinPoint joinPoint) {
        MDC.put(TRACE_ID, UUID.randomUUID().toString());
    }

    /**
     * 返回日志
     *
     * @param ret ret
     */
    public void doAfterReturning(Object ret) {
        MDC.remove(TRACE_ID);
    }
}
