package com.baidu.mybatisplus.threadPool;

import org.slf4j.MDC;

import java.util.Map;

public class TraceMdcUtil {

    public static void setTraceIdIfAbsent(){
        if (MDC.get("traceId") == null){
            MDC.put("traceId",TraceLogUtil.getTraceId());
        }
    }

    public static void setTraceId(){
        MDC.put("traceId",TraceLogUtil.getTraceId());
    }

    public static void setTraceId(String traceId){
        MDC.put("traceId",traceId);
    }

    public static Runnable wrap(final Runnable runnable,final Map<String,String> context){
        return () ->{
            if (context == null){
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }

        };
    }



}
