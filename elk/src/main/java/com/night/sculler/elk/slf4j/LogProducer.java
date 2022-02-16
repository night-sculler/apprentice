package com.night.sculler.elk.slf4j;


import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author houlongjie
 * @version 1.0
 * @date 2022/1/24
 */
public class LogProducer {

    /**
     * traceId
     */
    private static final String TRACE_ID = "traceId";

    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> taskList = Lists.newArrayList();

        addInterfaceTaskList("sayHello", taskList);
        addInterfaceTaskList("cook", taskList);
        addInterfaceTaskList("smile", taskList);
        addInterfaceTaskList("sky", taskList);
        addInterfaceTaskList("run", taskList);

        executorService.invokeAll(taskList);

        executorService.shutdown();
        System.out.println("");
    }

    private static void addInterfaceTaskList(String interfaceName, List<Callable<String>> taskList) {
        for (int i = 0; i <= 1; i++) {
            taskList.add(() -> {
                String threadName = Thread.currentThread().getName();
                Logger logger = LoggerFactory.getLogger(interfaceName);

                MDC.put(TRACE_ID, UUID.randomUUID().toString());


                for (int j = 0; j < 10; j++) {
//                    logger.warn("接口{} 步骤：{}", interfaceName, j);
//                    logger.info("接口{} 步骤：{}", interfaceName, j);
                    logger.error("接口{} 步骤：{}", interfaceName, j);
                }

                Thread thread = Thread.currentThread();

                MDC.remove(TRACE_ID);
                return threadName;
            });
        }
    }


}
